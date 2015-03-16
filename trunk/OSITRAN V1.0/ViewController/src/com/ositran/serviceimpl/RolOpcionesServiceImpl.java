package com.ositran.serviceimpl;

import com.ositran.dao.RolOpcionesDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.Rol;
import com.ositran.model.RolOpciones;
import com.ositran.service.RolOpcionesService;
import com.ositran.vo.bean.RolOpcionesVO;

import com.ositran.vo.bean.RolVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolOpcionesServiceImpl implements RolOpcionesService{
    private RolOpciones rolOpciones;
    private RolOpcionesVO rolOpcionesVO;
    private RolOpcionesDAO rolOpcionesDAOImpl;     
    
    public RolOpcionesServiceImpl() {
        super();
    }

    @Override
    public List<RolOpcionesVO> query() {
        List<RolOpciones> list=rolOpcionesDAOImpl.query();
        List<RolOpcionesVO> listVO=toListRolOpcionesVO(list);
        return listVO;
    }

    @Override
    public void updateEstado(int codigo) {
        rolOpcionesDAOImpl.updateEstado(codigo);
    }
    
    @Override
    public List<RolOpcionesVO> query1(Integer codigoRol) {
        List<RolOpciones> list=rolOpcionesDAOImpl.query1(codigoRol);
        List<RolOpcionesVO> listVO=toListRolOpcionesVO(list);
        return listVO;
    }
    
    @Override
    public String insert(RolOpcionesVO rolOpcionesVO) {
        RolOpciones rolOpciones=toRolOpciones(rolOpcionesVO);
        String result=rolOpcionesDAOImpl.insert(rolOpciones);
        return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(RolOpciones rolOpcionesOpciones) {
        // TODO Implement this method
        return null;
    }

    @Override
    public RolOpciones get(Integer id) {
        // TODO Implement this method
        return null;
    }
    
    //Convesiones *********************************************
     private List<RolOpcionesVO> toListRolOpcionesVO(List<RolOpciones> list)  {
        List<RolOpcionesVO> listVO=new ArrayList<RolOpcionesVO>();
        for(int i=0;i<list.size();i++){
            rolOpciones=(RolOpciones)list.get(i);
            rolOpcionesVO=toRolOpcionesVO(rolOpciones);
            listVO.add(rolOpcionesVO);
        }
        return listVO;
    }
    private RolOpcionesVO toRolOpcionesVO(RolOpciones rolOpciones)  {
        RolOpcionesVO rolOpcionesVO1=new RolOpcionesVO();
        rolOpcionesVO1.setRxoId(rolOpciones.getRxoId());
        rolOpcionesVO1.setMenId(rolOpciones.getMenId());
        rolOpcionesVO1.setRolId(rolOpciones.getRolId());
        rolOpcionesVO1.setTroAgregar(rolOpciones.getTroAgregar());
        rolOpcionesVO1.setTroConsultar(rolOpciones.getTroConsultar());
        rolOpcionesVO1.setTroEliminar(rolOpciones.getTroEliminar());
        rolOpcionesVO1.setTroEstado(rolOpciones.getTroEstado());
        rolOpcionesVO1.setTroFechaAlta(rolOpciones.getTroFechaAlta());
        rolOpcionesVO1.setTroFechaBaja(rolOpciones.getTroFechaBaja());
        rolOpcionesVO1.setTroFechaCambio(rolOpciones.getTroFechaCambio());
        rolOpcionesVO1.setTroModificar(rolOpciones.getTroModificar());
        rolOpcionesVO1.setTroTerminal(rolOpciones.getTroTerminal());
        rolOpcionesVO1.setTroUsuarioAlta(rolOpciones.getTroUsuarioAlta());
        rolOpcionesVO1.setTroUsuarioBaja(rolOpciones.getTroUsuarioBaja());
        rolOpcionesVO1.setTroUsuarioCambio(rolOpciones.getTroUsuarioCambio());
        return rolOpcionesVO1;
    }
    private RolOpciones toRolOpciones(RolOpcionesVO rolOpcionesVO)  {
        RolOpciones rolOpciones1=new RolOpciones();
        rolOpciones1.setRxoId(rolOpcionesVO.getRxoId());
        rolOpciones1.setMenId(rolOpcionesVO.getMenId());
        rolOpciones1.setRolId(rolOpcionesVO.getRolId());
        rolOpciones1.setTroAgregar(rolOpcionesVO.getTroAgregar());
        rolOpciones1.setTroConsultar(rolOpcionesVO.getTroConsultar());
        rolOpciones1.setTroEliminar(rolOpcionesVO.getTroEliminar());
        rolOpciones1.setTroEstado(rolOpcionesVO.getTroEstado());
        rolOpciones1.setTroFechaAlta(rolOpcionesVO.getTroFechaAlta());
        rolOpciones1.setTroFechaBaja(rolOpcionesVO.getTroFechaBaja());
        rolOpciones1.setTroFechaCambio(rolOpcionesVO.getTroFechaCambio());
        rolOpciones1.setTroModificar(rolOpcionesVO.getTroModificar());
        rolOpciones1.setTroTerminal(rolOpcionesVO.getTroTerminal());
        rolOpciones1.setTroUsuarioAlta(rolOpcionesVO.getTroUsuarioAlta());
        rolOpciones1.setTroUsuarioBaja(rolOpcionesVO.getTroUsuarioBaja());
        rolOpciones1.setTroUsuarioCambio(rolOpcionesVO.getTroUsuarioCambio());
        return rolOpciones1;
    }


    public void setRolOpciones(RolOpciones rolOpciones) {
        this.rolOpciones = rolOpciones;
    }

    public RolOpciones getRolOpciones() {
        return rolOpciones;
    }

    public void setRolOpcionesVO(RolOpcionesVO rolOpcionesVO) {
        this.rolOpcionesVO = rolOpcionesVO;
    }

    public RolOpcionesVO getRolOpcionesVO() {
        return rolOpcionesVO;
    }

    public void setRolOpcionesDAOImpl(RolOpcionesDAO rolOpcionesDAOImpl) {
        this.rolOpcionesDAOImpl = rolOpcionesDAOImpl;
    }

    public RolOpcionesDAO getRolOpcionesDAOImpl() {
        return rolOpcionesDAOImpl;
    }

   
}
