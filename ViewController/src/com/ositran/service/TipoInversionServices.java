package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.text.ParseException;

import java.util.List;

public interface TipoInversionServices {    
        public List<TipoInversionVO> query()throws SQLException ,Exception;
        public String insert(TipoInversionVO tipoInversionVO) throws SQLException ,Exception;
        public String update(TipoInversionVO tipoInversionVO) throws ParseException,SQLException ,Exception;
        public TipoInversionVO get(Integer id) throws SQLException ,Exception ;
        public List<TipoInversionVO> query1(String buscar) throws SQLException ,Exception;
         public int getCanNombres(String nombre)  throws SQLException ,Exception;
                
}