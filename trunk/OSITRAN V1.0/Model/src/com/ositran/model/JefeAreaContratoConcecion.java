package com.ositran.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_JEFE_AREA")

public class JefeAreaContratoConcecion implements Serializable {
    private static final long serialVersionUID = -8358715111071088266L;
    @Id
    @Column(name = "SJA_ID", nullable = false)
    private int sjaId;
    @Column(name = "SJA_NOMBRE", length = 50)
    private String sjaNombre;
    @Column(name = "SJA_NUMERO_DOCUMENTO", length = 20)
    private String sjaNumeroDocumento;
    @Column(name = "SJA_TIPO_DOCUMENTO", length = 20)
    private String sjaTipoDocumento;
    @Column(name = "SJA_TIPO_INFRAESTRUCTURA", nullable = false)
    private int sjaTipoInfraestructura;

    public JefeAreaContratoConcecion() {
    }

    public JefeAreaContratoConcecion(int sjaId, String sjaNombre, String sjaNumeroDocumento,
                                     String sjaTipoDocumento, int sjaTipoInfraestructura) {
        this.sjaId = sjaId;
        this.sjaNombre = sjaNombre;
        this.sjaNumeroDocumento = sjaNumeroDocumento;
        this.sjaTipoDocumento = sjaTipoDocumento;
        this.sjaTipoInfraestructura = sjaTipoInfraestructura;
    }

    public int getSjaId() {
        return sjaId;
    }

    public void setSjaId(int sjaId) {
        this.sjaId = sjaId;
    }

    public String getSjaNombre() {
        return sjaNombre;
    }

    public void setSjaNombre(String sjaNombre) {
        this.sjaNombre = sjaNombre;
    }

    public String getSjaNumeroDocumento() {
        return sjaNumeroDocumento;
    }

    public void setSjaNumeroDocumento(String sjaNumeroDocumento) {
        this.sjaNumeroDocumento = sjaNumeroDocumento;
    }

    public String getSjaTipoDocumento() {
        return sjaTipoDocumento;
    }

    public void setSjaTipoDocumento(String sjaTipoDocumento) {
        this.sjaTipoDocumento = sjaTipoDocumento;
    }

    public int getSjaTipoInfraestructura() {
        return sjaTipoInfraestructura;
    }

    public void setSjaTipoInfraestructura(int sjaTipoInfraestructura) {
        this.sjaTipoInfraestructura = sjaTipoInfraestructura;
    }
}
