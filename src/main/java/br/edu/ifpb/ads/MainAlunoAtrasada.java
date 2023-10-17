package br.edu.ifpb.ads;

import java.time.LocalDate;

import br.edu.ifpb.ads.controller.AlunoController;
import br.edu.ifpb.ads.model.Aluno;
import br.edu.ifpb.ads.model.enums.Nivel;
import br.edu.ifpb.ads.model.enums.Turno;
import br.edu.ifpb.ads.pagamento.DinheiroPagamento;
import br.edu.ifpb.ads.pagamento.FormaPagamentoStrategy;

public class MainAlunoAtrasada {

    public static void main(String[] args) {
        FormaPagamentoStrategy formaPagamentoStrategy = new DinheiroPagamento(); // Forma de pagamento em dinheiro
        LocalDate dataMatricula = LocalDate.of(2023, 1, 15); // Data de matrícula
        LocalDate dataVencimento = LocalDate.of(2023, 2, 1); // Data de vencimento (atrasada)
        double valorMensalidade = 1000.0; // Valor da mensalidade

        Aluno aluno = new Aluno("Joao", LocalDate.of(2000, 5, 10), "joao@email.com", "123456789", "MAT123", Turno.MANHA, Nivel.BASICO, dataMatricula, valorMensalidade, dataVencimento, formaPagamentoStrategy);

        System.out.println("Aluno cadastrado com sucesso!");
        System.out.println("Dados do Aluno:");
        System.out.println(aluno);

        System.out.print("Deseja realizar o pagamento da mensalidade? (S/N): ");
        String resposta = "S"; // Simular que o usuário escolheu sim

        if (resposta.equalsIgnoreCase("S")) {
            aluno.realizarPagamento();
            System.out.println("Pagamento efetuado com sucesso!");
        }

        System.out.println("Status do Aluno: " + (aluno.isAtivo() ? "Ativo" : "Inativo"));

        AlunoController alunoController = new AlunoController();
        alunoController.adicionarAluno(aluno);
    }
}
