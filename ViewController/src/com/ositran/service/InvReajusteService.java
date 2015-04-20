package com.ositran.service;

import com.ositran.model.InvReajuste;
import com.ositran.vo.bean.InvReajusteVO;

import java.sql.SQLException;

import java.util.List;

public interface InvReajusteService {
    public List<InvReajusteVO> query() throws SQLException;
    public String insert(InvReajusteVO invReajuste) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(InvReajusteVO invReajuste) throws SQLException;
    public InvReajuste get(Integer id) throws SQLException;
    public List<InvReajusteVO> getInvReajustesAvance(Integer tiaNumero) throws SQLException;
}
