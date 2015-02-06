package com.ositran.service;



import com.ositran.vo.bean.InfraestructuraTipoVO;


import java.util.List;

public interface InfraestructuraTipoService {
        public List<InfraestructuraTipoVO> query();
        public String insert(InfraestructuraTipoVO infraestructuraTipoVO);
        public String delete(Integer id);
        public String update(InfraestructuraTipoVO infraestructuraTipoVO);
        public InfraestructuraTipoVO get(Integer id);
}
   