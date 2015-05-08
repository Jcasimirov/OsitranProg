package com.ositran.daoimpl.reportes;

import com.ositran.dao.reportes.ReportesDAO;
import com.ositran.model.reportes.AvaInvConConc;
import com.ositran.model.reportes.AvaInvRecConConc;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisora;
import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesInversiones;
import com.ositran.model.reportes.EmpSupInf;

import com.ositran.model.reportes.EmpSupInfAeropuerto;
import com.ositran.model.reportes.InversionesTipoConcepto;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

import com.ositran.model.reportes.TrazabilidadPrincipalesEventos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ositran.util.HibernateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.jdbc.Work;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ReportesDAOImpl implements ReportesDAO {
    static private List<EmpSupInf> result = new ArrayList<EmpSupInf>();
    static private List<AvaInvConConc> resultAvaInvConConc = new ArrayList<AvaInvConConc>();
    static private List<InversionesTipoConcepto> resultInvTipoConcep = new ArrayList<InversionesTipoConcepto>();
    static private List<InversionesTipoConceptoDetalle> resultInvTipoConcepDet = new ArrayList<InversionesTipoConceptoDetalle>();
    static private List<TrazabilidadPrincipalesEventos> resultTrazaPrinEventos = new ArrayList<TrazabilidadPrincipalesEventos>();
    static private List<EmpSupInfAeropuerto> resultEmpSupInfAeropuerto = new ArrayList<EmpSupInfAeropuerto>();
    static private List<ControlPlazosFlujoValorizacionesInversiones> resultControlPlazoFlujoValorizacionesInversiones = new ArrayList<ControlPlazosFlujoValorizacionesInversiones>();
    static private List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> resultControlPlazosFlujoValorizacionesEmpresaSupervisora = new ArrayList<ControlPlazosFlujoValorizacionesEmpresaSupervisora>();
    static private List<AvaInvRecConConc> resultAvaInvRecConConc= new ArrayList<AvaInvRecConConc>();
    
    static private Object param1 = new Object();
    static private Object param2 = new Object();
    static private Object param3 = new Object();
    static private Object param4 = new Object();
    static private Object param5 = new Object();
    
    boolean existeWhere=false;
    
    @Override
    public List<EmpSupInf> getEmpresaSupervisoraVsInfraestructura(int idTipoEstructura, int idConcesion,
                                                                  int idEmpSupervisora) throws SQLException {

        if (idTipoEstructura != -1) {
            param1 = idTipoEstructura;
        }else{
            param1 = null;
        }
        if (idConcesion != -1) {
            param2 = idConcesion;
        }else{
            param2 = null;
        }
        if (idEmpSupervisora != -1) {
            param3 = idEmpSupervisora;
        }else{
            param3 = null;
        }

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String query =
                    "SELECT (SELECT itip.tin_nombre\n" + "              FROM t_infraestructura_tipo itip\n" +
                    "             WHERE itip.tin_id = cps.tin_id) nomTipInfraestructura,\n" +
                    "           csi.csi_nombre nomConcesion,\n" + "           (SELECT mco.mco_nombre\n" +
                    "              FROM t_modalidad_concesion mco\n" +
                    "             WHERE mco.mco_id = con.mco_id) nomModalidad,\n" +
                    "           (SELECT esu.sup_nombre\n" + "              FROM t_empresa_supervisora esu\n" +
                    "             WHERE esu.sup_id = cps.sup_id) nomEmpSupervisora\n" +
                    "      FROM t_contrato con, t_contrato_supervisora cps, t_concesion csi\n" +
                    "     WHERE con.con_id = cps.con_id\n" + "       AND cps.csi_id = csi.csi_id\n" +
                    "       AND con.con_estado = 1\n" + "       AND cps.cps_estado = 1\n" +
                    "       AND csi.csi_estado = 1\n" + "      AND cps.tin_id != 2";

                String filtros = "";
                if (param1 != null) {
                    filtros = filtros + " AND cps.tin_id = " + param1.toString();
                }
                if (param2 != null) {
                    filtros = filtros + " AND con.mco_id = " + param2.toString();
                }
                if (param3 != null) {
                    filtros = filtros + " AND cps.sup_id = " + param3.toString();
                }

                PreparedStatement preparedStatement = connection.prepareStatement(query + filtros);
                ResultSet rs = preparedStatement.executeQuery(query + filtros);
                while (rs.next()) {
                    EmpSupInf bean = new EmpSupInf();
                    bean.setNomTipInfraestructura(rs.getString("nomTipInfraestructura"));
                    bean.setNomConcesion(rs.getString("nomConcesion"));
                    bean.setNomModalidad(rs.getString("nomModalidad"));
                    bean.setNomEmpSupervisora(rs.getString("nomEmpSupervisora"));

                    result.add(bean);
                }
            }
        });
        return getResult();
    }

    @Override
    public List<AvaInvConConc> getAvanceInversionesContratosConcesion(final int annio, final int mes, 
                                                                      int idTipoInfraestructura,
                                                                      int idConcesion,
                                                                      int idModalidad) throws SQLException {
        final int annioAnterior = annio - 1;
        param1 = annio;
        param2 = mes;
        if (idTipoInfraestructura != -1) {
            param3 = idTipoInfraestructura;
        }else{
            param3 = null;
        }
        if (idConcesion != -1) {
            param4 = idConcesion;
        }else{
            param4 = null;
        }
        if (idModalidad != -1) {
            param5 = idModalidad;
        }else{
            param5 = null;
        }

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                
                String filtros = "";
                if (param3 != null) {
                    filtros = filtros + " AND con.mco_id = " + param3.toString();                    
                }
                if (param4 != null) {
                    filtros = filtros + " AND con.tin_id = " + param4.toString();                   
                }
                if (param5 != null) {
                    filtros = filtros + " AND con.cnc_id = " + param5.toString();                   
                }
                
                String query =
                    "SELECT tbl.*, \n" + 
                    "       to_number((tbl.inversionAcumuladaAnnio*100)/tbl.totalCompromisoInv, '90D9') porcentajeCumplimiento\n" + 
                    "  FROM (\n" + 
                    "SELECT (SELECT tin.tin_nombre\n" + 
                    "          FROM t_infraestructura_tipo tin\n" + 
                    "         WHERE tin.tin_id = con.tin_id) tipoInfraestructura,\n" + 
                    "       csi.csi_nombre infraConcesionada, \n" + 
                    "       to_char(con.con_fecha_suscripcion, 'yyyy') fechaIniConcesion,\n" + 
                    "       to_char(con.con_plazoconcesion, 'dd/mm/yyyy') fechaPlazo,\n" + 
                    "       con.con_nota_plazoconcesion notaPlazo,\n" + 
                    "       to_char(con.con_fecha_suscripcion, 'mon-dd') fechaIniObras,\n" + 
                    "       (SELECT to_number(to_char(sum(decode(cco.mon_id, 1, (cco.cco_total / decode(nvl(cco.cco_tipo_cambio, 1), 0, 1)), 2, cco.cco_total)), '99999999999999D99'))\n" + 
                    "          FROM t_contrato_compromiso cco\n" + 
                    "         WHERE cco.cco_estado = 1\n" + 
                    "           AND cco.con_id = con.con_id) totalCompromisoInv,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND tia.tia_fecha_registro <= to_date('31/12/" + annioAnterior + "', 'dd/mm/yyyy')) inversionEjecutadaAcumAnnio,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char(" + mes + ", '00') || '/" + annio + "') inversionReconocidaMes,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'yyyy') = '" + annio + "') inversionReconocidaAnnio,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND tia.tia_fecha_registro <= to_date('01/' || to_char(" + mes + ", '00') || '/" + annio + "', 'dd/mm/yyyy')) inversionAcumuladaAnnio\n" + 
                    "  FROM t_contrato con, t_concesion csi\n" + 
                    " WHERE con.csi_id = csi.csi_id\n" + 
                    "   AND con.con_estado = 1\n" + 
                    "   AND csi.csi_estado = 1\n" + 
                    "   AND con.con_fecha_suscripcion is not null\n" + filtros +
                    "   ) tbl";
                
                System.out.println(query);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery(query);
                while (rs.next()) {
                    //
                    AvaInvConConc bean = new AvaInvConConc();
                    bean.setTipoInfraestructura(rs.getString("tipoInfraestructura"));
                    bean.setInfraConcesionada(rs.getString("infraConcesionada"));
                    bean.setFechaIniConcesion(rs.getString("fechaIniConcesion"));
                    bean.setFechaPlazo(rs.getString("fechaPlazo"));
                    bean.setNotaPlazo(rs.getString("notaPlazo"));
                    bean.setFechaIniObras(rs.getString("fechaIniObras"));
                    bean.setTotalCompromisoInv(rs.getInt("totalCompromisoInv"));
                    bean.setInversionEjecutadaAcumAnnio(rs.getInt("inversionEjecutadaAcumAnnio"));
                    bean.setInversionReconocidaAnnio(rs.getInt("inversionReconocidaAnnio"));
                    bean.setInversionReconocidaMes(rs.getInt("inversionReconocidaMes"));
                    bean.setInversionAcumuladaAnnio(rs.getInt("inversionAcumuladaAnnio"));
                    bean.setPorcentajeCumplimiento(rs.getInt("porcentajeCumplimiento"));

                    resultAvaInvConConc.add(bean);
                }
            }
        });
        return getResultAvaInvConConc();
    }

    @Override
    public List<InversionesTipoConcepto> getInversionesTipoConcepto(int anio, int mes, int idTipoInfraestructura,
                                                                    int idConcesion,
                                                                    int idConcepto) throws SQLException {        
        existeWhere=false;
        
        if (anio != -1) {
            existeWhere=true;
            param1 = anio;
        }else{
            param1 = null;
        }
        if (mes != -1) {
            existeWhere=true;
            param2 = mes;
        }else{
            param2 = null;
        }
        if (idTipoInfraestructura != -1) {
            existeWhere=true;
            param3 = idTipoInfraestructura;
        }else{
            param3 = null;
        }
        if (idConcesion != -1) {
            existeWhere=true;
            param4 = idConcesion;
        }else{
            param4 = null;
        }
        if (idConcepto != -1) {            
            param5 = idConcepto;
        }else{
            param5 = null;
        }

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String query =
                    "select  distinct\n" + 
                    "      tccs.csi_nombre as \"nomConcesion\", \n" + 
                    "      tcc.cnc_nombre as \"nomConcesionario\",\n" + 
                    "      tit.tin_nombre as \"nomTipInfraestructura\",\n" + 
                    "      tmccs.mco_nombre as \"nomModalidad\",\n" + 
                    "      tiadd.tia_numero as \"codigoInversion\"\n" + 
                    "from t_inv_avn tiadd inner join t_contrato tc on tiadd.con_id=tc.con_id\n" + 
                    "inner join  t_concesionario tcc on tc.cnc_id = tcc.cnc_id\n" + 
                    "inner join t_concesion tccs on tc.csi_id = tccs.csi_id \n" + 
                    "inner join t_infraestructura_tipo tit on tc.tin_id=tit.tin_id\n" + 
                    "inner join t_modalidad_concesion tmccs on tc.mco_id = tmccs.mco_id";

                if(existeWhere){                    
                    query+= " where ";              
                    if (param1 != null) {
                        query+=  " EXTRACT(year from tiad.iad_fec_inicio) = " + param1.toString();
                    }
                    if (param2 != null) {
                        query+= " AND EXTRACT(month from tiad.iad_fec_inicio) = " + param2.toString();
                    }
                    if (param3 != null) {
                        query+= " AND tit.tin_id = " + param3.toString();
                    }
                    if (param4 != null) {
                        query+= " AND tccs.csi_id = " + param4.toString();
                    }                
                }

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery(query);
                while (rs.next()) {
                    InversionesTipoConcepto bean = new InversionesTipoConcepto();
                    bean.setNomTipoInfraestructura(rs.getString("nomTipInfraestructura"));
                    bean.setNomConcesion(rs.getString("nomConcesion"));
                    bean.setNomModalidad(rs.getString("nomModalidad"));
                    bean.setNomConcesionario(rs.getString("nomConcesionario"));
                    bean.setIdDetalle(rs.getString("codigoInversion"));
                    
                    getResultInvTipoConcep().add(bean);
                }
            }
        });
        
            for(Iterator<InversionesTipoConcepto> i = getResultInvTipoConcep().iterator(); i.hasNext(); ) {
                InversionesTipoConcepto bean = i.next();
                bean.setLstDetalle(getInversionesTipoConceptoDetalle(Integer.parseInt(bean.getIdDetalle())));
            }
       
        return getResultInvTipoConcep();
    }


    @Override
    public List<InversionesTipoConceptoDetalle> getInversionesTipoConceptoDetalle(int idInversion) throws SQLException {

        if (idInversion != -1) {           
            param1 = idInversion;
        }else{
            param1 = null;
        }       

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String query =
                    "select \n" + 
                    "  EXTRACT(year from tiad.iad_fec_inicio) as \"anio\",\n" + 
                    "  EXTRACT(month from tiad.iad_fec_inicio) as \"mes\",\n" + 
                    "  titd.dti_descripcion as \"nomConcepto\",\n" + 
                    "  tir.ivr_monto_aprobado as \"montoReconocido\"\n" + 
                    "from t_inv_reconocimiento tir \n" + 
                    "inner join t_inv_avn tia on tir.tia_numero=tia.tia_numero \n" + 
                    "inner join T_INV_AVN_DETALLE tiad on tir.iad_id=tiad.iad_id and tia.tia_numero=tiad.tia_numero\n" + 
                    "inner join t_inversion_tipo_descripcion titd on titd.dti_id=tiad.dti_id\n";  
                
                if (param1 != null) {
                    query+= " where tia.tia_numero =  " + param1.toString();
                }
                
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery(query);
                while (rs.next()) {
                    InversionesTipoConceptoDetalle bean = new InversionesTipoConceptoDetalle();
                    bean.setAnio(rs.getString("anio"));
                    bean.setMes(rs.getString("mes"));
                    bean.setNomConcepto(rs.getString("nomConcepto"));
                    bean.setMontoReconocido(rs.getString("montoReconocido"));

                    getResultInvTipoConcepDet().add(bean);
                }
            }
        });
        return getResultInvTipoConcepDet();
    }
    
    @Override
    public List<TrazabilidadPrincipalesEventos> getTrazabilidadPrincipalesEventos(int idTipoInfraestructura, int anio,
                                                                                  int mes) throws SQLException {
        existeWhere=false;
        
        if (idTipoInfraestructura != -1) {
            existeWhere=true;
            param1 = idTipoInfraestructura;
        }else{
            param1 = null;
        }
        if (anio != -1) {
            existeWhere=true;
            param2 = anio;
        }else{
            param2 = null;
        }
        if (mes != -1) {
            existeWhere=true;
            param3 = mes;
        }else{
            param3 = null;
        }       

        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException {
            String query =
                "select\n" + 
                "      tccs.csi_nombre as \"nomConcesion\", \n" + 
                "      tcc.cnc_nombre as \"nomConcesionario\",\n" + 
                "      tit.tin_nombre as \"nomTipoInfraestructura\",\n" + 
                "      tmccs.mco_nombre as \"nomModalidad\",\n" + 
                "      2 as \"nroValorizacion\",\n" + 
                "      tia.tia_fecha_registro as \"fechaRegistro\",\n" + 
                "     tia.tia_hr || tia.tia_anyo as \"ingval_nrohranio\",\n" + 
                "     tia.tia_fecha_registro as \"ingval_fechaRegistro\",\n" + 
                "     tia.tia_monto_total_presentado as \"ingval_montopresentado\",\n" + 
                "     tm.mon_nombre as \"ingval_moneda\",\n" + 
                "     tiad.nro_oficio as \"derval_nrooficio\",\n" + 
                "     tiad.iad_numero as \"derval_nroregistro\",\n" + 
                "     tiad.iad_plazo_en_dias as \"derval_plazodias\",\n" + 
                "     tiad.iad_fecha_vencimiento as \"derval_fechalimite\",\n" + 
                "     tias.ias_hr || tias.ias_anyo as \"revssuper_nrohranio\",\n" + 
                "     tias.ias_fecha_registro as \"revssuper_fecharegistro\",\n" + 
                "     (select sum(tiasd.ias_monto_revisado) from T_INV_AVN_SUPERVISADA_DETALLE tiasd where tiasd.ias_numero=tias.ias_numero) as \"revssuper_montorevisado\",\n" + 
                "     (select distinct tm.mon_nombre from T_INV_AVN_SUPERVISADA_DETALLE tiasd inner join t_moneda tm on tiasd.mon_id=tm.mon_id where tiasd.ias_numero=tias.ias_numero) as \"revssuper_moneda\",\n" + 
                "     ti.inv_numero_oficio as \"recsupinv_nrooficio\",\n" + 
                "     ti.inv_reg_salida_oficio as \"recsupinv_nroregsalofi\",\n" + 
                "     tia.tia_monto_total_aprobado as \"recsupinv_totalreconocido\",\n" + 
                "     tia.tia_monto_total_reajustado as \"recsupinv_totalconreajuste\"\n" + 
                "from T_INV_AVN tia inner join t_contrato tc on tia.con_id=tc.con_id\n" + 
                "inner join  t_concesionario tcc on tc.cnc_id = tcc.cnc_id \n" + 
                "inner join t_concesion tccs on tc.csi_id = tccs.csi_id\n" + 
                "inner join t_infraestructura_tipo tit on tc.tin_id=tit.tin_id\n" + 
                "inner join t_modalidad_concesion tmccs on tc.mco_id = tmccs.mco_id\n" + 
                "inner join t_moneda tm on tm.mon_id=tia.mon_id\n" + 
                "left join T_INV_AVN_DERIVADA tiad on tiad.tia_numero = tia.tia_numero\n" + 
                "left join T_INV_AVN_SUPERVISADA tias on tias.tia_numero = tia.tia_numero\n" + 
                "left join T_INV ti on ti.tia_numero = tia.tia_numero";

            if(existeWhere){                
                query+= " where ";
                
                if (param1 != null) {
                    query+= " tit.tin_id = " + param1.toString();                
                }
                if (param2 != null) {
                    query+= " AND EXTRACT(year from tia.tia_fecha_registro) = " + param2.toString();
                }
                if (param3 != null) {
                    query+=  " AND EXTRACT(month from tia.tia_fecha_registro) = " + param3.toString();
                }
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                TrazabilidadPrincipalesEventos bean = new TrazabilidadPrincipalesEventos();
                bean.setNomConcesion(rs.getString("nomConcesion"));
                bean.setNomConcesionario(rs.getString("nomConcesionario"));
                bean.setNomTipoInfraestructura(rs.getString("nomTipoInfraestructura"));
                bean.setNomModalidad(rs.getString("nomModalidad"));
                bean.setNroValorizacion(rs.getString("nroValorizacion"));
                bean.setFechaRegistro(rs.getString("fechaRegistro"));
                //INGRESO VALORIZACION
                bean.setIngval_nrohranio(rs.getString("ingval_nrohranio"));
                bean.setIngval_fechaRegistro(rs.getString("ingval_fechaRegistro"));
                bean.setIngval_montopresentado(rs.getString("ingval_montopresentado"));
                bean.setIngval_moneda(rs.getString("ingval_moneda"));
                //DERIVADO VALORIZACION
                bean.setDerval_nrooficio(rs.getString("derval_nrooficio"));
                bean.setDerval_nroregistro(rs.getString("derval_nroregistro"));
                bean.setDerval_plazodias(rs.getString("derval_plazodias"));
                bean.setDerval_fechalimite(rs.getString("derval_fechalimite"));
                //REVISADO POR EL SUPERVISOR
                bean.setRevssuper_nrohranio(rs.getString("revssuper_nrohranio"));
                bean.setRevssuper_fecharegistro(rs.getString("revssuper_fecharegistro"));
                bean.setRevssuper_montorevisado(rs.getString("revssuper_montorevisado"));
                bean.setRevssuper_moneda(rs.getString("revssuper_moneda"));
                //RECONOCIMIENTO POR SUPERVISOR DE INVERSIONES
                bean.setRecsupinv_nrooficio(rs.getString("recsupinv_nrooficio"));
                bean.setRecsupinv_nroregsalofi(rs.getString("recsupinv_nroregsalofi"));
                bean.setRecsupinv_totalreconocido(rs.getString("recsupinv_totalreconocido"));
                bean.setRecsupinv_totalconreajuste(rs.getString("recsupinv_totalconreajuste"));
               
                getResultTrazaPrinEventos().add(bean);
            }
        }
        });
        return getResultTrazaPrinEventos();
    }
    
    @Override
    public List<EmpSupInfAeropuerto> getEmpresaSupervisoraVsInfraestructuraAeropuerto(int idTipoEstructura,
                                                                                      int idConcesion,
                                                                                      int idEmpSupervisora) throws SQLException {
        
        if (idConcesion != -1) {
            param1 = idConcesion;
        }else{
            param1 = null;
        }
        if (idEmpSupervisora != -1) {
            param2 = idEmpSupervisora;
        }else{
            param2 = null;
        }
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String query =
                    "SELECT \n" + 
                    " CONCESION.CSI_NOMBRE AS \"nomConcesion\"\n" + 
                    ",MODALIDAD.MCO_NOMBRE AS \"nomModalidad\"\n" + 
                    ",INFRA.INF_NOMBRE AS \"nomAeropuerto\"\n" + 
                    ",NVL(INVERSION.INV_DESCRIPCION,'') AS \"nomInversion\"\n" + 
                    ",SUP.SUP_NOMBRE AS  \"nomEmpresaSupervisora\"\n" + 
                    " FROM T_CONTRATO_INVERSION INVERSION\n" + 
                    " INNER JOIN T_INFRAESTRUCTURA INFRA ON INVERSION.INF_ID = INFRA.INF_ID AND INFRA.CSI_ID = INVERSION.CSI_ID\n" + 
                    " LEFT JOIN T_INFRAESTRUCTURA_TIPO TINFRA ON TINFRA.TIN_ID = INFRA.TIN_ID AND INVERSION.TIN_ID = TINFRA.TIN_ID\n" + 
                    " LEFT JOIN T_CONTRATO CONTRATO ON CONTRATO.CON_ID = INVERSION.CON_ID\n" + 
                    " LEFT JOIN T_CONCESION CONCESION ON CONCESION.CSI_ID =  INVERSION.CSI_ID\n" + 
                    " LEFT JOIN T_MODALIDAD_CONCESION MODALIDAD ON MODALIDAD.MCO_ID = CONTRATO.MCO_ID\n" + 
                    " LEFT JOIN T_CONTRATO_SUPERVISORA CSUP ON CSUP.INF_ID = INFRA.INF_ID \n" + 
                    " LEFT JOIN T_EMPRESA_SUPERVISORA SUP ON SUP.SUP_ID = CSUP.SUP_ID\n" + 
                    " WHERE TINFRA.TIN_ID=2 ";

                String filtros = "";
                if (param1 != null) {
                    query += "AND CONCESION.CSI_ID = " + param1.toString();
                }
                if (param2 != null) {
                    query +=  "AND SUP.SUP_ID = " + param2.toString();
                }

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery(query);
                while (rs.next()) {
                    EmpSupInfAeropuerto bean = new EmpSupInfAeropuerto();
                    bean.setNomConcesion(rs.getString("nomConcesion"));
                    bean.setNomModalidad(rs.getString("nomModalidad"));
                    bean.setNomAeropuerto(rs.getString("nomAeropuerto"));
                    bean.setNomInversion(rs.getString("nomInversion"));
                    bean.setNomEmpresaSupervisora(rs.getString("nomEmpresaSupervisora"));

                    getResultEmpSupInfAeropuerto().add(bean);
                }
            }
        });
        return getResultEmpSupInfAeropuerto();
    }
    
    @Override
    public List<ControlPlazosFlujoValorizacionesInversiones> getControlPlazosFlujoValorizacionesInversiones(int idTipoInfraestructura,
                                                                                                      int anio,
                                                                                                      int mes) throws SQLException {
    
        existeWhere=false;
        
        if (idTipoInfraestructura != -1) {
            existeWhere=true;
            param1 = idTipoInfraestructura;
        }else{
            param1 = null;
        }
        if (anio != -1) {
            existeWhere=true;
            param2 = anio;
        }else{
            param2 = null;
        }
        if (mes != -1) {
            existeWhere=true;
            param3 = mes;
        }else{
            param3 = null;
        }
        
    
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException {
            String query =
                "select\n" + 
                "      tccs.csi_nombre as \"nomConcesion\", \n" + 
                "      tcc.cnc_nombre as \"nomConcesionario\",\n" + 
                "      tia.tia_numero as \"nroValorizacion\",\n" + 
                "      tia.tia_fecha_registro as \"fechaRegistro\",\n" + 
                "      --\n" + 
                "     tcatc.cal_fecha_limite AS \"ingval_pl\",\n" + 
                "     case\n" + 
                "     when tia.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END AS \"ingval_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(tia.tia_fecha_registro,tcatc.cal_fecha_limite) AS \"ingval_v\",\n" + 
                "     ---\n" + 
                "     tia.tia_fecha_vencimiento_plazo as \"derval_fr\",\n" + 
                "     case\n" + 
                "     when tiad.iad_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END AS \"derval_est\",\n" + 
                "     \n" + 
                "     --\n" + 
                "     tiad.iad_fecha_respuesta as \"revssuper_fr\",\n" + 
                "     case\n" + 
                "     when tias.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END as \"revssuper_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(tias.ias_fecha_registro,tiad.iad_fecha_respuesta) as \"revssuper_v\",\n" + 
                "     --\n" + 
                "     (tcatc.cal_fecha_limite+ tcs.con_plazorevision) as \"recsupinv_fr\",\n" + 
                "     case\n" + 
                "     when ti.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END  as \"recsupinv_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(ti.inv_fecha_emision_oficio,(tcatc.cal_fecha_limite+ tcatc.cal_cantidad_plazo)) as \"recsupinv_v\"\n" + 
                "     \n" + 
                "from T_INV_AVN tia \n" + 
                "inner join t_contrato tc on tia.con_id=tc.con_id\n" + 
                "left join T_INV_AVN_DERIVADA tiad on tiad.tia_numero = tia.tia_numero\n" + 
                "left join T_INV_AVN_SUPERVISADA tias on tias.tia_numero = tia.tia_numero\n" + 
                "left join T_INV ti on ti.tia_numero = tia.tia_numero\n" + 
                "inner join  t_concesionario tcc on tc.cnc_id = tcc.cnc_id\n" + 
                "inner join t_concesion tccs on tc.csi_id = tccs.csi_id \n" + 
                "inner join t_contrato tcs on tcs.con_id = tia.con_id \n" + 
                "inner join t_contrato_alerta tcatc on tcatc.con_id = tcs.con_id and  tcatc.csi_id = tccs.csi_id  \n" + 
                "where \n" + 
                "tcatc.cal_tipo=1 and \n" + 
                "tcatc.cal_estado=1 and \n" + 
                "tia.tia_numero is not null and \n" + 
                "tiad.tia_numero is not null and\n" + 
                "tias.tia_numero is not null and\n" + 
                "ti.tia_numero is not null";
    
            if(existeWhere){                
                if (param1 != null) {
                    query+= " AND tia.tin_id = " + param1.toString();                
                }
                if (param2 != null) {
                    query+= " AND EXTRACT(year from tia.tia_fecha_registro) = " + param2.toString();
                }
                if (param3 != null) {
                    query+=  " AND EXTRACT(month from tia.tia_fecha_registro) = " + param3.toString();
                }            
            }
    
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                ControlPlazosFlujoValorizacionesInversiones bean = new ControlPlazosFlujoValorizacionesInversiones();
                bean.setNomConcesion(rs.getString("nomConcesion"));
                bean.setNroValorizacion(rs.getString("nroValorizacion"));
                bean.setFechaRegistro(rs.getString("fechaRegistro"));
                bean.setIngval_pl(rs.getString("ingval_pl"));
                bean.setIngval_est(rs.getString("ingval_est"));
                bean.setIngval_v("ingval_v");
                bean.setDerval_fr("derval_fr");
                bean.setDerval_est("derval_est");
                bean.setRevssuper_fr("revssuper_fr");
                bean.setRevssuper_est("revssuper_est");
                bean.setRevssuper_v("revssuper_v");
                bean.setRecsupinv_fr("recsupinv_fr");
                bean.setRecsupinv_est("recsupinv_est");
                bean.setRecsupinv_v("recsupinv_v");
               
                getResultControlPlazoFlujoValorizacionesInversiones().add(bean);
            }
        }
        });
        return getResultControlPlazoFlujoValorizacionesInversiones();
    }
    @Override
    public List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getControlPlazosFlujoValorizacionesEmpresaSupervisora(int idTipoInfraestructura,
                                                                                                                     int anio,
                                                                                                                     int mes) throws SQLException {
        
        existeWhere=false;
        if (idTipoInfraestructura != -1) {
            existeWhere=true;
            param1 = idTipoInfraestructura;
        }else{
            param1 = null;
        }
        if (anio != -1) {
            existeWhere=true;
            param2 = anio;
        }else{
            param2 = null;
        }
        if (mes != -1) {
            existeWhere=true;
            param3 = mes;
        }else{
            param3 = null;
        }        
    
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException {
            String query =
                "select\n" + 
                "      tccs.csi_nombre as \"nomConcesion\", \n" + 
                "      tcc.cnc_nombre as \"nomConcesionario\",\n" + 
                "      tia.tia_numero as \"nroValorizacion\",\n" + 
                "      tia.tia_fecha_registro as \"fechaRegistro\",\n" + 
                "      --\n" + 
                "     tcatc.cal_fecha_limite AS \"ingval_pl\",\n" + 
                "     case\n" + 
                "     when tia.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END AS \"ingval_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(tia.tia_fecha_registro,tcatc.cal_fecha_limite) AS \"ingval_v\",\n" + 
                "     ---\n" + 
                "     tia.tia_fecha_vencimiento_plazo as \"derval_fr\",\n" + 
                "     case\n" + 
                "     when tiad.iad_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END AS \"derval_est\",\n" + 
                "     \n" + 
                "     --\n" + 
                "     tiad.iad_fecha_respuesta as \"revssuper_fr\",\n" + 
                "     case\n" + 
                "     when tias.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END as \"revssuper_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(tias.ias_fecha_registro,tiad.iad_fecha_respuesta) as \"revssuper_v\",\n" + 
                "     --\n" + 
                "     (tcatc.cal_fecha_limite+ tcs.con_plazorevision) as \"recsupinv_fr\",\n" + 
                "     case\n" + 
                "     when ti.tia_numero is null then 'NO REGISTRADO'\n" + 
                "     else 'REGISTRADO'\n" + 
                "     END  as \"recsupinv_est\",\n" + 
                "     pkg_reportes.fnc_getSiEsMayorAFechaActual(ti.inv_fecha_emision_oficio,(tcatc.cal_fecha_limite+ tcatc.cal_cantidad_plazo)) as \"recsupinv_v\"\n" + 
                "     \n" + 
                "from T_INV_AVN tia \n" + 
                "inner join t_contrato tc on tia.con_id=tc.con_id\n" + 
                "left join T_INV_AVN_DERIVADA tiad on tiad.tia_numero = tia.tia_numero\n" + 
                "left join T_INV_AVN_SUPERVISADA tias on tias.tia_numero = tia.tia_numero\n" + 
                "left join T_INV ti on ti.tia_numero = tia.tia_numero\n" + 
                "inner join  t_concesionario tcc on tc.cnc_id = tcc.cnc_id\n" + 
                "inner join t_concesion tccs on tc.csi_id = tccs.csi_id \n" + 
                "inner join t_contrato tcs on tcs.con_id = tia.con_id \n" + 
                "inner join t_contrato_alerta tcatc on tcatc.con_id = tcs.con_id and  tcatc.csi_id = tccs.csi_id  \n" + 
                "where \n" + 
                "tcatc.cal_tipo=1 and \n" + 
                "tcatc.cal_estado=1 and \n" + 
                "tia.tia_numero is not null and \n" + 
                "tiad.tia_numero is not null and\n" + 
                "tias.tia_numero is not null and\n" + 
                "ti.tia_numero is not null";
    
            if(existeWhere){                
                if (param1 != null) {
                    query+= " AND TIF.TIN_ID = = " + param1.toString();                
                }
                if (param2 != null) {
                    query+= " AND EXTRACT(year from TVS.TVS_FECHA_REGISTRO) = " + param2.toString();
                }
                if (param3 != null) {
                    query+=  " AND EXTRACT(month from TVS.TVS_FECHA_REGISTRO) = " + param3.toString();
                }            
            }
    
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                ControlPlazosFlujoValorizacionesEmpresaSupervisora bean = new ControlPlazosFlujoValorizacionesEmpresaSupervisora();
                bean.setNomEmpresaSupervisora(rs.getString("nomEmpresaSupervisora"));
                bean.setNomConcesion(rs.getString("nomConcesion"));
                bean.setNomModalidad(rs.getString("nomModalidad"));
                bean.setNomTipoInfraestructura(rs.getString("nomTipoInfraestructura"));
                bean.setPre_fecharegistro(rs.getString("pre_fecharegistro"));
                bean.setPre_montopresentado("pre_montopresentado");
                bean.setApro_fecharegistro("apro_fecharegistro");
                bean.setApro_montototalaprob("apro_montototalaprob");
               
                getResultControlPlazosFlujoValorizacionesEmpresaSupervisora().add(bean);
            }
        }
        });
        return getResultControlPlazosFlujoValorizacionesEmpresaSupervisora();
    }    
    
    @Override
        public List<AvaInvRecConConc> getAvaInvRecConConc(int anio, int trimestre, int idTipoEstructura, int idConcesion,
                                                          int idModalidad) throws SQLException {
            
            existeWhere=true;            
            
            /*
            if (anio != -1) {
                existeWhere=true;
                param1 = anio;
            }
            if (trimestre != -1) {
                
                param2 = trimestre;
            }*/
            if (idTipoEstructura != -1) {
                existeWhere=true;
                param3 = idTipoEstructura;
            }else{
                param3 = null;
            }
            if (idConcesion != -1) {
                existeWhere=true;
                param4 = idConcesion;
            }else{
                param4 = null;
            }
            if (idModalidad != -1) {
                existeWhere=true;
                param5 = idModalidad;
            }else{
                param5 = null;
            }

            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                String query =
                    "SELECT tbl.*, \n" + 
                    "       to_number((tbl.inversionAcumuladaAnnio*100)/tbl.totalCompromisoInv, '90D9') porcentajeCumplimiento\n" + 
                    "  FROM (\n" + 
                    "SELECT (SELECT tin.tin_nombre\n" + 
                    "          FROM t_infraestructura_tipo tin\n" + 
                    "         WHERE tin.tin_id = con.tin_id) tipoInfraestructura,\n" + 
                    "       csi.csi_nombre infraConcesionada, \n" + 
                    "       to_char(con.con_fecha_suscripcion, 'yyyy') fechaIniConcesion,\n" + 
                    "       to_char(con.con_plazoconcesion, 'dd/mm/yyyy') fechaPlazo, \n" + 
                    "       con.con_nota_plazoconcesion notaPlazo,\n" + 
                    "       to_char(con.con_fecha_suscripcion, 'mon-dd') fechaIniObras,\n" + 
                    "       (SELECT to_number(to_char(sum(decode(cco.mon_id, 1, (cco.cco_total / decode(nvl(cco.cco_tipo_cambio, 1), 0, 1)), 2, cco.cco_total)), '99999999999999D99'))\n" + 
                    "          FROM t_contrato_compromiso cco\n" + 
                    "         WHERE cco.cco_estado = 1\n" + 
                    "           AND cco.con_id = con.con_id) totalCompromisoInv,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND tia.tia_fecha_registro <= to_date('31/12/"+param1+"', 'dd/mm/yyyy')) inversionEjecutadaAcumAnnio,\n" + 
                    "           --////////////////\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,1)+", '00') || '/"+param1+"') inversionReconocidaMesUno,\n" + 
                    "           --///////////////\n" + 
                    "           (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,2)+", '00') || '/"+param1+ "') inversionReconocidaMesDos,\n" + 
                    "           --////////////\n" + 
                    "           (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,3)+", '00') || '/"+param1+"') inversionReconocidaMesTres,\n" + 
                    "        --/////////////////////\n" + 
                    "        (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,1)+", '00') || '/"+param1+"')+\n" + 
                    "           (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,2)+", '00') || '/"+param1+"')+\n" + 
                    "           (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'mm/yyyy') =  to_char("+obtenerNumeroMesTrimestre((Integer)param2,3)+", '00') || '/"+param1+"') sumaMeses,\n" + 
                    "           \n" + 
                    "        --////////////////////   \n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND to_char(tia.tia_fecha_registro, 'yyyy') = '"+param1+"') inversionReconocidaAnnio,\n" + 
                    "       (SELECT nvl(sum(to_number(tia.tia_monto_total_aprobado)),0)\n" + 
                    "          FROM t_inv_avn tia \n" + 
                    "         WHERE tia.iae_id in (4, 5)\n" + 
                    "           AND tia.con_id = con.con_id\n" + 
                    "           AND tia.tia_fecha_registro <= to_date('31/' || to_char(12, '00') || '/"+param1+"', 'dd/mm/yyyy')) inversionAcumuladaAnnio\n" + 
                    "  FROM t_contrato con, t_concesion csi\n" + 
                    " WHERE con.csi_id = csi.csi_id\n" + 
                    "   AND con.con_estado = 1\n" + 
                    "   AND csi.csi_estado = 1\n" + 
                    "   AND con.con_fecha_suscripcion is not null\n" ;
                   
                if(existeWhere){
                    /*
                    if (!param1.equals(null)) {
                        query+=  " AND EXTRACT(year from con.con_fecha_registro) = " + param1.toString();
                    } */   
                    if (param3 != null) {
                        query+= " AND con.tin_id = " + param3.toString();                        
                    }
                    if (param4 != null) {
                        query+= " AND con.csi_id = " + param4.toString();
                    }
                    if (param5 != null) {
                        query+=  " AND con.mco_id = " + param5.toString();
                    }                
                }
                query+="   ) tbl";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery(query);
                while (rs.next()) {
                    AvaInvRecConConc bean = new AvaInvRecConConc();
                    bean.setTipoInfraestructura(rs.getString("tipoInfraestructura"));
                    bean.setInfraConcesionada(rs.getString("infraConcesionada"));
                    bean.setFechaIniConcesion(rs.getString("fechaIniConcesion"));
                    bean.setFechaPlazo(rs.getString("fechaPlazo"));
                    bean.setNotaPlazo(rs.getString("notaPlazo"));
                    bean.setFechaIniObras(rs.getString("fechaIniObras"));
                    bean.setTotalCompromisoInv(rs.getInt("totalCompromisoInv"));
                    bean.setInversionEjecutadaAcumAnnio(rs.getInt("inversionEjecutadaAcumAnnio"));
                    bean.setInversionReconocidaMesUno(rs.getString("inversionReconocidaMesUno"));
                    bean.setInversionReconocidaMesDos(rs.getString("inversionReconocidaMesDos"));
                    bean.setInversionReconocidaMesTres(rs.getString("inversionReconocidaMesTres"));
                    bean.setSumaMeses(rs.getString("sumaMeses"));
                    bean.setInversionReconocidaAnnio(rs.getInt("inversionReconocidaAnnio"));
                    bean.setInversionAcumuladaAnnio(rs.getInt("inversionAcumuladaAnnio"));
                    bean.setPorcentajeCumplimiento(rs.getInt("porcentajeCumplimiento"));
                   
                    getResultAvaInvRecConConc().add(bean);
                }
            }
            });
            return getResultAvaInvRecConConc();
        }

        public String obtenerNumeroMesTrimestre(int numeroTrimestre,int numeroMesObtener){
            int mesPreInicialDelTrimestre=(3*numeroTrimestre)-3;
            
            return ""+(mesPreInicialDelTrimestre+numeroMesObtener);
        }    

    public static List<EmpSupInf> getResult() {
        return result;
    }

    public static void setResult(List<EmpSupInf> result) {
        ReportesDAOImpl.result = result;
    }

    public static List<InversionesTipoConcepto> getResultInvTipoConcep() {
        return resultInvTipoConcep;
    }

    public static void setResultInvTipoConcep(List<InversionesTipoConcepto> resultInvTipoConcep) {
        ReportesDAOImpl.resultInvTipoConcep = resultInvTipoConcep;
    }

    public static List<InversionesTipoConceptoDetalle> getResultInvTipoConcepDet() {
        return resultInvTipoConcepDet;
    }

    public static void setResultInvTipoConcepDet(List<InversionesTipoConceptoDetalle> resultInvTipoConcepDet) {
        ReportesDAOImpl.resultInvTipoConcepDet = resultInvTipoConcepDet;
    }


    public static List<TrazabilidadPrincipalesEventos> getResultTrazaPrinEventos() {
        return resultTrazaPrinEventos;
    }

    public static void setResultTrazaPrinEventos(List<TrazabilidadPrincipalesEventos> resultTrazaPrinEventos) {
        ReportesDAOImpl.resultTrazaPrinEventos = resultTrazaPrinEventos;
    }


    public static List<EmpSupInfAeropuerto> getResultEmpSupInfAeropuerto() {
        return resultEmpSupInfAeropuerto;
    }

    public static void setResultEmpSupInfAeropuerto(List<EmpSupInfAeropuerto> resultEmpSupInfAeropuerto) {
        ReportesDAOImpl.resultEmpSupInfAeropuerto = resultEmpSupInfAeropuerto;
    }

    public static List<AvaInvConConc> getResultAvaInvConConc() {
        return resultAvaInvConConc;
    }

    public static void setResultAvaInvConConc(List<AvaInvConConc> resultAvaInvConConc) {
        ReportesDAOImpl.resultAvaInvConConc = resultAvaInvConConc;
    }

    public static List<ControlPlazosFlujoValorizacionesInversiones> getResultControlPlazoFlujoValorizacionesInversiones() {
        return resultControlPlazoFlujoValorizacionesInversiones;
    }

    public static void setResultControlPlazoFlujoValorizacionesInversiones(List<ControlPlazosFlujoValorizacionesInversiones> resultControlPlazoFlujoValorizacionesInversiones) {
        ReportesDAOImpl.resultControlPlazoFlujoValorizacionesInversiones = resultControlPlazoFlujoValorizacionesInversiones;
    }


    public static List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getResultControlPlazosFlujoValorizacionesEmpresaSupervisora() {
        return resultControlPlazosFlujoValorizacionesEmpresaSupervisora;
    }

    public static void setResultControlPlazosFlujoValorizacionesEmpresaSupervisora(List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> resultControlPlazosFlujoValorizacionesEmpresaSupervisora) {
        ReportesDAOImpl.resultControlPlazosFlujoValorizacionesEmpresaSupervisora = resultControlPlazosFlujoValorizacionesEmpresaSupervisora;
    }

    public static List<AvaInvRecConConc> getResultAvaInvRecConConc() {
        return resultAvaInvRecConConc;
    }

    public static void setResultAvaInvRecConConc(List<AvaInvRecConConc> resultAvaInvRecConConc) {
        ReportesDAOImpl.resultAvaInvRecConConc = resultAvaInvRecConConc;
    }
}
