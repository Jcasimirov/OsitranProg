package com.ositran.serviceimpl;

import com.ositran.dao.configReporteAvanceInversionDAO;
import com.ositran.model.Concesion;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.TRepCnfgAvncInvCab;
import com.ositran.model.TRepCnfgAvncInvDet;
import com.ositran.service.configReporteAvanceInversionService;
import com.ositran.vo.bean.TRepCnfgAvncInvCabVO;
import com.ositran.vo.bean.TRepCnfgAvncInvDetVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public final class configReporteAvanceInversionServiceImpl implements configReporteAvanceInversionService {
    private configReporteAvanceInversionDAO dao;
    
    @Override
    public List<TRepCnfgAvncInvDetVO> obtenReporteInversion() throws Exception {
        List<TRepCnfgAvncInvDetVO> reporteInversion=new ArrayList<TRepCnfgAvncInvDetVO>();
        List<TRepCnfgAvncInvCab> cabReporteInversionActivo=null;
        
        cabReporteInversionActivo=dao.obtenerTRepCnfgAvncInvCabActiva();
        
        if (cabReporteInversionActivo==null || cabReporteInversionActivo.size()==0){
            List<Object> rpta=dao.obtenerReporteInversionSinDetalle();
            for (Object aux : rpta) {
                if(aux instanceof Object[]) {
                    TRepCnfgAvncInvDetVO elementoReporteInversion=new TRepCnfgAvncInvDetVO();
                    Concesion concesion;
                    InfraestructuraTipo infraestructuraTipo;
                    if(((Object[])aux)[0] instanceof Concesion) {
                        concesion=(Concesion)(((Object[])aux)[0]);
                    } else {
                        throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                    }
                    if(((Object[])aux)[1] instanceof InfraestructuraTipo) {
                        infraestructuraTipo=(InfraestructuraTipo)(((Object[])aux)[1]);
                    } else {
                        throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                    }
                    elementoReporteInversion.setCsiId(new BigDecimal(concesion.getCsiId()));
                    elementoReporteInversion.setTinId(new BigDecimal(concesion.getTinId()));
                    elementoReporteInversion.setConcesionNombre(concesion.getCsiNombre());
                    elementoReporteInversion.setInfraestructuraTipo(infraestructuraTipo.getTinNombre());
                    reporteInversion.add(elementoReporteInversion);
                } else {
                    throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                }
            }
        } else {
            if (cabReporteInversionActivo.size()>1){
                throw new IllegalStateException("Se obtuvo más de un REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
            } else {
                List<Object> rpta=dao.obtenerReporteInversionConDetalle();
                for (Object aux : rpta) {
                    if(aux instanceof Object[]) {
                        TRepCnfgAvncInvDetVO elementoReporteInversion=new TRepCnfgAvncInvDetVO();
                        TRepCnfgAvncInvDet detalle;
                        Concesion concesion;
                        InfraestructuraTipo infraestructuraTipo;
                        if(((Object[])aux)[0] instanceof TRepCnfgAvncInvDet) {
                            detalle=(TRepCnfgAvncInvDet)(((Object[])aux)[0]);
                        } else {
                            throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                        }
                        if(((Object[])aux)[1] instanceof Concesion) {
                            concesion=(Concesion)(((Object[])aux)[1]);
                        } else {
                            throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                        }
                        if(((Object[])aux)[2] instanceof InfraestructuraTipo) {
                            infraestructuraTipo=(InfraestructuraTipo)(((Object[])aux)[2]);
                        } else {
                            throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                        }
                        validaTRepCnfgAvncInvDet(detalle);
                        if(detalle.getCaiMontoTotalSinAjuste().equals(1)) {
                            elementoReporteInversion.setTipoMontoTotal("sinAjuste");
                        }
                        if(detalle.getCaiMontoTotalConReajuste().equals(1)) {
                            elementoReporteInversion.setTipoMontoTotal("conReajuste");
                        }
                        elementoReporteInversion.setAidId(detalle.getAidId());
                        elementoReporteInversion.setCaiId(detalle.getCaiId());
                        elementoReporteInversion.setCsiId(new BigDecimal(concesion.getCsiId()));
                        elementoReporteInversion.setTinId(new BigDecimal(concesion.getTinId()));
                        elementoReporteInversion.setConcesionNombre(concesion.getCsiNombre());
                        elementoReporteInversion.setInfraestructuraTipo(infraestructuraTipo.getTinNombre());
                        reporteInversion.add(elementoReporteInversion);
                    } else {
                        throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar la consulta.");
                    }
                }
            }
        }
        return reporteInversion;
    }
    
    @Override
    public TRepCnfgAvncInvCabVO obtenConfigAvanceCab() throws Exception {
        TRepCnfgAvncInvCabVO configAvanceCab;
        List<TRepCnfgAvncInvCab> cabReporteInversionActivo;
        
        cabReporteInversionActivo=dao.obtenerTRepCnfgAvncInvCabActiva();
        
        if (cabReporteInversionActivo==null || cabReporteInversionActivo.size()==0){
            configAvanceCab=null;
        } else {
            if (cabReporteInversionActivo.size()>1){
                throw new IllegalStateException("Se obtuvo más de un REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
            } else {
                TRepCnfgAvncInvCab aux=cabReporteInversionActivo.get(0);
                validaTRepCnfgAvncInvCab(aux);
                configAvanceCab=new TRepCnfgAvncInvCabVO();
                configAvanceCab.setCaiEstado(aux.getCaiEstado());
                configAvanceCab.setCaiFechaAlta(aux.getCaiFechaAlta());
                configAvanceCab.setCaiFechaBaja(aux.getCaiFechaBaja());
                configAvanceCab.setCaiFechaCambio(aux.getCaiFechaCambio());
                configAvanceCab.setCaiFechaEmision(aux.getCaiFechaEmision());
                configAvanceCab.setCaiId(aux.getCaiId());
                configAvanceCab.setCaiMotivoDeCambio(aux.getCaiMotivoDeCambio());
                configAvanceCab.setCaiNumeroDeDocumento(aux.getCaiNumeroDeDocumento());
                configAvanceCab.setCaiReferencia(aux.getCaiReferencia());
                configAvanceCab.setCaiTerminal(aux.getCaiTerminal());
                configAvanceCab.setCaiUsuarioAlta(aux.getCaiUsuarioAlta());
                configAvanceCab.setCaiUsuarioBaja(aux.getCaiUsuarioBaja());
                configAvanceCab.setCaiUsuarioCambio(aux.getCaiUsuarioCambio());
            }
        }
        return configAvanceCab;
    }

    @Override
    public void guardarConfigReporteInversiones(List<TRepCnfgAvncInvDetVO> reporteInversion, TRepCnfgAvncInvCabVO cabReporteInversionActivo) throws Exception {
        List<TRepCnfgAvncInvDet> reporteInversionPersistente=new ArrayList<TRepCnfgAvncInvDet>();
        TRepCnfgAvncInvCab cabReporteInversionActivoPersistente= new TRepCnfgAvncInvCab();
        
        cabReporteInversionActivoPersistente.setCaiMotivoDeCambio(cabReporteInversionActivo.getCaiMotivoDeCambio());
        cabReporteInversionActivoPersistente.setCaiNumeroDeDocumento(cabReporteInversionActivo.getCaiNumeroDeDocumento());
        cabReporteInversionActivoPersistente.setCaiFechaEmision(cabReporteInversionActivo.getCaiFechaEmision());
        cabReporteInversionActivoPersistente.setCaiEstado(cabReporteInversionActivo.getCaiEstado());
        cabReporteInversionActivoPersistente.setCaiFechaAlta(cabReporteInversionActivo.getCaiFechaAlta());
        cabReporteInversionActivoPersistente.setCaiUsuarioAlta(cabReporteInversionActivo.getCaiUsuarioAlta());
        cabReporteInversionActivoPersistente.setCaiFechaCambio(cabReporteInversionActivo.getCaiFechaCambio());
        cabReporteInversionActivoPersistente.setCaiUsuarioCambio(cabReporteInversionActivo.getCaiUsuarioCambio());
        cabReporteInversionActivoPersistente.setCaiReferencia(cabReporteInversionActivo.getCaiReferencia());
        if(cabReporteInversionActivo.getCaiId()==null) {
            for(TRepCnfgAvncInvDetVO aux : reporteInversion) {
                TRepCnfgAvncInvDet detalle=new TRepCnfgAvncInvDet();
                detalle.setTinId(aux.getTinId());
                detalle.setCsiId(aux.getCsiId());
                if(aux.getTipoMontoTotal().toLowerCase().equals("sinajuste")) {
                    detalle.setCaiMontoTotalSinAjuste(1);
                    detalle.setCaiMontoTotalConReajuste(0);
                } else {
                    detalle.setCaiMontoTotalSinAjuste(0);
                    detalle.setCaiMontoTotalConReajuste(1);
                }
                reporteInversionPersistente.add(detalle);
            }
            dao.insertaConfigReporteInversion(reporteInversionPersistente, cabReporteInversionActivoPersistente);
        } else {
            for(TRepCnfgAvncInvDetVO aux : reporteInversion) {
                TRepCnfgAvncInvDet detalle=new TRepCnfgAvncInvDet();
                detalle.setCaiId(aux.getCaiId());
                detalle.setAidId(aux.getAidId());

                detalle.setTinId(aux.getTinId());
                detalle.setCsiId(aux.getCsiId());
                if(aux.getTipoMontoTotal().toLowerCase().equals("sinajuste")) {
                    detalle.setCaiMontoTotalSinAjuste(1);
                    detalle.setCaiMontoTotalConReajuste(0);
                } else {
                    detalle.setCaiMontoTotalSinAjuste(0);
                    detalle.setCaiMontoTotalConReajuste(1);
                }
                reporteInversionPersistente.add(detalle);
            }
            cabReporteInversionActivoPersistente.setCaiId(cabReporteInversionActivo.getCaiId());
            dao.actualizaConfigReporteInversion(reporteInversionPersistente, cabReporteInversionActivoPersistente);
        }

    }

    public void setDao(configReporteAvanceInversionDAO dao) {
        this.dao = dao;
    }

    public configReporteAvanceInversionDAO getDao() {
        return dao;
    }
    
    private void validaTRepCnfgAvncInvCab(TRepCnfgAvncInvCab cabecera) {
    }
    
    private void validaTRepCnfgAvncInvDet(TRepCnfgAvncInvDet detalle) throws IllegalStateException {
        if(detalle.getCaiMontoTotalConReajuste()!=0 && detalle.getCaiMontoTotalConReajuste()!=1) {
            throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar en la tabla \"t_rep_cnfg_avnc_inv_det\" la columna \"cai_monto_total_con_reajuste\".");
        }
        if(detalle.getCaiMontoTotalSinAjuste()!=0 && detalle.getCaiMontoTotalSinAjuste()!=1) {
            throw new IllegalStateException("Se obtuvo datos inconsistentes. Verificar en la tabla \"t_rep_cnfg_avnc_inv_det\" la columna \"cai_monto_total_sin_ajuste\".");
        }
    }
    
}
