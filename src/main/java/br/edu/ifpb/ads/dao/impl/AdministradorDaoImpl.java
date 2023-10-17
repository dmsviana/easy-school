package br.edu.ifpb.ads.dao.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.TypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import br.edu.ifpb.ads.dao.AdministradorDAO;
import br.edu.ifpb.ads.dto.AdministradorDTO;
import br.edu.ifpb.ads.model.Administrador;

public class AdministradorDaoImpl implements AdministradorDAO {

    private static final String XML_FILE_PATH = "admin.xml";
    private XStream xstream;
    private String emailSalvo;
    private boolean statusCheckBox = false;

    public AdministradorDaoImpl() {
        xstream = new XStream(new DomDriver());

        TypePermission allowAll = new AnyTypePermission();
        TypePermission allowAdministrador = new WildcardTypePermission(new String[] { "model.Administrador" });
        xstream.addPermission(allowAll);
        xstream.addPermission(allowAdministrador);

        xstream.alias("administador", Administrador.class);
    }


    private Administrador recuperarDados(){
        try {
            FileInputStream fileInputStream = new FileInputStream(XML_FILE_PATH);
            return (Administrador) xstream.fromXML(fileInputStream);
        } catch (IOException ex){
            return new Administrador();
        }
    }

    private void salvarDados(Administrador administrador){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(XML_FILE_PATH);
            xstream.toXML(administrador, fileOutputStream);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void salvarAdmin(AdministradorDTO admin) {
        Administrador administrador = new Administrador();
        administrador.setNome(admin.getNome());
        administrador.setEmail(admin.getEmail());
        administrador.setSenha(admin.getSenha());
        administrador.setDataNascimento(admin.getDataNascimento());

        salvarDados(administrador);

    }
    
    @Override
    public Administrador autenticarAdmin(String email, String senha) {
        Administrador administrador = recuperarDados();
        if (administrador.getEmail().equals(email) && administrador.getSenha().equals(senha)) {
            return administrador;
        }
        return null;
    }


    public String getEmailSalvo() {
        return emailSalvo;
    }


    public void setEmailSalvo(String emailSalvo) {
        this.emailSalvo = emailSalvo;
    }


    public boolean isStatusCheckBox() {
        return statusCheckBox;
    }


    public void setStatusCheckBox(boolean statusCheckBox) {
        this.statusCheckBox = statusCheckBox;
    }

    


}
