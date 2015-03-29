package com.ositran.serviceimpl;

import com.ositran.daoimpl.AvanceInversionWebDAOImpl;
import com.ositran.model.AvanceInversionWeb;
import com.ositran.model.TipoDocumento;
import com.ositran.service.AvanceInversionWebService;
import com.ositran.vo.bean.AvanceInversionWebVO;
import com.ositran.vo.bean.TipoDocumentoVO;

import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvanceInversionWebServiceImpl implements AvanceInversionWebService{
    AvanceInversionWeb avanceInversionWeb;
    AvanceInversionWebVO avanceInversionWebVO;
    AvanceInversionWebDAOImpl avanceInversionWebDAOImpl;
    

    @Override
    public List<AvanceInversionWebVO> query() throws SQLException, Exception {
        return Collections.emptyList();
    }

    @Override
    public String insert(AvanceInversionWebVO avanceInversionWebVO) throws SQLException, Exception {
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(AvanceInversionWebVO avanceInversionWebVO) throws ParseException, SQLException, Exception {
        return null;
    }

    @Override
    public AvanceInversionWebVO get(Integer id) throws SQLException, Exception {
        avanceInversionWeb =avanceInversionWebDAOImpl.get(id);
        avanceInversionWebVO=toAvanceInversionWebVO(avanceInversionWeb);
        return avanceInversionWebVO;
    }
    
    
    //conversiones
    private List<AvanceInversionWebVO> toAvanceInversionWebVO(List<AvanceInversionWeb> list){
        List<AvanceInversionWebVO> listVO=new ArrayList<AvanceInversionWebVO>();
        for(int i=0;i<list.size();i++){
            AvanceInversionWeb avanceInversionWeb=(AvanceInversionWeb)list.get(i);
            AvanceInversionWebVO avanceInversionWebVO=toAvanceInversionWebVO(avanceInversionWeb);
            listVO.add(avanceInversionWebVO);
        }
        return listVO;
    }
    private AvanceInversionWebVO toAvanceInversionWebVO(AvanceInversionWeb avanceInversionWeb1){
        AvanceInversionWebVO avanceInversionWebVO1=new AvanceInversionWebVO();
        avanceInversionWebVO1.setCsiId(avanceInversionWeb1.getCsiId());
        avanceInversionWebVO1.setInvId(avanceInversionWeb1.getInvId());
        avanceInversionWebVO1.setIwcFechaFin(avanceInversionWeb1.getIwcFechaFin());
        avanceInversionWebVO1.setIwcFechaInicio(avanceInversionWeb1.getIwcFechaInicio());
        avanceInversionWebVO1.setIwcId(avanceInversionWeb1.getIwcId());
        avanceInversionWebVO1.setMcoId(avanceInversionWeb1.getMcoId());
        avanceInversionWebVO1.setMonId(avanceInversionWeb1.getMonId());
        avanceInversionWebVO1.setTinId(avanceInversionWeb1.getTinId());
        return avanceInversionWebVO1;
    }
    
    private AvanceInversionWeb toAvanceInversionWeb(AvanceInversionWebVO avanceInversionWebVO1){
        AvanceInversionWeb avanceInversionWeb1=new AvanceInversionWeb();
        avanceInversionWeb1.setCsiId(avanceInversionWebVO1.getCsiId());
        avanceInversionWeb1.setInvId(avanceInversionWebVO1.getInvId());
        avanceInversionWeb1.setIwcFechaFin(avanceInversionWebVO1.getIwcFechaFin());
        avanceInversionWeb1.setIwcFechaInicio(avanceInversionWebVO1.getIwcFechaInicio());
        avanceInversionWeb1.setIwcId(avanceInversionWebVO1.getIwcId());
        avanceInversionWeb1.setMcoId(avanceInversionWebVO1.getMcoId());
        avanceInversionWeb1.setMonId(avanceInversionWebVO1.getMonId());
        avanceInversionWeb1.setTinId(avanceInversionWebVO1.getTinId());
        return avanceInversionWeb1;
        
    }


    public void setAvanceInversionWeb(AvanceInversionWeb avanceInversionWeb) {
        this.avanceInversionWeb = avanceInversionWeb;
    }

    public AvanceInversionWeb getAvanceInversionWeb() {
        return avanceInversionWeb;
    }

    public void setAvanceInversionWebVO(AvanceInversionWebVO avanceInversionWebVO) {
        this.avanceInversionWebVO = avanceInversionWebVO;
    }

    public AvanceInversionWebVO getAvanceInversionWebVO() {
        return avanceInversionWebVO;
    }

    public void setAvanceInversionWebDAOImpl(AvanceInversionWebDAOImpl avanceInversionWebDAOImpl) {
        this.avanceInversionWebDAOImpl = avanceInversionWebDAOImpl;
    }

    public AvanceInversionWebDAOImpl getAvanceInversionWebDAOImpl() {
        return avanceInversionWebDAOImpl;
    }
}
