package com.ositran.dao;


import com.ositran.model.VSupInv;

import java.sql.SQLException;

import java.util.List;

public interface VSupInvDAO {
    public List<VSupInv> buscarCoordinador(int codtipoInfraestructura)throws SQLException;
}
