package com.ositran.service;

import com.ositran.model.InvAvnDerivada;
import com.ositran.serviceimpl.InvAvnDerivadaServiceImpl;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.InvAvnDerivadaVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface InvAvnDerivadaService {
    public List<InvAvnDerivadaVO> query()throws SQLException ,Exception;
    public String insert(InvAvnDerivadaVO invAvnDerivadaVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(InvAvnDerivadaVO invAvnDerivadaVO) throws ParseException,SQLException ,Exception;
    public InvAvnDerivadaVO get(Integer id) throws SQLException ,Exception ;
    public InvAvnDerivadaVO getAvanceInversion(int id) throws SQLException ,Exception ;
    
    
    
    
}
