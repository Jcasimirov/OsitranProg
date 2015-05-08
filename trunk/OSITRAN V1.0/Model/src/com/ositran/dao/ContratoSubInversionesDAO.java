package com.ositran.dao;

import com.ositran.model.ContratoSupInversiones;
import com.ositran.model.InversionTipo;

import java.sql.SQLException;
import java.util.List;


public interface ContratoSubInversionesDAO {
    
    public List<ContratoSupInversiones> query()throws SQLException ,Exception;
    public List<ContratoSupInversiones> query1(int filtro)throws SQLException ,Exception;
    public String insert(ContratoSupInversiones contratoSupInversiones)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(ContratoSupInversiones contratoSupInversiones)throws SQLException ,Exception;
    public ContratoSupInversiones get(Integer id)throws SQLException ,Exception;
    public ContratoSupInversiones get1(Integer id)throws SQLException ,Exception;
}
