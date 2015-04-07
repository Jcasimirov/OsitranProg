package com.ositran.service;

import com.ositran.vo.bean.ContratoSupervisoraVO;
import java.sql.SQLException;
import java.util.List;

public interface ContratoEmpresaSupervisoraService {
        public List<ContratoSupervisoraVO> query() throws SQLException;
        public String insert(ContratoSupervisoraVO contrato) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoSupervisoraVO contrato) throws SQLException;
        public ContratoSupervisoraVO get(Integer id) throws SQLException;
        public int ValidarContratoSupervisora(int concesion, int tipoinfra) throws SQLException;
}
