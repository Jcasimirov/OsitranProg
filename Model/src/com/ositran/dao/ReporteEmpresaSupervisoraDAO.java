package com.ositran.dao;


import java.sql.SQLException;

import java.util.List;
public interface ReporteEmpresaSupervisoraDAO {
    public List<Object[]> generarReporteEmpresaSupervisora(String tipoInfra, String concesion, String estado, String fecIni, String fecFin) throws SQLException;
}
