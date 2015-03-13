package com.ositran.dao;

import com.ositran.model.RolOpciones;

import java.util.List;

public interface RolOpcionesDAO {
    
        public List<RolOpciones> query();
        public String insert(RolOpciones rolOpciones);
        public String delete(Integer id);
        public String update(RolOpciones rolOpciones);
        public RolOpciones get(Integer id);
         public List<RolOpciones> query1(Integer codigoRol);
    public void updateEstado(int codigo);
}
