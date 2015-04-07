package com.ositran.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * To create ID generator sequence "T_MONEDA_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_MONEDA_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(name = "T_MONEDA")
@SequenceGenerator(name = "Moneda_Id_Seq_Gen", sequenceName = "MONEDA_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Moneda implements Serializable {
    private static final long serialVersionUID = -5006168602848989530L;
    @Id
    @Column(name = "MON_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Moneda_Id_Seq_Gen")
    private Integer monId;
    @Column(name = "MON_NOMBRE", nullable = false, length = 50)
    private String monNombre;
    @Column(name = "MON_SIMBOLO", length = 3)
    private String monSimbolo;
    @Column(name = "MON_ABREVIATURA", length = 3)
    private String monAbreviatura;

    public Moneda() {
    }

    public Moneda(Integer monId,
                  String monNombre, String monSimbolo, String monAbreviatura) {
        
        this.monId = monId;
        this.monNombre = monNombre;
        this.monSimbolo = monSimbolo;
        this.monAbreviatura = monAbreviatura;
    }


    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonNombre(String monNombre) {
        this.monNombre = monNombre;
    }

    public String getMonNombre() {
        return monNombre;
    }

    public void setMonSimbolo(String monSimbolo) {
        this.monSimbolo = monSimbolo;
    }

    public String getMonSimbolo() {
        return monSimbolo;
    }

    public void setMonAbreviatura(String monAbreviatura) {
        this.monAbreviatura = monAbreviatura;
    }

    public String getMonAbreviatura() {
        return monAbreviatura;
    }
}
