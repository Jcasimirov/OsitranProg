package com.ositran.service;

import com.ositran.vo.bean.TipoInversionVO;

import com.ositran.vo.bean.TipoRevisionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;

public interface TipoRevisionService {
    
    public List<TipoRevisionVO> query()throws SQLException ,Exception;
    public String insert(TipoRevisionVO tipoRevisionVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(TipoInversionVO tipoRevisionVO) throws ParseException,SQLException ,Exception;
    public TipoRevisionVO get(Integer id) throws SQLException ,Exception ;
}
