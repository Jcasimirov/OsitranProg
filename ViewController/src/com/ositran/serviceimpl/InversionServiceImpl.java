package com.ositran.serviceimpl;

import com.ositran.service.InversionService;
import com.ositran.vo.bean.InversionVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class InversionServiceImpl implements InversionService {
    public InversionServiceImpl() {
        super();
    }

    @Override
    public List<InversionVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(InversionVO inversionVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InversionVO inversionVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public InversionVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
