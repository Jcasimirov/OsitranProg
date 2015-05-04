package com.ositran.service;

import com.ositran.model.InvAvnSupervisadaDetalle;
import com.ositran.vo.bean.InvAvnSupervisadaDetalleVO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface InvAvnSupervisadaDetalleService {
    
    public List<InvAvnSupervisadaDetalle> query()throws SQLException ,Exception;
    public int insert(InvAvnSupervisadaDetalleVO invAvnSupervisadaDetalleVO) throws SQLException ,Exception;
    public String delete(Integer id) throws SQLException ,Exception;
    public String update(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle) throws ParseException,SQLException ,Exception;
    public InvAvnSupervisadaDetalle get(Integer id) throws SQLException ,Exception ;
}
