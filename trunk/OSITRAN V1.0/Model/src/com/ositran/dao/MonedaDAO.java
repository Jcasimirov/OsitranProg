package com.ositran.dao;
import com.ositran.model.Moneda;
import java.sql.SQLException;
import java.util.List;


public interface MonedaDAO {
    public String insert(Moneda moneda) throws SQLException; 
    public String delete(Integer id) throws SQLException;
    public String update(Moneda moneda)throws SQLException;
    public Moneda get(Integer id) throws SQLException;
    public List<Moneda> query() throws SQLException;
    public List<Moneda> MonedaSearch(String searchMoneda, String searchAbreviatura) throws SQLException;
}
