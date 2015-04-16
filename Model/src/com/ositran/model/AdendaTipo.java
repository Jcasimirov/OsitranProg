package com.ositran.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@NamedQueries({ @NamedQuery(name = "AdendaTipo.findAll", query = "select o from AdendaTipo o") })
@Table(name = "T_ADENDA_TIPO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_T_ADENDA_TIPO"))
public class AdendaTipo implements Serializable {
    private static final long serialVersionUID = 3787160805495589073L;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "TAD_ID", nullable = false)
    private Integer tadId;
    @Column(name = "TAD_NOMBRE", nullable = false, length = 50)
    private String tadNombre;

    public AdendaTipo() {
    }

    public AdendaTipo(Integer tadId, String tadNombre) {
        this.tadId = tadId;
        this.tadNombre = tadNombre;
    }

    public Integer getTadId() {
        return tadId;
    }

    public void setTadId(Integer tadId) {
        this.tadId = tadId;
    }

    public String getTadNombre() {
        return tadNombre;
    }

    public void setTadNombre(String tadNombre) {
        this.tadNombre = tadNombre;
    }
}
