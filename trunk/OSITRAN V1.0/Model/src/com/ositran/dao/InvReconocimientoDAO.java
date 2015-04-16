package com.ositran.dao;

import com.ositran.model.InvReconocimiento;

import java.sql.SQLException;

import java.util.List;

public interface InvReconocimientoDAO {
    public List<InvReconocimiento> query() throws SQLException;

    public String insert(InvReconocimiento invReconocimiento) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(InvReconocimiento invReconocimiento) throws SQLException;

    public InvReconocimiento get(Integer id) throws SQLException;

    public List<InvReconocimiento> getInvReconocimientosAvance(Integer invId) throws SQLException;
}
