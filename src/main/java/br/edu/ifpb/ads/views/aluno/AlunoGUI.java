package br.edu.ifpb.ads.views.aluno;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
import br.edu.ifpb.ads.views.components.JLabelTitulo;
import br.edu.ifpb.ads.views.components.JTextFieldPadrao;
import br.edu.ifpb.ads.views.components.JanelaPadrao;

public class AlunoGUI extends JanelaPadrao {


    private JCheckBox filtroAlunosAtivos;
    private JTable tabelaAlunos;
    private JScrollPane painelTabela;
    private DefaultTableModel modeloTabela;
    private AlunoController alunoController;
    private JPanel conteudoPainel;
    
    public AlunoGUI() {
        super("Easy School - Alunos");
        alunoController = new AlunoController();
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        conteudoPainel = new JPanel();
        setContentPane(conteudoPainel);
        conteudoPainel.setLayout(new BorderLayout());
        adicionarImagens();
        adicionarButtons();
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

    // Método para adicionar um aluno à tabela
    private void adicionarAlunoNaTabela(Aluno aluno) {
        Object[] linha = new Object[7];
        linha[0] = aluno.getNome();
        linha[1] = aluno.getEmail();
        linha[2] = aluno.getDataNascimento();
        linha[3] = aluno.getTelefone();
        linha[4] = aluno.getMatricula();
        linha[5] = aluno.getNivel().getDescricao();
        linha[6] = aluno.getTurno().getDescricao();
        modeloTabela.addRow(linha);
    }

    private void adicionarTabela(){
        modeloTabela = getModeloTabela();
        List<Aluno> listaDeAlunos = alunoController.listarAlunos();
        for(Aluno aluno : listaDeAlunos){
            adicionarAlunoNaTabela(aluno);
        }
        tabelaAlunos = new JTable(modeloTabela);
        tabelaAlunos.setAutoscrolls(true);
        painelTabela = new JScrollPane(tabelaAlunos);
        conteudoPainel.add(painelTabela, BorderLayout.CENTER);
    }


    private void adicionarImagens() {
        JLabel lblAlunoFlat = new JLabel(Imagens.ALUNO_FLAT);
        conteudoPainel.add(lblAlunoFlat, BorderLayout.WEST);
    }

    private void adicionarLabels() {

        JLabel lblTitulo = new JLabelTitulo("Alunos");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        conteudoPainel.add(lblTitulo, BorderLayout.NORTH);
    }

    private void adicionarButtons() {
        JButtonVoltar btnVoltar = new JButtonVoltar();
        btnVoltar.setBounds(10, 10, 50, 50);
        btnVoltar.addActionListener(e -> {
            dispose();
            new InicioGUI().setVisible(true);
        });
        add(btnVoltar);


        JPanel painelBotoes = new JPanel();
        JButton btnNovo = new JButtonPadrao("Adicionar Aluno");
        btnNovo.setIcon(Imagens.ADICIONAR);
        JButton btnAtualizarAluno = new JButtonPadrao("Editar Aluno");
        btnAtualizarAluno.setIcon(Imagens.EDITAR);
        JButton btnRemoverAluno = new JButtonPadrao("Remover Aluno");
        btnRemoverAluno.setIcon(Imagens.DELETAR);

        JTextFieldPadrao txtBuscar = new JTextFieldPadrao("Buscar Aluno");
        JLabel lblPesquisar = new JLabel(Imagens.PESQUISAR);
        filtroAlunosAtivos = new JCheckBox("Mostrar apenas alunos ativos");
        filtroAlunosAtivos.addActionListener(new OuvinteFiltroCheckBox());
        

        painelBotoes.add(filtroAlunosAtivos);
        painelBotoes.add(lblPesquisar);
        painelBotoes.add(txtBuscar);
        painelBotoes.add(btnNovo);
        painelBotoes.add(btnAtualizarAluno);
        painelBotoes.add(btnRemoverAluno);
        conteudoPainel.add(painelBotoes, BorderLayout.SOUTH);

    }


    private class OuvinteFiltroCheckBox implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            modeloTabela.setRowCount(0);
            List<Aluno> listaDeAlunos = alunoController.listarAlunos();
    
            for (Aluno aluno : listaDeAlunos) {
                if (!filtroAlunosAtivos.isSelected() || aluno.isAtivo()) {
                    adicionarAlunoNaTabela(aluno);
                }
            }
    
            tabelaAlunos.repaint();
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
