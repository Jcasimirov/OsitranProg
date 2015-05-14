package com.ositran.dao;

import com.ositran.model.Concesion;

import java.sql.SQLException;

import java.util.List;


public interface ConcesionDAO {
    public List<Concesion> query() throws SQLException;
    public String insert(Concesion concesion) throws SQLException;
    public String delete(Integer idconcesion) throws SQLException;
    public String update(Concesion concesion) throws SQLException;
    public String update2(Concesion concesion) throws SQLException;
    public Concesion get(Integer idconcesion)throws SQLException;
    public int idConcesion(Concesion concesion)throws SQLException;
    public List<Concesion> queryfiltro(int codigo, String nombre)throws SQLException;
    /*  public Concesion get2(Integer id); */
    // Iosusky
    public List<Concesion> filtrarConcesion(int tipoInfraestructura) throws SQLException;
    public List<Concesion> listarConcesiones() throws SQLException;
    public List<Concesion> listarConcesionesxIdConcesion(int idConcesion) throws Exception;
}