package com.ositran.dao;

import com.ositran.model.ContratoJefeArea;
import com.ositran.model.InversionTipo;

import java.sql.SQLException;

import java.util.List;

public interface ContratoJefeAreaDAO {
    
    public List<ContratoJefeArea> query();
    public String insert(ContratoJefeArea contratoJefeArea);
       public String delete(Integer id);
       public String update(ContratoJefeArea contratoJefeArea);
       public InversionTipo get(Integer id);
       public List<ContratoJefeArea> query1(String buscar);
       public int getCanNombres(String nombre);
}
