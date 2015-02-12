package com.ositran.dao;

import com.ositran.model.ModalidadConcesion;

import java.util.List;

public interface ModalidadConcesionDAO {
        public List<ModalidadConcesion> query();
        public String insert(ModalidadConcesion modalidadConcesion);
        public String delete(Integer id);
        public String update(ModalidadConcesion modalidadConcesion);
        public ModalidadConcesion get(Integer id);
}
