package com.ositran.service;

import com.ositran.vo.bean.ValorizacionSupVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ValorizacionSupService {
    
    
    public List<ValorizacionSupVO> query()throws SQLException ,Exception;
    public int insert(ValorizacionSupVO valorizacionSupVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(ValorizacionSupVO valorizacionSupVO) throws ParseException,SQLException ,Exception;
    public ValorizacionSupVO get(Integer id) throws SQLException ,Exception ;
	
	//Ivan
    public List<ValorizacionSupVO> ListaValorizacionesRegistradas(Integer Id) throws SQLException, Exception;
    
}
