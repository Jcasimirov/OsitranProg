package com.ositran.service;

import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface AvanceInversionWebService {
    public List<AvanceInversionWebVO> query()throws SQLException ,Exception;
    public String insert(AvanceInversionWebVO avanceInversionWebVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(AvanceInversionWebVO avanceInversionWebVO) throws ParseException,SQLException ,Exception;
    public AvanceInversionWebVO get(Integer id) throws SQLException ,Exception ;
  
}
