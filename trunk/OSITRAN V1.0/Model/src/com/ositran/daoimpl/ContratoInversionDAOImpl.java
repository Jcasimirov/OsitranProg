package com.ositran.daoimpl;

import com.ositran.dao.ContratoInversionDAO;
import com.ositran.model.ContratoInversion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoInversionDAOImpl implements ContratoInversionDAO {
    public ContratoInversionDAOImpl() {
        super();
    }

    @Override
    public List<ContratoInversion> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list = session.createQuery("from ContratoInversion ca where ca.invEstado != 0").list();
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
    public String insert(ContratoInversion contratoInversion) throws SQLException {
        String result = null;

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoInversion);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
            e.printStackTrace();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoInversion contratoInversion = (ContratoInversion) session.get(ContratoInversion.class, id);
            session.delete(contratoInversion);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String update(ContratoInversion contratoInversion) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoInversion);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoInversion get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoInversion contratoInversion = (ContratoInversion) session.get(ContratoInversion.class, id);
            tx.commit();
            return contratoInversion;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<ContratoInversion> getInversionesContratoenRectificacion(Integer conId) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;
            query = session.createQuery("FROM ContratoInversion o where o.conId = :busqueda1 order by o.invId DESC");
            query.setParameter("busqueda1", conId);
            List<ContratoInversion> list = query.list();
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

    public List<ContratoInversion> ListaPorAeropuerto(int contrato, int tipoInfraestructura, int concesion,
                                                      int infraestructura) throws SQLException {
        Query query;
        System.out.println("contrato: " + contrato);
        System.out.println("tipoInfraestructura: " + tipoInfraestructura);
        System.out.println("concesion: " + concesion);
        System.out.println("infraestructura: " + infraestructura);
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            query =
                session.createQuery("FROM ContratoInversion ci where ci.invEstado <> 0  AND ci.conId = :contrato and ci.tinId = :tipoInfraestructura and ci.csiId = :concesion and ci.infId = :infraestructura");
            query.setParameter("contrato", contrato);
            query.setParameter("tipoInfraestructura", tipoInfraestructura);
            query.setParameter("concesion", concesion);
            query.setParameter("infraestructura", infraestructura);
            List<ContratoInversion> list = query.list();
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


    public String insertListaInversion(List<ContratoInversion> lista) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        ContratoInversion coninv = null;
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            if (lista.size() > 0) {
                coninv = (ContratoInversion) lista.get(0);
                Query query =
                    session.createSQLQuery(" UPDATE T_CONTRATO_INVERSION " + "   SET INV_ESTADO = 0," +
                                           "       INV_USUARIO_CAMBIO = '" + coninv.getInvUsuarioCambio() + "', " +
                                           "       INV_FECHA_CAMBIO   = :fechacambio " +
                                           " WHERE CON_ID            = " + coninv.getConId() + " " +
                                           "   AND CSI_ID            = " + coninv.getCsiId() + " " +
                                           "   AND TIN_ID            = " + coninv.getTinId() + " " +
                                           "   AND INF_ID            = " + coninv.getInfId());
                query.setDate("fechacambio", coninv.getInvFechaCambio());
                query.executeUpdate();
                for (ContratoInversion contratoInversion : lista) {
                    if (contratoInversion.getInvId() != null)
                        session.update(contratoInversion);
                    else
                        session.save(contratoInversion);
                }
                session.flush();
                tx.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
        } finally {
            session.close();
	}
        return "";
    }
    public String updateInversionxInfraestructuras(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                   String usuario,
                                                   String terminal) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();          
            Query query =
                session.createSQLQuery(" UPDATE T_CONTRATO_INVERSION " +
                                       " SET   INV_ESTADO = 0," +
                                       "       INV_USUARIO_CAMBIO = '" + usuario + "', " +
                                       "       INV_FECHA_CAMBIO   = :fechacambio," +
                                       "       INV_TERMINAL       = :terminal " +
                                       " WHERE CON_ID            = " + contratoId + " " +
                                       "   AND CSI_ID            = " + csiId + " " +
                                       "   AND TIN_ID            = " + tinId + " " +
                                       "   AND INF_ID            = " + infId);
            query.setDate("fechacambio", new Date());
            query.setString("terminal",terminal);
            query.executeUpdate();
            
            session.flush();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
        } finally {
            session.close();
	}
        return "";
    }
    public boolean validaNoExisteNombreInversion(int contratoId,
                                                   int csiId,
                                                   int tinId,
                                                   int infId,
                                                String nombreInversion)throws Exception{
        boolean noExiste=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query =
                session.createQuery(" SELECT count(M.invId) FROM ContratoInversion M "+
                                     " WHERE M.conId = " + contratoId + " " +
                                     "   AND M.csiId = " + csiId + " " +
                                     "   AND M.tinId = " + tinId + " " +
                                     "   AND M.infId = " + infId + " " +
               " AND upper(trim(M.invDescripcion)) = '" + nombreInversion+"'");
            Long result=(Long)query.uniqueResult();
            if(result>0)
                noExiste=false;
            else
                noExiste=true;
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
	}
        return noExiste;
    }
    public boolean validaInversionNoEstaEnUso(Integer idInversion)throws Exception{
        boolean estaenUso=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query =
                session.createQuery(" SELECT count(M.invId) FROM ValorizacionInversionAvanceDetalle M "+
                                     " WHERE M.invId = " + idInversion);
            Long result=(Long)query.uniqueResult();
            if(result>0L)
                estaenUso=true;
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return estaenUso;
    }
}
