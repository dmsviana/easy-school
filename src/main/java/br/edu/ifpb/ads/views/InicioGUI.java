package br.edu.ifpb.ads.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import br.edu.ifpb.ads.factory.aluno.AlunoFactoryGUI;
import br.edu.ifpb.ads.utils.Imagens;
import br.edu.ifpb.ads.views.components.JButtonPadrao;
import br.edu.ifpb.ads.views.components.JLabelTitulo;
import br.edu.ifpb.ads.views.components.JanelaPadrao;
import br.edu.ifpb.ads.views.ouvintes.OuvinteBotoesTelaInicial;

public class InicioGUI extends JanelaPadrao {

    public InicioGUI() {
        super("Easy School - Início");
        adicionarLabels();
        adicionarImagens();
        adicionarButtons();
        adicionarSeparador();
        adicionarMenuBar();
    }


    private void adicionarLabels() {
        //TODO adicionar nome do usuário logado -> buscar na base de dados
        JLabel lblTitulo = new JLabelTitulo("Olá, bem-vindo de volta!", 510, 5, 300, 50);
        add(lblTitulo);

    }

    private void adicionarImagens() {
        JLabel lblImagemInicio = new JLabel(Imagens.INICIO_FLAT);
        lblImagemInicio.setBounds(5, 35, 368, 368);
        add(lblImagemInicio);
    }

    private void adicionarButtons(){
        JButton btnAlunos = new JButtonPadrao("Alunos", 510, 95, 300, 50);
        btnAlunos.addActionListener(new OuvinteBotoesTelaInicial(new AlunoFactoryGUI(), this));
        add(btnAlunos);

        JButton btnProfessores = new JButtonPadrao("Professores", 510, 155, 300, 50);
        add(btnProfessores);

        JButton btnTurmas = new JButtonPadrao("Turmas", 510, 215, 300, 50);
        add(btnTurmas);

        JButton btnFinanceiro = new JButtonPadrao("Financeiro", 510, 275, 300, 50);


        btnFinanceiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Mensageiro.send();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        add(btnFinanceiro);
    }

    private void adicionarSeparador(){
        JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
        separador.setBounds(370, 0, 5, 500);
        separador.setForeground(Color.GRAY);
        add(separador);
    }

    private void adicionarMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Opções");
        menuBar.add(menu);

        JMenuItem itemSobre = new JMenuItem("Sobre");
        //TODO adicionar action listener (ação) -> exibir janela com informações sobre o sistema
        menu.add(itemSobre);

        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI().setVisible(true);
            }
        });
        menu.add(itemSair);

    }

}
