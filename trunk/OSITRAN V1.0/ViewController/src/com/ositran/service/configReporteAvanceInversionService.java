package com.ositran.service;

import com.ositran.vo.bean.TRepCnfgAvncInvCabVO;
import com.ositran.vo.bean.TRepCnfgAvncInvDetVO;

import java.util.List;

public interface configReporteAvanceInversionService {
    
    List<TRepCnfgAvncInvDetVO> obtenReporteInversion() throws Exception;
    TRepCnfgAvncInvCabVO obtenConfigAvanceCab() throws Exception;
    void guardarConfigReporteInversiones(List<TRepCnfgAvncInvDetVO> reporteInversion, TRepCnfgAvncInvCabVO cabReporteInversionActivo) throws Exception;

}
