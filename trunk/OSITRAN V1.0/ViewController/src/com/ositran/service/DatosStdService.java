package com.ositran.service;

import com.ositran.vo.bean.ViewTdInternosVO;

import java.sql.SQLException;


public interface DatosStdService {
    public ViewTdInternosVO BuscaStd(Integer a�o, String nro) throws SQLException;       
}
