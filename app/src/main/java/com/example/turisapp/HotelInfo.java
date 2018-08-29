package com.example.turisapp;

import android.view.View;

public class HotelInfo {
    HotelInfo(int imagen, String nombre, String descripcion, String ubicacion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }


    int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    private int imagen;
    String nombre, descripcion, ubicacion;

}
