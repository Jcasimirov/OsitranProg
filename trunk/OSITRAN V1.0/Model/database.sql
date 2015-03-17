DROP TABLE T_USUARIO PURGE;
DROP TABLE T_CONTRATO_ADENDA PURGE;
DROP TABLE T_CONTRATO_ANEXO PURGE;
DROP TABLE T_CONTRATO_VALORIZACION PURGE;
DROP TABLE T_EMPRESA_SUPERVISORA PURGE;
DROP TABLE T_ROL_OPCIONES PURGE;
DROP TABLE T_TIPO_CAMBIO PURGE;
DROP TABLE T_CONCEPTO_INVERSION PURGE;
DROP TABLE T_CONCEPTO_VALORIZACION PURGE;
DROP TABLE T_CONTRATO PURGE;
DROP TABLE T_INFRAESTRUCTURA_TIPO_PLANTIL PURGE;
DROP TABLE T_INVERSION_TIPO PURGE;
DROP TABLE T_MEN PURGE;
DROP TABLE T_MODALIDAD_CONCESION PURGE;
DROP TABLE T_MONEDA PURGE;
DROP TABLE T_ROL PURGE;
DROP TABLE T_INFRAESTRUCTURA_TIPO PURGE;
DROP TABLE T_CONCESIONARIO PURGE;
DROP TABLE T_CARGO PURGE;
DROP TABLE T_TIPO_DOCUMENTO PURGE;
DROP TABLE T_EXP_RECONOCIMIENTO_DETALLE PURGE;
DROP TABLE T_EXP_RECONOCIMIENTO PURGE;
DROP TABLE T_IMPUESTO PURGE;
DROP TABLE T_INVERSION PURGE;
DROP TABLE T_INVERSION_TIPO_DESCRIPCION PURGE;
DROP TABLE T_UNIVERSO_TEMAS_CONTRATO PURGE;
DROP TABLE T_CONCESION PURGE;
DROP TABLE T_INFRAESTRUCTURA PURGE;

CREATE TABLE T_IGV
   (	IGV_ID NUMBER NOT NULL ENABLE, 
	IGV_PORCENTAJE NUMBER(5,2) NOT NULL ENABLE, 
	IGV_FECHAVIGENCIA DATE, 
	IGV_FECHACADUCIDAD DATE, 
	IGV_ESTADO NUMBER, 
	IGV_FECHA_ALTA DATE, 
	IGV_USUARIO_ALTA VARCHAR2(50 BYTE), 
	IGV_FECHA_CAMBIO DATE, 
	IGV_USUARIO_CAMBIO VARCHAR2(50 BYTE), 
	IGV_FECHA_BAJA DATE, 
	IGV_USUARIO_BAJA VARCHAR2(50 BYTE), 
	IGV_TERMINAL VARCHAR2(20 BYTE),
        CONSTRAINT PK_T_IGV PRIMARY KEY (IGV_ID));
        
CREATE TABLE t_tipo_documento
(
	tdo_id		  NUMBER  NOT NULL ,
	tdo_nombre	  VARCHAR2(100)  NOT NULL ,
	tdo_descripcion	  VARCHAR2(100)  NOT NULL ,
	tdo_estado	  NUMBER  NOT NULL ,
	tdo_fecha_alta	  DATE  NOT NULL ,
	tdo_usuario_alta  VARCHAR2(20)  NULL ,
	tdo_fecha_cambio  DATE  NULL ,
	tdo_usuario_cambio  VARCHAR2(20)  NULL ,
	tdo_fecha_baja	  DATE  NULL ,
	tdo_usuario_baja  VARCHAR2(20)  NULL ,
	tdo_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (tdo_id)
);




CREATE TABLE T_INFRAESTRUCTURA_TIPO
   ( TIN_NOMBRE VARCHAR2(50 BYTE) NOT NULL ENABLE,
    TIN_DESCRIPCION VARCHAR2(100 BYTE) NOT NULL ENABLE,
    TIN_ID NUMBER NOT NULL ENABLE,
    TIN_ESTADO NUMBER DEFAULT 0 NOT NULL ENABLE,
    TIN_FECHA_ALTA DATE,
    TIN_USUARIO_ALTA VARCHAR2(20 BYTE),
    TIN_FECHA_CAMBIO DATE,
    TIN_USUARIO_CAMBIO VARCHAR2(20 BYTE),
    TIN_FECHA_BAJA DATE,
    TIN_USUARIO_BAJA VARCHAR2(20 BYTE),
    TIN_TERMINAL VARCHAR2(20 BYTE),
    CONSTRAINT PK_INFRAESTRUCTURA_TIPO PRIMARY KEY (TIN_ID)
   );



CREATE TABLE t_cargo
(
	crg_id		  NUMBER  NOT NULL ,
	crg_nombre	  VARCHAR2(100)  NOT NULL ,
	crg_descripcion	  VARCHAR2(100)  NOT NULL ,
	crg_estado	  NUMBER  NOT NULL ,
	crg_fecha_alta	  DATE  NOT NULL ,
	crg_usuario_alta  VARCHAR2(20)  NULL ,
	crg_fecha_cambio  DATE  NULL ,
	crg_usuario_cambio  VARCHAR2(20)  NULL ,
	crg_fecha_baja	  DATE  NULL ,
	crg_usuario_baja  VARCHAR2(20)  NULL ,
	crg_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (crg_id)
);



CREATE TABLE t_supervisor_inversiones
(
	tsi_id		  NUMBER  NOT NULL ,
	tsi_nombre	  VARCHAR2(100)  NOT NULL ,
	tsi_siglas	  VARCHAR2(4000)  NOT NULL ,
	tsi_descripcion	  VARCHAR2(100)  NULL ,
	tsi_telefono	  VARCHAR2(20)  NULL ,
	tsi_terminal	  VARCHAR2(20)  NULL ,
	tsi_direccion	  VARCHAR2(20)  NULL ,
	tsi_nro_documento  VARCHAR2(20)  NULL ,
	tsi_correo	  VARCHAR2(20)  NULL ,
	tsi_encargado	  NUMBER  NOT NULL ,
	tsi_habilitado	  NUMBER  NOT NULL ,
	tdo_id		  NUMBER  NULL ,
	tin_id		  NUMBER  NULL ,
	tsi_estado	  NUMBER  NOT NULL ,
	tsi_fecha_alta	  DATE  NOT NULL ,
	tsi_usuario_alta  VARCHAR2(20)  NULL ,
	tsi_fecha_cambio  DATE  NULL ,
	tsi_usuario_cambio  VARCHAR2(20)  NULL ,
	tsi_fecha_baja	  DATE  NULL ,
	tsi_usuario_baja  VARCHAR2(20)  NULL ,
	crg_id		  NUMBER  NULL ,
 PRIMARY KEY (tsi_id),
 FOREIGN KEY (tdo_id) REFERENCES t_tipo_documento(tdo_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id),
 FOREIGN KEY (crg_id) REFERENCES t_cargo(crg_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id)
);



CREATE TABLE t_modalidad_concesion
(
	mco_id		  NUMBER  NOT NULL ,
	mco_nombre	  VARCHAR2(100)  NOT NULL ,
	mco_descripcion	  VARCHAR2(100)  NOT NULL ,
	mco_estado	  NUMBER  NOT NULL ,
	mco_fecha_alta	  DATE  NOT NULL ,
	mco_usuario_alta  VARCHAR2(20)  NULL ,
	mco_fecha_cambio  DATE  NULL ,
	mco_usuario_cambio  VARCHAR2(20)  NULL ,
	mco_fecha_baja	  DATE  NULL ,
	mco_usuario_baja  VARCHAR2(20)  NULL ,
	mco_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (mco_id)
);



CREATE TABLE t_concesionario
(
	cnc_id		  NUMBER  NOT NULL ,
	cnc_nombre	  VARCHAR2(100)  NOT NULL ,
	cnc_descripcion	  VARCHAR2(100)  NOT NULL ,
	cnc_estado	  NUMBER  NOT NULL ,
	cnc_telefono	  VARCHAR2(15)  NULL ,
	cnc_terminal	  VARCHAR2(20)  NULL ,
	cnc_direccion	  VARCHAR2(20)  NULL ,
	cnc_correo	  VARCHAR2(20)  NULL ,
	cnc_representante_legal  VARCHAR2(20)  NULL ,
	cnc_fecha_alta	  DATE  NOT NULL ,
	cnc_usuario_alta  VARCHAR2(20)  NULL ,
	cnc_fecha_cambio  DATE  NULL ,
	cnc_usuario_cambio  VARCHAR2(20)  NULL ,
	cnc_fecha_baja	  DATE  NULL ,
	cnc_usuario_baja  VARCHAR2(20)  NULL ,
	cnc_nro_documento  VARCHAR2(20)  NULL ,
	tdo_id		  NUMBER  NULL ,
 PRIMARY KEY (cnc_id),
 FOREIGN KEY (tdo_id) REFERENCES t_tipo_documento(tdo_id)
);



CREATE TABLE t_moneda
(
	mon_id		  NUMBER  NOT NULL ,
	mon_nombre	  VARCHAR2(50)  NOT NULL ,
	mon_simbolo	  VARCHAR2(3)  NULL ,
	mon_estado	  NUMBER  NOT NULL ,
	mon_fecha_alta	  DATE  NOT NULL ,
	mon_usuario_alta  VARCHAR2(20)  NULL ,
	mon_fecha_cambio  DATE  NULL ,
	mon_usuario_cambio  VARCHAR2(20)  NULL ,
	mon_fecha_baja	  DATE  NULL ,
	mon_usuario_baja  VARCHAR2(20)  NULL ,
	mon_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (mon_id)
);



CREATE TABLE T_CONCESION
   (CSI_ID NUMBER,
    CSI_NOMBRE VARCHAR2(50 BYTE),
    CSI_FECHA_ALTA DATE,
    CSI_USUARIO_ALTA VARCHAR2(50 BYTE),
    CSI_FECHA_CAMBIO DATE,
    CSI_USUARIO_CAMBIO VARCHAR2(50 BYTE),
    CSI_FECHA_BAJA DATE,
    CSI_USUARIO_BAJA VARCHAR2(50 BYTE),
    CSI_TERMINAL VARCHAR2(50 BYTE),
    TIN_ID NUMBER,
    CSI_ESTADO NUMBER,
    CONSTRAINT PK_T_CONCESION PRIMARY KEY (CSI_ID),
    CONSTRAINT FK_T_INFRAESTRUCTURA_TIPO FOREIGN KEY (TIN_ID)
    REFERENCES T_INFRAESTRUCTURA_TIPO (TIN_ID) ENABLE
   );



CREATE TABLE t_periodo
(
	per_id		  NUMBER  NOT NULL ,
	per_nombre	  VARCHAR2(100)  NOT NULL ,
	per_descripcion	  VARCHAR2(100)  NOT NULL ,
	per_cantidadendías  VARCHAR2(255)  NULL ,
	per_estado	  NUMBER  NOT NULL ,
	per_fecha_alta	  DATE  NOT NULL ,
	per_usuario_alta  VARCHAR2(20)  NULL ,
	per_fecha_cambio  DATE  NULL ,
	per_usuario_cambio  VARCHAR2(20)  NULL ,
	per_fecha_baja	  DATE  NULL ,
	per_usuario_baja  VARCHAR2(20)  NULL ,
	per_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (per_id)
);



CREATE TABLE t_contrato
(
	con_id		  NUMBER  NOT NULL ,
	con_tipo	  NUMBER  NULL ,
	con_numero	  NUMBER  NULL ,
	mco_id		  NUMBER  NOT NULL ,
	cnc_id		  NUMBER  NULL ,
	con_estado	  NUMBER  NOT NULL ,
	con_fecha_alta	  DATE  NOT NULL ,
	con_usuario_alta  VARCHAR2(20)  NULL ,
	con_fecha_cambio  DATE  NULL ,
	con_usuario_cambio  VARCHAR2(20)  NULL ,
	con_fecha_baja	  DATE  NULL ,
	con_usuario_baja  VARCHAR2(20)  NULL ,
	con_oficio	  VARCHAR2(4000)  NOT NULL ,
	con_terminal	  VARCHAR2(20)  NULL ,
	mon_id		  NUMBER  NULL ,
	con_total_valorizacion  NUMBER  NULL ,
	con_domicilio_legal  VARCHAR2(4000)  NOT NULL ,
	csi_id		  NUMBER  NULL ,
	con_fecha_suscripcion  DATE  NULL ,
	con_diames	  NUMBER  NULL ,
	per_id		  NUMBER  NULL ,
	con_plazorevision  NUMBER  NULL ,
	con_tipodias	  NUMBER(1)  NOT NULL ,
	con_plazoconcesion  DATE  NULL ,
	con_pdfcontrato	  VARCHAR2(255)  NULL ,
	con_ficharesumen  VARCHAR2(255)  NULL ,
 PRIMARY KEY (con_id),
 FOREIGN KEY (mco_id) REFERENCES t_modalidad_concesion(mco_id),
 FOREIGN KEY (cnc_id) REFERENCES t_concesionario(cnc_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id),
 FOREIGN KEY (csi_id) REFERENCES t_concesion(csi_id),
 FOREIGN KEY (per_id) REFERENCES t_periodo(per_id)
);



  CREATE TABLE T_INFRAESTRUCTURA
   ( INF_ID NUMBER,
    INF_NOMBRE VARCHAR2(100 BYTE),
    CSI_ID NUMBER,
    INF_FECHA_ALTA DATE,
    INF_USUARIO_ALTA VARCHAR2(50 BYTE),
    INF_FECHA_CAMBIO DATE,
    INF_USUARIO_CAMBIO VARCHAR2(50 BYTE),
    INF_FECHA_BAJA DATE,
    INF_USUARIO_BAJA VARCHAR2(50 BYTE),
    INF_TERMINAL VARCHAR2(50 BYTE),
    INF_ESTADO NUMBER,
    CONSTRAINT PK_T_INFRAESTRUCTURA PRIMARY KEY (INF_ID),
    CONSTRAINT FK_T_CONCESION FOREIGN KEY (CSI_ID)
    REFERENCES T_CONCESION (CSI_ID) ENABLE
   ) ;



CREATE TABLE t_empresa_supervisora
(
	sup_id		  NUMBER  NOT NULL ,
	sup_nombre	  VARCHAR2(100)  NOT NULL ,
	sup_descripcion	  VARCHAR2(100)  NOT NULL ,
	sup_estado	  NUMBER  NOT NULL ,
	sup_telefono	  VARCHAR2(20)  NULL ,
	sup_terminal	  VARCHAR2(20)  NULL ,
	sup_direccion	  VARCHAR2(20)  NULL ,
	sup_correo	  VARCHAR2(20)  NULL ,
	sup_representante_legal  VARCHAR2(20)  NULL ,
	sup_fecha_alta	  DATE  NOT NULL ,
	sup_usuario_alta  VARCHAR2(20)  NULL ,
	sup_fecha_cambio  DATE  NULL ,
	sup_usuario_cambio  VARCHAR2(20)  NULL ,
	sup_fecha_baja	  DATE  NULL ,
	sup_usuario_baja  VARCHAR2(20)  NULL ,
	sup_nro_documento  VARCHAR2(20)  NULL ,
	tdo_id		  NUMBER  NULL ,
	sup_jefe_supervision  VARCHAR2(4000)  NOT NULL ,
 PRIMARY KEY (sup_id),
 FOREIGN KEY (tdo_id) REFERENCES t_tipo_documento(tdo_id)
);



CREATE TABLE t_inversion
(
	inv_id		  NUMBER  NOT NULL ,
	inv_nombre	  VARCHAR2(100)  NOT NULL ,
	inv_descripcion	  VARCHAR2(100)  NOT NULL ,
	sup_id		  NUMBER  NULL ,
	inv_estado	  NUMBER  NOT NULL ,
	inv_fecha_alta	  DATE  NOT NULL ,
	inv_usuario_alta  VARCHAR2(20)  NULL ,
	inv_fecha_cambio  DATE  NULL ,
	inv_usuario_cambio  VARCHAR2(20)  NULL ,
	inv_fecha_baja	  DATE  NULL ,
	inv_usuario_baja  VARCHAR2(20)  NULL ,
	inv_terminal	  VARCHAR2(20)  NULL ,
	inf_id		  NUMBER  NULL ,
 PRIMARY KEY (inv_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (sup_id) REFERENCES t_empresa_supervisora(sup_id)
);



CREATE TABLE t_contrato_cao
(
	cao_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	cao_fecha	  DATE  NULL ,
	cao_oficio	  VARCHAR2(20)  NULL ,
	cao_monto	  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
 PRIMARY KEY (cao_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_contrato_para_supervisora
(
	cps_nro_de_contrato  NUMBER  NOT NULL ,
	cps_fecha_inicio  DATE  NULL ,
	cps_fecha_suscripcion  DATE  NULL ,
	cps_plazo_contrato  NUMBER  NULL ,
	cps_monto_contratado  NUMBER  NULL ,
	cps_adelanto_otorgado  NUMBER  NULL ,
	cps_fecha_adelanto  DATE  NULL ,
	cps_penalidades	  VARCHAR2(4000)  NOT NULL ,
	cps_caducidad	  VARCHAR2(4000)  NOT NULL ,
	cps_garantias	  VARCHAR2(4000)  NOT NULL ,
	cps_archivo_pdf	  NUMBER  NULL ,
	cps_estado	  NUMBER  NOT NULL ,
	cps_fecha_alta	  DATE  NOT NULL ,
	cps_usuario_alta  VARCHAR2(20)  NULL ,
	cps_fecha_cambio  DATE  NULL ,
	cps_usuario_cambio  VARCHAR2(20)  NULL ,
	cps_fecha_baja	  DATE  NULL ,
	cps_usuario_baja  VARCHAR2(20)  NULL ,
	cps_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (cps_nro_de_contrato)
);



CREATE TABLE t_contrato_etapa_periodo
(
	cvl_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	sup_id		  NUMBER  NULL ,
	cps_nro_de_contrato  NUMBER  NULL ,
	cvl_fecha	  DATE  NULL ,
	cep_avance	  VARCHAR2(20)  NULL ,
	cva_monto	  NUMBER(14,2)  NOT NULL ,
	cep_fecha_inicio  DATE  NULL ,
	cep_duración	  NUMBER  NULL ,
 PRIMARY KEY (cvl_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (sup_id) REFERENCES t_empresa_supervisora(sup_id),
 FOREIGN KEY (cps_nro_de_contrato) REFERENCES t_contrato_para_supervisora(cps_nro_de_contrato)
);



CREATE TABLE t_inv_avn_derivada
(
	iad_numero	  NUMBER  NOT NULL ,
	iad_fecha_inicio  DATE  NULL ,
	iad_fecha_fin	  DATE  NULL ,
	iad_hr		  NUMBER  NULL ,
	iad_anyo	  NUMBER(4)  NOT NULL ,
	iad_fecha_registro  DATE  NULL ,
	iad_asunto	  VARCHAR2(4000)  NOT NULL ,
	iad_plazo_en_días  NUMBER  NULL ,
	iad_dias_habiles  NUMBER(1)  NULL ,
	iad_estado	  NUMBER  NOT NULL ,
	iad_fecha_alta	  DATE  NOT NULL ,
	iad_usuario_alta  VARCHAR2(20)  NULL ,
	iad_fecha_cambio  DATE  NULL ,
	iad_usuario_cambio  VARCHAR2(20)  NULL ,
	iad_fecha_baja	  DATE  NULL ,
	iad_usuario_baja  VARCHAR2(20)  NULL ,
	iad_terminal	  VARCHAR2(20)  NULL ,
	iad_fecha_vencimiento  DATE  NULL ,
	csi_id		  NUMBER  NULL ,
	tin_id		  NUMBER  NULL ,
	mco_id		  NUMBER  NULL ,
	inf_id		  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
	con_id		  NUMBER  NULL ,
	cvl_id		  NUMBER  NULL ,
	nro_oficio	  VARCHAR2(20)  NULL ,
	iad_nro_carta	  VARCHAR2(20)  NULL ,
	iad_plazo_días	  NUMBER  NULL ,
	iad_reg_salida	  VARCHAR2(20)  NULL ,
	iad_fecha_emisión  DATE  NULL ,
	iad_fecha_recepción  DATE  NULL ,
	iad_fecha_respuesta  DATE  NULL ,
	iad_tipo_días	  NUMBER  NULL ,
 PRIMARY KEY (iad_numero),
 FOREIGN KEY (csi_id) REFERENCES t_concesion(csi_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id),
 FOREIGN KEY (mco_id) REFERENCES t_modalidad_concesion(mco_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id),
 FOREIGN KEY (cvl_id,con_id) REFERENCES t_contrato_etapa_periodo(cvl_id,con_id)
);



CREATE TABLE t_inv_avn_derivada_detalle
(
	iad_numero	  NUMBER  NOT NULL ,
	iad_total	  NUMBER(14,2)  NOT NULL ,
	iad_monto_presentado  NUMBER(14,2)  NOT NULL ,
	iad_igv		  NUMBER(14,2)  NOT NULL ,
 PRIMARY KEY (iad_numero),
 FOREIGN KEY (iad_numero) REFERENCES t_inv_avn_derivada(iad_numero)
);



CREATE TABLE t_opciones
(
	opc_id		  NUMBER  NOT NULL ,
	opc_nombre	  VARCHAR2(4000)  NOT NULL ,
	opc_descripcion	  VARCHAR2(4000)  NOT NULL ,
	opc_formulario	  VARCHAR2(4000)  NOT NULL ,
	opc_padre	  NUMBER  NULL ,
	opc_estado	  NUMBER  NOT NULL ,
	opc_fecha_alta	  DATE  NOT NULL ,
	opc_usuario_alta  VARCHAR2(20)  NULL ,
	opc_fecha_cambio  DATE  NULL ,
	opc_usuario_cambio  VARCHAR2(20)  NULL ,
	opc_fecha_baja	  DATE  NULL ,
	opc_usuario_baja  VARCHAR2(20)  NULL ,
	opc_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (opc_id)
);



CREATE TABLE t_rol
(
	rol_id		  NUMBER  NOT NULL ,
	rol_nombre	  VARCHAR2(100)  NOT NULL ,
	rol_descripcion	  VARCHAR2(100)  NOT NULL ,
	rol_estado	  NUMBER  NOT NULL ,
	rol_fecha_alta	  DATE  NOT NULL ,
	rol_usuario_alta  VARCHAR2(20)  NULL ,
	rol_fecha_cambio  DATE  NULL ,
	rol_usuario_cambio  VARCHAR2(20)  NULL ,
	rol_fecha_baja	  DATE  NULL ,
	rol_usuario_baja  VARCHAR2(20)  NULL ,
	rol_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (rol_id)
);



CREATE TABLE t_rol_opciones
(
	rol_id		  NUMBER  NOT NULL ,
	opc_id		  NUMBER  NOT NULL ,
	tro_consultar	  NUMBER  NOT NULL ,
	tro_agregar	  NUMBER  NOT NULL ,
	tro_modificar	  NUMBER  NOT NULL ,
	tro_eliminar	  NUMBER  NOT NULL ,
	tro_descripcion	  VARCHAR2(4000)  NOT NULL ,
	tro_estado	  NUMBER  NOT NULL ,
	tro_fecha_alta	  DATE  NOT NULL ,
	tro_usuario_alta  VARCHAR2(20)  NULL ,
	tro_fecha_cambio  DATE  NULL ,
	tro_usuario_cambio  VARCHAR2(20)  NULL ,
	tro_fecha_baja	  DATE  NULL ,
	tro_usuario_baja  VARCHAR2(20)  NULL ,
	tro_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (rol_id,opc_id),
 FOREIGN KEY (opc_id) REFERENCES t_opciones(opc_id),
 FOREIGN KEY (rol_id) REFERENCES t_rol(rol_id)
);



CREATE TABLE t_avance_inversion_web
(
	iwc_id		  NUMBER  NOT NULL ,
	inf_id		  NUMBER  NOT NULL ,
	mco_id		  NUMBER  NOT NULL ,
	tin_id		  NUMBER  NOT NULL ,
	csi_id		  NUMBER  NOT NULL ,
	inv_id		  NUMBER  NULL ,
	iwc_fecha_inicio  DATE  NULL ,
	iwc_fecha_fin	  DATE  NULL ,
	mon_id		  NUMBER  NULL ,
 PRIMARY KEY (iwc_id),
 FOREIGN KEY (csi_id) REFERENCES t_concesion(csi_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id),
 FOREIGN KEY (mco_id) REFERENCES t_modalidad_concesion(mco_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id),
 FOREIGN KEY (mco_id) REFERENCES t_modalidad_concesion(mco_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_concepto_valorizacion
(
	cva_id		  NUMBER  NOT NULL ,
	cva_nombre	  VARCHAR2(100)  NOT NULL ,
	cva_descripcion	  VARCHAR2(100)  NOT NULL ,
	cva_estado	  NUMBER  NOT NULL ,
	cva_fecha_alta	  DATE  NOT NULL ,
	cva_usuario_alta  VARCHAR2(20)  NULL ,
	cva_fecha_cambio  DATE  NULL ,
	cva_usuario_cambio  VARCHAR2(20)  NULL ,
	cva_fecha_baja	  DATE  NULL ,
	cva_usuario_baja  VARCHAR2(20)  NULL ,
	cva_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (cva_id)
);



CREATE TABLE t_avance_inversion_web_detalle
(
	iwc_id		  NUMBER  NOT NULL ,
	iwd_id		  NUMBER  NULL ,
	cva_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	iwd_neto	  NUMBER(14,2)  NOT NULL ,
	iwd_igv		  NUMBER(14,2)  NOT NULL ,
	iwd_total	  NUMBER(14,2)  NOT NULL ,
 PRIMARY KEY (iwc_id),
 FOREIGN KEY (iwc_id) REFERENCES t_avance_inversion_web(iwc_id),
 FOREIGN KEY (cva_id) REFERENCES t_concepto_valorizacion(cva_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_contrato_entrega
(
	ent_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	ent_entrega	  VARCHAR2(4000)  NOT NULL ,
	ent_descripcion	  VARCHAR2(4000)  NOT NULL ,
	ent_fecha	  DATE  NULL ,
 PRIMARY KEY (ent_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id)
);



CREATE TABLE t_alerta
(
	ale_id		  NUMBER  NOT NULL ,
	tin_id		  NUMBER  NULL ,
	ale_nombre	  VARCHAR2(4000)  NOT NULL ,
	ale_fecha_limite  DATE  NULL ,
	ale_dias_restantes  NUMBER  NULL ,
	ale_dias_de_exceso  NUMBER  NULL ,
	ale_tipo	  NUMBER  NULL ,
	ale_estado	  NUMBER  NOT NULL ,
	ale_fecha_alta	  DATE  NOT NULL ,
	ale_usuario_alta  VARCHAR2(20)  NULL ,
	ale_fecha_cambio  DATE  NULL ,
	ale_usuario_cambio  VARCHAR2(20)  NULL ,
	ale_fecha_baja	  DATE  NULL ,
	ale_usuario_baja  VARCHAR2(20)  NULL ,
	ale_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (ale_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id)
);



CREATE TABLE t_alerta_estado
(
	ale_id		  NUMBER  NOT NULL ,
	eal_id		  NUMBER  NOT NULL ,
	per_estado	  NUMBER  NOT NULL ,
	eal_fecha	  DATE  NULL ,
 PRIMARY KEY (ale_id,eal_id),
 FOREIGN KEY (eal_id) REFERENCES t_alerta(ale_id)
);



CREATE TABLE t_contrato_hito
(
	hto_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	hto_fecha	  DATE  NULL ,
	hto_oficio	  VARCHAR2(20)  NULL ,
	hto_monto	  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
	sup_id		  NUMBER  NULL ,
 PRIMARY KEY (hto_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id),
 FOREIGN KEY (sup_id) REFERENCES t_empresa_supervisora(sup_id)
);



CREATE TABLE t_inv_avn_supervisada
(
	ias_numero	  NUMBER  NOT NULL ,
	csi_id		  NUMBER  NULL ,
	tin_id		  NUMBER  NULL ,
	inf_id		  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
	con_id		  NUMBER  NULL ,
	cvl_id		  NUMBER  NULL ,
	ias_hr		  NUMBER  NULL ,
	ias_anyo	  NUMBER(4)  NOT NULL ,
	ias_fecha_registro  DATE  NULL ,
	ias_estado	  NUMBER  NOT NULL ,
	ias_fecha_alta	  DATE  NOT NULL ,
	ias_usuario_alta  VARCHAR2(20)  NULL ,
	ias_fecha_cambio  DATE  NULL ,
	ias_usuario_cambio  VARCHAR2(20)  NULL ,
	ias_fecha_baja	  DATE  NULL ,
	ias_usuario_baja  VARCHAR2(20)  NULL ,
	ias_terminal	  VARCHAR2(20)  NULL ,
	ias_nro_oficio	  VARCHAR2(20)  NULL ,
	ias_nro_carta	  VARCHAR2(20)  NULL ,
	ias_plazo_días	  NUMBER  NULL ,
	ias_reg_salida	  VARCHAR2(20)  NULL ,
	ias_fecha_emisión  DATE  NULL ,
	ias_fecha_recepción  DATE  NULL ,
	ias_fecha_respuesta  DATE  NULL ,
	ias_observaciones  VARCHAR2(4000)  NOT NULL ,
 PRIMARY KEY (ias_numero),
 FOREIGN KEY (csi_id) REFERENCES t_concesion(csi_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id),
 FOREIGN KEY (cvl_id,con_id) REFERENCES t_contrato_etapa_periodo(cvl_id,con_id)
);



CREATE TABLE t_inv_avn_supervisada_detalle
(
	ias_numero	  NUMBER  NOT NULL ,
	tia_total	  NUMBER(14,2)  NOT NULL ,
	Monto_presentado  NUMBER(14,2)  NOT NULL ,
	IGV		  NUMBER(14,2)  NOT NULL ,
	inf_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
 PRIMARY KEY (ias_numero),
 FOREIGN KEY (ias_numero) REFERENCES t_inv_avn_supervisada(ias_numero),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_contrato_ppo
(
	ppo_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	ppo_fecha	  DATE  NULL ,
	ppo_oficio	  VARCHAR2(20)  NULL ,
	ppo_monto	  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
 PRIMARY KEY (ppo_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id)
);



CREATE TABLE t_inv_avn
(
	tia_numero	  NUMBER  NOT NULL ,
	con_id		  NUMBER  NULL ,
	tia_fecha_inicio  DATE  NULL ,
	tia_fecha_fin	  DATE  NULL ,
	inf_id		  NUMBER  NULL ,
	inv_id		  NUMBER  NULL ,
	csi_id		  NUMBER  NULL ,
	tin_id		  NUMBER  NULL ,
	mco_id		  NUMBER  NULL ,
	tia_hr		  NUMBER  NULL ,
	tia_anyo	  NUMBER(4)  NOT NULL ,
	tia_fecha_registro  DATE  NULL ,
	tia_asunto	  VARCHAR2(4000)  NOT NULL ,
	tia_plazo_en_días  NUMBER  NULL ,
	tia_dias_habiles  NUMBER(1)  NULL ,
	cnv_estado	  NUMBER  NOT NULL ,
	cnv_fecha_alta	  DATE  NOT NULL ,
	cnv_usuario_alta  VARCHAR2(20)  NULL ,
	cnv_fecha_cambio  DATE  NULL ,
	cnv_usuario_cambio  VARCHAR2(20)  NULL ,
	cnv_fecha_baja	  DATE  NULL ,
	cnv_usuario_baja  VARCHAR2(20)  NULL ,
	cnv_terminal	  VARCHAR2(20)  NULL ,
	tia_fecha_vencimiento_plazo  DATE  NULL ,
	cvl_id		  NUMBER  NULL ,
 PRIMARY KEY (tia_numero),
 FOREIGN KEY (cvl_id,con_id) REFERENCES t_contrato_etapa_periodo(cvl_id,con_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (csi_id) REFERENCES t_concesion(csi_id),
 FOREIGN KEY (tin_id) REFERENCES t_infraestructura_tipo(tin_id),
 FOREIGN KEY (mco_id) REFERENCES t_modalidad_concesion(mco_id),
 FOREIGN KEY (inf_id) REFERENCES t_infraestructura(inf_id),
 FOREIGN KEY (inv_id) REFERENCES t_inversion(inv_id)
);



CREATE TABLE t_concepto_inversion
(
	cnv_id		  NUMBER  NOT NULL ,
	cnv_nombre	  VARCHAR2(50)  NOT NULL ,
	cnv_descripcion	  VARCHAR2(100)  NOT NULL ,
	cnv_estado	  NUMBER  NOT NULL ,
	cnv_fecha_alta	  DATE  NOT NULL ,
	cnv_usuario_alta  VARCHAR2(20)  NULL ,
	cnv_fecha_cambio  DATE  NULL ,
	cnv_usuario_cambio  VARCHAR2(20)  NULL ,
	cnv_fecha_baja	  DATE  NULL ,
	cnv_usuario_baja  VARCHAR2(20)  NULL ,
	cnv_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (cnv_id)
);



CREATE TABLE t_inv_avn_detalle
(
	tia_numero	  NUMBER  NOT NULL ,
	tia_total	  NUMBER(14,2)  NOT NULL ,
	Monto_presentado  NUMBER(14,2)  NOT NULL ,
	IGV		  NUMBER(14,2)  NOT NULL ,
	cnv_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
 PRIMARY KEY (tia_numero),
 FOREIGN KEY (tia_numero) REFERENCES t_inv_avn(tia_numero),
 FOREIGN KEY (cnv_id) REFERENCES t_concepto_inversion(cnv_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_valorizacion_supervision
(
	tvs_hr		  NUMBER  NOT NULL ,
	cva_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	tvs_neto	  NUMBER  NULL ,
	tvs_igv		  NUMBER  NULL ,
	tvs_bruto	  NUMBER  NULL ,
 PRIMARY KEY (tvs_hr),
 FOREIGN KEY (cva_id) REFERENCES t_concepto_valorizacion(cva_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_usuario
(
	usu_id		  VARCHAR2(20)  NOT NULL ,
	rol_id		  NUMBER  NOT NULL ,
	usu_alias	  VARCHAR2(20)  NULL ,
	usu_nombre	  VARCHAR2(100)  NOT NULL ,
	usu_descripcion	  VARCHAR2(100)  NOT NULL ,
	usu_estado	  NUMBER  NOT NULL ,
	usu_fecha_alta	  DATE  NOT NULL ,
	usu_usuario_alta  VARCHAR2(20)  NULL ,
	usu_fecha_cambio  DATE  NULL ,
	usu_usuario_cambio  VARCHAR2(20)  NULL ,
	usu_fecha_baja	  DATE  NULL ,
	usu_usuario_baja  VARCHAR2(20)  NULL ,
	usu_terminal	  VARCHAR2(20)  NULL ,
	usu_esexterno	  NUMBER  NULL ,
	usu_contrasenya	  VARCHAR2(4000)  NOT NULL ,
	usu_correo	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (usu_id,rol_id),
 FOREIGN KEY (rol_id) REFERENCES t_rol(rol_id)
);



CREATE TABLE t_auditoria
(
	usu_id		  VARCHAR2(20)  NOT NULL ,
	rol_id		  NUMBER  NOT NULL ,
	aud_atributo	  VARCHAR2(50)  NOT NULL ,
	aud_valor_anterior  VARCHAR2(4000)  NOT NULL ,
	aud_valor_actual  VARCHAR2(4000)  NOT NULL ,
	aud_tipo_dato	  VARCHAR2(20)  NULL ,
	aud_accion	  NUMBER(1)  NOT NULL ,
	aud_fecha	  DATE  NOT NULL ,
	aud_pantalla	  VARCHAR2(255)  NULL ,
 PRIMARY KEY (usu_id,rol_id),
 FOREIGN KEY (usu_id,rol_id) REFERENCES t_usuario(usu_id,rol_id)
);



CREATE TABLE t_contrato_penalidad
(
	tcp_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	tcp_motivo	  VARCHAR2(4000)  NOT NULL ,
	tcp_plazo	  NUMBER(4)  NOT NULL ,
	tcp_bruto	  NUMBER(14,2)  NOT NULL ,
	tcp_igv		  NUMBER(14,2)  NOT NULL ,
	tcp_total	  NUMBER(14,2)  NOT NULL ,
	mon_id		  NUMBER  NULL ,
 PRIMARY KEY (tcp_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id)
);



CREATE TABLE t_inversion_tipo
(
	tiv_id		  NUMBER  NOT NULL ,
	tiv_nombre	  VARCHAR2(100)  NOT NULL ,
	tiv_descripcion	  VARCHAR2(100)  NOT NULL ,
	tiv_estado	  NUMBER  NOT NULL ,
	tiv_fecha_alta	  DATE  NOT NULL ,
	tiv_usuario_alta  VARCHAR2(20)  NULL ,
	tiv_fecha_cambio  DATE  NULL ,
	tiv_usuario_cambio  VARCHAR2(20)  NULL ,
	tiv_fecha_baja	  DATE  NULL ,
	tiv_usuario_baja  VARCHAR2(20)  NULL ,
	tiv_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (tiv_id)
);



CREATE TABLE t_inversion_tipo_descripcrion
(
	tiv_id		  NUMBER  NOT NULL ,
	dti_id		  NUMBER  NOT NULL ,
	dti_nombre	  VARCHAR2(100)  NOT NULL ,
	dti_descripcion	  VARCHAR2(100)  NOT NULL ,
	dti_estado	  NUMBER  NOT NULL ,
	dti_fecha_alta	  DATE  NOT NULL ,
	dti_usuario_alta  VARCHAR2(20)  NULL ,
	dti_fecha_cambio  DATE  NULL ,
	dti_usuario_cambio  VARCHAR2(20)  NULL ,
	dti_fecha_baja	  DATE  NULL ,
	dti_usuario_baja  VARCHAR2(20)  NULL ,
	dti_terminal	  VARCHAR2(20)  NULL ,
 PRIMARY KEY (tiv_id,dti_id),
 FOREIGN KEY (dti_id) REFERENCES t_inversion_tipo(tiv_id)
);



CREATE TABLE t_contrato_compromiso
(
	con_id		  NUMBER  NOT NULL ,
	tcc_tipo	  NUMBER  NOT NULL ,
	tiv_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	cco_periodo	  VARCHAR2(4000)  NOT NULL ,
	cco_plazo	  NUMBER(4)  NOT NULL ,
	cco_bruto	  NUMBER(14,2)  NOT NULL ,
	cco_igv		  NUMBER(14,2)  NOT NULL ,
	cco_total	  NUMBER(14,2)  NOT NULL ,
	cco_alcance	  VARCHAR2(4000)  NOT NULL ,
	dti_id		  NUMBER  NULL ,
 PRIMARY KEY (con_id,tcc_tipo),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id),
 FOREIGN KEY (tiv_id,dti_id) REFERENCES t_inversion_tipo_descripcrion(tiv_id,dti_id),
 FOREIGN KEY (mon_id) REFERENCES t_moneda(mon_id),
 FOREIGN KEY (tiv_id) REFERENCES t_inversion_tipo(tiv_id)
);



CREATE TABLE t_contrato_adenda
(
	cad_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	cad_fecha	  DATE  NULL ,
	cad_documento_fisico  VARCHAR2(255)  NULL ,
	cad_entrega	  VARCHAR2(4000)  NOT NULL ,
	cad_descripcion	  VARCHAR2(4000)  NOT NULL ,
 PRIMARY KEY (cad_id,con_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id)
);



CREATE TABLE t_contrato_alerta
(
	cal_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NULL ,
	cal_nombreconcesion  VARCHAR2(4000)  NOT NULL ,
	cal_aeropuerto	  VARCHAR2(4000)  NOT NULL ,
	cal_inversion	  NUMBER  NULL ,
	cal_etapa	  NUMBER  NULL ,
	cal_fechalimite	  DATE  NULL ,
	cal_diasrestantes  NUMBER  NULL ,
	cal_diasexceso	  NUMBER  NULL ,
 PRIMARY KEY (cal_id),
 FOREIGN KEY (con_id) REFERENCES t_contrato(con_id)
);



   
CREATE SEQUENCE SEQ_CONCESION INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_CONCESIONARIO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_CONTRATO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_EMPRESASUPERVISORA INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_IGV INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_INFRAESTRUCTURA INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_INFRAESTRUCTURATIPO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_INVERSIONTIPO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_INVERSIONTIPODESCRIPCION INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_MODALIDADCONCESION INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_OPCIONTIPO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_ROLES INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SEQ_USUARIO INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1 CACHE 20;




/*
SELECT COUNT(*) FROM T_USUARIO;

INSERT INTO "OSITRAN"."T_USUARIO" (USU_ID, USU_NOMBRE, USU_ESTADO, USU_USUARIO_ALTA, USU_USUARIO_CAMBIO, USU_USUARIO_BAJA, USU_TERMINAL, USU_ESEXTERNO, ROL_ID, 
USU_CONTRASENYA, CRG_ID) VALUES (1, '1', 1, '1', '1', '1', '1', 1, '1', '1', '1')

*/

