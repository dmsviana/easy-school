package br.edu.ifpb.ads.views.aluno;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import br.edu.ifpb.ads.views.components.JLabelTitulo;
import br.edu.ifpb.ads.views.components.JTextFieldPadrao;
import br.edu.ifpb.ads.views.components.JanelaPadrao;

public class CadastroAlunoGUI extends JanelaPadrao {

    private JTextField txtNomeCompleto;
    private JTextField txtMatricula;
    private JTextField txtEmail;
    private JFormattedTextField txtTelefone;
    private JFormattedTextField txtDataNascimento;
    private JFormattedTextField txtDataMatricula;

    public CadastroAlunoGUI() {
        super("Easy School - Cadastro de Aluno");
        adicionarLabels();
        adicionarTextFields();
    }

    private void adicionarLabels() {
        JLabelTitulo lblTitulo = new JLabelTitulo("Cadastro de Aluno", 400, 20, 200, 25);
        add(lblTitulo);

        JLabel lblNomeCompleto = new JLabel("Nome Completo");
        lblNomeCompleto.setBounds(400, 55, 100, 25);
        add(lblNomeCompleto);

        JLabel lblMatricula = new JLabel("Matricula");
        lblMatricula.setBounds(400, 115, 100, 25);
        add(lblMatricula);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(400, 175, 100, 25);
        add(lblEmail);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(400, 235, 100, 25);
        add(lblTelefone);

        JLabel lblDataNascimento = new JLabel("Data Nascimento");
        lblDataNascimento.setBounds(400, 295, 100, 25);
        add(lblDataNascimento);

        JLabel lblDataMatricula = new JLabel("Data Matricula");
        lblDataMatricula.setBounds(400, 355, 100, 25);
        add(lblDataMatricula);

    }

    private void adicionarTextFields() {

        txtNomeCompleto = new JTextFieldPadrao("Digite o nome completo do aluno", 400, 80, 250, 30);

        txtMatricula = new JTextFieldPadrao("Digite a Matricula", 400, 140, 250, 30);

        txtEmail = new JTextFieldPadrao("Digite o email do aluno", 400, 200, 250, 30);

        txtTelefone = formatarCampoTelefone(txtTelefone);
        txtTelefone.setBounds(400, 260, 250, 30);

        txtDataNascimento = formatarCampoData(txtDataNascimento);
        txtDataNascimento.setBounds(400, 320, 250, 30);
        txtDataMatricula = formatarCampoData(txtDataMatricula);

        txtDataMatricula.setBounds(400, 380, 250, 30);

        add(txtNomeCompleto);
        add(txtMatricula);
        add(txtEmail);
        add(txtTelefone);
        add(txtDataNascimento);
        add(txtDataMatricula);
    }

    private JFormattedTextField formatarCampoData(JFormattedTextField textFieldFormatado) {

        try {
            MaskFormatter mask = new MaskFormatter("####-##-##");
            textFieldFormatado = new JFormattedTextField(mask);
            textFieldFormatado.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ANO-MES-DIA");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return textFieldFormatado;
    }

    private JFormattedTextField formatarCampoTelefone(JFormattedTextField textFieldFormatado) {

        try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            textFieldFormatado = new JFormattedTextField(mask);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return textFieldFormatado;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatRobotoFont.install();
            FlatLaf.registerCustomDefaultsSource("themes.flat");
            UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
            FlatMacDarkLaf.setup();
            new CadastroAlunoGUI().setVisible(true);
        });
    }

}
