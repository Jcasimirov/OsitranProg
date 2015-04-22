package com.ositran.service;

import com.ositran.model.Moneda;
import com.ositran.vo.bean.MonedaVO;

import java.util.List;

public interface MonedaService {
    
    public List<MonedaVO> query()  throws Exception;
    public MonedaVO get(Integer id) throws Exception;
    
}
