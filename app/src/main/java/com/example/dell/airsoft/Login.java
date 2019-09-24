package com.example.dell.airsoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.dell.airsoft.Entidades.Usuarios;
import com.example.dell.airsoft.Firebase.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends Activity {

    private EditText edtemail;
    private EditText edtsenha;
    private Button btnlogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;
    private TextView tvAbreCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtemail = (EditText) findViewById(R.id.EdiEmail);
        edtsenha = (EditText) findViewById(R.id.EditSenha);
        btnlogar = (Button) findViewById(R.id.btlogin);
        tvAbreCadastro = (TextView) findViewById(R.id.Cadastro);

        btnlogar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (!edtemail.getText().toString().equals("")&& !edtsenha.getText().toString().equals("")){

            usuarios = new Usuarios();
            usuarios.setEmail(edtemail.getText().toString());
            usuarios.setSenha(edtsenha.getText().toString());
            validarlogin();


        } else {
            Toast.makeText(Login.this, "Preencha os campos de email e senha!", Toast.LENGTH_SHORT).show();
        }
    }
});


tvAbreCadastro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        abreCadastroUsuario();
    }
});



    }


public void validarlogin (){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            public void onComplete(@NonNull Task<AuthResult> task) {
           if (task.isSuccessful()){
               abrirtelaprincipal();
               Toast.makeText(Login.this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(Login.this, "Usuario ou senha invalidos!!", Toast.LENGTH_SHORT).show();
           }
            }
        });

}


        public void abrirtelaprincipal(){
            Intent intentabrirtelaprincipal = new Intent(Login.this, ReservaActivity.class);
            startActivity(intentabrirtelaprincipal);
        }


        public void abreCadastroUsuario (){
        Intent intent = new Intent(Login.this, CadastroActivity.class);
        startActivity(intent);
        }
}
