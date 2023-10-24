package br.edu.ifpb.ads.model;

import java.time.LocalDate;

import br.edu.ifpb.ads.payments.FormaPagamentoStrategy;

public class Mensalidade {

    private double valor;
    private LocalDate dataVencimento;
    private boolean pago;
    private FormaPagamentoStrategy formaPagamentoStrategy;


    public Mensalidade(){
        this.pago = false;

    }

    public Mensalidade(double valor, LocalDate dataVencimento){
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = false;
    }

    public Mensalidade(double valor, LocalDate dataVencimento, FormaPagamentoStrategy formaPagamentoStrategy) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = false;
        this.formaPagamentoStrategy = formaPagamentoStrategy;
    }

    public boolean isMensalidadeAtrasada(){
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.isAfter(dataVencimento) && !pago;
    }

    public int calcularDiasAtraso(){
        LocalDate dataAtual = LocalDate.now();
        return (int) dataVencimento.until(dataAtual).getDays();
    }


    public void calcularPagamento(){
        if (!pago){
            double valorFinal = formaPagamentoStrategy.calcularValorPagamento(valor);

            if (isMensalidadeAtrasada()){
                int diasAtraso = calcularDiasAtraso();
                valorFinal += (valor * 0.01 * diasAtraso);

            }

            efetuarPagamento(valorFinal);
        }
    }

    public void efetuarPagamento(double valorFinal){
        this.pago = true;
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
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public FormaPagamentoStrategy getFormaPagamentoStrategy() {
        return formaPagamentoStrategy;
    }

    public void setFormaPagamentoStrategy(FormaPagamentoStrategy formaPagamentoStrategy) {
        this.formaPagamentoStrategy = formaPagamentoStrategy;
    }

    

}
