package br.edu.ifpb.ads.dao.impl;

import br.edu.ifpb.ads.dao.DAO;
import br.edu.ifpb.ads.dao.IAdministradorDAO;
import br.edu.ifpb.ads.model.Administrador;
import jakarta.persistence.EntityManager;

public class AdministradorDaoImpl extends DAO implements IAdministradorDAO {


    private static AdministradorDaoImpl adminSingleton;

    private AdministradorDaoImpl(){

    }

    public static synchronized AdministradorDaoImpl getInstance(){
        if(adminSingleton == null){
            adminSingleton = new AdministradorDaoImpl();
        }
        return adminSingleton;
    }

    @Override
    public void salvarAdmin(Administrador admin) throws Exception {

        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(admin);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Erro ao salvar administrador");
        } finally {
            manager.close();
        }
    }

    @Override
    public Administrador autenticarAdministrador(String email, String senha) throws Exception {

        EntityManager manager = getEntityManager();

        try {
            Administrador admin = manager.createQuery("SELECT a FROM Administrador a WHERE a.email = :email AND a.senha = :senha", Administrador.class)
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
            return admin;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao autenticar administrador");
        } finally {
            manager.close();
        }
        
    }
    
}
