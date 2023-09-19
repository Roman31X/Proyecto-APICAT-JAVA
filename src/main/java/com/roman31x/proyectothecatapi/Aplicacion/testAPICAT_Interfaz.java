package com.roman31x.proyectothecatapi.Aplicacion;

import com.roman31x.proyectothecatapi.controlador.Controlador_MenuInicio;
import com.roman31x.proyectothecatapi.vista.MENU_PRINCIPAL;
import javax.sound.sampled.LineUnavailableException;

public class testAPICAT_Interfaz {
    public static void main(String[] args) {
        MENU_PRINCIPAL inicio = new MENU_PRINCIPAL();
        
        Controlador_MenuInicio controlMenu = new Controlador_MenuInicio(inicio);
        try {
            controlMenu.Mostrar();
        } catch (LineUnavailableException ex) {
            System.out.println(ex);
        }
        
    }
}
