package com.softulp.menunavpractica.modelos;

import java.io.Serializable;

public class Ciudad implements Serializable {

    private String nombre;
    private int img;
    private double distancia;
    private int habitantes;

    public Ciudad(String nombre, int img, double distancia, int habitantes) {
        this.nombre = nombre;
        this.img = img;
        this.distancia = distancia;
        this.habitantes = habitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImg() {
        return img;
    }

    public double getDistancia() {
        return distancia;
    }

    public int getHabitantes() {
        return habitantes;
    }
}
