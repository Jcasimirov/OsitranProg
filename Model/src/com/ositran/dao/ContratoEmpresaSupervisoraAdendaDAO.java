package com.ositran.dao;

import com.ositran.model.ContratoSupervisoraAdenda;
import java.sql.SQLException;
import java.util.List;

public interface ContratoEmpresaSupervisoraAdendaDAO {
    
    
    public List<ContratoSupervisoraAdenda> query() throws SQLException;
    public String insert(ContratoSupervisoraAdenda contratoSupervisoraAdenda) throws SQLException;
    public String delete(Integer id) throws SQLException;
    
}
