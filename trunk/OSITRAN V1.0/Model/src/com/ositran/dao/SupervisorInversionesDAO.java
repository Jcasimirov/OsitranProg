package com.ositran.dao;

import com.ositran.model.SupervisorInversiones;
import java.sql.SQLException;
import java.util.List;

public interface SupervisorInversionesDAO {
    public List<SupervisorInversiones> buscarCoordinador(int codtipoInfraestructura)throws SQLException;

}


