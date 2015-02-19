package com.ositran.service;

import com.ositran.vo.bean.CargoVO;
import com.ositran.vo.bean.IgvVO;

import java.util.List;

public interface CargoService {
    public List<CargoVO> query();
    public String insert(CargoVO cargoVO);
    public String delete(Integer id);
    public String update(CargoVO cargoVO);
    public CargoVO get(Integer id);
}
