package com.ositran.dao;

import com.ositran.model.Igv;

import com.ositran.model.TipoDocumento;

import java.util.List;

public interface TipoDocumentoDAO {
    public List<TipoDocumento> query();
    public String insert(TipoDocumento tipodocumento);
    public String delete(Integer id);
    public String update(TipoDocumento tipodocumento);
    public TipoDocumento get(Integer id);
}
