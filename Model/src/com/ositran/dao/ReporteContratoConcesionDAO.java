package com.ositran.dao;
import java.util.List;
public interface ReporteContratoConcesionDAO {
    public List<Object[]> generarReporteContratoConcesion(String tipoInfra, String concesion, String modalidad);
}
