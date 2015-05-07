package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionSupDAOImpl;
import com.ositran.model.Usuario;
import com.ositran.model.ValorizacionSup;
import com.ositran.service.ValorizacionSupService;
import com.ositran.vo.bean.ValorizacionSupVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ValorizacionSupServiceImpl implements ValorizacionSupService {
    public ValorizacionSupServiceImpl() {
        super();
    }
    
    private ValorizacionSupDAOImpl valorizacionSupDAOImpl= new ValorizacionSupDAOImpl();
    public List<ValorizacionSupVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int insert(ValorizacionSupVO valorizacionSupVO) throws SQLException, Exception {
        ValorizacionSup valorizacionSup = toValorizacionSup(valorizacionSupVO);
        int result = valorizacionSupDAOImpl.insert(valorizacionSup);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionSupVO valorizacionSupVO) throws ParseException, SQLException, Exception {
        ValorizacionSup valorizacionSup=toValorizacionSup(valorizacionSupVO);
        String result=this.valorizacionSupDAOImpl.update(valorizacionSup);
        return result;
    }

    @Override
    public ValorizacionSupVO get(Integer id) throws SQLException, Exception {
        ValorizacionSup valorizacionSup= valorizacionSupDAOImpl.get(id);
        ValorizacionSupVO valorizacionSupVO=toValorizacionSupVO(valorizacionSup);
        return valorizacionSupVO;
        
    }

    public void setValorizacionSupDAOImpl(ValorizacionSupDAOImpl valorizacionSupDAOImpl) {
        this.valorizacionSupDAOImpl = valorizacionSupDAOImpl;
    }

    public ValorizacionSupDAOImpl getValorizacionSupDAOImpl() {
        return valorizacionSupDAOImpl;
    }


    //conversiones
    private List<ValorizacionSupVO> toListValorizacionSupVO(List<ValorizacionSup> list){
        List<ValorizacionSupVO> listVO=new ArrayList<ValorizacionSupVO>();
        for(int i=0;i<list.size();i++){
            ValorizacionSup valorizacionSup=(ValorizacionSup)list.get(i);
            ValorizacionSupVO valorizacionSupVO=toValorizacionSupVO(valorizacionSup);
            listVO.add(valorizacionSupVO);
        }
        return listVO;
    }
    
    private ValorizacionSupVO toValorizacionSupVO(ValorizacionSup valorizacionSup){
        ValorizacionSupVO valorizacionSupVO=new ValorizacionSupVO();
        valorizacionSupVO.setTvsId(valorizacionSup.getTvsId());        
        valorizacionSupVO.setMonId(valorizacionSup.getMonId());
        valorizacionSupVO.setTvsBruto(valorizacionSup.getTvsBruto());
        valorizacionSupVO.setTvsHr(valorizacionSup.getTvsHr());
        valorizacionSupVO.setTvsIgv(valorizacionSup.getTvsIgv());
        valorizacionSupVO.setTvsInfFechaEmision(valorizacionSup.getTvsInfFechaEmision());
        valorizacionSupVO.setTvsInfNumero(valorizacionSup.getTvsInfNumero());
        valorizacionSupVO.setTvsInfRegSalida(valorizacionSup.getTvsInfRegSalida());
        valorizacionSupVO.setTvsMemFechaEmision(valorizacionSup.getTvsMemFechaEmision());
        valorizacionSupVO.setTvsMemNumero(valorizacionSup.getTvsMemNumero());
        valorizacionSupVO.setTvsMemRegSalida(valorizacionSup.getTvsMemRegSalida());
        valorizacionSupVO.setTvsNeto(valorizacionSup.getTvsNeto());
        valorizacionSupVO.setTvsOfiFechaEmision(valorizacionSup.getTvsOfiFechaEmision());
        valorizacionSupVO.setTvsOfiNumero(valorizacionSup.getTvsOfiNumero());
        valorizacionSupVO.setTvsOfiRegSalida(valorizacionSup.getTvsOfiRegSalida());
        valorizacionSupVO.setTvsEstado(valorizacionSup.getTvsEstado());
        valorizacionSupVO.setSupId(valorizacionSup.getSupId());
        valorizacionSupVO.setTvsAnyo(valorizacionSup.getTvsAnyo());
        valorizacionSupVO.setTvsFechaRegistro(valorizacionSup.getTvsFechaRegistro());
        valorizacionSupVO.setTvsAsunto(valorizacionSup.getTvsAsunto());
        valorizacionSupVO.setTvsAprobado(valorizacionSup.getTvsAprobado());
        valorizacionSupVO.setTvsObservacion(valorizacionSup.getTvsObservacion());        
        valorizacionSupVO.setTvsFechaAprob(valorizacionSup.getTvsFechaAprob());        
        valorizacionSupVO.setTvsMontoTotalAprob(valorizacionSup.getTvsMontoTotalAprob());        
        valorizacionSupVO.setTvsUsuarioAprob(valorizacionSup.getTvsUsuarioAprob());        
        valorizacionSupVO.setTvsTinId(valorizacionSup.getTvsTinId());        
        valorizacionSupVO.setTvsCsiId(valorizacionSup.getTvsCsiId());        
        valorizacionSupVO.setTvsCcoId(valorizacionSup.getTvsCcoId());        
        valorizacionSupVO.setTvsTccTipo(valorizacionSup.getTvsTccTipo());        
        valorizacionSupVO.setTvsMcoId(valorizacionSup.getTvsMcoId());        
        valorizacionSupVO.setTvsInfId(valorizacionSup.getTvsInfId());        
        valorizacionSupVO.setTvsInvId(valorizacionSup.getTvsInvId());        
        valorizacionSupVO.setTvsCcoTotal(valorizacionSup.getTvsCcoTotal());        
        valorizacionSupVO.setTvsCcoPlazo(valorizacionSup.getTvsCcoPlazo());
        
        return valorizacionSupVO;
    }
    
    private ValorizacionSup toValorizacionSup(ValorizacionSupVO valorizacionSupVO){
        ValorizacionSup valorizacionSup=new ValorizacionSup();
        valorizacionSup.setTvsId(valorizacionSupVO.getTvsId());
        valorizacionSup.setMonId(valorizacionSupVO.getMonId());
        valorizacionSup.setTvsBruto(valorizacionSupVO.getTvsBruto());
        valorizacionSup.setTvsHr(valorizacionSupVO.getTvsHr());
        valorizacionSup.setTvsIgv(valorizacionSupVO.getTvsIgv());
        valorizacionSup.setTvsInfFechaEmision(valorizacionSupVO.getTvsInfFechaEmision());
        valorizacionSup.setTvsInfNumero(valorizacionSupVO.getTvsInfNumero());
        valorizacionSup.setTvsInfRegSalida(valorizacionSupVO.getTvsInfRegSalida());
        valorizacionSup.setTvsMemFechaEmision(valorizacionSupVO.getTvsMemFechaEmision());
        valorizacionSup.setTvsMemNumero(valorizacionSupVO.getTvsMemNumero());
        valorizacionSup.setTvsMemRegSalida(valorizacionSupVO.getTvsMemRegSalida());
        valorizacionSup.setTvsNeto(valorizacionSupVO.getTvsNeto());
        valorizacionSup.setTvsOfiFechaEmision(valorizacionSupVO.getTvsOfiFechaEmision());
        valorizacionSup.setTvsOfiNumero(valorizacionSupVO.getTvsOfiNumero());
        valorizacionSup.setTvsOfiRegSalida(valorizacionSupVO.getTvsOfiRegSalida());
        valorizacionSup.setTvsEstado(valorizacionSupVO.getTvsEstado());
        valorizacionSup.setSupId(valorizacionSupVO.getSupId());
        valorizacionSup.setTvsAnyo(valorizacionSupVO.getTvsAnyo());
        valorizacionSup.setTvsFechaRegistro(valorizacionSupVO.getTvsFechaRegistro());
        valorizacionSup.setTvsAsunto(valorizacionSupVO.getTvsAsunto()); 
        valorizacionSup.setTvsAprobado(valorizacionSupVO.getTvsAprobado());
        valorizacionSup.setTvsObservacion(valorizacionSupVO.getTvsObservacion());        
        valorizacionSup.setTvsFechaAprob(valorizacionSupVO.getTvsFechaAprob());        
        valorizacionSup.setTvsMontoTotalAprob(valorizacionSupVO.getTvsMontoTotalAprob());        
        valorizacionSup.setTvsUsuarioAprob(valorizacionSupVO.getTvsUsuarioAprob());        
        valorizacionSup.setTvsTinId(valorizacionSupVO.getTvsTinId());        
        valorizacionSup.setTvsCsiId(valorizacionSupVO.getTvsCsiId());        
        valorizacionSup.setTvsCcoId(valorizacionSupVO.getTvsCcoId());        
        valorizacionSup.setTvsTccTipo(valorizacionSupVO.getTvsTccTipo());        
        valorizacionSup.setTvsMcoId(valorizacionSupVO.getTvsMcoId());        
        valorizacionSup.setTvsInfId(valorizacionSupVO.getTvsInfId());        
        valorizacionSup.setTvsInvId(valorizacionSupVO.getTvsInvId());        
        valorizacionSup.setTvsCcoTotal(valorizacionSupVO.getTvsCcoTotal());        
        valorizacionSup.setTvsCcoPlazo(valorizacionSupVO.getTvsCcoPlazo());
        
        return valorizacionSup;
        
    }
    
    //Ivan
    @Override
    public List<ValorizacionSupVO> ListaValorizacionesRegistradas(Integer id) throws SQLException, Exception {
        List<ValorizacionSup> Lista = valorizacionSupDAOImpl.ListaValorizacionesRegistradas(id);
        List<ValorizacionSupVO> ListaVO = toListValorizacionSupVO(Lista);
        return ListaVO;
    }
    
}
