package br.edu.ifpb.ads.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import br.edu.ifpb.ads.model.Aluno;

public class EmailService {

    private static String remetente = "myseriespoo@gmail.com";
    private static String senha = "eaxv gnrp lcpr ohft";
    private static String assunto = "Agradecemos sua inscrição";

    public String enviarMensagemBoasVindas(Aluno aluno) throws Exception {

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(remetente);
            email.setSubject(assunto);
            email.setHtmlMsg(
                    "<html>" +
                            "<head>" +
                            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" +
                            "<title>Easy!</title>" +
                            "</head>" +
                            "<body style=\"margin: 0; padding: 0\">" +
                            "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">"
                            +
                            "<tr>" +
                            "<td align=\"center\" bgcolor=\"#fff\" style=\"padding: 5px 0 5px 0;\">" +
                            "<img src=\"https://img.freepik.com/vetores-gratis/template-logo-educacao_23-2149493023.jpg?w=740&t=st=1697822659~exp=1697823259~hmac=1c57b79c82f0da2340dda54f5cd72c648c1b66f2c82ec6871b3355919f29014f\" alt=\"Logo Easy!\" width=\"150px\" style=\"display: block;\" />"
                            +
                            "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">" +
                            "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">" +
                            "<tr>" +
                            "<td style=\"color:#1A2226; font-size: 24px; font-family: Roboto, sans-serif\" >" +
                            "<b>" + aluno.getNome() + "</b>" +
                            "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td style=\"padding: 20px 0 30px 0; color:#1A2226; font-size: 16px; font-family: Roboto, sans-serif; line-height: 20px\">" +
                            "É com grande prazer que damos as boas-vindas a você à Escola de Idiomas Easy! Estamos empolgados em tê-lo(a) como nosso mais novo aluno e estamos ansiosos para ajudá-lo a atingir seus objetivos de aprendizado de idiomas." +
                            "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td style=\"padding: 20px 0 30px 0; color:#1A2226; font-size: 16px; font-family: Roboto, sans-serif; line-height: 20px\">"
                            +
                            "Nossa missão na Easy é proporcionar a você uma experiência educacional enriquecedora, na qual você irá aprimorar suas habilidades linguísticas e se envolver em um ambiente de aprendizado acolhedor e estimulante. Temos uma equipe dedicada de instrutores qualificados que irá guiá-lo em cada etapa do seu percurso de aprendizado."
                            +
                            "</td>" +
                            "</tr>" +
                            "</table>" +
                            "</td>" +
                            "</tr>" +
                            "</table>" +
                            "</body>" +
                            "</html>");

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
