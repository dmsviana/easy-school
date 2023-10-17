package br.edu.ifpb.ads.pagamento;

public class PixPagamento implements FormaPagamentoStrategy {

    @Override
    public double calcularValorPagamento(double valorMensalidade) {
        //sem acréscimo ou desconto
        return valorMensalidade;
    }

}

