package com.example.dell.airsoft;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainAcitivy extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botao = findViewById(R.id.btlogin);
        Button btnReserva = findViewById(R.id.btCad);
        Button btnMis = findViewById(R.id.btmissoes);
        Button btnValores = findViewById(R.id.btVal);
        Button btnequipamentos = findViewById(R.id.btEqui);
        Button btnEndereço = findViewById(R.id.btEnd);
        Button imagens = findViewById(R.id.btimg);


        botao.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, Login.class);
                startActivity(intent);
            }
        });



        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, ReservaActivity.class);
                startActivity(intent);
            }
        });




        btnMis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, Tela_missoes.class);
                startActivity(intent);

            }
        });

        btnValores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, EmBreve.class);
                startActivity(intent);
            }
        });

        btnEndereço.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, EmBreve.class);
                startActivity(intent);
            }
        });

        btnequipamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, EmBreve.class);
                startActivity(intent);
            }
        });

        imagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAcitivy.this, EmBreve.class);
                startActivity(intent);
            }
        });

    }}
