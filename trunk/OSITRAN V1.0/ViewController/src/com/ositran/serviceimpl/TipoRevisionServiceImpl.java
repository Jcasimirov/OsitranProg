package com.ositran.serviceimpl;
import com.ositran.daoimpl.TipoRevisionDAOImpl;
import com.ositran.model.TipoRevision;
import com.ositran.service.TipoRevisionService;
import com.ositran.vo.bean.TipoInversionVO;
import com.ositran.vo.bean.TipoRevisionVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TipoRevisionServiceImpl implements TipoRevisionService {
    TipoRevisionDAOImpl tipoRevisionDAOImpl= new TipoRevisionDAOImpl();
    TipoRevision tipoRevision = new TipoRevision(); 
    TipoRevisionVO tipoRevisionVO=new TipoRevisionVO();
    
    public TipoRevisionServiceImpl() {
        super();
    }

    @Override
    public List<TipoRevisionVO> query() throws SQLException, Exception {
        List<TipoRevision> list = tipoRevisionDAOImpl.query();
        List<TipoRevisionVO> listVO = toListTipoRevisionVO(list);
        return listVO;
    }

    @Override
    public String insert(TipoRevisionVO tipoRevisionVO) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(TipoInversionVO tipoRevisionVO) throws ParseException, SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public TipoRevisionVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
    
    //conversiones
    private List<TipoRevisionVO> toListTipoRevisionVO(List<TipoRevision> list) {
        List<TipoRevisionVO> listVO = new ArrayList<TipoRevisionVO>();
        for (int i = 0; i < list.size(); i++) {
             tipoRevision = (TipoRevision) list.get(i);
            tipoRevisionVO = toTipoRevisionVO(tipoRevision);
            listVO.add(tipoRevisionVO);
        }
        return listVO;
    }

    private TipoRevisionVO toTipoRevisionVO(TipoRevision tipoRevision1) {
        TipoRevisionVO tipoRevisionVO1 = new TipoRevisionVO();
        tipoRevisionVO1.setItrDescripcion(tipoRevision1.getItrDescripcion());
        tipoRevisionVO1.setItrId(tipoRevision1.getItrId());

        return tipoRevisionVO1;
    }

    private TipoRevision toTipoRevision(TipoRevisionVO tipoRevisionVO1) {
        TipoRevision tipoRevision = new TipoRevision();
        tipoRevision.setItrDescripcion(tipoRevisionVO1.getItrDescripcion());
        tipoRevision.setItrId(tipoRevisionVO1.getItrId());
        return tipoRevision;
    }
    
    
}
