package com.ositran.dao;

import com.ositran.model.EmpresaSupervisora;

import java.util.List;

public interface EmpresaSupervisoraDAO {
        public List<EmpresaSupervisora> query();
        public String insert(EmpresaSupervisora empresaSupervisora);
        public String delete(Integer id);
        public String update(EmpresaSupervisora empresaSupervisora);
        public EmpresaSupervisora get(Integer id);
}
