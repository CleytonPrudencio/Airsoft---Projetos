package com.example.dell.airsoft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.airsoft.Entidades.Usuarios;
import com.example.dell.airsoft.Firebase.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ReservaActivity extends Activity {

    Button btnres;
    Button btnReserva;
    private DatabaseReference firebase;
    private CheckBox equipamentos;
    private CheckBox bolinhas;
    private CheckBox HJogo;
    private Usuarios equi;

    private Login CLogin;
    private EditText edtemail;
    private EditText edtsenha;
    private Usuarios usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        btnres = (Button) findViewById(R.id.btn_pacotes);
        btnReserva = (Button) findViewById(R.id.btn_reservar);
        String valores = "";
        edtemail = (EditText) findViewById(R.id.EdiEmail);
        edtsenha = (EditText) findViewById(R.id.EditSenha);




        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox checkBox = (CheckBox) findViewById(R.id.check_1hora);
                CheckBox checkBox1 = (CheckBox) findViewById(R.id.check_1e30);
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.check_2Horas);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.check_2e30);
                CheckBox checkBox4 = (CheckBox) findViewById(R.id.check_100);
                CheckBox checkBox5 = (CheckBox) findViewById(R.id.check_150);
                CheckBox checkBox6 = (CheckBox) findViewById(R.id.check_200);
                CheckBox checkBox7 = (CheckBox) findViewById(R.id.check_250);
                CheckBox checkBox8 = (CheckBox) findViewById(R.id.check_300);
                CheckBox checkBox9 = (CheckBox) findViewById(R.id.check_colete);
                CheckBox checkBox10 = (CheckBox) findViewById(R.id.check_luva);
                CheckBox checkBox11 = (CheckBox) findViewById(R.id.check_mascara);


                equi = new Usuarios();
                String valoresHoras = "";
                if (checkBox.isChecked()) {
                    valoresHoras += "1 Hora";
                    equi.setQuantidadeHoras(checkBox.getText().toString());
                    equi.setQuantidadeHoras(checkBox.getText().toString());

                } else if (checkBox1.isChecked()) {
                    valoresHoras += "1 Hora e meia";
                    equi.setQuantidadeHoras(checkBox1.getText().toString());
                    equi.setQuantidadeHoras(checkBox1.getText().toString());

                } else if (checkBox2.isChecked()) {
                    valoresHoras += "2 Horas";
                    equi.setQuantidadeHoras(checkBox2.getText().toString());
                    equi.setQuantidadeHoras(checkBox2.getText().toString());

                } else if (checkBox3.isChecked()) {
                    valoresHoras += "2 Horae e meia";
                    equi.setQuantidadeHoras(checkBox3.getText().toString());
                    equi.setQuantidadeHoras(checkBox3.getText().toString());

                }


                String valoresBolinhas = "";
                if (checkBox4.isChecked()) {
                    valoresBolinhas += "100 Bolinhas";
                    equi.setQuantidadeBolinhas(checkBox4.getText().toString());
                    equi.setQuantidadeBolinhas(checkBox4.getText().toString());

                } else if (checkBox5.isChecked()) {
                    valoresBolinhas += "150 Bolinhas";
                    equi.setQuantidadeBolinhas(checkBox5.getText().toString());
                    equi.setQuantidadeBolinhas(checkBox5.getText().toString());

                } else if (checkBox6.isChecked()) {
                    valoresBolinhas += "200 Bolinhas";
                    equi.setQuantidadeBolinhas(checkBox6.getText().toString());
                    equi.setQuantidadeBolinhas(checkBox6.getText().toString());

                } else if (checkBox7.isChecked()) {
                    valoresBolinhas += "250 Bolinhas";
                    equi.setQuantidadeBolinhas(checkBox7.getText().toString());
                    equi.setQuantidadeBolinhas(checkBox7.getText().toString());

                } else if (checkBox8.isChecked()) {
                    valoresBolinhas += "300 Bolinhas";
                    equi.setQuantidadeBolinhas(checkBox8.getText().toString());
                    equi.setQuantidadeBolinhas(checkBox8.getText().toString());

                }


                String valoresOpcional = "";
                if (checkBox9.isChecked()) {
                    valoresOpcional += "Opcionais";
                    equi.setOpcionais(checkBox9.getText().toString());
                    equi.setOpcionais(checkBox9.getText().toString());

                }
                if (checkBox10.isChecked()) {
                    valoresOpcional += "Opcionais";
                    equi.setOpcionais(checkBox10.getText().toString());
                    equi.setOpcionais(checkBox10.getText().toString());

                }
                if (checkBox11.isChecked()) {
                    valoresOpcional += "Opcionais";
                    equi.setOpcionais(checkBox11.getText().toString());
                    equi.setOpcionais(checkBox11.getText().toString());

                }


                salvarEquip(equi);
            }
            });

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pacotes = new Intent(ReservaActivity.this, PacotesActivity.class);
                startActivity(pacotes);
            }
        });
            }


            private boolean salvarEquip(Usuarios usuarios) {
                try {
                    firebase = ConfiguracaoFirebase.getFirebase().child("Reserva");

                    firebase.child(equi.getOpcionais()).setValue(equi);
                    Toast.makeText(ReservaActivity.this, "Reserva feita com sucesso", Toast.LENGTH_LONG).show();

                    return true;

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }


        }