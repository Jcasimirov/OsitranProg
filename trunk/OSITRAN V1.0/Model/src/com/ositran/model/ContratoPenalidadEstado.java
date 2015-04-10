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
@NamedQueries({
              @NamedQuery(name = "ContratoPenalidadEstado.findAll",
                          query = "select o from ContratoPenalidadEstado o") })
@Table(name = "T_CONTRATO_PENALIDAD_ESTADO")
@GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "SQ_CONTRATO_PENALIDAD_ESTADO"))
public class ContratoPenalidadEstado implements Serializable {
    private static final long serialVersionUID = 588393599642511983L;
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "PES_ID", nullable = false)
    private Integer pesId;
    @Column(name = "PES_NOMBRE", nullable = false, length = 50)
    private String pesNombre;

    public ContratoPenalidadEstado() {
    }

    public ContratoPenalidadEstado(Integer pesId, String pesNombre) {
        this.pesId = pesId;
        this.pesNombre = pesNombre;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public String getPesNombre() {
        return pesNombre;
    }

    public void setPesNombre(String pesNombre) {
        this.pesNombre = pesNombre;
    }
}
