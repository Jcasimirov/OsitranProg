package com.ositran.serviceimpl;

import com.ositran.daoimpl.ContratoConcesionDAOImpl;
import com.ositran.model.Contrato;
import com.ositran.service.ContratoConcesionService;
import com.ositran.util.Reutilizar;
import com.ositran.vo.bean.ContratoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContratoConcesionServiceImpl implements ContratoConcesionService{
    private ContratoConcesionDAOImpl contratoConcesionDAOImpl;

    public void setContratoConcesionDAOImpl(ContratoConcesionDAOImpl contratoConcesionDAOImpl) {
        this.contratoConcesionDAOImpl = contratoConcesionDAOImpl;
    }

    public ContratoConcesionDAOImpl getContratoConcesionDAOImpl() {
        return contratoConcesionDAOImpl;
    }

    @Override
    public List<ContratoVO> query() throws SQLException{
        List<Contrato> list=contratoConcesionDAOImpl.query();
        List<ContratoVO> listVO=toListContratoVO(list);
        return listVO;
        
    }

    @Override
    public String insert(ContratoVO contratoVO) throws SQLException{
        Contrato contrato=toContrato(contratoVO);
        String result=contratoConcesionDAOImpl.insert(contrato);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.contratoConcesionDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(ContratoVO contratoVO) throws SQLException{
        Contrato contrato=toContrato(contratoVO);
        String result=this.contratoConcesionDAOImpl.update(contrato);
        return result;
    }

    @Override
    public ContratoVO get(Integer id) throws SQLException{
        Contrato contrato=this.contratoConcesionDAOImpl.get(id);
        ContratoVO contratoVO=toContratoVO(contrato);
        return contratoVO;
    }
    
    @Override
    public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException{
        int respuesta =contratoConcesionDAOImpl.ValidarContratoConcesion(concesion,tipoinfra);
        return respuesta;        
    }
    
    @Override
    public List<ContratoVO> buscarContratos(int tinfraestructura, int concesion, int modalidadConcesion, Date fechaInicio, Date fechaFin) throws SQLException{
        List<Contrato> list=contratoConcesionDAOImpl.buscarContratos(tinfraestructura,concesion,modalidadConcesion,fechaInicio,fechaFin);
        List<ContratoVO> listVO=toListContratoVO(list);
        return listVO;
        
    }
    
    //conversiones
    
    private List<ContratoVO> toListContratoVO(List<Contrato> list){
        List<ContratoVO> listVO=new ArrayList<ContratoVO>();
        for(int i=0;i<list.size();i++){           
            Contrato contrato=(Contrato)list.get(i);            
            ContratoVO contratoVO=toContratoVO(contrato);
            listVO.add(contratoVO);
        }
        return listVO;
    }
    
    @Override
    public List<ContratoVO> buscarContratos1(int tinfraestructura) throws SQLException {
        List<Contrato> list=contratoConcesionDAOImpl.buscarContratos1(tinfraestructura);
        List<ContratoVO> listVO=toListContratoVO(list);
        return listVO;
    }
    private ContratoVO toContratoVO(Contrato contrato){
        ContratoVO contratoVO=new ContratoVO();
        contratoVO.setCncId(contrato.getCncId());
        contratoVO.setConAnyo(contrato.getConAnyo());
        contratoVO.setConAsunto(contrato.getConAsunto());
        contratoVO.setConAvanceobra(contrato.getConAvanceobra());
        contratoVO.setConDiames(contrato.getConDiames());
        contratoVO.setConDomicilioLegal(contrato.getConDomicilioLegal());
        contratoVO.setConEstado(contrato.getConEstado());
        contratoVO.setConFechaAlta(contrato.getConFechaAlta());
        contratoVO.setConFechaBaja(contrato.getConFechaBaja());
        contratoVO.setConFechaCambio(contrato.getConFechaCambio());
        contratoVO.setConFechaRegistro(contrato.getConFechaRegistro());
        contratoVO.setConFechaSuscripcion(contrato.getConFechaSuscripcion());
        contratoVO.setConFicharesumen(contrato.getConFicharesumen());
        contratoVO.setConId(contrato.getConId());
        contratoVO.setConNumero(contrato.getConNumero());
        contratoVO.setConPdfcontrato(contrato.getConPdfcontrato());
        contratoVO.setConPlazoconcesion(contrato.getConPlazoconcesion());
        contratoVO.setConPlazorevision(contrato.getConPlazorevision());
        contratoVO.setConTerminal(contrato.getConTerminal());
        contratoVO.setConTipodias(contrato.getConTipodias());
        contratoVO.setConUsuarioAlta(contrato.getConUsuarioAlta());
        contratoVO.setConUsuarioBaja(contrato.getConUsuarioBaja());
        contratoVO.setConUsuarioCambio(contrato.getConUsuarioCambio());
        contratoVO.setCsiId(contrato.getCsiId());
        contratoVO.setMcoId(contrato.getMcoId());
        contratoVO.setPerId(contrato.getPerId());
        contratoVO.setTinId(contrato.getTinId());
        
       
        return contratoVO;
    }
    private Contrato toContrato(ContratoVO contratoVO){
        Contrato contrato=new Contrato();
        contrato.setCncId(contratoVO.getCncId());
        contrato.setConAnyo(contratoVO.getConAnyo());
        contrato.setConAsunto(contratoVO.getConAsunto());
        contrato.setConAvanceobra(contratoVO.getConAvanceobra());
        contrato.setConDiames(contratoVO.getConDiames());
        contrato.setConDomicilioLegal(contratoVO.getConDomicilioLegal());
        contrato.setConEstado(contratoVO.getConEstado());
        contrato.setConFechaAlta(contratoVO.getConFechaAlta());
        contrato.setConFechaBaja(contratoVO.getConFechaBaja());
        contrato.setConFechaCambio(contratoVO.getConFechaCambio());
        contrato.setConFechaRegistro(contratoVO.getConFechaRegistro());
        contrato.setConFechaSuscripcion(contratoVO.getConFechaSuscripcion());
        contrato.setConFicharesumen(contratoVO.getConFicharesumen());
        contrato.setConId(contratoVO.getConId());
        contrato.setConNumero(contratoVO.getConNumero());
        contrato.setConPdfcontrato(contratoVO.getConPdfcontrato());
        contrato.setConPlazoconcesion(contratoVO.getConPlazoconcesion());
        contrato.setConPlazorevision(contratoVO.getConPlazorevision());
        contrato.setConTerminal(contratoVO.getConTerminal());
        contrato.setConTipodias(contratoVO.getConTipodias());
        contrato.setConUsuarioAlta(contratoVO.getConUsuarioAlta());
        contrato.setConUsuarioBaja(contratoVO.getConUsuarioBaja());
        contrato.setConUsuarioCambio(contratoVO.getConUsuarioCambio());
        contrato.setCsiId(contratoVO.getCsiId());
        contrato.setMcoId(contratoVO.getMcoId());
        contrato.setPerId(contratoVO.getPerId());
        contrato.setTinId(contratoVO.getTinId());
        
        contrato.setConDiaPlazoconcesion(contratoVO.getConDiaPlazoconcesion());
        contrato.setConMesoAnioPlazoconcesion(contratoVO.getConMesoAnioPlazoconcesion());
        contrato.setConNotaPlazoConcesion(contratoVO.getConNotaPlazoConcesion());        
        return contrato;
        
    }

    public List<ContratoVO> buscarxNombreConcesion(String nombreConcesion,int codTipoInfraestructura,int codConcesion,Date fechaIncioSuscripcion,Date fechafinSuscripcion) throws SQLException{
        List<Object[]> list=contratoConcesionDAOImpl.buscarxNombreConcesion( nombreConcesion, codTipoInfraestructura, codConcesion, fechaIncioSuscripcion, fechafinSuscripcion);
        List<ContratoVO> lstBusquedaxNombreConcesion=new ArrayList<ContratoVO>();
        for (Object[] columna : list) {
            ContratoVO con=new ContratoVO();
            con.setConFechaSuscripcion((Date)columna[0]);
            con.setConFechaSuscripcionDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(con.getConFechaSuscripcion()));
            con.setNombreTipoInfraestructura(columna[1]!=null?columna[1].toString():null);
            con.setNombreConcesion(columna[2]!=null?columna[2].toString():null);
            con.setNombreModalidad(columna[3]!=null?columna[3].toString():null);
            con.setNombreConcesionario(columna[4]!=null?columna[4].toString():null);
            con.setConPdfcontrato(columna[5]!=null?columna[5].toString():null);
            con.setConFicharesumen(columna[6]!=null?columna[6].toString():null);
            con.setTinId(new Integer(columna[7].toString()));
            con.setCsiId(new Integer(columna[8].toString()));
            con.setConId(new Integer(columna[9].toString()));
            con.setCncId(new Integer(columna[10].toString()));
            con.setMcoId(new Integer(columna[11].toString()));
            con.setConDomicilioLegal(columna[12]!=null?columna[12].toString():null);
            con.setConAvanceobra(columna[13]!=null?new Integer(columna[13].toString()):null);
            con.setPerId(columna[14]!=null?new Integer(columna[14].toString()):null);
            con.setConDiames(columna[15]!=null?new Integer(columna[15].toString()):null);
            con.setConPlazorevision(columna[16]!=null?new Integer(columna[16].toString()):null);
            con.setConTipodias(columna[17]!=null?new Integer(columna[17].toString()):null);
            con.setConPlazoconcesion((Date)columna[18]);
            con.setConPlazoconcesionDescripcion(Reutilizar.getNewInstance().convertirFechaenCadena(con.getConPlazoconcesion()));
            con.setConAnyo(columna[19]!=null?new Integer(columna[19].toString()):null);
            con.setConNumero(columna[20]!=null?new Integer(columna[20].toString()):null);
            con.setConEstado(columna[21]!=null?new Integer(columna[21].toString()):null);
            con.setConFechaAlta((Date)columna[22]);
            con.setConAsunto(columna[23]!=null?columna[23].toString():null);
            lstBusquedaxNombreConcesion.add(con);
           // System.out.println("*********SERVICE*******buscarContratoxNombreConcesion():"+((Date)columna[0])+"-"+columna[1].toString()+"-"+columna[2].toString()+"-"+columna[3].toString()+"-"+columna[4].toString()+"-"+columna[5].toString()+"-"+columna[6].toString());
       }

        return lstBusquedaxNombreConcesion;
    }
}
