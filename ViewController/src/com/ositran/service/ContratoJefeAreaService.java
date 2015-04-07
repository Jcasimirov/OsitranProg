package com.ositran.service;

import com.ositran.vo.bean.ContratoJefeAreaVO;
import com.ositran.vo.bean.RolVO;

import java.util.List;

public interface ContratoJefeAreaService {
    public List<ContratoJefeAreaVO> query();
    public List<ContratoJefeAreaVO> query1(int filtro);
    public String insert(ContratoJefeAreaVO contratoJefeAreaVO);
    public String delete(Integer id);
    public String update(ContratoJefeAreaVO contratoJefeAreaVO);
    public ContratoJefeAreaVO get(Integer id);
    public int getCodigo(ContratoJefeAreaVO contratoJefeAreaVO);
    
}
