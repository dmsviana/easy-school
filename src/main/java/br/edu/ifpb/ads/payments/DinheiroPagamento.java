package br.edu.ifpb.ads.payments;

public class DinheiroPagamento implements FormaPagamentoStrategy {

    @Override
    public double calcularValorPagamento(double valorMensalidade) {
        //desconto de 5%
        return valorMensalidade * 0.95;
    }
    
}
