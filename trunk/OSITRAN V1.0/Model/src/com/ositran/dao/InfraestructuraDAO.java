package com.ositran.dao;

import com.ositran.model.Infraestructura;

import java.sql.SQLException;

import java.util.List;

public interface InfraestructuraDAO {

    public List<Infraestructura> query() throws SQLException;

    public String insert(Infraestructura infraestructura) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(Infraestructura infraestructura) throws SQLException;

    public Infraestructura get(int codifoInfraestructura,int codigoConcesion,int tipoInfraestructura)throws SQLException;

    public List<Infraestructura> query1(int codigoC) throws SQLException;
    
    public List<Infraestructura> query2(int codigoC) throws SQLException;

    public Infraestructura get2(Integer id) throws SQLException;
    
    public List<Infraestructura> getInfraestructurasContrato(int codigoContrato) throws SQLException;
    public List<Infraestructura> getInfraestructurasInversion(int codigoConcesion) throws Exception;
}
