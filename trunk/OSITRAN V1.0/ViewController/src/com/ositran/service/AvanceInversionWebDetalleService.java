package com.ositran.service;

import com.ositran.vo.bean.AvanceInversionWebDetalleVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface AvanceInversionWebDetalleService {
    public List<AvanceInversionWebDetalleVO> query()throws SQLException ,Exception;
    public String insert(AvanceInversionWebDetalleVO avanceInversionWebDetalleVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(AvanceInversionWebDetalleVO avanceInversionWebDetalleVO) throws ParseException,SQLException ,Exception;
    public AvanceInversionWebDetalleVO get(Integer id) throws SQLException ,Exception ;
}


