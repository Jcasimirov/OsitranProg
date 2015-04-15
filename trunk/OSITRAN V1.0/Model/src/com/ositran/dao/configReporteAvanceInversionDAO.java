package com.ositran.dao;

import com.ositran.model.TRepCnfgAvncInvCab;

import com.ositran.model.TRepCnfgAvncInvDet;

import java.util.List;

public interface configReporteAvanceInversionDAO {
    
    List<TRepCnfgAvncInvCab> obtenerTRepCnfgAvncInvCabActiva() throws Exception ;
    List<Object> obtenerReporteInversionConDetalle() throws Exception ;
    List<Object> obtenerReporteInversionSinDetalle() throws Exception ;
    void insertaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws Exception ;
    void actualizaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws Exception ;
}
