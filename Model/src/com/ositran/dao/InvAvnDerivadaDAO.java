package com.ositran.dao;

import com.ositran.model.InversionTipo;

import com.ositran.model.InvAvnDerivada;

import java.sql.SQLException;

import java.util.List;

public interface InvAvnDerivadaDAO {
        public List<InvAvnDerivada> query()throws SQLException ,Exception;
        public String insert(InvAvnDerivada invAvnDerivada)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(InvAvnDerivada invAvnDerivada)throws SQLException ,Exception;
       public InvAvnDerivada get(Integer id)throws SQLException ,Exception;
    public InvAvnDerivada getAvanceInversion(Integer id) throws SQLException ,Exception ;
      
    
}
