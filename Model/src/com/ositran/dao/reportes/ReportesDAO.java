package com.ositran.dao.reportes;

import com.ositran.model.reportes.AvaInvConConc;
import com.ositran.model.reportes.AvaInvRecConConc;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisora;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesInversiones;
import com.ositran.model.reportes.EmpSupInf;

import com.ositran.model.reportes.EmpSupInfAeropuerto;
import com.ositran.model.reportes.InversionesTipoConcepto;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

import com.ositran.model.reportes.TrazabilidadPrincipalesEventos;

import java.sql.SQLException;

import java.util.List;

public interface ReportesDAO {

    public List<EmpSupInf> getEmpresaSupervisoraVsInfraestructura(int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException;
    public List<AvaInvConConc> getAvanceInversionesContratosConcesion(int anio, int mes, int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException;
    public List<InversionesTipoConcepto> getInversionesTipoConcepto(int anio,int mes,int idTipoInfraestructura, int idConcesion, int idConcepto) throws SQLException;
    public List<InversionesTipoConceptoDetalle> getInversionesTipoConceptoDetalle(int idInversion) throws SQLException;
    public List<TrazabilidadPrincipalesEventos> getTrazabilidadPrincipalesEventos(int idTipoInfraestructura, int anio, int mes) throws SQLException;
    public List<EmpSupInfAeropuerto> getEmpresaSupervisoraVsInfraestructuraAeropuerto(int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException;    
    public List<ControlPlazosFlujoValorizacionesInversiones> getControlPlazosFlujoValorizacionesInversiones(int idTipoInfraestructura, int anio, int mes) throws SQLException;
    public List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getControlPlazosFlujoValorizacionesEmpresaSupervisora(int idTipoInfraestructura, int anio, int mes) throws SQLException;
    public List<AvaInvRecConConc> getAvaInvRecConConc(int anio,int trimestre,int idTipoEstructura, int idConcesion,int idModalidad) throws SQLException;
}
