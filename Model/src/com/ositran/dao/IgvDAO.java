package com.ositran.dao;

import com.ositran.model.Igv;

import java.util.List;

public interface IgvDAO {
    public List<Igv> query();
    public String insert(Igv igv);
    public String delete(Integer id);
    public String update(Igv igv);
    public Igv get(Integer id);
}
