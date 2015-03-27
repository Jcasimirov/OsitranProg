package com.ositran.serviceimpl;

import com.ositran.daoimpl.DatosStdDAOImpl;
import com.ositran.model.ViewTdInternos;
import com.ositran.service.DatosStdService;
import com.ositran.vo.bean.ViewTdInternosVO;
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
    public ViewTdInternosVO BuscaStd(Integer año, String nro) throws SQLException{
        try {
        ViewTdInternos vista=this.datosStdDAOImpl.BuscaStd(año,nro);
        if (vista != null){
            ViewTdInternosVO vistaVO=toViewTdInternosVO(vista);
            return vistaVO;
        }
        } catch (Exception e) {
            System.out.println(e);            
        }
        return null;
    }
     
    
    private ViewTdInternosVO toViewTdInternosVO(ViewTdInternos viewTdInternos){
        ViewTdInternosVO viewTdInternosVO=new ViewTdInternosVO();
        viewTdInternosVO.setAnyo(viewTdInternos.getAnyo());
        viewTdInternosVO.setAnyoHtRefe(viewTdInternos.getAnyoHtRefe());
        viewTdInternosVO.setAsunto(viewTdInternos.getAsunto());
        viewTdInternosVO.setCargo(viewTdInternos.getCargo());
        viewTdInternosVO.setCodDestinatario(viewTdInternos.getCodDestinatario());
        viewTdInternosVO.setCodRemitente(viewTdInternos.getCodRemitente());
        viewTdInternosVO.setCodTipEmpresa(viewTdInternos.getCodTipEmpresa());
        viewTdInternosVO.setCod_Tip_Doc(viewTdInternos.getCod_Tip_Doc());
        viewTdInternosVO.setEmpresa(viewTdInternos.getCodTipEmpresa());
        viewTdInternosVO.setFecDoc(viewTdInternos.getFecDoc());
        viewTdInternosVO.setFechaRegistro(viewTdInternos.getFechaRegistro());
        viewTdInternosVO.setHtReferencia(viewTdInternos.getHtReferencia());
        viewTdInternosVO.setNomDestinatario(viewTdInternos.getNomDestinatario());
        viewTdInternosVO.setNroRegistro(viewTdInternos.getNroRegistro());
        viewTdInternosVO.setNumDoc(viewTdInternos.getNumDoc());
        viewTdInternosVO.setRemitente(viewTdInternos.getCodRemitente());
        viewTdInternosVO.setTipDoc(viewTdInternos.getTipDoc());
        viewTdInternosVO.setTipoDestino(viewTdInternos.getTipoDestino());
        viewTdInternosVO.setTipoEmpresa(viewTdInternos.getTipoEmpresa());
   
        return viewTdInternosVO;
    }

}
