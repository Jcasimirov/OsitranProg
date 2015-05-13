package com.ositran.dao;

import com.ositran.model.InversionTipoDescripcion;

import java.sql.SQLException;

import java.util.List;

public interface InversionDescripcionDAO {

 
        public List<InversionTipoDescripcion> query() throws SQLException ,Exception;
        public List<InversionTipoDescripcion> query1(int codigoCompromiso) throws SQLException ,Exception;
        public String insert(InversionTipoDescripcion inversionTipoDes) throws SQLException ,Exception;
        public String update(InversionTipoDescripcion inversionTipoDes) throws SQLException ,Exception;
        public InversionTipoDescripcion get(Integer id) throws SQLException ,Exception;
        public List<InversionTipoDescripcion> query1(String buscar) throws SQLException ,Exception;
        public int getCanNombres(String nombre)  throws SQLException ,Exception;    
        public List<InversionTipoDescripcion> queryAllIdtEstado()  throws SQLException ,Exception;
}





