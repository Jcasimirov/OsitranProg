package com.ositran.dao;


import com.ositran.daoimpl.AsignarResponsableSupDAOImpl;
import com.ositran.model.ContratoResSupDetalle;
import com.ositran.model.ContratoRespSup;
import java.sql.SQLException;
import java.util.List;

public interface AsignarResponsableSupDAO {
    public List<ContratoResSupDetalle> ListarDetalle(int codigoContrato, int compromiso) throws SQLException;
    public ContratoRespSup insertCab(ContratoRespSup contratoRespSup) throws SQLException;
    public String insertDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException;
    public String updateDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException;
    public ContratoRespSup getCab(Integer id) throws SQLException;
    public ContratoResSupDetalle getDet(Integer id) throws SQLException;
    public ContratoRespSup ValidaCab(Integer concesion, Integer compromiso) throws SQLException;
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento,Integer tipoSup) throws SQLException;
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException;
    public  List<ContratoResSupDetalle> BuscarAsignacion (Integer contrato, Integer etapa, Integer aeropuerto, Integer inversion, Integer tipoSupervision) throws SQLException;
    public String ObtieneCorreo(Integer tipoDoc, String nroDocumento,Integer tipoSup) throws SQLException;

}
