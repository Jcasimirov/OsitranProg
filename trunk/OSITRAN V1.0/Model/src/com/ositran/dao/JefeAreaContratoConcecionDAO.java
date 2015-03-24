package com.ositran.dao;

import com.ositran.model.InversionTipo;
import com.ositran.model.JefeAreaContratoConcecion;
import java.sql.SQLException;
import java.util.List;

public interface JefeAreaContratoConcecionDAO {
    
    public List<JefeAreaContratoConcecion> query()throws SQLException ,Exception;
    public String insert(JefeAreaContratoConcecion jefeAreaContratoConcecion)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(JefeAreaContratoConcecion jefeAreaContratoConcecion)throws SQLException ,Exception;
    public JefeAreaContratoConcecion get(Integer id)throws SQLException ,Exception;
       
}
