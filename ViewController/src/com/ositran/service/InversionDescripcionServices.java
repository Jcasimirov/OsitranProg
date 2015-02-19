package com.ositran.service;

import com.ositran.vo.bean.InversionDescripcionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.util.List;

public interface InversionDescripcionServices {
    public List<InversionDescripcionVO> query();
    public String insert(InversionDescripcionVO inversionDescrpcionVO);
    public String delete(Integer id);
    public String update(InversionDescripcionVO inversionDescrpcionVO);
    public InversionDescripcionVO get(Integer id);
    public List<InversionDescripcionVO> query1(String buscar);
}
