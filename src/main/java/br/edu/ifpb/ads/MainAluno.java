package br.edu.ifpb.ads;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.ifpb.ads.controller.AlunoController;
import br.edu.ifpb.ads.model.Aluno;
import br.edu.ifpb.ads.model.Mensalidade;
import br.edu.ifpb.ads.model.enums.Nivel;
import br.edu.ifpb.ads.model.enums.Turno;
import br.edu.ifpb.ads.payments.FormaPagamentoStrategy;
import br.edu.ifpb.ads.payments.TipoPagamento;

public class MainAluno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Alunos");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), formatador);

        System.out.print("Digite o email do aluno: ");
        String email = scanner.nextLine();

        System.out.print("Digite o telefone do aluno: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        System.out.print("Digite o turno do aluno (MANHA, TARDE ou NOITE): ");
        Turno turno = Turno.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Digite o nível do aluno (BASICO, INTERMEDIARIO, AVANCADO): ");
        Nivel nivel = Nivel.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Digite a data de matrícula (dd/MM/yyyy): ");
        LocalDate dataMatricula = LocalDate.parse(scanner.nextLine(), formatador);

        System.out.print("Digite o valor da mensalidade: ");
        double valorMensalidade = Double.parseDouble(scanner.nextLine());


        System.out.print("Escolha a forma de pagamento (PIX, DINHEIRO, ou CARTAO): ");
        String formaPagamento = scanner.nextLine().toUpperCase();

        TipoPagamento tipoPagamento = TipoPagamento.valueOf(formaPagamento);

        FormaPagamentoStrategy formaPagamentoStrategy = tipoPagamento.obterFormaPagamento();

        // Gere mensalidades automaticamente
        LocalDate dataInicioMensalidades = dataMatricula.plusMonths(1);
        Mensalidade[] mensalidades = new Mensalidade[5];
        for (int i = 0; i < 5; i++) {
            mensalidades[i] = new Mensalidade(valorMensalidade);
            dataInicioMensalidades = dataInicioMensalidades.plusMonths(1);
        }

        Aluno aluno = new Aluno(nome, dataNascimento, email, telefone, matricula, turno, nivel, dataMatricula, valorMensalidade, formaPagamentoStrategy);
        aluno.definirMensalidades(mensalidades);
        System.out.println("Aluno cadastrado com sucesso!");
        System.out.println("Dados do Aluno:");
        System.out.println(aluno);

        while (true) {
            System.out.print("Deseja realizar o pagamento de mensalidades? (S/N): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                for (int i = 0; i < 5; i++) {
                    if (!aluno.getMensalidades()[i].isPago()) {
                        System.out.println("Mensalidade #" + (i + 1) + ": " + aluno.getMensalidades()[i].getDataVencimento());
                    }
                }

                System.out.print("Digite o número da mensalidade que deseja pagar (1 a 5), ou 0 para sair: ");
                int numeroMensalidade = Integer.parseInt(scanner.nextLine());

                if (numeroMensalidade == 0) {
                    break;
                }

                if (numeroMensalidade >= 1 && numeroMensalidade <= 5 && !aluno.getMensalidades()[numeroMensalidade - 1].isPago()) {
                    aluno.getMensalidades()[numeroMensalidade - 1].calcularPagamento();
                    System.out.println("Pagamento da Mensalidade #" + numeroMensalidade + " efetuado com sucesso!");
                } else {
                    System.out.println("Número de mensalidade inválido ou já paga.");
                }
            } else {
                break;
            }
        }


        System.out.println("Status do Aluno: " + (aluno.isAtivo() ? "Ativo" : "Inativo"));

        scanner.close();

        AlunoController alunoController = new AlunoController();
        alunoController.adicionarAluno(aluno);
    }
}