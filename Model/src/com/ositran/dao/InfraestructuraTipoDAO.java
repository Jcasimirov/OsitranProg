package com.ositran.dao;

import com.ositran.model.InfraestructuraTipo;

import java.util.List;

public interface InfraestructuraTipoDAO {
        public List<InfraestructuraTipo> query();
        public String insert(InfraestructuraTipo infraestructuraTipo);
        public String delete(Integer id);
        public String update(InfraestructuraTipo infraestructuraTipo);
        public InfraestructuraTipo get(Integer id);
}
