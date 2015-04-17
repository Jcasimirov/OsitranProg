package com.ositran.dao;

import com.ositran.model.InvAvnEstado;

import java.sql.SQLException;

import java.util.List;

public interface InversionAvanceEstadoDAO {
    public List<InvAvnEstado> query() throws SQLException;
}
