package com.ositran.service;

import com.ositran.vo.bean.ContratoAlertaVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAlertaService {
    public List<ContratoAlertaVO> query() throws SQLException;
    public String insert(ContratoAlertaVO contratoAlertaVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoAlertaVO contratoAlertaVO) throws SQLException;
    public ContratoAlertaVO get(Integer id) throws SQLException;
}
