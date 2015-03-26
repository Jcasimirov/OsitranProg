package com.ositran.service;



import com.ositran.vo.bean.ContratoAlertaEstadoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAlertaEstadoService {
    public List<ContratoAlertaEstadoVO> query() throws SQLException;
    public String insert(ContratoAlertaEstadoVO contratoAlertaEstadoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoAlertaEstadoVO contratoAlertaEstadoVO) throws SQLException;
    public ContratoAlertaEstadoVO get(Integer id) throws SQLException;
}
