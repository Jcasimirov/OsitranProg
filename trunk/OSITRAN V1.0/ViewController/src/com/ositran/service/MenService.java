package com.ositran.service;

import com.ositran.model.Men;
import com.ositran.vo.bean.MenVO;
import java.util.List;

public interface MenService {
    public List<MenVO> query();
    public List<MenVO> query1(String filtro);
    public String insert(MenVO men);
    public String delete(Integer id);
    public String update(MenVO menVO);
    public MenVO get(Integer id);
    public String getNombre(Integer codigo);
    public int getPadre(Integer codigo);
        
   
}
