package br.edu.ifpb.ads.factory.aluno;

import javax.swing.JFrame;

import br.edu.ifpb.ads.factory.FactoryGUI;
import br.edu.ifpb.ads.views.aluno.AlunoGUI;

public class AlunoFactoryGUI implements FactoryGUI {

    @Override
    public JFrame criarGUI() {
        return new AlunoGUI();
    }
    
}
