package com.ositran.vo.bean;

public class JefeAreaContratoConcecionVO {
 
    private int sjaId;
    private String sjaNombre;
    private String sjaNumeroDocumento;
    private String sjaTipoDocumento;
    private int sjaTipoInfraestructura;
    

    public JefeAreaContratoConcecionVO() {
    }

    public JefeAreaContratoConcecionVO(int sjaId, String sjaNombre, String sjaNumeroDocumento,
                                     String sjaTipoDocumento, int sjaTipoInfraestructura) {
        this.sjaId = sjaId;
        this.sjaNombre = sjaNombre;
        this.sjaNumeroDocumento = sjaNumeroDocumento;
        this.sjaTipoDocumento = sjaTipoDocumento;
        this.sjaTipoInfraestructura = sjaTipoInfraestructura;
    }


    public void setSjaId(int sjaId) {
        this.sjaId = sjaId;
    }

    public int getSjaId() {
        return sjaId;
    }

    public void setSjaNombre(String sjaNombre) {
        this.sjaNombre = sjaNombre;
    }

    public String getSjaNombre() {
        return sjaNombre;
    }

    public void setSjaNumeroDocumento(String sjaNumeroDocumento) {
        this.sjaNumeroDocumento = sjaNumeroDocumento;
    }

    public String getSjaNumeroDocumento() {
        return sjaNumeroDocumento;
    }

    public void setSjaTipoDocumento(String sjaTipoDocumento) {
        this.sjaTipoDocumento = sjaTipoDocumento;
    }

    public String getSjaTipoDocumento() {
        return sjaTipoDocumento;
    }

    public void setSjaTipoInfraestructura(int sjaTipoInfraestructura) {
        this.sjaTipoInfraestructura = sjaTipoInfraestructura;
    }

    public int getSjaTipoInfraestructura() {
        return sjaTipoInfraestructura;
    }


}
