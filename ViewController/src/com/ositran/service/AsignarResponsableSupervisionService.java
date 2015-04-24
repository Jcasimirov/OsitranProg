package com.ositran.service;

import com.ositran.vo.bean.ContratoResSupDetalleVO;
import com.ositran.vo.bean.ContratoRespSupVO;
import java.sql.SQLException;
import java.util.List;

public interface AsignarResponsableSupervisionService {
    
    public List<ContratoResSupDetalleVO> query(int CodigoContrato) throws SQLException;
    public ContratoRespSupVO insertCab(ContratoRespSupVO contratoRespSupVO) throws SQLException;
    public String insertDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException;
    public String updateDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException;
    public ContratoRespSupVO getCab(Integer id) throws SQLException;
    public ContratoResSupDetalleVO getDet(Integer id) throws SQLException;
    public ContratoRespSupVO ValidaCab(Integer concesion) throws SQLException;
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento) throws SQLException;
    public int ValidaAsignaci�n(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException;
  
}