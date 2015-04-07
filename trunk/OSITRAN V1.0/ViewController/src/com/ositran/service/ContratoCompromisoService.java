package com.ositran.service;

import com.ositran.model.ContratoCompromiso;
import com.ositran.vo.bean.ContratoCompromisoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoCompromisoService {
    public List<ContratoCompromisoVO> query() throws SQLException;
        public List<ContratoCompromisoVO> query1(int codigo) throws SQLException;
        public String insert(ContratoCompromisoVO contratoCompromisoVO) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoCompromisoVO contratoCompromisoVO) throws SQLException;
        public ContratoCompromisoVO get(Integer id) throws SQLException;
        public List<ContratoCompromisoVO> getCompromisosContrato(Integer conId,Integer tccTipo) throws SQLException;
    

}
