package com.ositran.serviceimpl;


import com.ositran.daoimpl.VSupInvDAOImpl;
import com.ositran.daoimpl.VEmpSupDAOImpl;
import com.ositran.model.VSupInv;
import com.ositran.model.VEmpSup;
import com.ositran.service.VSupInvService;
import com.ositran.vo.bean.VSupInvVO;

import com.ositran.vo.bean.VEmpSupVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class VSupInvServiceImpl implements VSupInvService {
    
    private VSupInvDAOImpl vsupinvDAOImpl;
    List<VSupInvVO> listVO;


    public void setVsupinvDAOImpl(VSupInvDAOImpl vsupinvDAOImpl) {
        this.vsupinvDAOImpl = vsupinvDAOImpl;
    }

    public VSupInvDAOImpl getVsupinvDAOImpl() {
        return vsupinvDAOImpl;
    }

    public void setListVO(List<VSupInvVO> listVO) {
        this.listVO = listVO;
    }

    public List<VSupInvVO> getListVO() {
        return listVO;
    }

    public VSupInvServiceImpl() {
        super();
    }

    @Override
    public List<VSupInvVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException {
        List<VSupInv> list=vsupinvDAOImpl.buscarCoordinador(codTipoInfraestructura);
        List<VSupInvVO> listVO=toListV_BuscarEmpresaSupervisoraVO(list);
        return listVO;
    }
    
    private List<VSupInvVO> toListV_BuscarEmpresaSupervisoraVO(List<VSupInv> list) throws SQLException {
        listVO = new ArrayList<VSupInvVO>();
        try {
            for (int i = 0; i < list.size(); i++) {
                VSupInv coordinador = (VSupInv) list.get(i);
                VSupInvVO coreVO =
                    toV_VO(coordinador); //enviando a la clase V_BuscarEmpresaSupervisoraVO el arreglo
                listVO.add(coreVO);
            }
        } catch (Exception e) {
            System.out.println();
        }
        return listVO;
    }


    private VSupInvVO toV_VO(VSupInv supinv) throws SQLException {
        VSupInvVO supinvVO = new VSupInvVO();
        supinvVO.setCrgId(supinv.getCrgId());
        supinvVO.setTdoId(supinv.getTdoId());
        supinvVO.setTinId(supinv.getTinId());       
        supinvVO.setTsiCorreo(supinv.getTsiCorreo());       
        supinvVO.setTsiDescripcion(supinv.getTsiDescripcion());
        supinvVO.setTsiDireccion(supinv.getTsiDireccion());
        supinvVO.setTsiEncargado(supinv.getTsiEncargado());
        supinvVO.setTsiEstado(supinv.getTsiEstado());
        supinvVO.setTsiFechaAlta(supinv.getTsiFechaAlta());
        supinvVO.setTsiFechaBaja(supinv.getTsiFechaBaja());
        supinvVO.setTsiFechaCambio(supinv.getTsiFechaCambio());
        supinvVO.setTsiHabilitado(supinv.getTsiHabilitado());
        supinvVO.setTsiId(supinv.getTsiId());
        supinvVO.setTsiNombre(supinv.getTsiNombre());
        supinvVO.setTsiNroDocumento(supinv.getTsiNroDocumento());
        supinvVO.setTsiSiglas(supinv.getTsiSiglas());
        supinvVO.setTsiTelefono(supinv.getTsiTelefono());
        supinvVO.setTsiTerminal(supinv.getTsiTerminal());
        supinvVO.setTsiUsuarioAlta(supinv.getTsiUsuarioAlta());
        supinvVO.setTsiUsuarioBaja(supinv.getTsiUsuarioBaja());
        supinvVO.setTsiUsuarioCambio(supinv.getTsiUsuarioCambio());
      
        

                
        return supinvVO;
    }


    private VSupInv toV_BuscarEmpresaSupervisora(VSupInvVO supinvVO) throws SQLException {
        VSupInv supinv = new VSupInv();
        supinv.setCrgId(supinvVO.getCrgId());
        supinv.setTdoId(supinvVO.getTdoId());
        supinv.setTinId(supinvVO.getTinId());       
        supinv.setTsiCorreo(supinvVO.getTsiCorreo());       
        supinv.setTsiDescripcion(supinvVO.getTsiDescripcion());
        supinv.setTsiDireccion(supinvVO.getTsiDireccion());
        supinv.setTsiEncargado(supinvVO.getTsiEncargado());
        supinv.setTsiEstado(supinvVO.getTsiEstado());
        supinv.setTsiFechaAlta(supinvVO.getTsiFechaAlta());
        supinv.setTsiFechaBaja(supinvVO.getTsiFechaBaja());
        supinv.setTsiFechaCambio(supinvVO.getTsiFechaCambio());
        supinv.setTsiHabilitado(supinvVO.getTsiHabilitado());
        supinv.setTsiId(supinvVO.getTsiId());
        supinv.setTsiNombre(supinvVO.getTsiNombre());
        supinv.setTsiNroDocumento(supinvVO.getTsiNroDocumento());
        supinv.setTsiSiglas(supinvVO.getTsiSiglas());
        supinv.setTsiTelefono(supinvVO.getTsiTelefono());
        supinv.setTsiTerminal(supinvVO.getTsiTerminal());
        supinv.setTsiUsuarioAlta(supinvVO.getTsiUsuarioAlta());
        supinv.setTsiUsuarioBaja(supinvVO.getTsiUsuarioBaja());
        supinv.setTsiUsuarioCambio(supinvVO.getTsiUsuarioCambio());
        
        return supinv;
    }

    
}
