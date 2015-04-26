package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;

import com.ositran.model.ValorizacionSupDetalle;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionSupDetalleDAO {
    
    public List<ValorizacionSupDetalle> query() throws SQLException;

    public String insert(ValorizacionSupDetalle valorizacionSupDetalle) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(ValorizacionSupDetalle valorizacionSupDetalle) throws SQLException;

    public ValorizacionSupDetalle get(Integer id) throws SQLException; 
	
	//Ivan
	public List<ValorizacionSupDetalle> ListaValorizacionesDetRegistradas(Integer id) throws SQLException, Exception;

}
