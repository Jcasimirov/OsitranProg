package com.ositran.serviceimpl;

import com.ositran.daoimpl.ReporteContratoConcesionDAOImpl;
import com.ositran.service.ReporteContratoConcesionService;
import com.ositran.vo.bean.ReporteContratoConcesionVO;
import java.util.ArrayList;
import java.util.List;

public class ReporteContratoConcesionServiceImpl implements ReporteContratoConcesionService{
    ReporteContratoConcesionDAOImpl reporteContratoConcesionDAOImpl=new ReporteContratoConcesionDAOImpl();
    public ReporteContratoConcesionServiceImpl() {
        super();
    }

    @Override
    public List<ReporteContratoConcesionVO> generarReporteContratoConcesion(String tipoInfra, String concesion, String modalidad) {

        List<Object[]> list=reporteContratoConcesionDAOImpl.generarReporteContratoConcesion(tipoInfra,concesion,modalidad);

        if((list.size())>0){
            List<ReporteContratoConcesionVO> lstBusqueda=new ArrayList<ReporteContratoConcesionVO>();
            for (Object[] columna : list) {
                ReporteContratoConcesionVO con=new ReporteContratoConcesionVO();
                con.setConCsiId(new Integer(columna[0].toString()));//CON.CSI_ID
                con.setCsiNombre(columna[1].toString());// CONC.CSI_NOMBRE;
                con.setCncNombre(columna[2].toString());// CONCES.CNC_NOMBRE;
                con.setTinNombre(columna[3].toString());///private String TI.TIN_NOMBRE;
                con.setMcoNombreModalidad(columna[4].toString());// MC.MCO_NOMBRE AS MODALIDAD;
                if(columna[5]!=null){
                    con.setConFechaSuscripcion(columna[5].toString());//CON.CON_FECHA_SUSCRIPCION;
                }else{
                    con.setConFechaSuscripcion("");
                }
                if(columna[6]!=null){
                    con.setConPlazoConcesion(columna[6].toString());//CON.CON_PLAZOCONCESION;
                }else{
                    con.setConPlazoConcesion("");
                }
                con.setTadTipoDocumento(columna[7].toString());//TA.TAD_NOMBRE;
                con.setCadFecha(columna[8].toString());//private String CA.CAD_FECHA;
                con.setCadDescripcion(columna[9].toString());// CA.CAD_DESCRIPCION;
                con.setCcoPeriodo(columna[10].toString());//CC.CCO_PERIODO AS PERIODO
                con.setCcoAlcance(columna[11].toString());// CC.CCO_ALCANCE;
                con.setTivNomTipoInversion(columna[12].toString());// CC.TIV_ID;
                con.setMonMoneda(columna[13].toString());// M.MON_NOMBRE;
                con.setCcoTotal(columna[14].toString());
                
                /*
                con.setSupId();
                con.setSupNombre();
                if(columna[2]!=null){
                    con.setSupDireccion();
                }else{
                    con.setSupDireccion("");
                }
                if(columna[3]!=null){
                    con.setSupCorreo;
                }else{
                    con.setSupCorreo("");
                }
                con.setSupSiglas;
                if(columna[5]!=null){
                    con.setSupTelefono;
                }else{
                    con.setSupTelefono("");
                }
                if(columna[6]!=null){
                    con.setSupRepresentanteLegal;
                }else{
                    con.setSupRepresentanteLegal("");
                }
                if(columna[7]!=null){
                    con.setSupJefeSupervision;
                }else{
                    con.setSupJefeSupervision("");
                }
                if(columna[8]!=null){
                    con.setCpsFechaSuscripcion;
                }else{
                    con.setCpsFechaSuscripcion("");
                }
                if(columna[8]!=0){
                    con.setSupEstado;
                }else{
                    con.setSupEstado("");
                }
                con.setMcoNombre;
                if(columna[11]!=null){
                    con.setCpsFechaInicio;
                }else{
                    con.setCpsFechaInicio("");
                }
                con.setCpsPlazoContrato;            
                con.setTinNombre;
                con.setCpsMontoContratado;
                con.setCsiNombre(columna[15].toString());
                */
                System.out.println("getters y setters: "+con.getConCsiId()+" "+con.getCsiNombre()+" "+con.getMonMoneda()+" "+con.getTinNombre()+" "+con.getCncNombre());
                lstBusqueda.add(con);
            }
            return lstBusqueda;
        }else{
            System.out.println("la lista no posee elmentos");
            return null;
        }        
    }
}
