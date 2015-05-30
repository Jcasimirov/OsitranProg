package com.ositran.service;


import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.List;

public interface InfraestructuraTipoService {
        public List<InfraestructuraTipoVO> query() throws SQLException;
        public String insert(InfraestructuraTipoVO infraestructuraTipoVO) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(InfraestructuraTipoVO infraestructuraTipoVO)throws SQLException;
        public InfraestructuraTipoVO get(Integer id) throws SQLException;
        public List<InfraestructuraTipoVO> AllSearch(String a)throws SQLException;
        public String getNombre(int codigo) throws SQLException;
        public boolean validarCodigoEnUso(Integer csiId) throws Exception;
}
   