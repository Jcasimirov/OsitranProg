package com.ositran.dao;

import com.ositran.model.InvAvnSupervisada;
import com.ositran.model.InversionTipo;

import java.sql.SQLException;

import java.util.List;

public interface InvAvnSupervisadaDAO {
    InvAvnSupervisada invAvnSupervisada=new InvAvnSupervisada();
    
        public List<InvAvnSupervisada> query()throws SQLException ,Exception;
        public int insert(InvAvnSupervisada invAvnSupervisada)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(InvAvnSupervisada invAvnSupervisada)throws SQLException ,Exception;
       public InvAvnSupervisada get(Integer id)throws SQLException ,Exception;
}
