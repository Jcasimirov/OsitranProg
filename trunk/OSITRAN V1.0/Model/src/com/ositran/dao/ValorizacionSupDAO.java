package com.ositran.dao;

import com.ositran.model.JefeAreaContratoConcecion;

import com.ositran.model.ValorizacionSup;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionSupDAO {
    
    public List<ValorizacionSup> query()throws SQLException ,Exception;
    public int insert(ValorizacionSup valorizacionSup)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(ValorizacionSup valorizacionSup)throws SQLException ,Exception;
    public ValorizacionSup get(Integer id)throws SQLException ,Exception;
	
	//Ivan
    public List<ValorizacionSup> ListaValorizacionesRegistradas(Integer id) throws SQLException, Exception ;
    
}
    