package com.ositran.vo.bean;



public class MonedaVO {
   
  
    private Integer monId;   
    private String monNombre;  
    private String monSimbolo;
    String monAbreviatura;
    
    public MonedaVO() {
    }


    public void setMonId(Integer monId) {
        this.monId = monId;
    }

    public Integer getMonId() {
        return monId;
    }

    public void setMonAbreviatura(String monAbreviatura) {
        this.monAbreviatura = monAbreviatura;
    }

    public String getMonAbreviatura() {
        return monAbreviatura;
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
}
