package com.ositran.service;


import com.ositran.vo.bean.ReporteContratoConcesionVO;

import java.util.List;

public interface ReporteContratoConcesionService {
    public List<ReporteContratoConcesionVO> generarReporteContratoConcesion(String tipoInfra, String concesion, String modalidad);
}
