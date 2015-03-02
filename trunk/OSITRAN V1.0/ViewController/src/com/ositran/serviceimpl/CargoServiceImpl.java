package com.ositran.serviceimpl;

import com.ositran.daoimpl.CargoDAOImpl;

import com.ositran.model.Cargo;

import com.ositran.service.CargoService;

import com.ositran.vo.bean.CargoVO;


import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

public class CargoServiceImpl implements CargoService{
    private CargoDAOImpl cargoDAOImpl;

    public void setCargoDAOImpl(CargoDAOImpl cargoDAOImpl) {
        this.cargoDAOImpl = cargoDAOImpl;
    }

    public CargoDAOImpl getCargoDAOImpl() {
        return cargoDAOImpl;
    }


    public CargoServiceImpl() {
        super();
    }

    @Override
    public List<CargoVO> query() throws SQLException{
        List<Cargo> list=cargoDAOImpl.query();
        List<CargoVO> listVO=toListCargoVO(list);
        return listVO;
    }

    @Override
    public String insert(CargoVO cargoVO) throws SQLException{
        Cargo cargo=toCargo(cargoVO);
        String result=cargoDAOImpl.insert(cargo);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.cargoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(CargoVO cargoVO) throws SQLException{
        Cargo cargo=toCargo(cargoVO);
        String result=this.cargoDAOImpl.update(cargo);
        return result;
    }

    @Override
    public CargoVO get(Integer id) throws SQLException{
        Cargo cargo=this.cargoDAOImpl.get(id);
        CargoVO cargoVO=toCargoVO(cargo);
        return cargoVO;
    }
     
    //conversiones
    private List<CargoVO> toListCargoVO(List<Cargo> list){
        List<CargoVO> listVO=new ArrayList<CargoVO>();
        for(int i=0;i<list.size();i++){
            Cargo cargo=(Cargo)list.get(i);
            CargoVO cargoVO=toCargoVO(cargo);
            listVO.add(cargoVO);
        }
        return listVO;
    }
    private CargoVO toCargoVO(Cargo cargo){
        CargoVO cargoVO=new CargoVO();
        
        cargoVO.setCrgDescripcion(cargo.getCrgDescripcion());
        cargoVO.setCrgEstado(cargo.getCrgEstado());
        cargoVO.setCrgFechaAlta(cargo.getCrgFechaAlta());
        cargoVO.setCrgFechaBaja(cargo.getCrgFechaBaja());
        cargoVO.setCrgFechaCambio(cargo.getCrgFechaCambio());
        cargoVO.setCrgId(cargo.getCrgId());
        cargoVO.setCrgNombre(cargo.getCrgNombre());
        cargoVO.setCrgTerminal(cargo.getCrgTerminal());
        cargoVO.setCrgUsuarioAlta(cargo.getCrgUsuarioAlta());
        cargoVO.setCrgUsuarioBaja(cargo.getCrgUsuarioBaja());
        cargoVO.setCrgUsuarioCambio(cargo.getCrgUsuarioCambio());    
    
        return cargoVO;
    }
    private Cargo toCargo(CargoVO cargoVO){
        Cargo cargo=new Cargo();
        
        cargo.setCrgDescripcion(cargoVO.getCrgDescripcion());
        cargo.setCrgEstado(cargoVO.getCrgEstado());
        cargo.setCrgFechaAlta(cargoVO.getCrgFechaAlta());
        cargo.setCrgFechaBaja(cargoVO.getCrgFechaBaja());
        cargo.setCrgFechaCambio(cargoVO.getCrgFechaCambio());
        cargo.setCrgId(cargoVO.getCrgId());
        cargo.setCrgNombre(cargoVO.getCrgNombre());
        cargo.setCrgTerminal(cargoVO.getCrgTerminal());
        cargo.setCrgUsuarioAlta(cargoVO.getCrgUsuarioAlta());
        cargo.setCrgUsuarioBaja(cargoVO.getCrgUsuarioBaja());
        cargo.setCrgUsuarioCambio(cargoVO.getCrgUsuarioCambio()); 
        
        return cargo;
        
    }







   
}
