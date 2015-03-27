package com.ositran.service;

import com.ositran.vo.bean.ViewTdInternosVO;

import java.sql.SQLException;


public interface DatosStdService {
    public ViewTdInternosVO BuscaStd(Integer año, String nro) throws SQLException;       
}
