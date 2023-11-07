package br.edu.ifpb.ads.model;

import java.time.LocalDate;

import br.edu.ifpb.ads.payments.FormaPagamentoStrategy;

public class Mensalidade {

    private double valor;
    private LocalDate dataVencimento;
    private boolean paga;
    private FormaPagamentoStrategy formaPagamentoStrategy;


    public Mensalidade() {
        this.paga = false;
    }

    public Mensalidade(double valor) {
        this.valor = valor;
        this.paga = false;
    }
    
    public Mensalidade(double valor, LocalDate dataVencimento) {
    	this.valor = valor;
    	this.dataVencimento = dataVencimento;
    	this.paga = false;
    }

    public Mensalidade(double valor, LocalDate dataVencimento, FormaPagamentoStrategy formaPagamentoStrategy) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.paga = false;
        this.formaPagamentoStrategy = formaPagamentoStrategy;
    }

    public boolean isMensalidadeAtrasada(){
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.isAfter(dataVencimento) && !paga;
    }

    public int calcularDiasAtraso(){
        LocalDate dataAtual = LocalDate.now();
        return (int) dataVencimento.until(dataAtual).getDays();
    }


    public void calcularPagamento(){
        if (!paga){
            double valorFinal = formaPagamentoStrategy.calcularValorPagamento(valor);

            if (isMensalidadeAtrasada()){
                int diasAtraso = calcularDiasAtraso();
                valorFinal += (valor * 0.01 * diasAtraso);

            }

            efetuarPagamento(valorFinal);
        }
    }

    public void efetuarPagamento(double valorFinal){
        this.paga = true;
        this.valor = valorFinal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPago() {
        return paga;
    }

    public void setPago(boolean paga) {
        this.paga = paga;
    }

    public FormaPagamentoStrategy getFormaPagamentoStrategy() {
        return formaPagamentoStrategy;
    }

    public void setFormaPagamentoStrategy(FormaPagamentoStrategy formaPagamentoStrategy) {
        this.formaPagamentoStrategy = formaPagamentoStrategy;
    }

    

}
