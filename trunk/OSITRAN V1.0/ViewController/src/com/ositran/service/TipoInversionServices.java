package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.text.ParseException;

import java.util.List;

public interface TipoInversionServices {    
        public List<TipoInversionVO> query();
        public String insert(TipoInversionVO tipoInversionVO);
        public String delete(Integer id) ;
        public String update(TipoInversionVO tipoInversionVO) throws ParseException;
        public TipoInversionVO get(Integer id);
        public List<TipoInversionVO> query1(String buscar);
                
}
