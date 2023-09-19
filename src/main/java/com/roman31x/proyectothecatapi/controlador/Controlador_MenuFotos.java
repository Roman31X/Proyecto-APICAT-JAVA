package com.roman31x.proyectothecatapi.controlador;

import com.roman31x.proyectothecatapi.vista.*;
import java.awt.Desktop;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class Controlador_MenuFotos implements ActionListener{
    private final Menu_Fotos menufotos;
    private MENU_PRINCIPAL menuPrincipal;

    private Controlador_MenuInicio menuInicio;
    
    public Controlador_MenuFotos(Menu_Fotos menufotos2) {
        this.menufotos = menufotos2;
        
        menufotos.Foto.addActionListener(this);
        menufotos.favorito.addActionListener(this);
        menufotos.Regresar.addActionListener(this);
        menufotos.Navegador.addActionListener(this);
    }
    
    public void Mostrar(){
        this.menufotos.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        menuPrincipal = new MENU_PRINCIPAL();
        switch(accion){
            case "VER FOTO":
                try {
                    ControladorServiciosAPI.VerGatos(menufotos);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                break;
            case "navegador":
                String link = menufotos.url.getText();
                    try {
                        Desktop.getDesktop().browse(new URI(link));
                    } catch (URISyntaxException ex) {
                        System.out.println(ex);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                break;
            case "AGREGAR FAVORITO":
                ControladorServiciosAPI.AgregarFavorito(menufotos);
                break;
            case "REGRESAR":
                menuInicio = new Controlador_MenuInicio(menuPrincipal);
                try {
                    menuInicio.Mostrar();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Controlador_MenuFotos.class.getName()).log(Level.SEVERE, null, ex);
                }
                menufotos.setVisible(false);
                break;    
    
        }
    }
    
}
