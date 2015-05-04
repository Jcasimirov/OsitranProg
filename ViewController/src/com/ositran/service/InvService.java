package com.ositran.service;

import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvVO;

import java.sql.SQLException;

import java.util.List;

public interface InvService {
    public List<InvVO> query() throws SQLException;
    public String insert(InvVO invVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(InvVO invVO) throws SQLException;
    public InvVO get(Integer tiaNumero) throws SQLException;
    public List<InvVO> getInvsAvance(Integer tiaNumero) throws SQLException;
    public InvVO obtenerInversion(Integer invId, Integer tiaNumero) throws SQLException;
    public String insertDeclaracion(InvAvnVO invAvn,InvVO invVO, List<InvReconocimientoVO> listInvReconocimientoVO,List<InvReajusteVO> listInvReajusteVO) throws SQLException;
}
