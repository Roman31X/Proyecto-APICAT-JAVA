package com.roman31x.proyectothecatapi.modelo;

public class DatosAPICAT {
    String id;
    String url;
    String apiKey = "AGREGAR APIKEY";
    String imagen;

    public DatosAPICAT() {
    }

    public DatosAPICAT(String id, String url, String imagen) {
        this.id = id;
        this.url = url;
        this.imagen = imagen;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
