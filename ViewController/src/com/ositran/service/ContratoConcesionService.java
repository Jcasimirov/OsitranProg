package com.ositran.service;


import com.ositran.vo.bean.ContratoVO;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public interface ContratoConcesionService {
        public List<ContratoVO> query() throws SQLException;
        public String insert(ContratoVO contratoVO) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoVO contratoVO) throws SQLException;
        public ContratoVO get(Integer id) throws SQLException;
        public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException;
        public List<ContratoVO> buscarContratos(int tinfraestructura, int concesion, int modalidadConcesion, Date fechaInicio, Date fechaFin) throws SQLException;
        public List<ContratoVO> buscarxNombreConcesion(String nombreConcesion,int codTipoInfraestructura,int codConcesion,Date fechaIncioSuscripcion,Date fechafinSuscripcion) throws SQLException;
}
   