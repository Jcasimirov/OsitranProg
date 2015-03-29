package com.ositran.serviceimpl;

import com.ositran.daoimpl.ValorizacionSupDAOImpl;
import com.ositran.model.ValorizacionSup;
import com.ositran.service.ValorizacionSupService;
import com.ositran.vo.bean.ValorizacionSupVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValorizacionSupServiceImpl implements ValorizacionSupService {
    public ValorizacionSupServiceImpl() {
        super();
    }
    
    private ValorizacionSupDAOImpl valorizacionSupDAOImpl;

    @Override
    public List<ValorizacionSupVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ValorizacionSupVO valorizacionSupVO) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionSupVO valorizacionSupVO) throws ParseException, SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionSupVO get(Integer id) throws SQLException, Exception {
        ValorizacionSup valorizacionSup= valorizacionSupDAOImpl.get(id);
        ValorizacionSupVO valorizacionSupVO=toValorizacionSupVO(valorizacionSup);
        return valorizacionSupVO;
        
    }

    public void setValorizacionSupDAOImpl(ValorizacionSupDAOImpl valorizacionSupDAOImpl) {
        this.valorizacionSupDAOImpl = valorizacionSupDAOImpl;
    }

    public ValorizacionSupDAOImpl getValorizacionSupDAOImpl() {
        return valorizacionSupDAOImpl;
    }


    //conversiones
    private List<ValorizacionSupVO> toListValorizacionSupVO(List<ValorizacionSup> list){
        List<ValorizacionSupVO> listVO=new ArrayList<ValorizacionSupVO>();
        for(int i=0;i<list.size();i++){
            ValorizacionSup valorizacionSup=(ValorizacionSup)list.get(i);
            ValorizacionSupVO valorizacionSupVO=toValorizacionSupVO(valorizacionSup);
            listVO.add(valorizacionSupVO);
        }
        return listVO;
    }
    
    private ValorizacionSupVO toValorizacionSupVO(ValorizacionSup valorizacionSup){
        ValorizacionSupVO valorizacionSupVO=new ValorizacionSupVO();
        
        valorizacionSupVO.setMonId(valorizacionSup.getMonId());
        valorizacionSupVO.setTvsBruto(valorizacionSup.getTvsBruto());
        valorizacionSupVO.setTvsHr(valorizacionSup.getTvsHr());
        valorizacionSupVO.setTvsIgv(valorizacionSup.getTvsIgv());
        valorizacionSupVO.setTvsInfFechaEmision(valorizacionSup.getTvsInfFechaEmision());
        valorizacionSupVO.setTvsInfNumero(valorizacionSup.getTvsInfNumero());
        valorizacionSupVO.setTvsInfRegSalida(valorizacionSup.getTvsInfRegSalida());
        valorizacionSupVO.setTvsMemFechaEmision(valorizacionSup.getTvsMemFechaEmision());
        valorizacionSupVO.setTvsMemNumero(valorizacionSup.getTvsMemNumero());
        valorizacionSupVO.setTvsMemRegSalida(valorizacionSup.getTvsMemRegSalida());
        valorizacionSupVO.setTvsNeto(valorizacionSup.getTvsNeto());
        valorizacionSupVO.setTvsOfiFechaEmision(valorizacionSup.getTvsOfiFechaEmision());
        valorizacionSupVO.setTvsOfiNumero(valorizacionSup.getTvsOfiNumero());
        valorizacionSupVO.setTvsOfiRegSalida(valorizacionSup.getTvsOfiRegSalida());
        return valorizacionSupVO;
    }
    
    private ValorizacionSup toValorizacionSup(ValorizacionSupVO valorizacionSupVO){
        ValorizacionSup valorizacionSup=new ValorizacionSup();
        
        valorizacionSup.setMonId(valorizacionSupVO.getMonId());
        valorizacionSup.setTvsBruto(valorizacionSupVO.getTvsBruto());
        valorizacionSup.setTvsHr(valorizacionSupVO.getTvsHr());
        valorizacionSup.setTvsIgv(valorizacionSupVO.getTvsIgv());
        valorizacionSup.setTvsInfFechaEmision(valorizacionSupVO.getTvsInfFechaEmision());
        valorizacionSup.setTvsInfNumero(valorizacionSupVO.getTvsInfNumero());
        valorizacionSup.setTvsInfRegSalida(valorizacionSupVO.getTvsInfRegSalida());
        valorizacionSup.setTvsMemFechaEmision(valorizacionSupVO.getTvsMemFechaEmision());
        valorizacionSup.setTvsMemNumero(valorizacionSupVO.getTvsMemNumero());
        valorizacionSup.setTvsMemRegSalida(valorizacionSupVO.getTvsMemRegSalida());
        valorizacionSup.setTvsNeto(valorizacionSupVO.getTvsNeto());
        valorizacionSup.setTvsOfiFechaEmision(valorizacionSupVO.getTvsOfiFechaEmision());
        valorizacionSup.setTvsOfiNumero(valorizacionSupVO.getTvsOfiNumero());
        valorizacionSup.setTvsOfiRegSalida(valorizacionSupVO.getTvsOfiRegSalida());
        return valorizacionSup;
        
    }
    
}
