package com.ositran.serviceimpl;

import com.ositran.service.ContratoCompromisoService;
import com.ositran.vo.bean.ContratoCompromisoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoCompromisoServiceImpl implements ContratoCompromisoService {
    public ContratoCompromisoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoCompromisoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCompromisoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}
