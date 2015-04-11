package com.ositran.dao;

import com.ositran.model.TRepCnfgAvncInvCab;

import com.ositran.model.TRepCnfgAvncInvDet;

import java.util.List;

public interface configReporteAvanceInversionDAO {
    
    List<TRepCnfgAvncInvCab> obtenerTRepCnfgAvncInvCabActiva();
    List<Object> obtenerReporteInversionConDetalle();
    List<Object> obtenerReporteInversionSinDetalle();
    void insertaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente);
    void actualizaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente);
}
