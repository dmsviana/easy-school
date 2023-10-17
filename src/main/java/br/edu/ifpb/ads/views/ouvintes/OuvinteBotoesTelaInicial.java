package br.edu.ifpb.ads.views.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.edu.ifpb.ads.factory.FactoryGUI;

public class OuvinteBotoesTelaInicial implements ActionListener {
    
    private FactoryGUI fabricaGUI;
    private JFrame janelaAnterior;


    public OuvinteBotoesTelaInicial(FactoryGUI fabricaGUI, JFrame janelaAnterior){
        this.fabricaGUI = fabricaGUI;
        this.janelaAnterior = janelaAnterior;
    }


        @Override
        public void actionPerformed(ActionEvent e) {
           JFrame tela = fabricaGUI.criarGUI();
            janelaAnterior.dispose();
            tela.setVisible(true);
        }
    
}
