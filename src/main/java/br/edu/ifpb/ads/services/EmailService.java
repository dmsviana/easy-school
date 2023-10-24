package br.edu.ifpb.ads.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

import br.edu.ifpb.ads.model.Aluno;

public class EmailService {

    private static String remetente = "myseriespoo@gmail.com";
    private static String senha = "eaxv gnrp lcpr ohft";
    private static String assunto = "Agradecemos sua inscrição";

    public String enviarContrato(Aluno aluno) throws Exception {

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(remetente);
            email.setSubject(assunto);
            email.setMsg("Olá, " + aluno.getNome() + "!\n\n" +"Seja bem-vindo a Easy! Escola de Idiomas.\n\n" + "Segue em anexo o contrato de matrícula.\n\n" + "Atenciosamente,\n" + "Equipe Easy! Escola de Idiomas");

            EmailAttachment contratoAnexo = new EmailAttachment();
            contratoAnexo.setPath("CONTRATO-EASY 2023.1.pdf");
            contratoAnexo.setName("contrato-matricula.pdf");
            email.attach(contratoAnexo);
            

            email.addTo(aluno.getEmail());

            email.send();
            return "Email enviado com sucesso!";

        } catch (Exception e) {
            return "Falha ao enviar email!";
        }
    }


    public String enviarCobrancaMensalidade(Aluno aluno) throws Exception{
        try {
            return "Email enviado com sucesso!";
        } catch (Exception e){
            throw new Exception("Falha ao enviar email!");
        }
    }
}
