package com.ositran.serviceimpl;

import com.ositran.dao.MenDAO;
import com.ositran.daoimpl.MenDAOImpl;
import com.ositran.model.InversionTipo;
import com.ositran.model.Men;
import com.ositran.model.Rol;
import com.ositran.service.MenService;
import com.ositran.vo.bean.MenVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenServiceImpl implements  MenService{
    Men men;
    MenVO menVO;
    MenDAO menDAOImpl;
    
    @Override
    public List<MenVO> query() {
       List<Men> list=menDAOImpl.query();
       List<MenVO> listVO=toListMenVO(list);
       
        return listVO;
    }
    
    @Override
    public List<MenVO> query1(String filtro) {
        List<Men> list=menDAOImpl.query1(filtro);
        List<MenVO> listVO=toListMenVO(list);
        
         return listVO;
    }
    
    @Override
    public int getPadre(Integer codigo) {
        int codigoP=menDAOImpl.getPadre(codigo);
        return codigoP;
    }
    
    @Override
    public String getNombre(Integer codigo) {
        String nombre=menDAOImpl.getNombre(codigo);
        return nombre;
    }

  

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(MenVO menVO) {
        men=toTipoInversion(menVO);
        String result=menDAOImpl.update(men);
        return result;
    }

    @Override
    public MenVO get(Integer id) {
        men =menDAOImpl.get(id);
        menVO=toMenVO(men);
        return menVO;
       
    }
    
    @Override
    public String insert(MenVO menVO) {
        men=toTipoInversion(menVO);
        String result=menDAOImpl.insert(men);
        return result;
    }
    
    //Convesiones *********************************************
       private List<MenVO> toListMenVO(List<Men> list)  {
        List<MenVO> listVO=new ArrayList<MenVO>();
        for(int i=0;i<list.size();i++){
            men=(Men)list.get(i);
            menVO=toMenVO(men);
            listVO.add(menVO);
        }
        return listVO;
    }
    private MenVO toMenVO(Men men)  {
       MenVO menVO1=new MenVO();
       menVO1.setMenId(men.getMenId());
       menVO1.setDescripcion(men.getDescripcion());
       menVO1.setMenEstado(men.getMenEstado());
       menVO1.setMenFechaAlta(men.getMenFechaAlta());
       menVO1.setMenFechaBaja(men.getMenFechaBaja());
       menVO1.setMenFechaCambio(men.getMenFechaCambio());
       menVO1.setMenFormulario(men.getMenFormulario());
       menVO1.setMenNombre(men.getMenNombre());
       menVO1.setMenPadre(men.getMenPadre());
       menVO1.setMenTerminal(men.getMenTerminal());
       menVO1.setMenUsuarioAlta(men.getMenUsuarioAlta());
       menVO1.setMenUsuarioBaja(men.getMenUsuarioBaja());
       menVO1.setMenUsuarioCambio(men.getMenUsuarioCambio());
       menVO1.setMenUrl(men.getMenUrl());
        return menVO1;
    }
    private Men toTipoInversion(MenVO menVO1)  {
        Men men1=new Men();
       men1.setMenId(menVO1.getMenId());
       men1.setDescripcion(menVO1.getDescripcion());
       men1.setMenEstado(menVO1.getMenEstado());
       men1.setMenFechaAlta(menVO1.getMenFechaAlta());
       men1.setMenFechaBaja(menVO1.getMenFechaBaja());
       men1.setMenFechaCambio(menVO1.getMenFechaCambio());
       men1.setMenFormulario(menVO1.getMenFormulario());
       men1.setMenNombre(menVO1.getMenNombre());
       men1.setMenPadre(menVO1.getMenPadre());
       men1.setMenTerminal(menVO1.getMenTerminal());
       men1.setMenUsuarioAlta(menVO1.getMenUsuarioAlta());
       men1.setMenUsuarioBaja(menVO1.getMenUsuarioBaja());
       men1.setMenUsuarioCambio(menVO1.getMenUsuarioCambio());
        men1.setMenUrl(menVO1.getMenUrl());
        return men1;
    }

    public void setMen(Men men) {
        this.men = men;
    }

    public Men getMen() {
        return men;
    }

    public void setMenVO(MenVO menVO) {
        this.menVO = menVO;
    }

    public MenVO getMenVO() {
        return menVO;
    }

    public void setMenDAOImpl(MenDAO menDAOImpl) {
        this.menDAOImpl = menDAOImpl;
    }

    public MenDAO getMenDAOImpl() {
        return menDAOImpl;
    }


  
}
