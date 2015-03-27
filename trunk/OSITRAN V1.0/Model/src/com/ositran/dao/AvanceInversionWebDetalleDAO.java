package com.ositran.dao;

import com.ositran.model.AvanceInversionWebDetalle;
import java.sql.SQLException;
import java.util.List;

public interface AvanceInversionWebDetalleDAO {
    
    public List<AvanceInversionWebDetalle> query()throws SQLException ,Exception;
    public String insert(AvanceInversionWebDetalle avanceInversionWebDetalle)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(AvanceInversionWebDetalle avanceInversionWebDetalle)throws SQLException ,Exception;
       public AvanceInversionWebDetalle get(Integer id)throws SQLException ,Exception;
       public List<AvanceInversionWebDetalle> query1(String buscar)throws SQLException ,Exception;
       public int getCanNombres(String nombre)  throws SQLException ,Exception;
}
