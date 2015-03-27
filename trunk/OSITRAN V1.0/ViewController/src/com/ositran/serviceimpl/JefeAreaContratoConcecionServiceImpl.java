package com.ositran.serviceimpl;

import com.ositran.daoimpl.JefeAreaContratoConcecionDAOImpl;
import com.ositran.model.InversionTipo;
import com.ositran.model.JefeAreaContratoConcecion;
import com.ositran.service.JefeAreaContratoConcecionService;
import com.ositran.vo.bean.JefeAreaContratoConcecionVO;
import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JefeAreaContratoConcecionServiceImpl implements JefeAreaContratoConcecionService{
    private JefeAreaContratoConcecion jefeAreaContratoConcecion;
    private JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO;
    private JefeAreaContratoConcecionDAOImpl jefeAreaContratoConcecionDAOImpl;
        


    @Override
    public List<JefeAreaContratoConcecionVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) throws SQLException, Exception {
        
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) throws ParseException, SQLException,
                                                                                         Exception {
     
        return null;
    }

    @Override
    public JefeAreaContratoConcecionVO get(Integer codigoTipoInfra) throws SQLException, Exception {
        jefeAreaContratoConcecion =jefeAreaContratoConcecionDAOImpl.get(codigoTipoInfra);
        jefeAreaContratoConcecionVO=toJefeAreaContratoConcecionVO(jefeAreaContratoConcecion);
        return jefeAreaContratoConcecionVO;
    }

    //conversiones
    private List<JefeAreaContratoConcecionVO> toJefeAreaContratoConcecionVO(List<JefeAreaContratoConcecion> list)  {
       List<JefeAreaContratoConcecionVO> listVO=new ArrayList<JefeAreaContratoConcecionVO>();
       for(int i=0;i<list.size();i++){
           jefeAreaContratoConcecion=(JefeAreaContratoConcecion)list.get(i);
           jefeAreaContratoConcecionVO=toJefeAreaContratoConcecionVO(jefeAreaContratoConcecion);
           listVO.add(jefeAreaContratoConcecionVO);
       }
       return listVO;
    }
    private JefeAreaContratoConcecionVO toJefeAreaContratoConcecionVO(JefeAreaContratoConcecion jefeAreaContratoConcecion)  {
       JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO2=new JefeAreaContratoConcecionVO();
       jefeAreaContratoConcecionVO2.setSjaId(jefeAreaContratoConcecion.getSjaId());
       jefeAreaContratoConcecionVO2.setSjaNombre(jefeAreaContratoConcecion.getSjaNombre());
       jefeAreaContratoConcecionVO2.setSjaNumeroDocumento(jefeAreaContratoConcecion.getSjaNumeroDocumento());
       jefeAreaContratoConcecionVO2.setSjaTipoDocumento(jefeAreaContratoConcecion.getSjaTipoDocumento());
       jefeAreaContratoConcecionVO2.setSjaTipoInfraestructura(jefeAreaContratoConcecion.getSjaTipoInfraestructura());
        return jefeAreaContratoConcecionVO2;
    }
    private JefeAreaContratoConcecion toJefeAreaContratoConcecion(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO)  {
       JefeAreaContratoConcecion jefeAreaContratoConcecion1=new JefeAreaContratoConcecion();
        jefeAreaContratoConcecion1.setSjaId(jefeAreaContratoConcecionVO.getSjaId());
        jefeAreaContratoConcecion1.setSjaNombre(jefeAreaContratoConcecionVO.getSjaNombre());
        jefeAreaContratoConcecion1.setSjaNumeroDocumento(jefeAreaContratoConcecionVO.getSjaTipoDocumento());
        jefeAreaContratoConcecion1.setSjaTipoDocumento(jefeAreaContratoConcecionVO.getSjaTipoDocumento());
        jefeAreaContratoConcecion1.setSjaTipoInfraestructura(jefeAreaContratoConcecionVO.getSjaTipoInfraestructura());
        return jefeAreaContratoConcecion1;
    }







    public void setJefeAreaContratoConcecion(JefeAreaContratoConcecion jefeAreaContratoConcecion) {
        this.jefeAreaContratoConcecion = jefeAreaContratoConcecion;
    }

    public JefeAreaContratoConcecion getJefeAreaContratoConcecion() {
        return jefeAreaContratoConcecion;
    }

    public void setJefeAreaContratoConcecionVO(JefeAreaContratoConcecionVO jefeAreaContratoConcecionVO) {
        this.jefeAreaContratoConcecionVO = jefeAreaContratoConcecionVO;
    }

    public JefeAreaContratoConcecionVO getJefeAreaContratoConcecionVO() {
        return jefeAreaContratoConcecionVO;
    }

    public void setJefeAreaContratoConcecionDAOImpl(JefeAreaContratoConcecionDAOImpl jefeAreaContratoConcecionDAOImpl) {
        this.jefeAreaContratoConcecionDAOImpl = jefeAreaContratoConcecionDAOImpl;
    }

    public JefeAreaContratoConcecionDAOImpl getJefeAreaContratoConcecionDAOImpl() {
        return jefeAreaContratoConcecionDAOImpl;
    }
}
