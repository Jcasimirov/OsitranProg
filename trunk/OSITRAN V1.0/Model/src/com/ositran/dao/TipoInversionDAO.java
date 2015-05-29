package com.ositran.dao;

import com.ositran.model.InversionTipo;

import java.sql.SQLException;

import java.util.List;

public interface TipoInversionDAO {
     public List<InversionTipo> query()throws SQLException ,Exception;
     public String insert(InversionTipo inversionTipo)throws SQLException ,Exception;
        public String update(InversionTipo inversionTipo)throws SQLException ,Exception;
        public InversionTipo get(Integer id)throws SQLException ,Exception;
        public List<InversionTipo> query1(String buscar)throws SQLException ,Exception;
        public int getCanNombres(String nombre)  throws SQLException ,Exception;
    public boolean validarCodigoEnUso(Integer tivId) throws Exception;
}

