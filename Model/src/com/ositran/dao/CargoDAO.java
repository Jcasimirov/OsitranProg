package com.ositran.dao;

import com.ositran.model.Cargo;

import java.util.List;

public interface CargoDAO {
    public List<Cargo> query();
    public String insert(Cargo cargo);
    public String delete(Integer id);
    public String update(Cargo cargo);
    public Cargo get(Integer id);
}
