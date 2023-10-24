package br.edu.ifpb.ads;

import br.edu.ifpb.ads.controller.AlunoController;
import br.edu.ifpb.ads.model.Aluno;
import br.edu.ifpb.ads.services.EmailService;

public class MainEmail {
    public static void main(String[] args) throws Exception {

        AlunoController alunoController = new AlunoController();

        Aluno aluno = alunoController.buscarAluno("20231024");
        EmailService emailService = new EmailService();

        System.out.println(emailService.enviarContrato(aluno));
    }
}
