package com.ositran.dao;

import com.ositran.model.ViewTdInternos;
import java.sql.SQLException;


public interface DatosStdDAO {       
        public ViewTdInternos BuscaStd(Integer a�o, String nro) throws SQLException;        
}
