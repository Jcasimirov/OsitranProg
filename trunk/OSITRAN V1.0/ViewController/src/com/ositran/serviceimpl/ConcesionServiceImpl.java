package com.ositran.serviceimpl;

import com.ositran.daoimpl.ConcesionDAOImpl;
import com.ositran.model.Concesion;
import com.ositran.model.Infraestructura;
import com.ositran.service.ConcesionService;
import com.ositran.vo.bean.ConcesionVO;

import com.ositran.vo.bean.InfraestructuraVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class ConcesionServiceImpl implements ConcesionService{
   
    private ConcesionDAOImpl concesionDAOImpl;

    public void setConcesionDAOImpl(ConcesionDAOImpl concesionDAOImpl) {
        this.concesionDAOImpl = concesionDAOImpl;
    }

    public ConcesionDAOImpl getConcesionDAOImpl() {
        return concesionDAOImpl;
    }


    public ConcesionServiceImpl() {
        super();
    }

    @Override
    public List<ConcesionVO> query() throws SQLException{
        
        System.out.println("Services");
        List<Concesion> list=concesionDAOImpl.query();
        List<ConcesionVO> listVO=toListConcesionVO(list);
        return listVO;
    }

    @Override
    public String insert(ConcesionVO concesionVO) throws SQLException{
        Concesion concesion=toConcesion(concesionVO);
        String result=concesionDAOImpl.insert(concesion);
        return result;
    }

    @Override
    public int idConcesion(ConcesionVO concesionVO) throws SQLException{
        Concesion concesion=toConcesion(concesionVO);
        int result=concesionDAOImpl.idConcesion(concesion);
        return result;
    }
    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.concesionDAOImpl.delete(id);
        return result;
    }
    
     
    /*   public Integer cambiarEstado(Integer estado) {
        Integer result=this.concesionDAOImpl.update(estado);
        return result;
    }  */

    @Override
    public String update(ConcesionVO concesionVO) throws SQLException{
        System.out.println("servicves");
        Concesion concesion=toConcesion(concesionVO);
        String result=concesionDAOImpl.update(concesion);
        return result;
    }


    @Override
    public String update2(ConcesionVO concesionVO) throws SQLException{
        System.out.println("servicves");
        Concesion concesion=toConcesion(concesionVO);
        String result=concesionDAOImpl.update(concesion);
        return result;
    }



    @Override
    public ConcesionVO get(Integer id) throws SQLException{
        System.out.println("llego al services");
        Concesion concesion=this.concesionDAOImpl.get(id);
        ConcesionVO concesionVO=toConcesionVO(concesion);
        return concesionVO;
    }
    
    
    
    //conversiones
    private List<ConcesionVO> toListConcesionVO(List<Concesion> list) throws SQLException{
        List<ConcesionVO> listVO=new ArrayList<ConcesionVO>();
        for(int i=0;i<list.size();i++){
            Concesion concesion=(Concesion)list.get(i);
            ConcesionVO concesionVO=toConcesionVO(concesion);
            listVO.add(concesionVO);
        }
        return listVO;
    }
    private ConcesionVO toConcesionVO(Concesion concesion) throws SQLException{
        ConcesionVO concesionVO=new ConcesionVO();
       
         concesionVO.setCsiFechaAlta(concesion.getCsiFechaAlta());
        concesionVO.setCsiFechaBaja(concesion.getCsiFechaBaja());
        concesionVO.setCsiFechaCambio(concesion.getCsiFechaCambio());
        concesionVO.setCsiTerminal(concesion.getCsiTerminal());
        concesionVO.setCsiUsuarioAlta(concesion.getCsiUsuarioAlta());
        concesionVO.setCsiUsuarioBaja(concesion.getCsiUsuarioBaja());
        concesionVO.setCsiUsuarioCambio(concesion.getCsiUsuarioCambio());   
        concesionVO.setCsiId(concesion.getCsiId());
        concesionVO.setCsiNombre(concesion.getCsiNombre());
        concesionVO.setInfraestructuraTipo(concesion.getInfraestructuraTipo());
       
        return concesionVO;
    }
    public Concesion toConcesion(ConcesionVO concesionVO) throws SQLException{
        Concesion concesion=new Concesion();
     
        concesion.setCsiFechaAlta(concesionVO.getCsiFechaAlta());
        concesion.setCsiFechaBaja(concesionVO.getCsiFechaBaja());
        concesion.setCsiFechaCambio(concesionVO.getCsiFechaCambio());
        concesion.setCsiTerminal(concesionVO.getCsiTerminal());
        concesion.setCsiUsuarioAlta(concesionVO.getCsiUsuarioAlta());
        concesion.setCsiUsuarioBaja(concesionVO.getCsiUsuarioBaja());
        concesion.setCsiUsuarioCambio(concesionVO.getCsiUsuarioCambio());
        concesion.setCsiId(concesionVO.getCsiId());
        concesion.setInfraestructuraTipo(concesionVO.getInfraestructuraTipo());
        concesion.setCsiNombre(concesionVO.getCsiNombre());
        concesion.setCsiEstado(concesionVO.getCsiEstado());
       
        return concesion; 
        
    }
    
    public List<ConcesionVO> buscarconcesionfiltro(int codigo, String nombre)throws SQLException{
        
        List<Concesion> list=concesionDAOImpl.queryfiltro(codigo,nombre);
        List<ConcesionVO> listVO=toListConcesionVO(list);
        return listVO;
    }
    
    // Iosusky 
        // Metodo: Filtrar la Concesi�n 
        // Ventana: Registrar Contrato de Concesi�n
        @Override
        public List<ConcesionVO> filtrarConcesion(int tipoInfraestructura) throws SQLException{
            List<Concesion> list=concesionDAOImpl.filtrarConcesion(tipoInfraestructura);
            List<ConcesionVO> listVO=toListConcesionVO(list);
            return listVO;
        }

    


}
