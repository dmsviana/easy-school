package br.edu.ifpb.ads.views.components;

import javax.swing.JButton;
import java.awt.Insets;

import br.edu.ifpb.ads.utils.Imagens;

public class JButtonVoltar extends JButton {


    public JButtonVoltar(){
        super(Imagens.VOLTAR);
        setMargin(new Insets(0, 0, 0, 0));
        setBorder(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setToolTipText("Voltar");
    }


    
}
