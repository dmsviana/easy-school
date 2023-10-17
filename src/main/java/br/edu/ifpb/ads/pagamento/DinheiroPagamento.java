package br.edu.ifpb.ads.pagamento;

public class DinheiroPagamento implements FormaPagamentoStrategy {

    @Override
    public double calcularValorPagamento(double valorMensalidade) {
        //desconto de 5%
        return valorMensalidade * 0.95;
    }
    
}
