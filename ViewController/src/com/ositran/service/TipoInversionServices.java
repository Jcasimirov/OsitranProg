package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.util.List;

public interface TipoInversionServices {    
        public List<TipoInversionVO> query();
        public String insert(TipoInversionVO tipoInversionVO);
        public String delete(Integer id);
        public String update(TipoInversionVO tipoInversionVO);
        public TipoInversionVO get(Integer id);
                
}
