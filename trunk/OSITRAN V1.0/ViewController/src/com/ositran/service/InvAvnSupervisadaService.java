package com.ositran.service;

import com.ositran.dao.InvAvnSupervisadaDAO;

import com.ositran.vo.bean.InvAvnSupervisadaVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;

public interface InvAvnSupervisadaService { 
    public List<InvAvnSupervisadaVO> query()throws SQLException ,Exception;
    public int insert(InvAvnSupervisadaVO invAvnSupervisadaVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(InvAvnSupervisadaVO invAvnSupervisadaVO) throws ParseException,SQLException ,Exception;
    public TipoInversionVO get(Integer id) throws SQLException ,Exception ;
    
}
