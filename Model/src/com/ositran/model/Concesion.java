package com.ositran.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Concesion.findAll", query = "select o from Concesion o") })
@Table(name = "T_CONCESION")
@SequenceGenerator(name = "TConcesion_Id_Seq_Gen", sequenceName = "T_CONCESION_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class Concesion implements Serializable {
    
    @Id
    @Column(name = "CON_ID", nullable = false)
    private Integer conId;
    @Column(name = "CON_NOMBRE", length = 100)
    private String conNombre;
    @Column(name = "CON_NOMINFRA", length = 100)
    private String conNominfra;
    @Column(name = "CON_TIPOINFRA", length = 100)
    private String conTipoinfra;

    public Concesion() {
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNominfra(String conNominfra) {
        this.conNominfra = conNominfra;
    }

    public String getConNominfra() {
        return conNominfra;
    }

    public void setConTipoinfra(String conTipoinfra) {
        this.conTipoinfra = conTipoinfra;
    }

    public String getConTipoinfra() {
        return conTipoinfra;
    }

}
