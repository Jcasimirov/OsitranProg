package com.ositran.service;

import com.ositran.vo.bean.ValorizacionInversionAvanceVO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ValorizacionInversionAvanceService {
    
    public List<ValorizacionInversionAvanceVO> query()throws SQLException ,Exception;
    public List<ValorizacionInversionAvanceVO> query1(int codigoContrato)throws SQLException ,Exception;
    public List<ValorizacionInversionAvanceVO> queryDerivarInversion(int codigoContrato,int codigoContratoCompromiso,int estado)throws SQLException ,Exception;
    public int insert(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(ValorizacionInversionAvanceVO valorizacionInversionAvanceVO) throws ParseException,SQLException ,Exception;
    public ValorizacionInversionAvanceVO get(Integer id) throws SQLException ,Exception ;
}
