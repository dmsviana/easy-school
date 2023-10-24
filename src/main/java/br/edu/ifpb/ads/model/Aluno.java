package br.edu.ifpb.ads.model;

import java.time.LocalDate;

import br.edu.ifpb.ads.model.enums.Nivel;
import br.edu.ifpb.ads.model.enums.Turno;
import br.edu.ifpb.ads.payments.FormaPagamentoStrategy;

public class Aluno extends Pessoa {
    private String email;
    private String telefone;
    private String matricula;
    private Turno turno;
    private Nivel nivel;
    private LocalDate dataMatricula;
    private Mensalidade mensalidade;
    private boolean ativo;

    public Aluno() {
    }

    public Aluno(String nome, LocalDate dataNascimento, String email, String telefone, String matricula, Turno turno, Nivel nivel, LocalDate dataMatricula, double valorMensalidade, LocalDate dataVencimento) {
        super(nome, dataNascimento);
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.turno = turno;
        this.nivel = nivel;
        this.dataMatricula = dataMatricula;
        this.ativo = true;
        this.mensalidade = new Mensalidade(valorMensalidade, dataVencimento);
    }



    public Aluno(String nome, LocalDate dataNascimento, String email, String telefone, String matricula, Turno turno, Nivel nivel, LocalDate dataMatricula, double valorMensalidade, LocalDate dataVencimento, FormaPagamentoStrategy formaPagamentoStrategy) {
        super(nome, dataNascimento);
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.turno = turno;
        this.nivel = nivel;
        this.dataMatricula = dataMatricula;
        this.ativo = true;
        this.mensalidade = new Mensalidade(valorMensalidade, dataVencimento, formaPagamentoStrategy);
    }

    public void realizarPagamento() {
        mensalidade.calcularPagamento();
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

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return "Aluno [email=" + email + ", telefone=" + telefone + ", matricula=" + matricula + ", turno=" + turno
                + ", nivel=" + nivel + ", dataMatricula=" + dataMatricula + ", mensalidade=" + mensalidade + ", ativo="
                + ativo + "]";
    }


    

    

}

