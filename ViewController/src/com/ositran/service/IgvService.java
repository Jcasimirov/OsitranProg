package com.ositran.service;

import com.ositran.vo.bean.IgvVO;

import java.util.List;

public interface IgvService {
    public List<IgvVO> query();
    public String insert(IgvVO igvVO);
    public String delete(Integer id);
    public String update(IgvVO igvVO);
    public IgvVO get(Integer id);
}
