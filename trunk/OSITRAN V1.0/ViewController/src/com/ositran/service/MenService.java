package com.ositran.service;

import com.ositran.model.Men;
import com.ositran.vo.bean.MenVO;
import java.util.List;

public interface MenService {
    public List<MenVO> query();
    public String insert(Men men);
    public String delete(Integer id);
    public String update(Men men);
    public Men get(Integer id);
    public String getNombre(Integer codigo);
        
   
}
