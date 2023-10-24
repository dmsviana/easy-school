package br.edu.ifpb.ads.payments;

public class PixPagamento implements FormaPagamentoStrategy {

    @Override
    public double calcularValorPagamento(double valorMensalidade) {
        //sem acréscimo ou desconto
        return valorMensalidade;
    }

}

