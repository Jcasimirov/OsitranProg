package com.ositran.service;


import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;


import java.util.List;

public interface EmpresaSupervisoraService {
        public List<EmpresaSupervisoraVO> query();
        public String insert(EmpresaSupervisoraVO empresaSupervisoraVO);
        public String delete(Integer id);
        public String update(EmpresaSupervisoraVO empresaSupervisoraVO);
        public EmpresaSupervisoraVO get(Integer id);
}
   