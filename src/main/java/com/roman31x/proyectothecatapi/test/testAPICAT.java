package com.roman31x.proyectothecatapi.test;

import com.roman31x.proyectothecatapi.controlador.ControladorServiciosAPICAT;
import com.roman31x.proyectothecatapi.modelo.DatosAPICAT;
import java.io.IOException;
import javax.swing.JOptionPane;

public class testAPICAT {
    public static void main(String[] args) throws IOException {
        int opcion = -1;
        //Variable de tipo arreglo para almacenar las opciones del menú
        String[] botones = {
          " [1] - Ver gatos",
          " [2] - Ver Favoritos",
          " [3] - Salir"
        };

        //Bucle para iterar el menu y capturar la opción ingresada por consola
        do{
            //Capturar la opcion del Menú principal
            String accion = (String) JOptionPane.showInputDialog(null,"Esta listo para ver Gatitos",
                    "Este es el menu de la Interfaz",JOptionPane.INFORMATION_MESSAGE,null,botones,botones[0]);

            for (int i=0;i<botones.length;i++){
                if(accion.equals(botones[i])){
                    opcion = i;
                }
            }

            switch (opcion){
                case 0:
                    ControladorServiciosAPICAT.VerGatos();
                    break;
                case 1:
                    DatosAPICAT gato = new DatosAPICAT();
                    ControladorServiciosAPICAT.VerFavoritos(gato.getApiKey());
                default:
                    break;
            }

        }while(opcion != 1);

    }
}
