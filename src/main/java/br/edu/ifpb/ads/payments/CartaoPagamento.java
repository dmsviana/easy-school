package br.edu.ifpb.ads.payments;

public class CartaoPagamento implements FormaPagamentoStrategy{

    @Override
    public double calcularValorPagamento(double valorMensalidade) {
        //acréscimo de 3%
        return valorMensalidade * 1.03;
    }
    
}
