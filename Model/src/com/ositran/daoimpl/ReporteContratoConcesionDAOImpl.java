package com.ositran.daoimpl;

import com.ositran.dao.ReporteContratoConcesionDAO;

import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ReporteContratoConcesionDAOImpl implements ReporteContratoConcesionDAO {
    public ReporteContratoConcesionDAOImpl() {
        super();
    }

    @Override
    public List<Object[]> generarReporteContratoConcesion(String tipoInfra, String concesion, String modalidad) {
        try{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            StringBuffer querysql= new StringBuffer("SELECT CON.CSI_ID, CONC.CSI_NOMBRE, CONCES.CNC_NOMBRE, TI.TIN_NOMBRE, MC.MCO_NOMBRE AS MODALIDAD,CON.CON_FECHA_SUSCRIPCION," + 
            " CON.CON_PLAZOCONCESION, TA.TAD_NOMBRE AS TIPODOC, CA.CAD_FECHA AS FECHA, CA.CAD_DESCRIPCION AS OBJETO," + 
            " CC.CCO_PERIODO AS PERIODO, CC.CCO_ALCANCE AS ALCANCE, TIV.TIV_NOMBRE AS TIPOINVERSION," + 
            " M.MON_NOMBRE AS MONEDA, CC.CCO_TOTAL AS TOTAL " + 
            " FROM T_CONTRATO CON, T_CONTRATO_ADENDA CA, T_ADENDA_TIPO TA, T_MONEDA M, T_CONTRATO_COMPROMISO CC, T_CONCESION CONC," + 
            " T_CONCESIONARIO CONCES, T_INFRAESTRUCTURA_TIPO TI, T_MODALIDAD_CONCESION MC, T_INVERSION_TIPO TIV " + 
            " WHERE CON.CON_ID=CA.CON_ID AND CON.MCO_ID=MC.MCO_ID AND CON.CON_ID=CC.CON_ID AND TA.TAD_ID=CA.TAD_ID " + 
            " AND CON.CSI_ID=CONC.CSI_ID AND CON.CNC_ID=CONCES.CNC_ID AND CON.TIN_ID=TI.TIN_ID AND " + 
            " CC.TIV_ID=TIV.TIV_ID AND CC.MON_ID=M.MON_ID AND CON.CSI_ID=CON.CON_ID AND " + 
            "MC.MCO_ID="+modalidad+" AND " + 
            "CON.CSI_ID="+concesion+" AND " + 
            "CON.TIN_ID="+ tipoInfra+" ");
            System.out.println("==================");
            System.out.println("SQL: "+querysql.toString());
            System.out.println("==================");
            Query query=session.createSQLQuery(querysql.toString());
            List<Object[]> list=(List<Object[]>)query.list(); 
            session.getTransaction().commit();
            return list;
        }catch(NullPointerException npe){
            System.out.println("la consulta produce 0 registros");
            return null;
        }        
    }
}
