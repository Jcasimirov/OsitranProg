package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.InversionTipo;

import com.ositran.model.InversionTipoDescripcion;

import java.util.List;

public interface InversionDescripcionDAO {
        public List<InversionTipoDescripcion> query();
        public String insert(InversionTipoDescripcion inversionTipoDes);
        public String delete(Integer id);
        public String update(InversionTipoDescripcion inversionTipoDes);
        public InversionTipoDescripcion get(Integer id);
         public List<InversionTipo> query1(String buscar);
}
