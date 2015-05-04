package com.ositran.dao;

import com.ositran.model.InvAvnSupervisadaDetalle;
import java.sql.SQLException;
import java.util.List;

public interface InvAvnSupervisadaDetalleDAO {
    public List<InvAvnSupervisadaDetalle> query()throws SQLException ,Exception;
    public int insert(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle)throws SQLException ,Exception;
       public InvAvnSupervisadaDetalle get(Integer id)throws SQLException ,Exception;
}
