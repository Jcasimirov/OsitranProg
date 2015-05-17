package com.ositran.dao;

import com.ositran.model.ContratoInversion;

import java.sql.SQLException;

import java.util.List;

public interface ContratoInversionDAO {
    public List<ContratoInversion> query() throws SQLException;
    public String insert(ContratoInversion contratoInversion) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoInversion contratoInversion) throws SQLException;
    public ContratoInversion get(Integer id) throws SQLException;
    public List<ContratoInversion> getInversionesContratoenRectificacion(Integer conId) throws SQLException;
    public List<ContratoInversion> ListaPorAeropuerto(int contrato, int tipoInfraestructura, int concesion, int infraestructura) throws SQLException;
    public String insertListaInversion(List<ContratoInversion> lista) throws SQLException;
    public String updateInversionxInfraestructuras(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                   String usuario,String terminal) throws SQLException;
}
