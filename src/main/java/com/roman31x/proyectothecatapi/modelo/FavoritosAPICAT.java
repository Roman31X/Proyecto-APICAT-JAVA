package com.roman31x.proyectothecatapi.modelo;

public class FavoritosAPICAT {
    String id;
    String image_id;
    String apikey = "live_vmEy0KXJwkfhMX8fRRGzqqfTrcqAHcf7IgN4D2OAtzC9FsA7D11wgTtJEbKLyyTk";
    DatosImagenAPICAT image;

    public FavoritosAPICAT() {
    }

    public FavoritosAPICAT(String id, String image_id) {
        this.id = id;
        this.image_id = image_id;
    }    

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage_id() {
        return image_id;
    }
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public DatosImagenAPICAT getImage() {
        return image;
    }
    public void setImage(DatosImagenAPICAT image) {
        this.image = image;
    }
}
