package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.Infraestructura;

import java.util.List;

public interface InfraestructuraDAO {
    public List<Infraestructura> query();
    public String insert(Infraestructura infraestructura);
       public String delete(Integer id);
       public String update(Infraestructura infraestructura);
       public InfraestructuraTipo get(Integer id);
       public List<Infraestructura> query1(Integer codigoC);

}
