package com.ositran.reports;

public class AnidadoEstado {
    private int id;
    private String nombre;
    public AnidadoEstado() {
        super();
    }

    public AnidadoEstado(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
