
package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;

import java.sql.SQLException;

import java.util.List;

public interface InfraestructuraTipoDAO {
    public List<InfraestructuraTipo> query() throws SQLException;

    public String insert(InfraestructuraTipo infraestructuraTipo) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(InfraestructuraTipo infraestructuraTipo) throws SQLException;

    public InfraestructuraTipo get(Integer id) throws SQLException;

    public List<InfraestructuraTipo> AllSearch(String a) throws SQLException;

    public String getNombre(int codigo) throws SQLException;
    public boolean validarCodigoEnUso(Integer csiId) throws Exception;
}
