package com.ositran.service;

import com.ositran.vo.bean.ConcesionVO;

import java.util.List;

public interface ConcesionService {
    public List<ConcesionVO> query();
    public String insert(ConcesionVO concesionVO);
    public String delete(Integer id);
    public String update(ConcesionVO concesionVO);
    public ConcesionVO get(Integer id);
}
