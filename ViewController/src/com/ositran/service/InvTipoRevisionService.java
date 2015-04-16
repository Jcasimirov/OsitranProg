package com.ositran.service;


import com.ositran.vo.bean.InvTipoRevisionVO;
import java.sql.SQLException;
import java.util.List;


public interface InvTipoRevisionService {
    public List<InvTipoRevisionVO> ListarAprobaciones() throws SQLException;    
}
