package com.ositran.service;

import com.ositran.vo.bean.ContratoSubInversionesVO;
import com.ositran.vo.bean.TipoInversionVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ContratoSubInversionesService {
    public List<ContratoSubInversionesVO>  query()throws SQLException ,Exception;
    public String insert(ContratoSubInversionesVO  contratoSubInversionesVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(ContratoSubInversionesVO contratoSubInversionesVO) throws ParseException,SQLException ,Exception;
    public ContratoSubInversionesVO get(Integer id) throws SQLException ,Exception ;
    public ContratoSubInversionesVO get1(Integer id) throws SQLException ,Exception ;
    public List<ContratoSubInversionesVO> query1(int filtro) throws SQLException ,Exception;
     public int getCanNombres(String nombre)  throws SQLException ,Exception;
    
}
