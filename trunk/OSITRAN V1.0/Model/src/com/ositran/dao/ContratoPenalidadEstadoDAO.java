package com.ositran.dao;

import com.ositran.model.ContratoPenalidadEstado;

import java.sql.SQLException;

import java.util.List;

public interface ContratoPenalidadEstadoDAO{
    public List<ContratoPenalidadEstado> query() throws SQLException;
    public List<ContratoPenalidadEstado> getXContrato() throws SQLException;
    public String insert(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException;
    public ContratoPenalidadEstado get(Integer id) throws SQLException;
}
