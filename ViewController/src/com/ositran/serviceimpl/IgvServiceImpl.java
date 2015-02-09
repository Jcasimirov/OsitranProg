package com.ositran.serviceimpl;

import com.ositran.daoimpl.IgvDAOImpl;
import com.ositran.daoimpl.IgvDAOImpl;
import com.ositran.model.Igv;
import com.ositran.model.Igv;
import com.ositran.service.IgvService;
import com.ositran.vo.bean.IgvVO;

import com.ositran.vo.bean.IgvVO;

import com.ositran.vo.bean.IgvVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IgvServiceImpl implements IgvService{
    private IgvDAOImpl igvDAOImpl;

    public void setIgvDAOImpl(IgvDAOImpl igvDAOImpl) {
        this.igvDAOImpl = igvDAOImpl;
    }

    public IgvDAOImpl getIgvDAOImpl() {
        return igvDAOImpl;
    }


    public IgvServiceImpl() {
        super();
    }

    @Override
    public List<IgvVO> query() {
        List<Igv> list=igvDAOImpl.query();
        List<IgvVO> listVO=toListIgvVO(list);
        return listVO;
    }

    @Override
    public String insert(IgvVO igvVO) {
        Igv igv=toIgv(igvVO);
        String result=igvDAOImpl.insert(igv);
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result=this.igvDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(IgvVO igvVO) {
        Igv igv=toIgv(igvVO);
        String result=this.igvDAOImpl.update(igv);
        return result;
    }

    @Override
    public IgvVO get(Integer id) {
        Igv igv=this.igvDAOImpl.get(id);
        IgvVO igvVO=toIgvVO(igv);
        return igvVO;
    }
    
    
    
    //conversiones
    private List<IgvVO> toListIgvVO(List<Igv> list){
        List<IgvVO> listVO=new ArrayList<IgvVO>();
        for(int i=0;i<list.size();i++){
            Igv igv=(Igv)list.get(i);
            IgvVO igvVO=toIgvVO(igv);
            listVO.add(igvVO);
        }
        return listVO;
    }
    private IgvVO toIgvVO(Igv igv){
        IgvVO igvVO=new IgvVO();
        igvVO.setIgvDescrip(igv.getIgvDescrip());
        igvVO.setIgvId(igv.getIgvId());
        igvVO.setIgvPercent(igv.getIgvPercent());
        return igvVO;
    }
    private Igv toIgv(IgvVO igvVO){
        Igv igv=new Igv();
        igv.setIgvDescrip(igvVO.getIgvDescrip());
        igv.setIgvId(igvVO.getIgvId());
        igv.setIgvPercent(igvVO.getIgvPercent());
        return igv;
        
    }

    
}
