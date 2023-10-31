package br.edu.ifpb.ads.factory.mensalidade;

import javax.swing.JFrame;

import br.edu.ifpb.ads.factory.FactoryGUI;
import br.edu.ifpb.ads.views.mensalidade.MensalidadeGUI;

public class MensalidadeFactoryGUI implements FactoryGUI {

    @Override
    public JFrame criarGUI() {
        return new MensalidadeGUI();
    
    }
    
}
