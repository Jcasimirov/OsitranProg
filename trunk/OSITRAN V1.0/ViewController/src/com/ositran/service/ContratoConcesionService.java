package com.ositran.service;


import com.ositran.vo.bean.ContratoVO;
import java.sql.SQLException;
import java.util.List;

public interface ContratoConcesionService {
        public List<ContratoVO> query() throws SQLException;
        public String insert(ContratoVO contratoVO) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoVO contratoVO) throws SQLException;
        public ContratoVO get(Integer id) throws SQLException;
}
   