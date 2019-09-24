package com.example.dell.airsoft.Entidades;

import com.example.dell.airsoft.Firebase.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {

    private String id;
    private String Nome;
    private String Sobrenome;
    private String email;
    private String senha;
    private String aniversario;
    private String sexo;

    private String opcionais;
    private String quantidadeBolinhas;
    private String quantidadeHoras;



    public Usuarios() {
    }

    public void Salvar (){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("Usuario").child(String.valueOf(getId())).setValue(this);
        referenciaFirebase.child("Opcionais").child(String.valueOf(getOpcionais())).setValue(this);
        referenciaFirebase.child("Quantidade de Bolinhas").child(String.valueOf(getQuantidadeBolinhas())).setValue(this);
        referenciaFirebase.child("Quantidade de Horas").child(String.valueOf(getQuantidadeHoras())).setValue(this);
    }

    @Exclude
        public Map<String, Object>toMap(){
        HashMap<String, Object> hashMapUsuario = new HashMap<>();
        hashMapUsuario.put("id", getId());
        hashMapUsuario.put("email", getEmail());
        hashMapUsuario.put("senha", getSenha());
        hashMapUsuario.put("Nome", getNome());
        hashMapUsuario.put("Sobrenome", getSobrenome());
        hashMapUsuario.put("aniversario", getAniversario());
        hashMapUsuario.put("sexo", getSexo());
        hashMapUsuario.put("Opcional", getOpcionais());
        hashMapUsuario.put("Bolinhas", getQuantidadeBolinhas());
        hashMapUsuario.put("Horas", getQuantidadeHoras());


        return hashMapUsuario;


    }
    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public String getQuantidadeBolinhas() {
        return quantidadeBolinhas;
    }

    public void setQuantidadeBolinhas(String quantidadeBolinhas) {
        this.quantidadeBolinhas = quantidadeBolinhas;
    }

    public String getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(String quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
