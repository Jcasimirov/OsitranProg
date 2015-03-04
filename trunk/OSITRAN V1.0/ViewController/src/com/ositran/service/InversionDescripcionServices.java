package com.ositran.service;

import com.ositran.vo.bean.InversionDescripcionVO;

import java.sql.SQLException;

import java.util.List;

public interface InversionDescripcionServices {
    public List<InversionDescripcionVO> query() throws SQLException ,Exception;
    public String insert(InversionDescripcionVO inversionDescrpcionVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(InversionDescripcionVO inversionDescrpcionVO) throws SQLException ,Exception;
    public InversionDescripcionVO get(Integer id) throws SQLException ,Exception;
    public List<InversionDescripcionVO> query1(String buscar) throws SQLException ,Exception;
}