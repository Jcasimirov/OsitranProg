package com.ositran.vo.bean;
import java.math.BigDecimal;
import java.util.Date;

public class InvAvnSupervisadaDetalleVO {
    public InvAvnSupervisadaDetalleVO() {
        super();
    }
    private BigDecimal asdEstado;
    private Date asdFechaRegistro;
    private BigDecimal asdId;
    private BigDecimal iasNumero;
    private BigDecimal isdIgv;
    private BigDecimal isdMontoPresentado;
    private int monId;
    private BigDecimal tiaTotal;
    private BigDecimal iasMontoRevisado;


    public void setAsdEstado(BigDecimal asdEstado) {
        this.asdEstado = asdEstado;
    }

    public BigDecimal getAsdEstado() {
        return asdEstado;
    }

    public void setAsdFechaRegistro(Date asdFechaRegistro) {
        this.asdFechaRegistro = asdFechaRegistro;
    }

    public Date getAsdFechaRegistro() {
        return asdFechaRegistro;
    }

    public void setAsdId(BigDecimal asdId) {
        this.asdId = asdId;
    }

    public BigDecimal getAsdId() {
        return asdId;
    }

    public void setIasNumero(BigDecimal iasNumero) {
        this.iasNumero = iasNumero;
    }

    public BigDecimal getIasNumero() {
        return iasNumero;
    }

    public void setIsdIgv(BigDecimal isdIgv) {
        this.isdIgv = isdIgv;
    }

    public BigDecimal getIsdIgv() {
        return isdIgv;
    }

    public void setIsdMontoPresentado(BigDecimal isdMontoPresentado) {
        this.isdMontoPresentado = isdMontoPresentado;
    }

    public BigDecimal getIsdMontoPresentado() {
        return isdMontoPresentado;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMonId() {
        return monId;
    }

    public void setTiaTotal(BigDecimal tiaTotal) {
        this.tiaTotal = tiaTotal;
    }

    public BigDecimal getTiaTotal() {
        return tiaTotal;
    }

    public void setIasMontoRevisado(BigDecimal iasMontoRevisado) {
        this.iasMontoRevisado = iasMontoRevisado;
    }

    public BigDecimal getIasMontoRevisado() {
        return iasMontoRevisado;
    }
}
