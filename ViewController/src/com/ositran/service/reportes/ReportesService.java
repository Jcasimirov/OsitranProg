package com.ositran.service.reportes;

/*
 * Clase: ReportesService
 * Descripcion: Esta clase expone al controller las consultas de los reportes desde el DAO
 * Autor: E. Alfredo Panitz R.
 * Fecha: 30/04/2015
 */

import com.ositran.model.reportes.AvaInvConConc;
import com.ositran.model.reportes.AvaInvRecConConc;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisora;
import com.ositran.model.reportes.EmpSupInf;

import com.ositran.model.reportes.EmpSupInfAeropuerto;
import com.ositran.model.reportes.InversionesTipoConcepto;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

import com.ositran.model.reportes.TrazabilidadPrincipalesEventos;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesInversiones;
import java.sql.SQLException;

import java.util.List;

public interface ReportesService {
    
    public List<EmpSupInf> getEmpresaSupervisoraVsInfraestructura(int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException ;
    public List<AvaInvConConc> getAvanceInversionesContratosConcesion(int anio, int mes, int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException ;
    public List<InversionesTipoConcepto> getInversionesTipoConcepto(int anio,int mes,int idTipoInfraestructura, int idConcesion, int idConcepto) throws SQLException ;
    
    public List<EmpSupInfAeropuerto> getEmpresaSupervisoraVsInfraestructuraAeropuerto(int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException ;
    public List<TrazabilidadPrincipalesEventos> getTrazabilidadPrincipalesEventos(int idTipoEstructura, int anio, int mes) throws SQLException ;
    public List<ControlPlazosFlujoValorizacionesInversiones> getControlPlazosFlujoValorizacionesInversiones(int idTipoIngraestructura, int anio, int mes) throws SQLException;
    public List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getControlPlazosFlujoValorizacionesEmpresaSupervisora(int idTipoIngraestructura, int anio, int mes) throws SQLException;
    
    public List<AvaInvRecConConc> getAvaInvRecConConc(int anio,int trimestre,int idTipoEstructura, int idConcesion,int idModalidad) throws SQLException;    
}
