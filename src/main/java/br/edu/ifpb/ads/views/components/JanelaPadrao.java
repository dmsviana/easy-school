package br.edu.ifpb.ads.views.components;

import javax.swing.JFrame;

import br.edu.ifpb.ads.utils.Imagens;

public abstract class JanelaPadrao extends JFrame {
    

    public JanelaPadrao(String titulo){
        setSize(1000, 500);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setIconImage(Imagens.SISTEMA.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
