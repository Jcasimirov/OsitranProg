package com.ositran.dao;

import com.ositran.model.VwDocInterno;
import java.sql.SQLException;


public interface DatosStdDAO {       
        public VwDocInterno BuscaStd(Integer a�o, String nro) throws SQLException;        
}
