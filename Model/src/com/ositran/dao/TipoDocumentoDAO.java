package com.ositran.dao;

import com.ositran.model.Igv;

import com.ositran.model.TipoDocumento;

import java.sql.SQLException;

import java.util.List;

public interface TipoDocumentoDAO {
    public List<TipoDocumento> query() throws SQLException;
    public String insert(TipoDocumento tipodocumento) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(TipoDocumento tipodocumento) throws SQLException;
    public TipoDocumento get(Integer id) throws SQLException;
}
