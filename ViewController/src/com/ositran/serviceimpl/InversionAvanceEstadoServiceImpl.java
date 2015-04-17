package com.ositran.serviceimpl;

import com.ositran.daoimpl.InversionAvanceEstadoDAOImpl;
import com.ositran.model.InvAvnEstado;
import com.ositran.service.InversionAvanceEstadoService;
import com.ositran.vo.bean.InvAvnEstadoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class InversionAvanceEstadoServiceImpl implements InversionAvanceEstadoService{
    private InversionAvanceEstadoDAOImpl  inversionAvanceEstadoDAOImpl;

    public void setInversionAvanceEstadoDAOImpl(InversionAvanceEstadoDAOImpl inversionAvanceEstadoDAOImpl) {
        this.inversionAvanceEstadoDAOImpl = inversionAvanceEstadoDAOImpl;
    }

    public InversionAvanceEstadoDAOImpl getInversionAvanceEstadoDAOImpl() {
        return inversionAvanceEstadoDAOImpl;
    }

    public List<InvAvnEstadoVO> query() throws SQLException {
        List<InvAvnEstado> list = inversionAvanceEstadoDAOImpl.query();
        List<InvAvnEstadoVO> listVO = toListInvAvnEstadoVO(list);
        return listVO;
    }

    private List<InvAvnEstadoVO> toListInvAvnEstadoVO(List<InvAvnEstado> list) {
        List<InvAvnEstadoVO> listVO = new ArrayList<InvAvnEstadoVO>();
        for (int i = 0; i < list.size(); i++) {
            InvAvnEstado invAvn = (InvAvnEstado) list.get(i);
            InvAvnEstadoVO invAvnVO = toInvAvnEstadoVO(invAvn);
            listVO.add(invAvnVO);
        }
        return listVO;
    }

    private InvAvnEstadoVO toInvAvnEstadoVO(InvAvnEstado invAvn) {
        InvAvnEstadoVO invAvnVO = new InvAvnEstadoVO();
        invAvnVO.setIaeId(invAvn.getIaeId());
        invAvnVO.setIaeNombre(invAvn.getIaeNombre());       
        return invAvnVO;
    }

    private InvAvnEstado toInvAvnEstado(InvAvnEstadoVO invAvnVO) {
        InvAvnEstado invAvn = new InvAvnEstado();
        invAvn.setIaeId(invAvnVO.getIaeId());
        invAvn.setIaeNombre(invAvnVO.getIaeNombre());
        return invAvn;

    }
}
