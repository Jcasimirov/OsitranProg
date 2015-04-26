package com.ositran.service;

import com.ositran.vo.bean.ValorizacionSupDetalleVO;
import java.sql.SQLException;
import java.util.List;

public interface ValorizacionSupDetalleService {
    
    public List<ValorizacionSupDetalleVO> query() throws SQLException;
    public String insert(ValorizacionSupDetalleVO valorizacionSupDetalleVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ValorizacionSupDetalleVO valorizacionSupDetalleVO)throws SQLException;
    public ValorizacionSupDetalleVO get(Integer id) throws SQLException;
   
   //Ivan
   public List<ValorizacionSupDetalleVO> ListaValorizacionesDetRegistradas(Integer id) throws SQLException, Exception;
    
}
