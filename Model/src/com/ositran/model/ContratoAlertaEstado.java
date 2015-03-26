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
@NamedQueries({ @NamedQuery(name = "ContratoAlertaEstado.findAll", query = "select o from ContratoAlertaEstado o") })
@Table(name = "T_CONTRATO_ALERTA_ESTADO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SEQ_CONTRATO_ALERTA_ESTADO"))
public class ContratoAlertaEstado implements Serializable {
    private static final long serialVersionUID = -6635949592893340457L;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CAE_ID", nullable = false)
    private Integer caeId;
    @Column(name = "CAE_NOMBRE", nullable = false, length = 50)
    private String caeNombre;

    public ContratoAlertaEstado() {
    }

    public ContratoAlertaEstado(Integer caeId, String caeNombre) {
        this.caeId = caeId;
        this.caeNombre = caeNombre;
    }

    public Integer getCaeId() {
        return caeId;
    }

    public void setCaeId(Integer caeId) {
        this.caeId = caeId;
    }

    public String getCaeNombre() {
        return caeNombre;
    }

    public void setCaeNombre(String caeNombre) {
        this.caeNombre = caeNombre;
    }
}
