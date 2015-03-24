package com.ositran.dao;

import com.ositran.model.VwDocInterno;
import java.sql.SQLException;


public interface DatosStdDAO {       
        public VwDocInterno BuscaStd(Integer año, String nro) throws SQLException;        
}
