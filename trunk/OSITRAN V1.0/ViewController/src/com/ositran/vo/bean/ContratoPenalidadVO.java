
package com.ositran.vo.bean;

import java.util.Date;


public class ContratoPenalidadVO {
    
    private Integer conId;    
    private Integer monId;    
    private Integer pesId;
    private Date tcpFecha;
    private Integer tcpId;
    private String tcpMotivo;
    private Long tcpTotal;
    private String tcpEstado;

    public ContratoPenalidadVO() {
        super();
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getPesId() {
        return pesId;
    }

    public void setPesId(Integer pesId) {
        this.pesId = pesId;
    }

    public Date getTcpFecha() {
        return tcpFecha;
    }

    public void setTcpFecha(Date tcpFecha) {
        this.tcpFecha = tcpFecha;
    }

    public Integer getTcpId() {
        return tcpId;
    }

    public void setTcpId(Integer tcpId) {
        this.tcpId = tcpId;
    }

    public String getTcpMotivo() {
        return tcpMotivo;
    }

    public void setTcpMotivo(String tcpMotivo) {
        this.tcpMotivo = tcpMotivo;
    }

    public Long getTcpTotal() {
        return tcpTotal;
    }

    public void setTcpTotal(Long tcpTotal) {
        this.tcpTotal = tcpTotal;
    }

    public String getTcpEstado() {
        return tcpEstado;
    }

    public void setTcpEstado(String tcpEstado) {
        this.tcpEstado = tcpEstado;
    }
}
