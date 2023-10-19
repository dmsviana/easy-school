package br.edu.ifpb.ads.dao.impl;

import java.util.List;

import br.edu.ifpb.ads.dao.DAO;
import br.edu.ifpb.ads.dao.IAlunoDAO;
import br.edu.ifpb.ads.model.Aluno;
import jakarta.persistence.EntityManager;

public class AlunoDaoImpl extends DAO implements IAlunoDAO {

    @Override
    public List<Aluno> listarAlunos() throws Exception {
        EntityManager manager = getEntityManager();

        try {
            List<Aluno> alunos = manager.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
            return alunos;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao listar alunos");
        } finally {
            manager.close();
        }
            

    }

    @Override
    public Aluno buscarAluno(String matricula) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            Aluno aluno = manager.find(Aluno.class, matricula);
            return aluno;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao buscar aluno");
        } finally {
            manager.close();
        }
    }

    @Override
    public void salvarAluno(Aluno aluno) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(aluno);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Erro ao salvar aluno");
        } finally {
            manager.close();
        }
    }

    @Override
    public void atualizarAluno(Aluno aluno) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.merge(aluno);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Erro ao atualizar aluno");
        } finally {
            manager.close();
        }
    }

    @Override
    public void removerAluno(String matricula) throws Exception {
        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            Aluno aluno = manager.find(Aluno.class, matricula);
            manager.remove(aluno);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Erro ao remover aluno");
        } finally {
            manager.close();
        }
    }

}
