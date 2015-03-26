package com.ositran.serviceimpl;

import com.ositran.service.ContratoHitoService;
import com.ositran.vo.bean.ContratoHitoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoHitoServiceImpl implements ContratoHitoService {
    public ContratoHitoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoHitoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoHitoVO contratoHitoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoHitoVO contratoHitoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoHitoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
