package com.ositran.service;

import com.ositran.vo.bean.DerivarReconocimientoSupervisorVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DerivarReconocimientoSupervisorService {
    
    public List<DerivarReconocimientoSupervisorVO> query()throws SQLException ,Exception;
    public List<DerivarReconocimientoSupervisorVO> queryDerivarInversion(int codigoCnotrato,int codigoContratoCompromiso,int estado)throws SQLException ,Exception;
    public String insert(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(DerivarReconocimientoSupervisorVO derivarReconocimientoSupervisorVO) throws ParseException,SQLException ,Exception;
    public DerivarReconocimientoSupervisorVO get(Integer id) throws SQLException ,Exception ;
}
