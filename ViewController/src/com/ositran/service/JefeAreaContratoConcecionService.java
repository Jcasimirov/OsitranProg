package com.ositran.service;

import com.ositran.vo.bean.JefeAreaContratoConcecionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;

public interface JefeAreaContratoConcecionService {
    
    public List<JefeAreaContratoConcecionVO> query()throws SQLException ,Exception;
    public String insert(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) throws ParseException,SQLException ,Exception;
    public JefeAreaContratoConcecionVO get(Integer id) throws SQLException ,Exception ;
    
}
