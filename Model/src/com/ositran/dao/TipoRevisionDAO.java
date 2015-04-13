package com.ositran.dao;

import com.ositran.model.InversionTipo;

import com.ositran.model.TipoRevision;

import java.sql.SQLException;

import java.util.List;

public interface TipoRevisionDAO {
    
    public List<TipoRevision> query()throws SQLException ,Exception;
    public String insert(TipoRevision tipoRevision)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(InversionTipo inversionTipo)throws SQLException ,Exception;
       public TipoRevision get(Integer id)throws SQLException ,Exception;
}
