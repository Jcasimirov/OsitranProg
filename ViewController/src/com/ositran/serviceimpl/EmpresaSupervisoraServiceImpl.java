package com.ositran.serviceimpl;

import com.ositran.daoimpl.EmpresaSupervisoraDAOImpl;
import com.ositran.model.EmpresaSupervisora;
import com.ositran.service.EmpresaSupervisoraService;
import com.ositran.vo.bean.EmpresaSupervisoraVO;

import com.ositran.vo.bean.InfraestructuraTipoVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpresaSupervisoraServiceImpl implements EmpresaSupervisoraService{
    public EmpresaSupervisoraServiceImpl() {
        super();
    }
    
    private EmpresaSupervisoraDAOImpl empresaSupervisoraDAOImpl=new EmpresaSupervisoraDAOImpl();

    public void setEmpresaSupervisoraDAOImpl(EmpresaSupervisoraDAOImpl empresaSupervisoraDAOImpl) {
        this.empresaSupervisoraDAOImpl = empresaSupervisoraDAOImpl;
    }

    @Override
    public List<EmpresaSupervisoraVO> query() throws SQLException{
        List<EmpresaSupervisora> list=empresaSupervisoraDAOImpl.query();
        List<EmpresaSupervisoraVO> listVO=toListEmpresaSupervisoraVO(list);
        return listVO;
        
    }
    
    @Override
    public List<EmpresaSupervisoraVO> FiltrarEmpSup(String nombre) throws SQLException{
        List<EmpresaSupervisora> list=empresaSupervisoraDAOImpl.FiltrarEmpSup(nombre);
        List<EmpresaSupervisoraVO> listVO=toListEmpresaSupervisoraVO(list);
        return listVO;        
    }
    
    @Override
    public int ValidaNombre(String atributo) throws SQLException{
        int respuesta =empresaSupervisoraDAOImpl.ValidarNombre(atributo);
        return respuesta;        
    }
    
    @Override
    public int ValidaRuc(String atributo, int documento) throws SQLException{
        int respuesta =empresaSupervisoraDAOImpl.ValidarRuc(atributo,documento);
        return respuesta;        
    }
    
    @Override
    public int ValidaNombreMod(String atributo, String Nombre) throws SQLException{
        int respuesta =empresaSupervisoraDAOImpl.ValidarNombreMod(atributo,Nombre);
        return respuesta;        
    }
    
    @Override
    public int ValidarRucMod(String atributo, String Nombre,int documento) throws SQLException{
        int respuesta = empresaSupervisoraDAOImpl.ValidarRucMod(atributo,Nombre,documento);
        return respuesta;        
    }

    @Override
    public String insert(EmpresaSupervisoraVO empresaSupervisoraVO) throws SQLException{
        EmpresaSupervisora empresaSupervisora=toEmpresaSupervisora(empresaSupervisoraVO);
        String result=empresaSupervisoraDAOImpl.insert(empresaSupervisora);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=this.empresaSupervisoraDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(EmpresaSupervisoraVO empresaSupervisoraVO) throws SQLException{
        EmpresaSupervisora empresaSupervisora=toEmpresaSupervisora(empresaSupervisoraVO);
        String result=this.empresaSupervisoraDAOImpl.update(empresaSupervisora);
        return result;
    }

    @Override
    public EmpresaSupervisoraVO get(Integer id) throws SQLException{
        EmpresaSupervisora empresaSupervisora=this.empresaSupervisoraDAOImpl.get(id);
        EmpresaSupervisoraVO empresaSupervisoraVO=toEmpresaSupervisoraVO(empresaSupervisora);
        return empresaSupervisoraVO;
    }
    
    //conversiones
    private List<EmpresaSupervisoraVO> toListEmpresaSupervisoraVO(List<EmpresaSupervisora> list){
        List<EmpresaSupervisoraVO> listVO=new ArrayList<EmpresaSupervisoraVO>();
        for(int i=0;i<list.size();i++){           
            EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)list.get(i);            
            EmpresaSupervisoraVO empresaSupervisoraVO=toEmpresaSupervisoraVO(empresaSupervisora);
            listVO.add(empresaSupervisoraVO);
        }
        return listVO;
    }
    private EmpresaSupervisoraVO toEmpresaSupervisoraVO(EmpresaSupervisora empresaSupervisora){
        EmpresaSupervisoraVO empresaSupervisoraVO=new EmpresaSupervisoraVO();
        empresaSupervisoraVO.setSupCorreo(empresaSupervisora.getSupCorreo());
        empresaSupervisoraVO.setSupDireccion(empresaSupervisora.getSupDireccion());
        empresaSupervisoraVO.setSupEstado(empresaSupervisora.getSupEstado());
        empresaSupervisoraVO.setSupFechaAlta(empresaSupervisora.getSupFechaAlta());
        empresaSupervisoraVO.setSupFechaBaja(empresaSupervisora.getSupFechaBaja());
        empresaSupervisoraVO.setSupFechaCambio(empresaSupervisora.getSupFechaCambio());
        empresaSupervisoraVO.setSupId(empresaSupervisora.getSupId());
        empresaSupervisoraVO.setSupJefeSupervision(empresaSupervisora.getSupJefeSupervision());
        empresaSupervisoraVO.setSupNombre(empresaSupervisora.getSupNombre());
        empresaSupervisoraVO.setSupNroDocumento(empresaSupervisora.getSupNroDocumento());
        empresaSupervisoraVO.setSupObra(empresaSupervisora.getSupObra());
        empresaSupervisoraVO.setSupRepresentanteLegal(empresaSupervisora.getSupRepresentanteLegal());
        empresaSupervisoraVO.setSupSiglas(empresaSupervisora.getSupSiglas());
        empresaSupervisoraVO.setSupTelefono(empresaSupervisora.getSupTelefono());
        empresaSupervisoraVO.setSupTerminal(empresaSupervisora.getSupTerminal());
        empresaSupervisoraVO.setSupUsuarioAlta(empresaSupervisora.getSupUsuarioAlta());
        empresaSupervisoraVO.setSupUsuarioBaja(empresaSupervisora.getSupUsuarioBaja());
        empresaSupervisoraVO.setSupUsuarioCambio(empresaSupervisora.getSupUsuarioCambio());
        empresaSupervisoraVO.setTdoId(empresaSupervisora.getTdoId());
       
        return empresaSupervisoraVO;
    }
    private EmpresaSupervisora toEmpresaSupervisora(EmpresaSupervisoraVO empresaSupervisoraVO){
        EmpresaSupervisora empresaSupervisora=new EmpresaSupervisora();
        empresaSupervisora.setSupCorreo(empresaSupervisoraVO.getSupCorreo());
        empresaSupervisora.setSupDireccion(empresaSupervisoraVO.getSupDireccion());
        empresaSupervisora.setSupEstado(empresaSupervisoraVO.getSupEstado());
        empresaSupervisora.setSupFechaAlta(empresaSupervisoraVO.getSupFechaAlta());
        empresaSupervisora.setSupFechaBaja(empresaSupervisoraVO.getSupFechaBaja());
        empresaSupervisora.setSupFechaCambio(empresaSupervisoraVO.getSupFechaCambio());
        empresaSupervisora.setSupId(empresaSupervisoraVO.getSupId());
        empresaSupervisora.setSupJefeSupervision(empresaSupervisoraVO.getSupJefeSupervision());
        empresaSupervisora.setSupNombre(empresaSupervisoraVO.getSupNombre());
        empresaSupervisora.setSupNroDocumento(empresaSupervisoraVO.getSupNroDocumento());
        empresaSupervisora.setSupObra(empresaSupervisoraVO.getSupObra());
        empresaSupervisora.setSupRepresentanteLegal(empresaSupervisoraVO.getSupRepresentanteLegal());
        empresaSupervisora.setSupSiglas(empresaSupervisoraVO.getSupSiglas());
        empresaSupervisora.setSupTelefono(empresaSupervisoraVO.getSupTelefono());
        empresaSupervisora.setSupTerminal(empresaSupervisoraVO.getSupTerminal());
        empresaSupervisora.setSupUsuarioAlta(empresaSupervisoraVO.getSupUsuarioAlta());
        empresaSupervisora.setSupUsuarioBaja(empresaSupervisoraVO.getSupUsuarioBaja());
        empresaSupervisora.setSupUsuarioCambio(empresaSupervisoraVO.getSupUsuarioCambio());
        empresaSupervisora.setTdoId(empresaSupervisoraVO.getTdoId());
        
        return empresaSupervisora;
        
    }
    
    @Override
    public List<EmpresaSupervisoraVO> BuscarEmpresaPorContrato(Integer contratoConcesion, Integer etapaContrato, String nombreEmpresa) throws SQLException{
        List<EmpresaSupervisoraVO> listVO = new ArrayList<EmpresaSupervisoraVO>();
        List<Object[]> list=empresaSupervisoraDAOImpl.BuscarEmpresaPorContrato(contratoConcesion,etapaContrato,nombreEmpresa);
        for(Object[] item:list){
            EmpresaSupervisoraVO empresa = new EmpresaSupervisoraVO();
            empresa.setSupCorreo(item[0]!=null?item[0].toString():null);
            empresa.setSupDireccion(item[1]!=null?item[1].toString():null);
            empresa.setSupEstado(item[2]!=null?Integer.parseInt(item[2].toString()):null);
            empresa.setSupFechaAlta(item[3]!=null?(Date)item[3]:null);
            empresa.setSupFechaBaja(item[4]!=null?(Date)item[4]:null);
            empresa.setSupFechaCambio(item[5]!=null?(Date)item[5]:null);
            empresa.setSupId(item[6]!=null?Integer.parseInt(item[6].toString()):null);
            empresa.setSupJefeSupervision(item[7]!=null?item[7].toString():null);
            empresa.setSupNombre(item[8]!=null?item[8].toString():null);
            empresa.setSupNroDocumento(item[9]!=null?item[9].toString():null);
            empresa.setSupObra(item[10]!=null?item[10].toString():null);
            empresa.setSupRepresentanteLegal(item[11]!=null?item[11].toString():null);
            empresa.setSupSiglas(item[12]!=null?item[12].toString():null);
            empresa.setSupTelefono(item[13]!=null?item[13].toString():null);
            empresa.setSupTerminal(item[14]!=null?item[14].toString():null);
            empresa.setSupUsuarioAlta(item[15]!=null?item[15].toString():null);
            empresa.setSupUsuarioBaja(item[16]!=null?item[16].toString():null);
            empresa.setSupUsuarioCambio(item[17]!=null?item[17].toString():null);
            empresa.setTdoId(item[18]!=null?Integer.parseInt(item[18].toString()):null);
            listVO.add(empresa);
        }
        return listVO;        
    }
    
}
