package com.ositran.dao;

import com.ositran.model.AvanceInversionWeb;
import java.sql.SQLException;
import java.util.List;

public interface AvanceInversionWebDAO {
    
       public List<AvanceInversionWeb> query()throws SQLException ,Exception;
       public String insert(AvanceInversionWeb avanceInversionWeb)throws SQLException ,Exception;
       public String delete(Integer id)throws SQLException ,Exception;
       public String update(AvanceInversionWeb avanceInversionWeb)throws SQLException ,Exception;
       public AvanceInversionWeb get(Integer id)throws SQLException ,Exception;
}
