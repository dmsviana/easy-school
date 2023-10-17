package br.edu.ifpb.ads.controller;

import java.util.List;
import java.util.Vector;

import br.edu.ifpb.ads.dao.AlunoDAO;
import br.edu.ifpb.ads.dao.impl.AlunoDaoImpl;
import br.edu.ifpb.ads.model.Aluno;

public class AlunoController {

    private AlunoDAO alunoDAO;

    public AlunoController(){
        alunoDAO = new AlunoDaoImpl();
    }

    public List<Aluno> listarAlunos(){
        return alunoDAO.listarAlunos();
    }



    public Aluno buscarAluno(String matricula){
        return alunoDAO.buscarAluno(matricula);
    }

    public void adicionarAluno(Aluno aluno){
        alunoDAO.adicionarAluno(aluno);
    }

    public void atualizarAluno(Aluno aluno) {
        alunoDAO.atualizarAluno(aluno);
    }

    public void removerAluno(String matricula) {
        alunoDAO.removerAluno(matricula);
    }


    
}
