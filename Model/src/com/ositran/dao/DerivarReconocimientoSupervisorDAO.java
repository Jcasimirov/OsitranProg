package com.ositran.dao;

import com.ositran.model.DerivarReconocimientoSupervisor;
import com.ositran.model.InversionTipo;
import com.ositran.model.TipoRevision;

import java.sql.SQLException;

import java.util.List;

public interface DerivarReconocimientoSupervisorDAO {
    
    
    
    public List<DerivarReconocimientoSupervisor> query()throws SQLException ,Exception;
    public String insert(DerivarReconocimientoSupervisor derivarReconocimientoSupervisor)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(DerivarReconocimientoSupervisor derivarReconocimientoSupervisor)throws SQLException ,Exception;
    public DerivarReconocimientoSupervisor get(Integer id)throws SQLException ,Exception;
}
