package com.ositran.dao;

import com.ositran.model.Concesion;

import java.util.List;


public interface ConcesionDAO {
    public List<Concesion> query();
    public String insert(Concesion concesion);
    public String delete(Integer idconcesion);
    public String update(Concesion concesion);
    public Concesion get(Integer idconcesion);
    public int idConcesion(Concesion concesion);
}