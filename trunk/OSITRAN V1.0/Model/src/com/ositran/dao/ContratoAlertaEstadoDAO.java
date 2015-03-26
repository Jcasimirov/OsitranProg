package com.ositran.dao;


import com.ositran.model.ContratoAlertaEstado;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAlertaEstadoDAO {
    public List<ContratoAlertaEstado> query() throws SQLException;
    public String insert(ContratoAlertaEstado contratoAlertaEstado) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoAlertaEstado contratoAlertaEstado) throws SQLException;
    public ContratoAlertaEstado get(Integer id) throws SQLException;
}
