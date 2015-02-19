package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraVO;


import java.util.List;


public interface InfraestructuraService {
    public List<InfraestructuraVO> query();
    public String insert(InfraestructuraVO infraestructuraVO);
    public String delete(Integer id);
    public String update(InfraestructuraVO infraestructuraVO);
    public InfraestructuraVO get(Integer id);
   
}
