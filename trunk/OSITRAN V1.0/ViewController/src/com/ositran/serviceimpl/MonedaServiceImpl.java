package com.ositran.serviceimpl;
import com.ositran.daoimpl.MonedaDAOImpl;
import com.ositran.model.Moneda;
import com.ositran.service.MonedaService;

import com.ositran.vo.bean.MonedaVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class MonedaServiceImpl implements MonedaService{
    private MonedaDAOImpl monedaDAOImpl;
    
    public MonedaServiceImpl(){
        super();
    }

    public MonedaDAOImpl getmonedaDAOImpl() {
        return monedaDAOImpl;
    }

    public void setmonedaDAOImpl(MonedaDAOImpl monedaDAOImpl) {
        this.monedaDAOImpl = monedaDAOImpl;
    }
    
    @Override
    public List<MonedaVO> query()  throws Exception{
        List<Moneda> list = monedaDAOImpl.query();
        List<MonedaVO> listVO = toListMonedaVO(list);
        return listVO;
    }
    
    
    //conversiones
    private List<MonedaVO> toListMonedaVO(List<Moneda> list)throws SQLException{
        List<MonedaVO> listVO = new ArrayList<MonedaVO>();
        for(int i=0;i<list.size();i++){
            Moneda moneda=(Moneda)list.get(i);
            MonedaVO monedaVO=toMonedaVO(moneda);//enviando a la clase MonedaVO el arreglo
            listVO.add(monedaVO);
        }
        return listVO;
    }
    
    private MonedaVO toMonedaVO(Moneda moneda)throws SQLException{
        MonedaVO monedaVO = new MonedaVO();
        monedaVO.setMonEstado(moneda.getMonEstado());
        monedaVO.setMonFechaAlta(moneda.getMonFechaAlta());
        monedaVO.setMonFechaBaja(moneda.getMonFechaBaja());
        monedaVO.setMonFechaCambio(moneda.getMonFechaCambio());
        monedaVO.setMonNombre(moneda.getMonNombre());
        monedaVO.setMonSimbolo(moneda.getMonSimbolo());
        monedaVO.setMonTerminal(moneda.getMonTerminal());
        monedaVO.setMonUsuarioAlta(moneda.getMonUsuarioAlta());
        monedaVO.setMonUsuarioBaja(moneda.getMonUsuarioBaja());
        monedaVO.setMonUsuarioCambio(moneda.getMonUsuarioCambio());   
        monedaVO.setMonId(moneda.getMonId());
        
        return monedaVO;
    }
   
    
}
