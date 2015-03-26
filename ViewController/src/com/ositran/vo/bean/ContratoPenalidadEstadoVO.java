package com.ositran.vo.bean;

import org.hibernate.annotations.GenericGenerator;


public class ContratoPenalidadEstadoVO {
    
    private Integer pesId;
    private String pesNombre;

    public ContratoPenalidadEstadoVO() {
        super();
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
