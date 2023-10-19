package br.edu.ifpb.ads.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("ADMIN")
public class Administrador extends Pessoa {


    private String email;
    private String senha;
    


    public Administrador() {
    }



    public Administrador(String nome, LocalDate dataNascimento, String email, String senha) {
        super(nome, dataNascimento);
        this.email = email;
        this.senha = senha;
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



    
}
