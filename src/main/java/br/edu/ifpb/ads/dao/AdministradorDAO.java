package br.edu.ifpb.ads.dao;

import br.edu.ifpb.ads.dto.AdministradorDTO;
import br.edu.ifpb.ads.model.Administrador;

public interface AdministradorDAO {


    void salvarAdmin(AdministradorDTO admin);

    Administrador autenticarAdmin(String email, String senha);


}
