package com.ositran.serviceimpl;

import com.ositran.service.AvanceInversionWebService;
import com.ositran.vo.bean.AvanceInversionWebVO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

public class AvanceInversionWebServiceImpl implements AvanceInversionWebService{

    @Override
    public List<AvanceInversionWebVO> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(AvanceInversionWebVO avanceInversionWebVO) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(AvanceInversionWebVO avanceInversionWebVO) throws ParseException, SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public AvanceInversionWebVO get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}
