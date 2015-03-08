package com.ositran.service;

import com.ositran.vo.bean.IgvVO;

import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;

import java.util.List;

public interface TipoDocumentoService {
    public List<TipoDocumentoVO> query() throws SQLException;

    public String insert(TipoDocumentoVO tipoDocumentoVO) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(TipoDocumentoVO tipoDocumentoVO) throws SQLException;

    public TipoDocumentoVO get(Integer id) throws SQLException;
}
