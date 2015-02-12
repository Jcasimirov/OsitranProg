package com.ositran;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "backing_ositran_principal")
@RequestScoped
@Generated(value = "1ositran/principal.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Principal {
    private List<String> imagenes;

    @PostConstruct
    public void init() {
        imagenes = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            imagenes.add("menu" + i + ".jpg");
        }
    }

    public List<String> getImagenes() {
        return imagenes;

    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }
}
