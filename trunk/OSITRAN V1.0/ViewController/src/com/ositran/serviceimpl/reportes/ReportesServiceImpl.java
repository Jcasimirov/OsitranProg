package com.ositran.serviceimpl.reportes;

/*
 * Clase: ReportesServiceImpl
 * Descripcion: Esta clase expone al controller las consultas de los reportes desde el DAO (Implementacion)
 * Autor: E. Alfredo Panitz R.
 * Fecha: 30/04/2015
 */

import com.ositran.dao.reportes.ReportesDAO;
import com.ositran.daoimpl.reportes.ReportesDAOImpl;
import com.ositran.model.reportes.AvaInvConConc;
import com.ositran.model.reportes.EmpSupInfAeropuerto;
import com.ositran.model.reportes.InversionesTipoConcepto;
import com.ositran.model.reportes.InversionesTipoConceptoDetalle;
import com.ositran.model.reportes.TrazabilidadPrincipalesEventos;
import com.ositran.service.reportes.ReportesService;
import com.ositran.model.reportes.EmpSupInf;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesInversiones;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisora;
import com.ositran.model.reportes.AvaInvRecConConc;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReportesServiceImpl implements ReportesService {

    ReportesDAOImpl reportesDao = new ReportesDAOImpl();
    //private ReportesDAO reportesDao;

    @Override
    public List<EmpSupInf> getEmpresaSupervisoraVsInfraestructura(int idTipoEstructura, int idConcesion, int idEmpSupervisora) throws SQLException  {        
        return reportesDao.getEmpresaSupervisoraVsInfraestructura(idTipoEstructura, idConcesion, idEmpSupervisora);
    }

    @Override
    public List<AvaInvConConc> getAvanceInversionesContratosConcesion(int anio, int mes, int idTipoEstructura,
                                                                      int idConcesion,
                                                                      int idEmpSupervisora) throws SQLException {
        return reportesDao.getAvanceInversionesContratosConcesion(anio,mes,idTipoEstructura, idConcesion, idEmpSupervisora);
    }

    @Override
    public List<InversionesTipoConcepto> getInversionesTipoConcepto(int anio, int mes, int idTipoInfraestructura,
                                                                    int idConcesion,
                                                                    int idConcepto) throws SQLException {
        // TODO Implement this method
        return reportesDao.getInversionesTipoConcepto(anio,mes,idTipoInfraestructura, idConcesion, idConcepto);
    }

    

    @Override
    public List<EmpSupInfAeropuerto> getEmpresaSupervisoraVsInfraestructuraAeropuerto(int idTipoEstructura,
                                                                                      int idConcesion,
                                                                                      int idEmpSupervisora) throws SQLException {
        
        // TODO Implement this method
        return reportesDao.getEmpresaSupervisoraVsInfraestructuraAeropuerto(idTipoEstructura, idConcesion, idEmpSupervisora);
        
    }

    @Override
    public List<TrazabilidadPrincipalesEventos> getTrazabilidadPrincipalesEventos(int idTipoEstructura, int anio,
                                                                                  int mes) throws SQLException {
        // TODO Implement this method
        return reportesDao.getTrazabilidadPrincipalesEventos(idTipoEstructura, anio, mes);
    }
    
    @Override
    public List<ControlPlazosFlujoValorizacionesInversiones> getControlPlazosFlujoValorizacionesInversiones(int idTipoIngraestructura,
                                                                                                          int anio,
                                                                                                          int mes) throws SQLException {
        // TODO Implement this method
        return reportesDao.getControlPlazosFlujoValorizacionesInversiones(idTipoIngraestructura, anio, mes);
    }

    @Override
    public List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getControlPlazosFlujoValorizacionesEmpresaSupervisora(int idTipoIngraestructura,
                                                                                                                          int anio,
                                                                                                                          int mes) throws SQLException {
        // TODO Implement this method
        return reportesDao.getControlPlazosFlujoValorizacionesEmpresaSupervisora(idTipoIngraestructura, anio, mes);
    }

    @Override
    public List<AvaInvRecConConc> getAvaInvRecConConc(int anio, int trimestre, int idTipoEstructura, int idConcesion,
                                                      int idModalidad) throws SQLException {
        // TODO Implement this method
        return reportesDao.getAvaInvRecConConc(anio,  trimestre,  idTipoEstructura,  idConcesion,
                                                       idModalidad);
    }
    
}
