
package com.ositran.serviceimpl;

import com.ositran.daoimpl.SupervisorInversionesDAOImpl;
import com.ositran.model.SupervisorInversiones;
import com.ositran.service.SupervisorInversionesService;
import com.ositran.vo.bean.SupervisorInversionesVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SupervisorInversionesServiceImpl implements SupervisorInversionesService {
    
    private SupervisorInversionesDAOImpl supervisorInversionesDAOImpl= new SupervisorInversionesDAOImpl();                   
    private SupervisorInversionesVO supervisorInversionesVO = new SupervisorInversionesVO();
    private SupervisorInversiones supervisorInversiones = new SupervisorInversiones();
    List<SupervisorInversionesVO> listVO;


    public List<SupervisorInversionesVO> buscarSupervisoresxInfraestructura(int codTipoInfraestructura) throws SQLException {
        List<SupervisorInversiones> list=supervisorInversionesDAOImpl.buscarCoordinador(codTipoInfraestructura);
        List<SupervisorInversionesVO> listVO=toListV_BuscarEmpresaSupervisoraVO(list);
        return listVO;
    }
    
    private List<SupervisorInversionesVO> toListV_BuscarEmpresaSupervisoraVO(List<SupervisorInversiones> list) throws SQLException {
        listVO = new ArrayList<SupervisorInversionesVO>();
        try {
            for (int i = 0; i < list.size(); i++) {
                SupervisorInversiones coordinador = (SupervisorInversiones) list.get(i);
                SupervisorInversionesVO coreVO =toV_VO(coordinador); //enviando a la clase V_BuscarEmpresaSupervisoraVO el arreglo
                listVO.add(coreVO);
            }
        } catch (Exception e) {
            System.out.println();
        }
        return listVO;
    }


    private SupervisorInversionesVO toV_VO(SupervisorInversiones supinv) throws SQLException {
        SupervisorInversionesVO supinvVO = new SupervisorInversionesVO();
        supinvVO.setCrgId(supinv.getCrgId());
        supinvVO.setTdoId(supinv.getTdoId());
        supinvVO.setTinId(supinv.getTinId());       
        supinvVO.setTsiCorreo(supinv.getTsiCorreo());       
        supinvVO.setTsiDescripcion(supinv.getTsiDescripcion());
        supinvVO.setTsiDireccion(supinv.getTsiDireccion());
        supinvVO.setTsiEncargado(supinv.getTsiEncargado());
        /*supinvVO.setTsiEstado(supinv.getTsiEstado());
        supinvVO.setTsiFechaAlta(supinv.getTsiFechaAlta());
        supinvVO.setTsiFechaBaja(supinv.getTsiFechaBaja());
        supinvVO.setTsiFechaCambio(supinv.getTsiFechaCambio());*/
        supinvVO.setTsiHabilitado(supinv.getTsiHabilitado());
        supinvVO.setTsiId(supinv.getTsiId());
        supinvVO.setTsiNombre(supinv.getTsiNombre());
        supinvVO.setTsiNroDocumento(supinv.getTsiNroDocumento());
        supinvVO.setTsiSiglas(supinv.getTsiSiglas());
        supinvVO.setTsiTelefono(supinv.getTsiTelefono());
        /*supinvVO.setTsiTerminal(supinv.getTsiTerminal());
        supinvVO.setTsiUsuarioAlta(supinv.getTsiUsuarioAlta());
        supinvVO.setTsiUsuarioBaja(supinv.getTsiUsuarioBaja());
        supinvVO.setTsiUsuarioCambio(supinv.getTsiUsuarioCambio());  */     
        return supinvVO;
    }


    private SupervisorInversiones toV_BuscarEmpresaSupervisora(SupervisorInversionesVO supinvVO) throws SQLException {
        SupervisorInversiones supinv = new SupervisorInversiones();
        supinv.setCrgId(supinvVO.getCrgId());
        supinv.setTdoId(supinvVO.getTdoId());
        supinv.setTinId(supinvVO.getTinId());       
        supinv.setTsiCorreo(supinvVO.getTsiCorreo());       
        supinv.setTsiDescripcion(supinvVO.getTsiDescripcion());
        supinv.setTsiDireccion(supinvVO.getTsiDireccion());
        supinv.setTsiEncargado(supinvVO.getTsiEncargado());
       /* supinv.setTsiEstado(supinvVO.getTsiEstado());
        supinv.setTsiFechaAlta(supinvVO.getTsiFechaAlta());
        supinv.setTsiFechaBaja(supinvVO.getTsiFechaBaja());
        supinv.setTsiFechaCambio(supinvVO.getTsiFechaCambio());*/
        supinv.setTsiHabilitado(supinvVO.getTsiHabilitado());
        supinv.setTsiId(supinvVO.getTsiId());
        supinv.setTsiNombre(supinvVO.getTsiNombre());
        supinv.setTsiNroDocumento(supinvVO.getTsiNroDocumento());
        supinv.setTsiSiglas(supinvVO.getTsiSiglas());
        supinv.setTsiTelefono(supinvVO.getTsiTelefono());
        /*supinv.setTsiTerminal(supinvVO.getTsiTerminal());
        supinv.setTsiUsuarioAlta(supinvVO.getTsiUsuarioAlta());
        supinv.setTsiUsuarioBaja(supinvVO.getTsiUsuarioBaja());
        supinv.setTsiUsuarioCambio(supinvVO.getTsiUsuarioCambio());  */      
        return supinv;
    }


    public void setSupervisorInversionesDAOImpl(SupervisorInversionesDAOImpl supervisorInversionesDAOImpl) {
        this.supervisorInversionesDAOImpl = supervisorInversionesDAOImpl;
    }

    public SupervisorInversionesDAOImpl getSupervisorInversionesDAOImpl() {
        return supervisorInversionesDAOImpl;
    }

    public void setSupervisorInversionesVO(SupervisorInversionesVO supervisorInversionesVO) {
        this.supervisorInversionesVO = supervisorInversionesVO;
    }

    public SupervisorInversionesVO getSupervisorInversionesVO() {
        return supervisorInversionesVO;
    }

    public void setSupervisorInversiones(SupervisorInversiones supervisorInversiones) {
        this.supervisorInversiones = supervisorInversiones;
    }

    public SupervisorInversiones getSupervisorInversiones() {
        return supervisorInversiones;
    }

    public void setListVO(List<SupervisorInversionesVO> listVO) {
        
        this.listVO = listVO;
    }

    public List<SupervisorInversionesVO> getListVO() {
        return listVO;
    }


    @Override
    public List<SupervisorInversionesVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public SupervisorInversionesVO getSupervisorInversiones(int idsupinv)throws SQLException {
        SupervisorInversiones supinv= supervisorInversionesDAOImpl.buscarSupervisor(idsupinv);
        SupervisorInversionesVO supinvVO=toV_VO(supinv);
        return supinvVO;
    }
}

