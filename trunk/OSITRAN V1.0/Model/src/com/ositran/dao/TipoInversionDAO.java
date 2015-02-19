package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.InversionTipo;

import java.util.List;

public interface TipoInversionDAO {
     public List<InversionTipo> query();
     public String insert(InversionTipo inversionTipo);
        public String delete(Integer id);
        public String update(InversionTipo inversionTipo);
        public InversionTipo get(Integer id);
        public List<InversionTipo> query1(String buscar);
}
