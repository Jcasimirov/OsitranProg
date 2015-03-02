package com.ositran.service;

import com.ositran.vo.bean.CargoVO;
import com.ositran.vo.bean.IgvVO;

import java.sql.SQLException;

import java.util.List;

public interface CargoService {
    public List<CargoVO> query() throws SQLException;
    public String insert(CargoVO cargoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(CargoVO cargoVO) throws SQLException;
    public CargoVO get(Integer id) throws SQLException;
}
