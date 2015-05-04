package com.ositran.serviceimpl;

import com.ositran.daoimpl.ReporteEmpresaSupervisoraDAOImpl;
import com.ositran.service.ReporteEmpresaSupervisoraService;
import com.ositran.vo.bean.ReporteEmpresaSupervisoraVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteEmpresaSupervisoraServiceImpl implements ReporteEmpresaSupervisoraService{
    ReporteEmpresaSupervisoraDAOImpl reporteEmpresaSupervisoraDAOImpl=new ReporteEmpresaSupervisoraDAOImpl();
    public ReporteEmpresaSupervisoraServiceImpl() {
        super();
    }

    @Override
    public List<ReporteEmpresaSupervisoraVO> generarReporteEmpresaSupervisora(String tipoInfra, String concesion, String estado,
                                                         String fecIni, String fecFin) throws SQLException {
        
        List<Object[]> list=reporteEmpresaSupervisoraDAOImpl.generarReporteEmpresaSupervisora(tipoInfra,concesion,estado,fecIni,fecFin);

        if((list.size())>0){
            List<ReporteEmpresaSupervisoraVO> lstBusqueda=new ArrayList<ReporteEmpresaSupervisoraVO>();
            for (Object[] columna : list) {
                ReporteEmpresaSupervisoraVO con=new ReporteEmpresaSupervisoraVO();
                con.setSupId(new Integer(columna[0].toString()));
                con.setSupNombre(columna[1].toString());
                if(columna[2]!=null){
                    con.setSupDireccion(columna[2].toString());
                }else{
                    con.setSupDireccion("");
                }
                if(columna[3]!=null){
                    con.setSupCorreo(columna[3].toString());
                }else{
                    con.setSupCorreo("");
                }
                con.setSupSiglas(columna[4].toString());
                if(columna[5]!=null){
                    con.setSupTelefono(columna[5].toString());
                }else{
                    con.setSupTelefono("");
                }
                if(columna[6]!=null){
                    con.setSupRepresentanteLegal(columna[6].toString());
                }else{
                    con.setSupRepresentanteLegal("");
                }
                if(columna[7]!=null){
                    con.setSupJefeSupervision(columna[7].toString());
                }else{
                    con.setSupJefeSupervision("");
                }
                if(columna[8]!=null){
                    con.setCpsFechaSuscripcion(columna[8].toString());
                }else{
                    con.setCpsFechaSuscripcion("");
                }
                if(columna[8]!=0){
                    con.setSupEstado(columna[9].toString());
                }else{
                    con.setSupEstado("");
                }
                con.setMcoNombre(columna[10].toString());
                if(columna[11]!=null){
                    con.setCpsFechaInicio(columna[11].toString());
                }else{
                    con.setCpsFechaInicio("");
                }
                con.setCpsPlazoContrato(columna[12].toString());            
                con.setTinNombre(columna[13].toString());
                con.setCpsMontoContratado(columna[14].toString());
                con.setCsiNombre(columna[15].toString());
                
                System.out.println("getters y setters: "+con.getSupId()+" "+con.getSupNombre()+" "+con.getCpsFechaSuscripcion()+" "+con.getMcoNombre()+" "+con.getCsiNombre());
                lstBusqueda.add(con);
            }
            return lstBusqueda;
        }else{
            System.out.println("la lista no posee elmentos");
            return null;
        }
        //List<ReporteEmpresaSupervisora>    list = reporteEmpresaSupervisoraDAOImpl.generarReporteEmpresaSupervisora(tipoInfra, concesion, estado, fecIni, fecFin);
        //List<ReporteEmpresaSupervisoraVO> listVO = toListReporteEmpresaSupervisoraVO(list);
    }
    
    //conversiones
    /*
    private List<ReporteEmpresaSupervisoraVO> toListReporteEmpresaSupervisoraVO(List<ReporteEmpresaSupervisora> list)throws SQLException{
        List<ReporteEmpresaSupervisoraVO> listVO=new ArrayList<ReporteEmpresaSupervisoraVO>();
        for(int i=0;i<list.size();i++){
            ReporteEmpresaSupervisora reporteEmpresaSupervisora=(ReporteEmpresaSupervisora)list.get(i);
            ReporteEmpresaSupervisoraVO reporteEmpresaSupervisoraVO=toReporteEmpresaSupervisoraVO(reporteEmpresaSupervisora);
            listVO.add(reporteEmpresaSupervisoraVO);
        }
        return listVO;
    }
    
    private ReporteEmpresaSupervisoraVO toReporteEmpresaSupervisoraVO(ReporteEmpresaSupervisora reporteEmpresaSupervisora)throws SQLException{
        ReporteEmpresaSupervisoraVO reporteEmpresaSupervisoraVO=new ReporteEmpresaSupervisoraVO();
        reporteEmpresaSupervisoraVO.setSupId(reporteEmpresaSupervisora.getSupId());
        return reporteEmpresaSupervisoraVO;
    }
    private ReporteEmpresaSupervisora toReporteEmpresaSupervisora(ReporteEmpresaSupervisoraVO reporteEmpresaSupervisoraVO) throws SQLException{
        ReporteEmpresaSupervisora reporteEmpresaSupervisora=new ReporteEmpresaSupervisora();     
        reporteEmpresaSupervisora.setSupId(reporteEmpresaSupervisoraVO.getSupId());
        return reporteEmpresaSupervisora;
        
    }*/

    

}