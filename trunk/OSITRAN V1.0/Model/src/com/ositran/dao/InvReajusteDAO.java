package com.ositran.dao;

import com.ositran.model.InvReajuste;

import java.sql.SQLException;

import java.util.List;

public interface InvReajusteDAO {
    public List<InvReajuste> query() throws SQLException;
    public String insert(InvReajuste invReajuste) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(InvReajuste invReajuste) throws SQLException;
    public InvReajuste get(Integer id) throws SQLException;
    public List<InvReajuste> getInvReajustesAvance(Integer tiaNumero) throws SQLException;
}
