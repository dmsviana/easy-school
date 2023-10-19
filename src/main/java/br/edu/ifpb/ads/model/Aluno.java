package br.edu.ifpb.ads.model;

import java.time.LocalDate;

import br.edu.ifpb.ads.model.enums.Nivel;
import br.edu.ifpb.ads.model.enums.Turno;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa {

    private String email;
    private String telefone;
    private String matricula;
    private Turno turno;
    private Nivel nivel;
    private LocalDate dataMatricula;
    private boolean ativo;

    public Aluno() {
    }

    public Aluno(String nome, LocalDate dataNascimento, String email, String telefone, String matricula, Turno turno,
            Nivel nivel, LocalDate dataMatricula, double valorMensalidade, LocalDate dataVencimento) {
        super(nome, dataNascimento);
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.turno = turno;
        this.nivel = nivel;
        this.dataMatricula = dataMatricula;
        this.ativo = true;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {
        return "Aluno [email=" + email + ", telefone=" + telefone + ", matricula=" + matricula + ", turno=" + turno
                + ", nivel=" + nivel + ", dataMatricula=" + dataMatricula + ", ativo="
                + ativo + "]";
    }

}
