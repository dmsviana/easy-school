package br.edu.ifpb.ads.dto;

import java.time.LocalDate;

public class AdministradorDTO {
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    public AdministradorDTO() {
    }

    public AdministradorDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}