package com.roman31x.proyectothecatapi.controlador;

import com.google.gson.Gson;
import com.roman31x.proyectothecatapi.modelo.*;
import com.roman31x.proyectothecatapi.vista.*;
import com.squareup.okhttp.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ControladorServiciosAPI {
    private static DatosAPICAT gato = new DatosAPICAT();
    private static FavoritosAPICAT apis = new FavoritosAPICAT();
    private static FavoritosAPICAT[] gatosFavoritos;
    
    public static void VerGatos(Menu_Fotos fotos) throws IOException{
        
        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search?limit=1")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        //2.- Cortar las primeras llaves de la identación
        //Para cortar la primera llave de la cadena
        json = json.substring(1,json.length());
        //Para cortar la ultima llave de la cadena
        json = json.substring(0,json.length()-1);

        //3.- Creamos un objeto de la clase Gson
        Gson gson = new Gson();
        DatosAPICAT gato = gson.fromJson(json,DatosAPICAT.class);
        
        //REDIMENCIONAMOS LA FOTO
        Image imgen= null;
        URL url = new URL(gato.getUrl());
        imgen = ImageIO.read(url);
        ImageIcon fondoGato = new ImageIcon(imgen);
        Image fondo = fondoGato.getImage();
        Image modificado = null;
        
        //MENU
        if(fondoGato.getIconWidth() <= 400){
            modificado = fondo.getScaledInstance(fondoGato.getIconWidth(),fondoGato.getIconHeight(), Image.SCALE_DEFAULT);
            fotos.nombre.setText(gato.getId());
            fotos.url.setText(gato.getUrl());
            fotos.GatoFoto.setIcon(new javax.swing.ImageIcon(modificado));
        }else{
            if(fondoGato.getIconWidth() < 1000){
                modificado = fondo.getScaledInstance(fondoGato.getIconWidth()/2,fondoGato.getIconHeight()/2, Image.SCALE_SMOOTH);
                fotos.nombre.setText(gato.getId());
                fotos.url.setText(gato.getUrl());
                fotos.GatoFoto.setIcon(new javax.swing.ImageIcon(modificado));
                
            }else{
                modificado = fondo.getScaledInstance(fondoGato.getIconWidth()/2,fondoGato.getIconHeight()/2, Image.SCALE_DEFAULT);
                fotos.nombre.setText(gato.getId());
                fotos.url.setText(gato.getUrl());
                fotos.GatoFoto.setIcon(new javax.swing.ImageIcon(modificado));
                JOptionPane.showMessageDialog(null,"IMAGEN DE GATO ES MUY GRANDE\n"+
                                                               " PARA MEJOR VISUALIZACION \n"+
                                                               "  ABRIRI EN SU NAVEGADOR");
            }
        }
        
    }
    
    public static void AgregarFavorito(Menu_Fotos fotos){
        if(fotos.nombre.getText().equals("MEOWTH")){
            JOptionPane.showMessageDialog(null,"  MEOWTH NO PUEDE SER\n"+
                                                           "AGREGADO A TUS FAVORITOS\n"+
                                                           " SELECCIONES VER FOTO");
        }else{
            try{
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\""+fotos.nombre.getText()+"\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();
            JOptionPane.showMessageDialog(null,"SE A AGREGADO LA FOTO DEL\n"+
                                                               "  GATO A TUS FAVORITOS");
        }catch(IOException e){
            System.out.println(e);
        }
        }
    }
    
    public static void Favoritos(Menu_Favoritos menu) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .get()
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", apis.getApikey())
              .build();
        Response response = client.newCall(request).execute();

        //Creamos un estrig para almacenar la respuesta
        String eljson = response.body().string();

        //Creamos un objeto de tipo Gson
        Gson gson = new Gson();

        //Creamos una estructura de json de favoritos
        gatosFavoritos = gson.fromJson(eljson, FavoritosAPICAT[].class);

        for (int i = 0; i < gatosFavoritos.length; i++) {
            menu.Nombre.addItem(String.valueOf(gatosFavoritos[i].getImage_id()));
        }
    } 
    
    public static void VerFavorito(String nombre, Menu_Favoritos menu){
        int indice = -1;
        for (int i = 0; i < gatosFavoritos.length; i++) {
            if(gatosFavoritos[i].getImage_id().equals(nombre)){
                indice = i;
                break;
            }
        }
        
        if(indice == -1){
            JOptionPane.showMessageDialog(null,"MEOWTH NO SE ENCUENTRA REGISTRADO\n"+
                                                           " EN LA LISTA DE APIS CAT DEBE DE\n"+
                                                           "SELECCIONAR UN NOMBRE DEL COMBOBOX");
        }else{
            FavoritosAPICAT favoritos = gatosFavoritos[indice];
            Image image;
            Image modificado = null;
            try{
                URL url = new URL(favoritos.getImage().getUrl());
                image = ImageIO.read(url);

                ImageIcon fondoGato = new ImageIcon(image);
                if(fondoGato.getIconWidth() <=400){
                    Image fondo = fondoGato.getImage();
                    modificado = fondo.getScaledInstance(fondoGato.getIconWidth(),fondoGato.getIconHeight(), Image.SCALE_DEFAULT);
                    menu.GatoFoto.setIcon(new javax.swing.ImageIcon(image));
                }else{
                    if(fondoGato.getIconWidth() < 1000){
                        Image fondo = fondoGato.getImage();
                        modificado = fondo.getScaledInstance(fondoGato.getIconWidth()/2,fondoGato.getIconHeight()/2, Image.SCALE_DEFAULT);
                        menu.GatoFoto.setIcon(new javax.swing.ImageIcon(image));
                    }else{
                        Image fondo = fondoGato.getImage();
                        modificado = fondo.getScaledInstance(fondoGato.getIconWidth()/2,fondoGato.getIconHeight()/2, Image.SCALE_SMOOTH);
                        menu.GatoFoto.setIcon(new javax.swing.ImageIcon(image));
                    }
                }
            }catch(IOException e){
                    System.out.println(e);
            }
        }
    }
    
    public static void EliminarFavorito(String nombre, Menu_Favoritos menu)throws IOException{
        String idBorrar = "";
        if(nombre.equals("MEOWTH")){
            JOptionPane.showMessageDialog(null,"MEOWTH NO SE ENCUENTRA REGISTRADO\n"+
                                                           "EN LA LISTA DE APIS CAT NO PUEDE\n"+
                                                           "SER ELIMINADO DEBE DE SEELECCIONAR\n"+
                                                           "       UN NOMBRE DEL COMBOBOX");
        }else{
            for (int i = 0; i < gatosFavoritos.length; i++) {
                if(gatosFavoritos[i].getImage_id().equals(nombre)){
                    idBorrar = gatosFavoritos[i].getId();
                    break;
                }            
            }
            try{
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "");
                Request request = new Request.Builder()
                  .url("https://api.thecatapi.com/v1/favourites/"+idBorrar+"")
                  .method("DELETE", body)
                  .addHeader("Content-Type", "application/json")
                  .addHeader("x-api-key", apis.getApikey())
                  .build();
                Response response = client.newCall(request).execute();
                JOptionPane.showMessageDialog(null,"GATO ELIMINADO CORRECTAMENTE\n"+
                                                               "      DE TUS FAVORITOS");
                menu.Nombre.removeAllItems();
                Favoritos(menu);
            }catch(IOException e){
                System.out.println(e);
            }
        }
        
    }
}
