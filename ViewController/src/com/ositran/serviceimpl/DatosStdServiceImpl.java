package com.ositran.serviceimpl;

import com.ositran.daoimpl.CargoDAOImpl;

import com.ositran.daoimpl.DatosStdDAOImpl;
import com.ositran.model.Cargo;

import com.ositran.model.VwDocInterno;
import com.ositran.service.CargoService;

import com.ositran.service.DatosStdService;
import com.ositran.vo.bean.CargoVO;


import com.ositran.vo.bean.VwDocInternoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class DatosStdServiceImpl implements DatosStdService{
    private DatosStdDAOImpl datosStdDAOImpl;


    public void setDatosStdDAOImpl(DatosStdDAOImpl datosStdDAOImpl) {
        this.datosStdDAOImpl = datosStdDAOImpl;
    }

    public DatosStdDAOImpl getDatosStdDAOImpl() {
        return datosStdDAOImpl;
    }

    public DatosStdServiceImpl() {
        super();
    }

    @Override
    public VwDocInternoVO BuscaStd(Integer año, String nro) throws SQLException{
        try {
        VwDocInterno vista=this.datosStdDAOImpl.BuscaStd(año,nro);
        if (vista != null){
            VwDocInternoVO vistaVO=toVwDocInternoVO(vista);
            return vistaVO;
        }
        } catch (Exception e) {
            System.out.println(e);            
        }
        return null;
    }
     
    
    private VwDocInternoVO toVwDocInternoVO(VwDocInterno vwDocInterno){
        VwDocInternoVO vwDocInternoVO=new VwDocInternoVO();
        vwDocInternoVO.setVdiAnyo(vwDocInterno.getVdiAnyo());
        vwDocInternoVO.setVdiArea(vwDocInterno.getVdiArea());
        vwDocInternoVO.setVdiAsunto(vwDocInterno.getVdiAsunto());
        vwDocInternoVO.setVdiDestino(vwDocInterno.getVdiDestino());
        vwDocInternoVO.setVdiFecha(vwDocInterno.getVdiFecha());
        vwDocInternoVO.setVdiFechaRegistro(vwDocInterno.getVdiFechaRegistro());
        vwDocInternoVO.setVdiHr(vwDocInterno.getVdiHr());
        vwDocInternoVO.setVdiNombre(vwDocInterno.getVdiNombre());
        vwDocInternoVO.setVdiNroregistrosalida(vwDocInterno.getVdiNroregistrosalida());
        vwDocInternoVO.setVdiNumero(vwDocInterno.getVdiNumero());
        vwDocInternoVO.setVdiQuienremite(vwDocInterno.getVdiQuienremite());
        vwDocInternoVO.setVdiTipo(vwDocInterno.getVdiTipo());
        return vwDocInternoVO;
    }

}
