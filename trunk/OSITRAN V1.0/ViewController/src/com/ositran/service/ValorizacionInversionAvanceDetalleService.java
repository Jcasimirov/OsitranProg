package com.ositran.service;

import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ValorizacionInversionAvanceDetalleService {
    
    public List<ValorizacionInversionAvanceDetalleVO> query()throws SQLException ,Exception;
    public String insert(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(ValorizacionInversionAvanceDetalleVO valorizacionInversionAvanceDetalleVO) throws ParseException,SQLException ,Exception;
    public ValorizacionInversionAvanceDetalleVO get(Integer id) throws SQLException ,Exception ;
}
