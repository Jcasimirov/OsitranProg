package com.ositran.serviceimpl;

import com.ositran.daoimpl.EmpresaSupervisoraDAOImpl;
import com.ositran.model.EmpresaSupervisora;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.vo.bean.EmpresaSupervisoraVO;

import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.util.ArrayList;
import java.util.List;

public class EmpresaSupervisoraServiceImpl implements EmpresaSupervisoraService{
    public EmpresaSupervisoraServiceImpl() {
        super();
    }
    
    private EmpresaSupervisoraDAOImpl empresaSupervisoraDAOImpl;

    public void setEmpresaSupervisoraDAOImpl(EmpresaSupervisoraDAOImpl empresaSupervisoraDAOImpl) {
        this.empresaSupervisoraDAOImpl = empresaSupervisoraDAOImpl;
    }

    @Override
    public List<EmpresaSupervisoraVO> query() {
        List<EmpresaSupervisora> list=empresaSupervisoraDAOImpl.query();
        List<EmpresaSupervisoraVO> listVO=toListEmpresaSupervisoraVO(list);
        return listVO;
    }

    @Override
    public String insert(EmpresaSupervisoraVO empresaSupervisoraVO) {
        EmpresaSupervisora empresaSupervisora=toEmpresaSupervisora(empresaSupervisoraVO);
        String result=empresaSupervisoraDAOImpl.insert(empresaSupervisora);
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result=this.empresaSupervisoraDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(EmpresaSupervisoraVO empresaSupervisoraVO) {
        EmpresaSupervisora empresaSupervisora=toEmpresaSupervisora(empresaSupervisoraVO);
        String result=this.empresaSupervisoraDAOImpl.update(empresaSupervisora);
        return result;
    }

    @Override
    public EmpresaSupervisoraVO get(Integer id) {
        EmpresaSupervisora empresaSupervisora=this.empresaSupervisoraDAOImpl.get(id);
        EmpresaSupervisoraVO empresaSupervisoraVO=toEmpresaSupervisoraVO(empresaSupervisora);
        return empresaSupervisoraVO;
    }
    
    //conversiones
    private List<EmpresaSupervisoraVO> toListEmpresaSupervisoraVO(List<EmpresaSupervisora> list){
        List<EmpresaSupervisoraVO> listVO=new ArrayList<EmpresaSupervisoraVO>();
        for(int i=0;i<list.size();i++){
            EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)list.get(i);
            EmpresaSupervisoraVO empresaSupervisoraVO=toEmpresaSupervisoraVO(empresaSupervisora);
            listVO.add(empresaSupervisoraVO);
        }
        return listVO;
    }
    private EmpresaSupervisoraVO toEmpresaSupervisoraVO(EmpresaSupervisora empresaSupervisora){
        EmpresaSupervisoraVO empresaSupervisoraVO=new EmpresaSupervisoraVO();
        empresaSupervisoraVO.setCrgId(empresaSupervisora.getCrgId());
        empresaSupervisoraVO.setSupCorreo(empresaSupervisora.getSupCorreo());
        empresaSupervisoraVO.setSupDescripcion(empresaSupervisora.getSupDescripcion());
        empresaSupervisoraVO.setSupDireccion(empresaSupervisora.getSupDireccion());
        empresaSupervisoraVO.setSupEstado(empresaSupervisora.getSupEstado());
        empresaSupervisoraVO.setSupFechaAlta(empresaSupervisora.getSupFechaAlta());
        empresaSupervisoraVO.setSupFechaBaja(empresaSupervisora.getSupFechaBaja());
        empresaSupervisoraVO.setSupFechaCambio(empresaSupervisora.getSupFechaCambio());
        empresaSupervisoraVO.setSupId(empresaSupervisora.getSupId());
        empresaSupervisoraVO.setSupNombre(empresaSupervisora.getSupNombre());
        empresaSupervisoraVO.setSupNroDocumento(empresaSupervisora.getSupNroDocumento());
        empresaSupervisoraVO.setSupRepresentanteLegal(empresaSupervisora.getSupRepresentanteLegal());
        empresaSupervisoraVO.setSupTelefono(empresaSupervisora.getSupTelefono());
        empresaSupervisoraVO.setSupTerminal(empresaSupervisora.getSupTerminal());
        empresaSupervisoraVO.setSupUsuarioAlta(empresaSupervisora.getSupUsuarioAlta());
        empresaSupervisoraVO.setSupUsuarioBaja(empresaSupervisora.getSupUsuarioBaja());
        empresaSupervisoraVO.setSupUsuarioCambio(empresaSupervisora.getSupUsuarioCambio());
        empresaSupervisoraVO.setTdoId(empresaSupervisora.getTdoId());

       
        return empresaSupervisoraVO;
    }
    private EmpresaSupervisora toEmpresaSupervisora(EmpresaSupervisoraVO empresaSupervisoraVO){
        EmpresaSupervisora empresaSupervisora=new EmpresaSupervisora();
        empresaSupervisora.setCrgId(empresaSupervisoraVO.getCrgId());
        empresaSupervisora.setSupCorreo(empresaSupervisoraVO.getSupCorreo());
        empresaSupervisora.setSupDescripcion(empresaSupervisoraVO.getSupDescripcion());
        empresaSupervisora.setSupDireccion(empresaSupervisoraVO.getSupDireccion());
        empresaSupervisora.setSupEstado(empresaSupervisoraVO.getSupEstado());
        empresaSupervisora.setSupFechaAlta(empresaSupervisoraVO.getSupFechaAlta());
        empresaSupervisora.setSupFechaBaja(empresaSupervisoraVO.getSupFechaBaja());
        empresaSupervisora.setSupFechaCambio(empresaSupervisoraVO.getSupFechaCambio());
        empresaSupervisora.setSupId(empresaSupervisoraVO.getSupId());
        empresaSupervisora.setSupNombre(empresaSupervisoraVO.getSupNombre());
        empresaSupervisora.setSupNroDocumento(empresaSupervisoraVO.getSupNroDocumento());
        empresaSupervisora.setSupRepresentanteLegal(empresaSupervisoraVO.getSupRepresentanteLegal());
        empresaSupervisora.setSupTelefono(empresaSupervisoraVO.getSupTelefono());
        empresaSupervisora.setSupTerminal(empresaSupervisoraVO.getSupTerminal());
        empresaSupervisora.setSupUsuarioAlta(empresaSupervisoraVO.getSupUsuarioAlta());
        empresaSupervisora.setSupUsuarioBaja(empresaSupervisoraVO.getSupUsuarioBaja());
        empresaSupervisora.setSupUsuarioCambio(empresaSupervisoraVO.getSupUsuarioCambio());
        empresaSupervisora.setTdoId(empresaSupervisoraVO.getTdoId());
        
        return empresaSupervisora;
        
    }

    
}
