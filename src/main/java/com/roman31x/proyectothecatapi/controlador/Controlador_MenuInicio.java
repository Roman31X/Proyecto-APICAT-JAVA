package com.roman31x.proyectothecatapi.controlador;

import com.roman31x.proyectothecatapi.vista.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Controlador_MenuInicio implements ActionListener{
    private final MENU_PRINCIPAL menuPrincipal;
    private Menu_Fotos menuFotos;
    private Menu_Favoritos menuFavoritos;
    
    private Controlador_MenuFotos controlFoto;
    private Controlador_MenuFavoritos controlFavoritos;
    private Clip musica;
        
    public Controlador_MenuInicio(MENU_PRINCIPAL menuPrincipal1) {
        this.menuPrincipal = menuPrincipal1;
        
        menuPrincipal.Foto.addActionListener(this);
        menuPrincipal.Favorito.addActionListener(this);
        menuPrincipal.Salir.addActionListener(this);
    }
    
    public void Mostrar() throws LineUnavailableException {
        this.menuPrincipal.setVisible(true);
        musica = Musica(1);
        musica.start(); 
    }
    
    public Clip Musica(int dato)throws LineUnavailableException{
        InputStream ruta;
        if(dato == 1){
            ruta =getClass().getResourceAsStream("/Sonidos/gatoXD.wav");
        }else{
            ruta =getClass().getResourceAsStream("/Sonidos/modelo.wav");
        }
        
        Clip clip;
        clip = AudioSystem.getClip();
        try {
            clip.open(AudioSystem.getAudioInputStream(ruta));
        } catch (UnsupportedAudioFileException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        return clip;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        menuFotos = new Menu_Fotos();
        menuFavoritos = new Menu_Favoritos();
        switch(accion){
            case "VER FOTO GATO":
                controlFoto = new Controlador_MenuFotos(menuFotos);
                musica.stop();
                controlFoto.Mostrar();
                menuPrincipal.setVisible(false);
                break;
            case "VER GATO FAVORITO":
                musica.stop();
                try {
                    musica = Musica(2);
                } catch (LineUnavailableException ex) {
                    System.out.println(ex);
                }
                musica.start();
                try {
                    ControladorServiciosAPI.Favoritos(menuFavoritos);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                controlFavoritos = new Controlador_MenuFavoritos(menuFavoritos);
                controlFavoritos.Mostrar();
                menuPrincipal.setVisible(false);
                break;

            case "SALIR":
                System.exit(0);
                break;
        }
    }
}
