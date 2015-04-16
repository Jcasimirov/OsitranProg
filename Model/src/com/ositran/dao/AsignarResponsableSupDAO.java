package com.ositran.dao;


import com.ositran.model.ContratoResSupDetalle;
import com.ositran.model.ContratoRespSup;
import java.sql.SQLException;
import java.util.List;

public interface AsignarResponsableSupDAO {
    public List<ContratoResSupDetalle> query(int CodigoContrato) throws SQLException;
    public ContratoRespSup insertCab(ContratoRespSup contratoRespSup) throws SQLException;
    public String insertDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException;
    public String updateDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException;
    public ContratoRespSup getCab(Integer id) throws SQLException;
    public ContratoResSupDetalle getDet(Integer id) throws SQLException;
    public ContratoRespSup ValidaCab(Integer concesion) throws SQLException;
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento) throws SQLException;
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException;
    
}
