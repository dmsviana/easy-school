package br.edu.ifpb.ads.dao;

import br.edu.ifpb.ads.model.Administrador;

public interface IAdministradorDAO {


    void salvarAdmin(Administrador admin) throws Exception;

    Administrador autenticarAdministrador(String email, String senha) throws Exception;


}
