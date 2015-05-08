package com.ositran.service;

import com.ositran.vo.bean.ContratoResSupDetalleVO;
import com.ositran.vo.bean.ContratoRespSupVO;
import java.sql.SQLException;
import java.util.List;

public interface AsignarResponsableSupervisionService {
    
    public List<ContratoResSupDetalleVO> ListarDetalle(int codigoContrato, int compromiso, int codigoAeropuerto, int codigoInversion) throws SQLException;
    public ContratoRespSupVO insertCab(ContratoRespSupVO contratoRespSupVO) throws SQLException;
    public String insertDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException;
    public String updateDet(ContratoResSupDetalleVO contratoResSupDetalleVO) throws SQLException;
    public ContratoRespSupVO getCab(Integer id) throws SQLException;
    public ContratoResSupDetalleVO getDet(Integer id) throws SQLException;
    public ContratoRespSupVO ValidaCab(Integer concesion, Integer compromiso) throws SQLException;
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento, Integer tipoSup) throws SQLException;
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException;
    public List<ContratoResSupDetalleVO> BuscarAsignacion(Integer contrato, Integer etapa, Integer aeropuerto, Integer inversion, Integer tipoSupervision) throws SQLException;
    public String ObtieneCorreo(Integer tipoDoc, String NroDocumento,Integer tipoSup) throws SQLException;
}
