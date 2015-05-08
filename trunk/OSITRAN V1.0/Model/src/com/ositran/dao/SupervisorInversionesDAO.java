package com.ositran.dao;

import com.ositran.model.InversionTipo;
import com.ositran.model.SupervisorInversiones;

import java.sql.SQLException;

import java.util.List;

public interface SupervisorInversionesDAO {
    public List<SupervisorInversiones> buscarCoordinador(int codtipoInfraestructura)throws SQLException;
    public SupervisorInversiones getSupervisorInversiones(int codtipoInfraestructura)throws SQLException;
    public SupervisorInversiones buscarSupervisor(int codtipoInfraestructura) throws SQLException;
    public SupervisorInversiones get(Integer id)throws SQLException ,Exception;
}


