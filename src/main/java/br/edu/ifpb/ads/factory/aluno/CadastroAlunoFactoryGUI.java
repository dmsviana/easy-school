package br.edu.ifpb.ads.factory.aluno;

import javax.swing.JFrame;

import br.edu.ifpb.ads.factory.FactoryGUI;
import br.edu.ifpb.ads.views.aluno.CadastroAlunoGUI;

public class CadastroAlunoFactoryGUI implements FactoryGUI {

    @Override
    public JFrame criarGUI() {
        return new CadastroAlunoGUI();
    }
    
}
