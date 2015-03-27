package com.ositran.vo.bean;
import java.util.Date;

public class AvanceInversionWebVO {
    private int csiId;
    private int invId;
    private Date iwcFechaFin;
    private Date iwcFechaInicio;
    private int iwcId;
    private int mcoId;
    private int monId;
    private int tinId;

    public AvanceInversionWebVO() {
    }

    public AvanceInversionWebVO(int csiId, int invId, Date iwcFechaFin, Date iwcFechaInicio,
                               int iwcId, int mcoId, int monId, int tinId) {
        this.csiId = csiId;
        this.invId = invId;
        this.iwcFechaFin = iwcFechaFin;
        this.iwcFechaInicio = iwcFechaInicio;
        this.iwcId = iwcId;
        this.mcoId = mcoId;
        this.monId = monId;
        this.tinId = tinId;
    }

    public int getCsiId() {
        return csiId;
    }

    public void setCsiId(int csiId) {
        this.csiId = csiId;
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }

    public Date getIwcFechaFin() {
        return iwcFechaFin;
    }

    public void setIwcFechaFin(Date iwcFechaFin) {
        this.iwcFechaFin = iwcFechaFin;
    }

    public Date getIwcFechaInicio() {
        return iwcFechaInicio;
    }

    public void setIwcFechaInicio(Date iwcFechaInicio) {
        this.iwcFechaInicio = iwcFechaInicio;
    }

    public int getIwcId() {
        return iwcId;
    }

    public void setIwcId(int iwcId) {
        this.iwcId = iwcId;
    }

    public int getMcoId() {
        return mcoId;
    }

    public void setMcoId(int mcoId) {
        this.mcoId = mcoId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getTinId() {
        return tinId;
    }

    public void setTinId(int tinId) {
        this.tinId = tinId;
    }
}
