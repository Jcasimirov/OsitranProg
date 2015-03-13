package com.ositran.serviceimpl;

import com.ositran.daoimpl.RolDAOImpl;
import com.ositran.model.InversionTipo;
import com.ositran.model.Rol;
import com.ositran.model.RolOpciones;
import com.ositran.service.RolService;
import com.ositran.vo.bean.ConcesionVO;
import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;

import com.ositran.vo.bean.TipoInversionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolServiceImpl  implements RolService{
    private Rol rol;
    private RolVO rolVO;
    private RolDAOImpl  rolDAOImpl;
    
    public RolServiceImpl() {
        super();
    }

    
    
    @Override
    public List<RolVO> query() {
        List<Rol> list=rolDAOImpl.query();
         List<RolVO> listVO=toListRolVO(list);
        return listVO;
    }
  
  
    @Override
    public int getCodigo(RolVO rolVO1) {
        int codigo=0;
        rol=toRol(rolVO1);
        codigo=rolDAOImpl.getCodigo(rol);
        return codigo;
    }

    @Override
    public String insert(RolVO rolVO) {
        rol=toRol(rolVO);
        String result=rolDAOImpl.insert(rol);
        return result;
        
    }

    @Override
    public String delete(Integer id) {
        rolDAOImpl.delete(id);
        return null;
    }

    @Override
    public String update(RolVO rol) {
        // TODO Implement this method
        return null;
    }

    @Override
    public RolVO get(Integer id) {
        rol =rolDAOImpl.get(id);
        rolVO=toRolVO(rol);
        return rolVO;
    }
    
    //Convesiones *********************************************
     private List<RolVO> toListRolVO(List<Rol> list)  {
        List<RolVO> listVO=new ArrayList<RolVO>();
        for(int i=0;i<list.size();i++){
            rol=(Rol)list.get(i);
            rolVO=toRolVO(rol);
            listVO.add(rolVO);
        }
        return listVO;
    }
     
  
    private RolVO toRolVO(Rol rol)  {
        RolVO toRolVO2=new RolVO();
        toRolVO2.setRolId(rol.getRolId());
        toRolVO2.setRolDescripcion(rol.getRolDescripcion());
        toRolVO2.setRolEstado(rol.getRolEstado());
        toRolVO2.setRolFechaAlta(rol.getRolFechaAlta());
        toRolVO2.setRolFechaCambio(rol.getRolFechaCambio());
        toRolVO2.setRolFechaBaja(rol.getRolFechaBaja());
        toRolVO2.setRolNombre(rol.getRolNombre());
        toRolVO2.setRolTerminal(rol.getRolTerminal());
        toRolVO2.setRolUsuarioAlta(rol.getRolUsuarioAlta());
        toRolVO2.setRolUsuarioBaja(rol.getRolUsuarioBaja());
        toRolVO2.setRolUsuarioCambio(rol.getRolUsuarioCambio());
        return toRolVO2;
    }
    private Rol toRol(RolVO rolVO)  {
        Rol rol1=new Rol();
        rol1.setRolId(rolVO.getRolId());
        rol1.setRolDescripcion(rolVO.getRolDescripcion());
        rol1.setRolEstado(rolVO.getRolEstado());
        rol1.setRolFechaAlta(rolVO.getRolFechaAlta());
        rol1.setRolFechaCambio(rolVO.getRolFechaCambio());
        rol1.setRolFechaBaja(rolVO.getRolFechaBaja());
        rol1.setRolNombre(rolVO.getRolNombre());
        rol1.setRolTerminal(rolVO.getRolTerminal());
        rol1.setRolUsuarioAlta(rolVO.getRolUsuarioAlta());
        rol1.setRolUsuarioBaja(rolVO.getRolUsuarioBaja());
        rol1.setRolUsuarioCambio(rolVO.getRolUsuarioCambio());
        return rol1;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRolVO(RolVO rolVO) {
        this.rolVO = rolVO;
    }

    public void setRolDAOImpl(RolDAOImpl rolDAOImpl) {
        this.rolDAOImpl = rolDAOImpl;
    }

    public RolDAOImpl getRolDAOImpl() {
        return rolDAOImpl;
    }

    public RolVO getRolVO() {
        return rolVO;
    }


}
