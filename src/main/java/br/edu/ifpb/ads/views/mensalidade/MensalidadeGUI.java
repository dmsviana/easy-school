package br.edu.ifpb.ads.views.mensalidade;

import br.edu.ifpb.ads.utils.Imagens;
import br.edu.ifpb.ads.views.components.JButtonVoltar;
import br.edu.ifpb.ads.views.components.JanelaPadrao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MensalidadeGUI extends JanelaPadrao {

    private JButton btnRealizarPagamento;
    private JButton btnCancelarMatricula;
    private JCheckBox filtrarAlunosAtrasadosCheckbox;
    private JButton btnEnviarNotificacao;
    private JLabel titulo;
    private JTable tabela;
    private JPanel contentPane;

    public MensalidadeGUI() {
        super("Easy School - Mensalidades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        adicionarLabels();
        adicionarButtons();
        adicionarTabela();

    }

    private void adicionarButtons() {
        // Botões
        JPanel buttonPanel = new JPanel();
        btnRealizarPagamento = new JButton("Realizar Pagamento");
        btnCancelarMatricula = new JButton("Cancelar Matrícula");
        filtrarAlunosAtrasadosCheckbox = new JCheckBox("Filtrar por alunos com mensalidades atrasadas");
        btnEnviarNotificacao = new JButton("Enviar Notificação");
        JButtonVoltar btnVoltar = new JButtonVoltar();
        btnVoltar.setBounds(0, 0, 50, 50);
        
        buttonPanel.add(filtrarAlunosAtrasadosCheckbox, BorderLayout.PAGE_END);
        buttonPanel.add(btnRealizarPagamento);
        buttonPanel.add(btnCancelarMatricula);
        buttonPanel.add(btnEnviarNotificacao);
        contentPane.add(btnVoltar);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        


    }

    private void adicionarTabela() {
        // Tabela
        tabela = new JTable(new Object[][] {
                { null, null, null },
                { null, null, null },
                { null, null, null },
                { null, null, null }
        }, new String[] { "Aluno", "Valor Mensalidade", "Data Vencimento" });
        JScrollPane scrollPane = new JScrollPane(tabela);
        contentPane.add(scrollPane, BorderLayout.CENTER);

    }

    private void adicionarLabels() {
        // Título
        titulo = new JLabel("Mensalidades");
        titulo.setFont(new Font("Roboto", Font.BOLD, 36));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(titulo, BorderLayout.NORTH);


        JLabel lblPagamentoImagem = new JLabel(Imagens.PAGAMENTO);
        contentPane.add(lblPagamentoImagem, BorderLayout.WEST);

    }

}
