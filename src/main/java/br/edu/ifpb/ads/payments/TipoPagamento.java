package br.edu.ifpb.ads.pagamento;

public enum TipoPagamento {

    PIX("Pix") {

        @Override
        public FormaPagamentoStrategy obterFormaPagamento() {
           return new PixPagamento();
        }
    },
    DINHEIRO("Dinheiro") {

        @Override
        public FormaPagamentoStrategy obterFormaPagamento() {
            return new DinheiroPagamento();
        }
    },
    CARTAO("Cartão") {
        
        @Override
        public FormaPagamentoStrategy obterFormaPagamento() {
          return new CartaoPagamento();
        }
    };

    private String descricao;

    TipoPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public abstract FormaPagamentoStrategy obterFormaPagamento();

}
