package com.ositran.service;

import com.ositran.vo.bean.ContratoInversionVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoInversionService {
    public List<ContratoInversionVO> query() throws SQLException;
    public String insert(ContratoInversionVO contratoInversionVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoInversionVO contratoInversionVO) throws SQLException;
    public ContratoInversionVO get(Integer id) throws SQLException;
    public List<ContratoInversionVO> ListaPorAeropuerto(int contrato, int tipoInfraestructura, int concesion, int infraestructura) throws SQLException;
    public String insertListaInversion(List<ContratoInversionVO> lista) throws SQLException;
    public String updateInversionxInfraestructuras(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                   String usuario,
                                                   String terminal) throws SQLException;
    public boolean validaNoExisteNombreInversion(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                String nombreInversion)throws Exception;
}
