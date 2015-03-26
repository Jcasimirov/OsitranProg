package com.ositran.serviceimpl;

import com.ositran.dao.ConceptoInversionDAO;
import com.ositran.daoimpl.ConceptoInversionDAOImpl;
import com.ositran.daoimpl.EmpresaSupervisoraDAOImpl;
import com.ositran.model.ConceptoInversion;
import com.ositran.model.Concesion;
import com.ositran.service.ConceptoInversionService;
import com.ositran.vo.bean.ConceptoInversionVO;

import com.ositran.vo.bean.ConcesionVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConceptoInversionServiceImpl implements ConceptoInversionService  {
    private ConceptoInversionDAOImpl conceptoInversionDAOImpl;

    public void setConceptoInversionDAOImpl(ConceptoInversionDAOImpl conceptoInversionDAOImpl) {
        this.conceptoInversionDAOImpl = conceptoInversionDAOImpl;
    }

    public ConceptoInversionServiceImpl() {
        super();
    }

    @Override
    public List<ConceptoInversionVO> query() throws SQLException {
        List<ConceptoInversion> list=conceptoInversionDAOImpl.query();
        List<ConceptoInversionVO> listVO=toListConceptoInversionVO(list);
        return listVO;
    }
        
    
    private List<ConceptoInversionVO> toListConceptoInversionVO(List<ConceptoInversion> list){
        List<ConceptoInversionVO> listVO=new ArrayList<ConceptoInversionVO>();
        for(int i=0;i<list.size();i++){
            ConceptoInversion conceptoInversion=(ConceptoInversion)list.get(i);
            ConceptoInversionVO conceptoInversionVO=toConceptoInversionVO(conceptoInversion);
            listVO.add(conceptoInversionVO);
        }
        return listVO;
    }
    
    private ConceptoInversionVO toConceptoInversionVO(ConceptoInversion conceptoInversion){
        ConceptoInversionVO conceptoInversionVO=new ConceptoInversionVO();
        conceptoInversionVO.setCnvDescripcion(conceptoInversion.getCnvDescripcion());
        /*conceptoInversionVO.setCnvEstado(conceptoInversion.getCnvEstado());
        conceptoInversionVO.setCnvFechaAlta(conceptoInversion.getCnvFechaAlta());
        conceptoInversionVO.setCnvFechaBaja(conceptoInversion.getCnvFechaBaja());
        conceptoInversionVO.setCnvFechaCambio(conceptoInversion.getCnvFechaCambio());*/
        conceptoInversionVO.setCnvId(conceptoInversion.getCnvId());
        conceptoInversionVO.setCnvNombre(conceptoInversion.getCnvNombre());
        /*conceptoInversionVO.setCnvTerminal(conceptoInversion.getCnvTerminal());
        conceptoInversionVO.setCnvUsuarioAlta(conceptoInversion.getCnvUsuarioAlta());
        conceptoInversionVO.setCnvUsuarioBaja(conceptoInversion.getCnvUsuarioBaja());
        conceptoInversionVO.setCnvUsuarioCambio(conceptoInversion.getCnvUsuarioCambio());*/
        return conceptoInversionVO;
    }
    
}
