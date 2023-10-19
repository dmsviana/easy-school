package br.edu.ifpb.ads.views.aluno;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import br.edu.ifpb.ads.utils.Imagens;
import br.edu.ifpb.ads.views.InicioGUI;
import br.edu.ifpb.ads.views.components.JButtonPadrao;
import br.edu.ifpb.ads.views.components.JButtonVoltar;
import br.edu.ifpb.ads.views.components.JTextFieldPadrao;
import br.edu.ifpb.ads.views.components.JanelaPadrao;

public class AlunoGUI extends JanelaPadrao {


    public AlunoGUI() {
        super("Easy School - Alunos");
        adicionarImagens();
        adicionarButtons();
        adicionarTextFields();
        adicionarLabels();
    }


    private void adicionarImagens() {
        JLabel lblAlunoFlat = new JLabel(Imagens.ALUNO_FLAT);
        lblAlunoFlat.setBounds(0, 35, 368, 387);
        add(lblAlunoFlat);
    }

    private void adicionarTextFields() {
        JTextFieldPadrao txtBuscar = new JTextFieldPadrao("Buscar aluno", 395, 60, 200, 25);
        add(txtBuscar);
    }

    private void adicionarLabels() {
        JLabel lblPesquisar = new JLabel(Imagens.PESQUISAR);
        lblPesquisar.setBounds(375, 65, 16, 16);
        add(lblPesquisar);
    }

    private void adicionarButtons() {
        JButtonVoltar btnVoltar = new JButtonVoltar();
        btnVoltar.setBounds(10, 10, 50, 50);
        btnVoltar.addActionListener(e -> {
            dispose();
            new InicioGUI().setVisible(true);
        });
        add(btnVoltar);

        JButton btnAdicionarAluno = new JButtonPadrao("Novo", 655, 60, 100, 25);
        btnAdicionarAluno.setIcon(Imagens.ADICIONAR);
        add(btnAdicionarAluno);

        JButton btnAtualizarAluno = new JButtonPadrao("Atualizar", 765, 60, 100, 25);
        btnAtualizarAluno.setIcon(Imagens.EDITAR);
        add(btnAtualizarAluno);

        JButton btnRemoverAluno = new JButtonPadrao("Remover", 875, 60, 100, 25);
        btnRemoverAluno.setIcon(Imagens.DELETAR);
        add(btnRemoverAluno);

    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes.flat");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        new AlunoGUI().setVisible(true);
    }

}
