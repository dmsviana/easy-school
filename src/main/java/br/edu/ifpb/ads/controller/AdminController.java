package br.edu.ifpb.ads.controller;

import javax.swing.JOptionPane;

import br.edu.ifpb.ads.dao.impl.AdministradorDaoImpl;
import br.edu.ifpb.ads.model.Administrador;

public class AdminController {
    

    private AdministradorDaoImpl administradorDAO;

    public AdminController(){
        this.administradorDAO = AdministradorDaoImpl.getInstance();
    }

    public void salvarAdmin(Administrador administrador){
        try {
            administradorDAO.salvarAdmin(administrador);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Administrador autenticarAdministrador(String email, String senha){
        
        try {
            Administrador admin = administradorDAO.autenticarAdministrador(email, senha);
            return admin;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
       
       
    }


}
