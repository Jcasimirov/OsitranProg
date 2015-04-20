package com.ositran.dao;

import com.ositran.model.InvReajuste;
import com.ositran.model.ValorizacionConcepto;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionConceptoDAO {
    public List<ValorizacionConcepto> query() throws SQLException;
    public String insert(InvReajuste invReajuste) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(InvReajuste invReajuste) throws SQLException;
    public InvReajuste get(Integer id) throws SQLException;
    public List<ValorizacionConcepto> getInvReajustesAvance(Integer tiaNumero) throws SQLException;
}
