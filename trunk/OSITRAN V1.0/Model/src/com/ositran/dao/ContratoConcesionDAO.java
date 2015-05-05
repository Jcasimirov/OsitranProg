package com.ositran.dao;

import com.ositran.model.Contrato;
import com.ositran.model.ContratoAlerta;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public interface ContratoConcesionDAO {
        public List<Contrato> query() throws SQLException;
        public String insert(Contrato contrato) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(Contrato contrato) throws SQLException;
        public Contrato get(Integer id) throws SQLException;
        public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException;
        public List<Contrato> buscarContratos(int tinfraestructura, int concesion, int modalidadConcesion, Date fechaInicio, Date fechaFin) throws SQLException;
        public List<Object[]> buscarxNombreConcesion(String nombreConcesion,int codTipoInfraestructura,int codConcesion,Date fechaIncioSuscripcion,Date fechafinSuscripcion) throws SQLException;
        public List<Contrato> buscarContratos1(int tinfraestructura) throws SQLException;
        public void updateContrato(Contrato contrato,ContratoAlerta contratoAlerta)throws Exception;

    
}
