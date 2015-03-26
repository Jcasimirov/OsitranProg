package com.ositran.serviceimpl;

import com.ositran.service.ContratoAlertaService;
import com.ositran.vo.bean.ContratoAlertaVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoAlertaServiceImpl implements ContratoAlertaService {
    public ContratoAlertaServiceImpl() {
        super();
    }

    @Override
    public List<ContratoAlertaVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoAlertaVO contratoAlertaVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoAlertaVO contratoAlertaVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoAlertaVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
