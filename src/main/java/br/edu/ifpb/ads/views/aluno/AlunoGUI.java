package br.edu.ifpb.ads.views.aluno;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import br.edu.ifpb.ads.controller.AlunoController;
import br.edu.ifpb.ads.model.Aluno;
import br.edu.ifpb.ads.utils.Imagens;
import br.edu.ifpb.ads.views.InicioGUI;
import br.edu.ifpb.ads.views.components.JButtonPadrao;
import br.edu.ifpb.ads.views.components.JButtonVoltar;
import br.edu.ifpb.ads.views.components.JTextFieldPadrao;
import br.edu.ifpb.ads.views.components.JanelaPadrao;

public class AlunoGUI extends JanelaPadrao {


    private JCheckBox filtroAlunosAtivos;
    private JTable tabelaAlunos;
    private JScrollPane painelTabela;
    private DefaultTableModel modeloTabela;
    private AlunoController alunoController;

    public AlunoGUI() {
        super("Easy School - Alunos");
        alunoController = new AlunoController();
        setSize(1200, 700);
        setLocationRelativeTo(null);
        adicionarCheckBox();
        adicionarImagens();
        adicionarButtons();
        adicionarTextFields();
        adicionarTabela();
        adicionarLabels();
    }

    private DefaultTableModel getModeloTabela(){
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("E-mail");
        modeloTabela.addColumn("Data Nascimento");
        modeloTabela.addColumn("Telefone");
        modeloTabela.addColumn("Matrícula");
        modeloTabela.addColumn("Nível");
        modeloTabela.addColumn("Turno");
        return modeloTabela;

    }

    private void adicionarTabela(){

        modeloTabela = getModeloTabela();

        List<Aluno> listaDeAlunos = alunoController.listarAlunos();

        for(Aluno aluno : listaDeAlunos){
            Object[] linha = new Object[7];
            linha[0] = aluno.getNome();
            linha[1] = aluno.getEmail();
            linha[2] = aluno.getDataNascimento();
            linha[3] = aluno.getTelefone();
            linha[4] = aluno.getMatricula();
            linha[5] = aluno.getNivel();
            linha[6] = aluno.getTurno();
            modeloTabela.addRow(linha);
        }

        tabelaAlunos = new JTable(modeloTabela);
        tabelaAlunos.setAutoscrolls(true);
        
        painelTabela = new JScrollPane(tabelaAlunos);
        painelTabela.setBounds(375, 100, 800, 500);
        add(painelTabela);
        repaint();

    }

    private void adicionarCheckBox(){
        filtroAlunosAtivos = new JCheckBox("Alunos Ativos");
        filtroAlunosAtivos.setBounds(375, 610, 120, 25);
        filtroAlunosAtivos.addActionListener(new OuvinteFiltroCheckBox());
        add(filtroAlunosAtivos);
    }

    private void adicionarImagens() {
        JLabel lblAlunoFlat = new JLabel(Imagens.ALUNO_FLAT);
        lblAlunoFlat.setBounds(0, 85, 368, 387);
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

        JButton btnAdicionarAluno = new JButtonPadrao("Novo", 855, 60, 100, 25);
        btnAdicionarAluno.setIcon(Imagens.ADICIONAR);
        add(btnAdicionarAluno);

        JButton btnAtualizarAluno = new JButtonPadrao("Atualizar", 965, 60, 100, 25);
        btnAtualizarAluno.setIcon(Imagens.EDITAR);
        add(btnAtualizarAluno);

        JButton btnRemoverAluno = new JButtonPadrao("Remover", 1075, 60, 100, 25);
        btnRemoverAluno.setIcon(Imagens.DELETAR);
        add(btnRemoverAluno);

    }


    private class OuvinteFiltroCheckBox implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(filtroAlunosAtivos.isSelected()){
                remove(painelTabela);
                modeloTabela = getModeloTabela();
                List<Aluno> listaDeAlunos = alunoController.listarAlunos();
                for(Aluno aluno : listaDeAlunos){
                    if(aluno.isAtivo()){
                        Object[] linha = new Object[7];
                        linha[0] = aluno.getNome();
                        linha[1] = aluno.getEmail();
                        linha[2] = aluno.getDataNascimento();
                        linha[3] = aluno.getTelefone();
                        linha[4] = aluno.getMatricula();
                        linha[5] = aluno.getNivel().getNivel();
                        linha[6] = aluno.getTurno().getTurno();
                        modeloTabela.addRow(linha);
                    }
                }

                tabelaAlunos = new JTable(modeloTabela);
                tabelaAlunos.setAutoscrolls(true);
                painelTabela = new JScrollPane(tabelaAlunos);
                painelTabela.setBounds(375, 100, 800, 500);
                add(painelTabela);
                repaint();

            }
            else {
                remove(painelTabela);
                adicionarTabela();
                repaint();
            }
            repaint();
        }

    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes.flat");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        new AlunoGUI().setVisible(true);
    }




}
