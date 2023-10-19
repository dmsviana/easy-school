package br.edu.ifpb.ads;

import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import br.edu.ifpb.ads.controller.AdminController;
import br.edu.ifpb.ads.model.Administrador;
import br.edu.ifpb.ads.views.LoginGUI;

public class Application {


    public static void main(String[] args) {

       Administrador admin = new Administrador();
        admin.setNome("Diogo Marcelo");
        admin.setDataNascimento(LocalDate.of(1998, 7, 17));
        admin.setEmail("admin");
        admin.setSenha("admin");

        AdminController adminController = new AdminController();
        adminController.salvarAdmin(admin);

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes.flat");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new LoginGUI().setVisible(true));
    }
}
