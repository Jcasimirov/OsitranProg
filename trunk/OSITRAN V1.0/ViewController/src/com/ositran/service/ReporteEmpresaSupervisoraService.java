package com.ositran.service;

import com.ositran.vo.bean.ReporteEmpresaSupervisoraVO;

import java.sql.SQLException;

import java.util.List;

public interface ReporteEmpresaSupervisoraService {
    public List<ReporteEmpresaSupervisoraVO> generarReporteEmpresaSupervisora(String tipoInfra, String concesion, String estado, String fecIni, String fecFin) throws SQLException;
}