package com.ositran.service;

import com.ositran.vo.bean.VwDocInternoVO;

import java.sql.SQLException;


public interface DatosStdService {
    public VwDocInternoVO BuscaStd(Integer a�o, String nro) throws SQLException;       
}
