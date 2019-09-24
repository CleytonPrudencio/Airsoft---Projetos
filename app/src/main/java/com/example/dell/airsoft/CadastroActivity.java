package com.example.dell.airsoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.dell.airsoft.Entidades.Usuarios;
import com.example.dell.airsoft.Firebase.ConfiguracaoFirebase;
import com.example.dell.airsoft.Helper.Base64Custom;
import com.example.dell.airsoft.Helper.Preferencias;
import com.example.dell.airsoft.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends Activity {

    private EditText edtCadEmail;
    private EditText edtCadNome;
    private EditText edtCadSobrenome;
    private EditText edtCadSenha;
    private EditText edtConfirmarSenha;
    private EditText edtCadAniversario;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnCadastro;
    private Usuarios usuarios;
private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edtCadEmail = (EditText)findViewById(R.id.edtCadEmail);
        edtCadNome = (EditText)findViewById(R.id.edtCadNome);
        edtCadSenha = (EditText)findViewById(R.id.edtCadSenha);
        edtConfirmarSenha = (EditText)findViewById(R.id.edtConfirmarSenha);
        edtCadAniversario = (EditText)findViewById(R.id.edtCadAniversario);
        edtCadSobrenome = (EditText)findViewById(R.id.edtCadSobrenome);
        rbFeminino = (RadioButton)findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        btnCadastro = (Button) findViewById(R.id.btnGravar);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCadSenha.getText().toString().equals(edtConfirmarSenha.getText().toString())){

                    usuarios = new Usuarios();
                    usuarios.setNome(edtCadNome.getText().toString());
                    usuarios.setEmail(edtCadEmail.getText().toString());
                    usuarios.setSenha(edtCadSenha.getText().toString());
                    usuarios.setAniversario(edtCadAniversario.getText().toString());
                    usuarios.setSobrenome(edtCadSobrenome.getText().toString());

                    if (rbFeminino.isChecked()){
                        usuarios.setSexo("Feminino");
                    } else {
                        usuarios.setSexo("Masculino");
                    }

                    CadastrarUsuario();


                }else {
                    Toast.makeText(CadastroActivity.this, "As senhas não são correspodentes.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private void CadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()

        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroActivity.this, "Usuario Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.Salvar();

                    Preferencias preferencias = new Preferencias(CadastroActivity.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());


                    abrirLoginUsuario();

                } else {
                    String erroEscecao = "";

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroEscecao = "Digite uma senha mais forte, contendo no mínimo 8 caracteres de letras e números.";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroEscecao = "O E-mail digitado é invalido. Digite um novo e-mail.";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroEscecao = "Esse email ja esta cadastrado no sistema.";
                    } catch (Exception e) {
                        erroEscecao = "Erro ao efetuar o cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, "Erro:" + erroEscecao, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void abrirLoginUsuario (){
        Intent intent = new Intent(CadastroActivity.this, Login.class);
        startActivity(intent);
        finish();

    }

}
