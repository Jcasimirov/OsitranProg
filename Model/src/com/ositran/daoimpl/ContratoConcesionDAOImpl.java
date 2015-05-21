package com.ositran.daoimpl;

import com.ositran.dao.ContratoConcesionDAO;
import com.ositran.model.Contrato;
import com.ositran.model.ContratoAlerta;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoConcesionDAOImpl implements ContratoConcesionDAO { 
        List<Contrato> list = null;    
    public ContratoConcesionDAOImpl() {
        super();
    }
    
   
    public List<Contrato> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            list= session.createQuery("select o from Contrato o").list();            
            System.out.println("LISTA = "+list);
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

        @Override
        public String insert(Contrato contrato) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            Transaction tx=null;
            try {
                tx=session.beginTransaction();
                session.persist(contrato);
                tx.commit();
           } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                result=e.getMessage();
            } finally {
		session.close();
            }
            return result;
        }
        
        @Override
        public String delete(Integer id) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            Transaction tx=null;
            try {
                tx=session.beginTransaction();
                Contrato contrato=(Contrato)session.get(Contrato.class, id);
                session.delete(contrato);
                tx.commit();
            } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                result=e.getMessage();
            } finally {
		session.close();
            }
            return result;
        }
        
    @Override
    public String update(Contrato contrato) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contrato);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            System.out.println(result);
        } finally {
		session.close();
	}
        return result;
    }
    
    public void updateContrato(Contrato contrato,ContratoAlerta contratoAlerta){
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            String fcambio=sdf.format(contrato.getConFechaCambio());
            Query query=session.createSQLQuery(" UPDATE T_CONTRATO_ALERTA " +
            "   SET CAL_ESTADO = 0," +
            "       CAE_ID     = 0," +
            "       CAL_USUARIO_CAMBIO = '"+contrato.getConUsuarioCambio()+"', "+
            "       CAL_FECHA_CAMBIO   = TO_DATE('"+fcambio+"','dd/MM/yyyy') "+
            " WHERE CON_ID     = "+contratoAlerta.getConId()+
            "   AND CAL_TIPO   = 1 ");
            query.executeUpdate();      
            if(contrato.getConAvanceobra()==1)
            session.save(contratoAlerta);
            session.update(contrato);
            session.flush();   
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
        } finally {
            session.close();
	}
    }   
    
        @Override
        public Contrato get(Integer id) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            Transaction tx=null;
            try {
                tx=session.beginTransaction();
                Contrato contrato=(Contrato)session.get(Contrato.class, id);
                tx.commit();
                return contrato;
            } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }
        
    @Override
    public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException{
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;     
            query=session.createQuery("FROM Contrato c WHERE c.csiId like :busqueda1 and c.tinId like :busqueda2");
            query.setParameter("busqueda1",concesion);
            query.setParameter("busqueda2",tipoinfra);
            list= query.list();
            tx.commit();
            return list.size();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<Contrato> buscarContratos(int tinfraestructura, int concesion, int modalidadConcesion, Date fechaInicio, Date fechaFin) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;
            if(fechaInicio == null && fechaFin == null){
                query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 and c.mcoId like :busqueda3");
                query.setParameter("busqueda1",tinfraestructura);
                query.setParameter("busqueda2",concesion);
                query.setParameter("busqueda3",modalidadConcesion);
            
            }else if((fechaInicio == null && fechaFin == null) && tinfraestructura == 0){
                query=session.createQuery("FROM Contrato c WHERE c.mcoId like :busqueda");
                query.setParameter("busqueda",modalidadConcesion);
            
            }else if((fechaInicio == null && fechaFin == null) && modalidadConcesion == 0){
                query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 ");
                query.setParameter("busqueda1",tinfraestructura);
                query.setParameter("busqueda2",concesion);
                
            }else if((fechaInicio == null && fechaFin == null) && modalidadConcesion == 0 && concesion == 0){
                query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda");
                query.setParameter("busqueda",tinfraestructura);
                
            }else {            
                query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 and c.mcoId like :busqueda3 and c.conFechaSuscripcion >= busqueda4 and c.conFechaSuscripcion <= busqueda5");
                query.setParameter("busqueda1",tinfraestructura);
                query.setParameter("busqueda2",concesion);
                query.setParameter("busqueda3",(modalidadConcesion==0?"%":modalidadConcesion));
                query.setParameter("busqueda4",fechaInicio);
                query.setParameter("busqueda5",fechaFin);
                
            }
            list= query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    public List<Object[]> buscarxNombreConcesion(String nombreConcesion,int codTipoInfraestructura,int codConcesion,Date fechaIncioSuscripcion,Date fechafinSuscripcion) throws SQLException{
        System.out.println("dao tipoInfraestructura, concesion"+codTipoInfraestructura+" "+ codConcesion);
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            StringBuffer querysql= new StringBuffer("Select c.CON_FECHA_SUSCRIPCION," );
                                        querysql.append("tin.TIN_NOMBRE, " );
                                        querysql.append("csi.CSI_NOMBRE, " );
                                        querysql.append("mco.MCO_NOMBRE, " );
                                        querysql.append("cnc.CNC_NOMBRE, " );
                                        querysql.append("c.CON_PDFCONTRATO, " );
                                        querysql.append("c.CON_FICHARESUMEN, " );
                                        querysql.append("c.TIN_ID, " );
                                        querysql.append("c.CSI_ID, " );
                                        querysql.append("c.CON_ID, " );
                                        querysql.append("c.CNC_ID, " );
                                        querysql.append("C.MCO_ID, " );
                                        querysql.append("C.CON_DOMICILIO_LEGAL, " );
                                        querysql.append("c.CON_AVANCEOBRA, " );
                                        querysql.append("C.PER_ID, " );
                                        querysql.append("C.CON_DIAMES, " );
                                        querysql.append("C.CON_PLAZOREVISION, " );
                                        querysql.append("C.CON_TIPODIAS, " );
                                        querysql.append("C.CON_PLAZOCONCESION, " );
                                                                  
                                        querysql.append("C.CON_ANYO," );
                                        querysql.append("C.CON_NUMERO, " );
                                        querysql.append("C.CON_ESTADO, " );
                                        querysql.append("C.CON_FECHA_ALTA," );
                                        querysql.append("C.CON_ASUNTO, " );                                                          
                                        querysql.append("C.CON_CANTIDAD_PLAZOCONCESION, " ); 
                                        querysql.append("C.CON_MESOANIO_PLAZOCONCESION, " ); 
                                        querysql.append("C.CON_NOTA_PLAZOCONCESION " ); 
                                        querysql.append("From T_CONTRATO c " );
                                        querysql.append("left join T_CONCESION csi on c.CSI_ID=csi.CSI_ID " );
                                        querysql.append("left join T_MODALIDAD_CONCESION  mco on c.MCO_ID=mco.MCO_ID " );
                                        querysql.append("left join T_CONCESIONARIO        cnc on c.CNC_ID=cnc.CNC_ID " ); 
                                        querysql.append("left join T_INFRAESTRUCTURA_TIPO tin on c.TIN_ID=tin.TIN_ID " );
                                        querysql.append("where 1=1 ");
                                        if(!nombreConcesion.equals("") && nombreConcesion!=null)
                                            querysql.append(" and  UPPER(TRIM(csi.CSI_NOMBRE)) like :nombre ");
                                        if(codTipoInfraestructura!=0)
                                            querysql.append(" and  c.TIN_ID = :tinid ");                                    
                                        if(codConcesion!=0)
                                            querysql.append(" and  c.CSI_ID = :csiid ");                                    
                                        if(fechaIncioSuscripcion!=null && fechafinSuscripcion!=null)
                                            querysql.append(" and  c.CON_FECHA_SUSCRIPCION between :fis and :ffs");
                                        
                               Query query=session.createSQLQuery(querysql.toString());
                                        if(!nombreConcesion.equals("") && nombreConcesion!=null)
                                            query.setParameter("nombre", "%"+nombreConcesion+"%");
                                        if(codTipoInfraestructura!=0)
                                            query.setParameter("tinid", codTipoInfraestructura);                                    
                                        if(codConcesion!=0)
                                            query.setParameter("csiid", codConcesion);                                    
                                        if(fechaIncioSuscripcion!=null && fechafinSuscripcion!=null){
                                            query.setParameter("fis", fechaIncioSuscripcion);
                                            query.setParameter("ffs", fechafinSuscripcion);
                                        }
                                    
            List<Object[]> list=(List<Object[]>)query.list(); 
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Contrato> buscarContratos1(int tinfraestructura) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;     
            query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.conEstado =1");
            query.setParameter("busqueda1",tinfraestructura);
            list= query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
