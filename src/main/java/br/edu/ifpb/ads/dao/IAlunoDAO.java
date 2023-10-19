package br.edu.ifpb.ads.dao;

import java.util.List;

import br.edu.ifpb.ads.model.Aluno;

public interface IAlunoDAO {

    List<Aluno> listarAlunos() throws Exception;
    Aluno buscarAluno(String matricula) throws Exception;
    void salvarAluno(Aluno aluno) throws Exception;
    void atualizarAluno(Aluno aluno) throws Exception;
    void removerAluno(String matricula) throws Exception;
    
}
