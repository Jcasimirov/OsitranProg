package com.ositran.service;


import com.ositran.vo.bean.ContratoAdendaVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAdendaService {
    public List<ContratoAdendaVO> query() throws SQLException;
    public String insert(ContratoAdendaVO contratoAdendaVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoAdendaVO contratoAdendaVO) throws SQLException;
    public ContratoAdendaVO get(Integer id) throws SQLException;
}
