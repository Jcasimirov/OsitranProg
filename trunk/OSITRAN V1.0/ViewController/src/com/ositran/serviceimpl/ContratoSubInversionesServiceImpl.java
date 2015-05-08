package com.ositran.serviceimpl;

import com.ositran.dao.ContratoSubInversionesDAO;
import com.ositran.daoimpl.ContratoSubInversionesDAOImpl;
import com.ositran.model.ContratoSupInversiones;
import com.ositran.service.ContratoSubInversionesService;
import com.ositran.vo.bean.ContratoSubInversionesVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContratoSubInversionesServiceImpl  implements  ContratoSubInversionesService{
    ContratoSupInversiones contratoSupInversiones= new ContratoSupInversiones();
    ContratoSubInversionesVO contratoSupInversionesVO= new ContratoSubInversionesVO();
    ContratoSubInversionesDAO contratoSubInversionesDAOImpl= new ContratoSubInversionesDAOImpl();
    
    

    @Override
    public List<ContratoSubInversionesVO> query() throws SQLException, Exception {
        List<ContratoSupInversiones> list=contratoSubInversionesDAOImpl.query();
        List<ContratoSubInversionesVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }

    @Override
    public String insert(ContratoSubInversionesVO contratoSubInversionesVO) throws SQLException, Exception {
        contratoSupInversiones=toContratoSupInversiones(contratoSubInversionesVO);
        String result=contratoSubInversionesDAOImpl.insert(contratoSupInversiones);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(ContratoSubInversionesVO contratoSubInversionesVO) throws ParseException, SQLException,                                                                                   Exception {
       contratoSupInversiones=toContratoSupInversiones(contratoSubInversionesVO);
        String result=contratoSubInversionesDAOImpl.update(contratoSupInversiones);
        return result;
    }

    @Override
    public ContratoSubInversionesVO get(Integer id) throws SQLException, Exception {
        contratoSupInversiones =contratoSubInversionesDAOImpl.get(id);
        contratoSupInversionesVO=toContratoSubInversionesVO(contratoSupInversiones);
        return contratoSupInversionesVO;
    }
    
    @Override
    public ContratoSubInversionesVO get1(Integer id) throws SQLException, Exception {
        contratoSupInversiones =contratoSubInversionesDAOImpl.get(id);
        contratoSupInversionesVO=toContratoSubInversionesVO(contratoSupInversiones);
        return contratoSupInversionesVO;
    }


    @Override
    public List<ContratoSubInversionesVO> query1(int filtro ) throws SQLException, Exception {
        List<ContratoSupInversiones> list=contratoSubInversionesDAOImpl.query1(filtro);
        List<ContratoSubInversionesVO> listVO=toListTipoInversionVO(list);
        return listVO;
    }

    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        return 0;
    }



    //conversiones
    private List<ContratoSubInversionesVO> toListTipoInversionVO(List<ContratoSupInversiones> list)  {
       List<ContratoSubInversionesVO> listVO=new ArrayList<ContratoSubInversionesVO>();
       for(int i=0;i<list.size();i++){
           contratoSupInversiones=(ContratoSupInversiones)list.get(i);
           contratoSupInversionesVO=toContratoSubInversionesVO(contratoSupInversiones);
           listVO.add(contratoSupInversionesVO);
       }
       return listVO;
    }
    private ContratoSubInversionesVO toContratoSubInversionesVO(ContratoSupInversiones contratoSubInversiones1)  {
       ContratoSubInversionesVO contratoSubInversionesVO1=new ContratoSubInversionesVO();
       contratoSubInversionesVO1.setConId(contratoSubInversiones1.getConId());
       contratoSubInversionesVO1.setCsiId(contratoSubInversiones1.getCsiId());
       contratoSubInversionesVO1.setInfId(contratoSubInversiones1.getInfId());
       contratoSubInversionesVO1.setSivEstado(contratoSubInversiones1.getSivEstado());
       contratoSubInversionesVO1.setSivFechaFinal(contratoSubInversiones1.getSivFechaFinal());
       contratoSubInversionesVO1.setSivFechaInicial(contratoSubInversiones1.getSivFechaInicial());
       contratoSubInversionesVO1.setSivId(contratoSubInversiones1.getSivId());
       contratoSubInversionesVO1.setSivNombre(contratoSubInversiones1.getSivNombre());
       contratoSubInversionesVO1.setSivUmero(contratoSubInversiones1.getSivNumero());
       contratoSubInversionesVO1.setConId(contratoSubInversiones1.getConId());
       contratoSubInversionesVO1.setTdoId(contratoSubInversiones1.getTdoId());
       contratoSubInversionesVO1.setTinId(contratoSubInversiones1.getTinId());
       contratoSubInversionesVO1.setTsiId(contratoSubInversiones1.getTsiId());

       return contratoSubInversionesVO1;
    }
    
    
    private ContratoSupInversiones toContratoSupInversiones(ContratoSubInversionesVO contratoSubInversionesVO1)  {
       ContratoSupInversiones contratoSubInversiones1=new ContratoSupInversiones();
        contratoSubInversiones1.setConId(contratoSubInversionesVO1.getConId());
        contratoSubInversiones1.setCsiId(contratoSubInversionesVO1.getCsiId());
        contratoSubInversiones1.setInfId(contratoSubInversionesVO1.getInfId());
        contratoSubInversiones1.setSivEstado(contratoSubInversionesVO1.getSivEstado());
        contratoSubInversiones1.setSivFechaFinal(contratoSubInversionesVO1.getSivFechaFinal());
        contratoSubInversiones1.setSivFechaInicial(contratoSubInversionesVO1.getSivFechaInicial());
        contratoSubInversiones1.setSivId(contratoSubInversionesVO1.getSivId());
        contratoSubInversiones1.setSivNombre(contratoSubInversionesVO1.getSivNombre());
        contratoSubInversiones1.setSivNumero(contratoSubInversionesVO1.getSivUmero());
        contratoSubInversiones1.setConId(contratoSubInversionesVO1.getConId());
        contratoSubInversiones1.setTdoId(contratoSubInversionesVO1.getTdoId());
        contratoSubInversiones1.setTinId(contratoSubInversionesVO1.getTinId());
        contratoSubInversiones1.setTsiId(contratoSubInversionesVO1.getTsiId());
       return contratoSubInversiones1;
    }





    public void setContratoSupInversiones(ContratoSupInversiones contratoSupInversiones) {
        this.contratoSupInversiones = contratoSupInversiones;
    }

    public ContratoSupInversiones getContratoSupInversiones() {
        return contratoSupInversiones;
    }


    public void setContratoSupInversionesVO(ContratoSubInversionesVO contratoSupInversionesVO) {
        this.contratoSupInversionesVO = contratoSupInversionesVO;
    }

    public ContratoSubInversionesVO getContratoSupInversionesVO() {
        return contratoSupInversionesVO;
    }


    public void setContratoSubInversionesDAOImpl(ContratoSubInversionesDAO contratoSubInversionesDAOImpl) {
        this.contratoSubInversionesDAOImpl = contratoSubInversionesDAOImpl;
    }

    public ContratoSubInversionesDAO getContratoSubInversionesDAOImpl() {
        return contratoSubInversionesDAOImpl;
    }

  
}
