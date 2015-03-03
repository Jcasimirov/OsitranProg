package com.ositran.service;

import com.ositran.model.Concesionario;

import com.ositran.vo.bean.ConcesionarioVO;

import java.util.List;

public interface ConcesionarioService {
    public List<ConcesionarioVO> query();
    public String insert(ConcesionarioVO concesionarioVO);
    public String delete(Integer id);
    public String update(ConcesionarioVO concesionarioVO);
    public ConcesionarioVO get(Integer id);
    public List<ConcesionarioVO> queryF(String filtro);
}
