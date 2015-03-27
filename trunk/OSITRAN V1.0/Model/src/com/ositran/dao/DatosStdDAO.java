package com.ositran.dao;

import com.ositran.model.ViewTdInternos;
import java.sql.SQLException;


public interface DatosStdDAO {       
        public ViewTdInternos BuscaStd(Integer año, String nro) throws SQLException;        
}
