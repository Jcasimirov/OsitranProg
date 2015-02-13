package com.ositran.service;

import com.ositran.vo.bean.IgvVO;

import com.ositran.vo.bean.TipoDocumentoVO;

import java.util.List;

public interface TipoDocumentoService {
    public List<TipoDocumentoVO> query();
    public String insert(TipoDocumentoVO tipoDocumentoVO);
    public String delete(Integer id);
    public String update(TipoDocumentoVO tipoDocumentoVO);
    public TipoDocumentoVO get(Integer id);
}
