package com.roman31x.proyectothecatapi.controlador;

import com.roman31x.proyectothecatapi.modelo.FavoritosAPICAT;
import com.roman31x.proyectothecatapi.vista.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class Controlador_MenuFavoritos implements ActionListener{
    private final Menu_Favoritos menuFavorito;
    private MENU_PRINCIPAL menuPrincipal;
    
    private FavoritosAPICAT gato;
    
    private Controlador_MenuInicio controlInicio;
    
    private String nombre = "";

    public Controlador_MenuFavoritos(Menu_Favoritos menuFavorito3) {
        this.menuFavorito = menuFavorito3;
        
        menuFavorito.Nombre.addActionListener(this);
        menuFavorito.VER.addActionListener(this);
        menuFavorito.ELIMINAR.addActionListener(this);
        menuFavorito.REGRESAR.addActionListener(this);
    }
    
    public void Mostrar(){
        this.menuFavorito.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        gato = new FavoritosAPICAT();
        menuPrincipal = new MENU_PRINCIPAL();
        
        switch(accion){
            case "VER FOTO":
                nombre = menuFavorito.Nombre.getSelectedItem().toString();
                ControladorServiciosAPI.VerFavorito(nombre,menuFavorito);
                break;
            case "ELIMINAR DE  FAVORITO":
                nombre = menuFavorito.Nombre.getSelectedItem().toString();
                try {
                    ControladorServiciosAPI.EliminarFavorito(nombre,menuFavorito);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                break;

            case "REGRESAR":
                controlInicio = new Controlador_MenuInicio(menuPrincipal);
                try {
                    controlInicio.Mostrar();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Controlador_MenuFavoritos.class.getName()).log(Level.SEVERE, null, ex);
                }
                menuFavorito.setVisible(false);
                break;    
    
        }
        



        
        /*
        try {
                    ControladorServiciosAPICAT.VerFavoritos(gato.getApiKey());
                } catch (IOException ex) {
                    Logger.getLogger(Controlador_MenuInicio.class.getName()).log(Level.SEVERE, null, ex);
                }*/
    }
}
