package com.ositran.serviceimpl;

import com.ositran.daoimpl.AdendaTipoDAOImpl;
import com.ositran.model.AdendaTipo;

import com.ositran.model.Cargo;
import com.ositran.service.AdendaTipoService;
import com.ositran.vo.bean.AdendaTipoVO;


import com.ositran.vo.bean.CargoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AdendaTipoServiceImpl implements AdendaTipoService {
    
    private AdendaTipoDAOImpl adendaTipoDAOImpl;
    
    public AdendaTipoServiceImpl() {
        super();
    }

    @Override
    public List<AdendaTipoVO> query() throws SQLException {
        List<AdendaTipo> list=adendaTipoDAOImpl.query();
        List<AdendaTipoVO> listVO=toListAdendaTipoVO(list);
        return listVO;
    }

    @Override
    public String insert(AdendaTipoVO adendaTipoVO) throws SQLException {
        AdendaTipo adendaTipo=toAdendaTipo(adendaTipoVO);
        String result=adendaTipoDAOImpl.insert(adendaTipo);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=this.adendaTipoDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(AdendaTipoVO adendaTipoVO) throws SQLException {
        AdendaTipo adendaTipo=toAdendaTipo(adendaTipoVO);
        String result=this.adendaTipoDAOImpl.update(adendaTipo);
        return result;
    }

    @Override
    public AdendaTipoVO get(Integer id) throws SQLException {
        AdendaTipo adendaTipo= adendaTipoDAOImpl.get(id);
        AdendaTipoVO adendaTipoVO=toAdendaTipoVO(adendaTipo);
        return adendaTipoVO;
    }

    public AdendaTipoDAOImpl getAdendaTipoDAOImpl() {
        return adendaTipoDAOImpl;
    }

    public void setAdendaTipoDAOImpl(AdendaTipoDAOImpl adendaTipoDAOImpl) {
        this.adendaTipoDAOImpl = adendaTipoDAOImpl;
    }
    
    // conversiones
    private List<AdendaTipoVO> toListAdendaTipoVO(List<AdendaTipo> list){
        List<AdendaTipoVO> listVO=new ArrayList<AdendaTipoVO>();
        for(int i=0;i<list.size();i++){
            AdendaTipo adendaTipo=(AdendaTipo)list.get(i);
            AdendaTipoVO adendaTipoVO=toAdendaTipoVO(adendaTipo);
            listVO.add(adendaTipoVO);
        }
        return listVO;
    }
    
    private AdendaTipoVO toAdendaTipoVO(AdendaTipo adendaTipo){
        AdendaTipoVO adendaTipoVO=new AdendaTipoVO();
        
        adendaTipoVO.setTadNombre(adendaTipo.getTadNombre());
        adendaTipoVO.setTadId(adendaTipo.getTadId());
    
        return adendaTipoVO;
    }
    
    private AdendaTipo toAdendaTipo(AdendaTipoVO adendaTipoVO){
        AdendaTipo adendaTipo=new AdendaTipo();
        
        adendaTipo.setTadNombre(adendaTipoVO.getTadNombre());
        adendaTipo.setTadId(adendaTipoVO.getTadId());

        return adendaTipo;
        
    }
}
