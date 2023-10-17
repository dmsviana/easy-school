package br.edu.ifpb.ads;

import java.time.LocalDate;
import java.util.Scanner;

import br.edu.ifpb.ads.controller.AlunoController;
import br.edu.ifpb.ads.model.Aluno;
import br.edu.ifpb.ads.model.enums.Nivel;
import br.edu.ifpb.ads.model.enums.Turno;
import br.edu.ifpb.ads.pagamento.CartaoPagamento;
import br.edu.ifpb.ads.pagamento.DinheiroPagamento;
import br.edu.ifpb.ads.pagamento.FormaPagamentoStrategy;
import br.edu.ifpb.ads.pagamento.PixPagamento;

public class MainAluno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Alunos");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o email do aluno: ");
        String email = scanner.nextLine();

        System.out.print("Digite o telefone do aluno: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        System.out.print("Digite o turno do aluno (MANHA, TARDE ou NOITE): ");
        Turno turno = Turno.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Digite o nível do aluno (GRADUACAO ou POS_GRADUACAO): ");
        Nivel nivel = Nivel.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Digite a data de matrícula (AAAA-MM-DD): ");
        LocalDate dataMatricula = LocalDate.parse(scanner.nextLine());

        System.out.print("Digite o valor da mensalidade: ");
        double valorMensalidade = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite a data de vencimento da mensalidade (AAAA-MM-DD): ");
        LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());

        System.out.print("Escolha a forma de pagamento (DINHEIRO, CARTAO, ou PIX): ");
        FormaPagamentoStrategy formaPagamentoStrategy;

        String formaPagamento = scanner.nextLine().toUpperCase();
        switch (formaPagamento) {
            case "DINHEIRO":
                formaPagamentoStrategy = new DinheiroPagamento();
                break;
            case "CARTAO":
                formaPagamentoStrategy = new CartaoPagamento();
                break;
            case "PIX":
                formaPagamentoStrategy = new PixPagamento();
                break;
            default:
                System.out.println("Forma de pagamento inválida. Usando PIX como padrão.");
                formaPagamentoStrategy = new PixPagamento();
        }

        Aluno aluno = new Aluno(nome, dataNascimento, email, telefone, matricula, turno, nivel, dataMatricula, valorMensalidade, dataVencimento, formaPagamentoStrategy);

        System.out.println("Aluno cadastrado com sucesso!");
        System.out.println("Dados do Aluno:");
        System.out.println(aluno);

        System.out.print("Deseja realizar o pagamento da mensalidade? (S/N): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            aluno.realizarPagamento();
            System.out.println("Pagamento efetuado com sucesso!");
        }

        System.out.print("Deseja tornar o aluno inativo? (S/N): ");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            aluno.setAtivo(false);
            System.out.println("Aluno inativado com sucesso!");
        }

        System.out.println("Status do Aluno: " + (aluno.isAtivo() ? "Ativo" : "Inativo"));

        scanner.close();

        AlunoController alunoController = new AlunoController();
        alunoController.adicionarAluno(aluno);
    }
}

