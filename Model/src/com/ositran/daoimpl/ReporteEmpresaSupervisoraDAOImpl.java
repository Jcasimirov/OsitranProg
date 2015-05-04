package com.ositran.daoimpl;

import com.ositran.dao.ReporteEmpresaSupervisoraDAO;

import com.ositran.util.HibernateUtil;

import com.ositran.util.ReportesJDBC;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.procedure.ProcedureCall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.orm.hibernate3.HibernateCallback;


public class ReporteEmpresaSupervisoraDAOImpl implements ReporteEmpresaSupervisoraDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public ReporteEmpresaSupervisoraDAOImpl() {
        super();
    }
    
    @Override
    public List<Object[]> generarReporteEmpresaSupervisora(String tipoInfra, String concesion, String estado,
                                                         String fecIni, String fecFin) throws SQLException{
        try{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            StringBuffer querysql= new StringBuffer("SELECT ES.SUP_ID, ES.SUP_NOMBRE, ES.SUP_DIRECCION, ES.SUP_CORREO, ES.SUP_SIGLAS, ES.SUP_TELEFONO, ES.SUP_REPRESENTANTE_LEGAL," + 
            " ES.SUP_JEFE_SUPERVISION, TO_CHAR(CS.CPS_FECHA_SUSCRIPCION,'DD/MM/YYYY'), ES.SUP_ESTADO, MC.MCO_NOMBRE," +
            " TO_CHAR(CS.CPS_FECHA_INICIO,'DD/MM/YYYY'), (CS.CPS_FECHA_INICIO+CS.CPS_PLAZO_CONTRATO) AS FECHA_FIN, TI.TIN_NOMBRE, CS.CPS_MONTO_CONTRATADO, CONC.CSI_NOMBRE " +
            " FROM T_Empresa_Supervisora ES, T_CONTRATO_SUPERVISORA CS, T_MODALIDAD_CONCESION MC, T_INFRAESTRUCTURA_TIPO TI, T_CONCESION CONC, T_CONTRATO CON" +
            " WHERE CS.SUP_ID=ES.SUP_ID " + 
            " AND CON.MCO_ID=MC.MCO_ID " + 
            " AND  CON.CON_ID=CS.CON_ID " + 
            " AND CS.TIN_ID=TI.TIN_ID " + 
            " AND CS.CSI_ID=CONC.CSI_ID "+
            " AND TI.TIN_ID = " + tipoInfra+
            " AND CONC.CSI_ID = "+concesion+
            " AND ES.SUP_ESTADO = "+estado+
            " AND CS.CPS_FECHA_INICIO BETWEEN TO_DATE('"+fecIni+"', 'DD/MM/YYYY') AND TO_DATE('"+fecFin+"', 'DD/MM/YYYY') ");
            Query query=session.createSQLQuery(querysql.toString());
            List<Object[]> list=(List<Object[]>)query.list(); 
            session.getTransaction().commit();
            return list;
        }catch(NullPointerException npe){
            System.out.println("la consulta produce 0 registros");
            return null;
        }
    }    
        
    public List<String> generarReporteSP(String tipoInfra, String concesion, String estado,
                                                         String fecIni, String fecFin){
        System.out.println("ingresa");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        
        //StringBuffer querysql= new StringBuffer("{ ? = call SP_EMPRESA_SUPERVISORA()}");
        
        Query query=session.getNamedQuery("LIB_SP");
        query.setLong("branchCD", 1);
        query.setLong("authorCD", 1);
        //query.setParameter("pSupId", "1");
        //List<Object[]> list=(List<Object[]>)query.list(); 
        //List<String> list=(List<String>)query.list(); 
        
        /*Query query = session.createSQLQuery("call PKG_REPORTES.SP_EMPRESA_SUPERVISORA(:pSupId)")
                .addEntity(ReporteEmpresaSupervisora.class)
                .setParameter("pSupId", "1");
         
        List result = null;
        try{
            result = query.list();
        }catch(java.lang.NegativeArraySizeException ne){
            System.out.println("cause: "+ne.getCause());
            System.out.println("mess: "+ne.getMessage());
        }*/
        ///Query query = session.createSQLQuery("call SP_LIB_DTL(?, :branchCD ,:authorCD)");
        //ProcedureCall query = session.createStoredProcedureCall("call SP_LIB_DTL(?, :branchCD ,:authorCD)");
        ///query.setInteger("branchCD", 1);        query.setInteger("authorCD", 1);
        List result = (List)query.list();
        for(int i=0; i<result.size(); i++){
                String str = (String)result.get(i);
                System.out.println(str);
        }
        System.out.println("lista: "+result);
        return result;
    }

    
    /*public List<String> generaReporte(String tipoInfra, String concesion, String estado,
                                                         String fecIni, String fecFin) {
        Connection con = ReportesJDBC.getConnection();
        CallableStatement proc = null;
        List<String> lista=new ArrayList<String>();
        try {
            proc = con.prepareCall("{ call PKG_REPORTES.SP_EMPRESA_SUPERVISORA(?, ?) }");//("{ ? = call list_early_deaths () }");
            proc.setString(1, "1");
            //proc.setInt(2, age);
            proc.execute();
            ResultSet rs=(ResultSet) proc.getObject(1);            
            while (rs.next()){
                System.out.println(rs);
                lista.add(String.valueOf(rs.getRow()));
                System.out.println("lista= "+lista);
                //String name = rs.getString(1);
                //int age = rs.getInt(2);
                //mapper.sendDeath(name, age);
            }
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                proc.close();
            } catch (SQLException e) {
            }
            //con.close();
        }
        return lista;
        /*Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List<String> list = session.createQuery("SELECT ES.SUP_NOMBRE, ES.SUP_DIRECCION, ES.SUP_CORREO, ES.SUP_SIGLAS, ES.SUP_TELEFONO, ES.SUP_REPRESENTANTE_LEGAL,\n" +
        " ES.SUP_JEFE_SUPERVISION,\n" +
        " CS.CPS_FECHA_SUSCRIPCION,\n" +
        //"DECODE(ES.SUP_ESTADO,1,'ACTIVO',0,'INACTIVO') AS ESTADO,\n" +
        " (SELECT MC.MCO_NOMBRE FROM T_CONTRATO C, T_MODALIDAD_CONCESION MC WHERE C.MCO_ID=MC.MCO_ID) AS MODALIDAD,\n" +
        " CS.CPS_FECHA_INICIO, CS.CPS_PLAZO_CONTRATO, TI.TIN_NOMBRE, CS.CPS_MONTO_CONTRATADO, CONC.CSI_NOMBRE\n" +
        "FROM  T_CONTRATO CON, T_EMPRESA_SUPERVISORA ES, T_CONTRATO_SUPERVISORA CS, T_INFRAESTRUCTURA_TIPO TI, T_CONCESION CONC\n" +
        "WHERE CS.SUP_ID=ES.SUP_ID\n" +
        "AND  CON.CON_ID=CS.CON_ID\n" +
        "AND CS.TIN_ID=TI.TIN_ID\n" +
        "AND CS.CSI_ID=CONC.CSI_ID").list();
        return list;* /
        
    }*/
}
