package com.ositran.dao;

import com.ositran.model.InvReajuste;
import com.ositran.model.ValorizacionConcepto;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionConceptoDAO {
    public List<ValorizacionConcepto> query() throws SQLException;
    public String insert(ValorizacionConcepto valorizacionConcepto) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ValorizacionConcepto valorizacionConcepto) throws SQLException;
    public ValorizacionConcepto get(Integer id) throws SQLException;
    public List<ValorizacionConcepto> getValorizacionConcepto(Integer cvaId) throws SQLException;
}
