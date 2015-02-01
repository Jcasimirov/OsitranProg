DROP TABLE t_usuario PURGE;
DROP TABLE t_contrato_adenda PURGE;
DROP TABLE t_contrato_anexo PURGE;
DROP TABLE t_contrato_valorizacion PURGE;
DROP TABLE t_empresa_supervisora PURGE;
DROP TABLE t_rol_opciones PURGE;
DROP TABLE t_tipo_cambio PURGE;
DROP TABLE T_CONCEPTO_INVERSION PURGE;
DROP TABLE t_concepto_valorizacion PURGE;
DROP TABLE t_contrato PURGE;
DROP TABLE t_infraestructura_tipo_plantil PURGE;
DROP TABLE t_inversion_tipo PURGE;
DROP TABLE t_men PURGE;
DROP TABLE t_modalidad_concesion PURGE;
DROP TABLE t_moneda PURGE;
DROP TABLE t_rol PURGE;
DROP TABLE t_infraestructura_tipo PURGE;
DROP TABLE t_concesionario PURGE;
DROP TABLE T_CARGO PURGE;
DROP TABLE t_tipo_documento PURGE;
DROP TABLE t_exp_reconocimiento_detalle PURGE;
DROP TABLE t_exp_reconocimiento PURGE;
DROP TABLE t_impuesto PURGE;
DROP TABLE t_inversion PURGE;
DROP TABLE t_inversion_tipo_descripcion PURGE;
DROP TABLE t_universo_temas_contrato PURGE;

CREATE TABLE t_cargo
(
	crg_nombre	  VARCHAR2(100)  NOT NULL ,
	crg_descripcion	  VARCHAR2(100)  NOT NULL ,
	crg_id		  NUMBER  NOT NULL ,
	crg_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	crg_fecha_alta	  DATE  NULL ,
	crg_fecha_cambio  DATE  NULL ,
	crg_fecha_baja	  DATE  NULL ,
	crg_terminal	  VARCHAR2(20)  NULL ,
	crg_usuario_alta  VARCHAR2(20)  NULL ,
	crg_usuario_cambio  VARCHAR2(20)  NULL ,
	crg_usuario_baja  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKCargo ON t_cargo
(crg_id  ASC);



ALTER TABLE t_cargo
	ADD CONSTRAINT  XPKCargo PRIMARY KEY (crg_id);



CREATE TABLE t_concepto_inversion
(
	cnv_nombre	  VARCHAR2(50)  NOT NULL ,
	cnv_descripcion	  VARCHAR2(100)  NOT NULL ,
	cnv_id		  NUMBER  NOT NULL ,
	cnv_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	cnv_fecha_alta	  DATE  NULL ,
	cnv_usuario_alta  VARCHAR2(20)  NULL ,
	cnv_fecha_cambio  DATE  NULL ,
	cnv_usuario_cambio  VARCHAR2(20)  NULL ,
	cnv_fecha_baja	  DATE  NULL ,
	cnv_usuario_baja  VARCHAR2(20)  NULL ,
	cnv_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKConceptos_de_inversión ON t_concepto_inversion
(cnv_id  ASC);



ALTER TABLE t_concepto_inversion
	ADD CONSTRAINT  XPKConceptos_de_inversión PRIMARY KEY (cnv_id);



CREATE TABLE t_concepto_valorizacion
(
	cva_nombre	  VARCHAR2(100)  NOT NULL ,
	cva_descripcion	  VARCHAR2(100)  NOT NULL ,
	cva_id		  NUMBER  NOT NULL ,
	cva_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	cva_fecha_alta	  DATE  NULL ,
	cva_usuario_alta  VARCHAR2(20)  NULL ,
	cva_fecha_cambio  DATE  NULL ,
	cva_usuario_cambio  VARCHAR2(20)  NULL ,
	cva_fecha_baja	  DATE  NULL ,
	cva_usuario_baja  VARCHAR2(20)  NULL ,
	cva_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKConcepto_de_valorización ON t_concepto_valorizacion
(cva_id  ASC);



ALTER TABLE t_concepto_valorizacion
	ADD CONSTRAINT  XPKConcepto_de_valorización PRIMARY KEY (cva_id);



CREATE TABLE t_concesionario
(
	cnc_nombre	  VARCHAR2(100)  NOT NULL ,
	cnc_descripcion	  VARCHAR2(100)  NOT NULL ,
	cnc_id		  NUMBER  NOT NULL ,
	cnc_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	cnc_fecha_alta	  DATE  NULL ,
	cnc_fecha_cambio  DATE  NULL ,
	cnc_fecha_baja	  DATE  NULL ,
	cnc_terminal	  VARCHAR2(20)  NULL ,
	cnc_usuario_alta  VARCHAR2(20)  NULL ,
	cnc_usuario_cambio  VARCHAR2(20)  NULL ,
	cnc_usuario_baja  VARCHAR2(20)  NULL ,
	cnc_telefono	  VARCHAR2(15)  NULL ,
	cnc_nro_documento  VARCHAR2(20)  NULL ,
	cnc_direccion	  VARCHAR2(20)  NULL ,
	cnc_correo	  VARCHAR2(20)  NULL ,
	cnc_representante_legal  VARCHAR2(20)  NULL ,
	crg_id		  NUMBER  NULL ,
	tdo_id		  NUMBER  NULL 
);



CREATE UNIQUE INDEX XPKConcesionario ON t_concesionario
(cnc_id  ASC);



ALTER TABLE t_concesionario
	ADD CONSTRAINT  XPKConcesionario PRIMARY KEY (cnc_id);



CREATE TABLE t_contrato
(
	con_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	con_fecha_alta	  DATE  NULL ,
	con_usuario_alta  VARCHAR2(20)  NULL ,
	con_fecha_cambio  DATE  NULL ,
	con_usuario_cambio  VARCHAR2(20)  NULL ,
	con_fecha_baja	  DATE  NULL ,
	con_usuario_baja  VARCHAR2(20)  NULL ,
	con_terminal	  VARCHAR2(20)  NULL ,
	mco_id		  NUMBER  NOT NULL ,
	cnc_id		  NUMBER  NULL ,
	tiv_id		  NUMBER  NULL ,
	con_id		  NUMBER  NOT NULL ,
	tin_id		  NUMBER  NOT NULL ,
	mon_id		  NUMBER  NULL ,
	Total_de_la_valorización  NUMBER  NULL ,
	con_concesion	  VARCHAR2(4000)  NOT NULL 
);



CREATE UNIQUE INDEX XPKContrato ON t_contrato
(con_id  ASC,tin_id  ASC);



ALTER TABLE t_contrato
	ADD CONSTRAINT  XPKContrato PRIMARY KEY (con_id,tin_id);



CREATE TABLE t_contrato_adenda
(
	cad_id		  NUMBER  NOT NULL ,
	cad_fecha	  DATE  NULL ,
	cad_documento_fisico  VARCHAR2(255)  NULL ,
	tin_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKContrato_Adenda ON t_contrato_adenda
(cad_id  ASC,tin_id  ASC,con_id  ASC);



ALTER TABLE t_contrato_adenda
	ADD CONSTRAINT  XPKContrato_Adenda PRIMARY KEY (cad_id,tin_id,con_id);



CREATE TABLE t_contrato_anexo
(
	cax_id		  NUMBER  NOT NULL ,
	cax_fecha	  DATE  NULL ,
	cax_documento_fisico  VARCHAR2(255)  NULL ,
	tin_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKContrato_Anexo ON t_contrato_anexo
(cax_id  ASC,tin_id  ASC,con_id  ASC);



ALTER TABLE t_contrato_anexo
	ADD CONSTRAINT  XPKContrato_Anexo PRIMARY KEY (cax_id,tin_id,con_id);



CREATE TABLE t_contrato_detalle
(
	cnd_correlativo	  NUMBER  NOT NULL ,
	cnd_valor_texto	  VARCHAR2(200),
	cnd_valor_fecha	  DATE  NULL ,
	cnd_valor_numerico  NUMBER(14,3)  NULL ,
	cnd_referencia	  VARCHAR2(4000)  NOT NULL ,
	con_id		  NUMBER  NOT NULL ,
	tin_id		  NUMBER  NOT NULL ,
	utc_Id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKContrato_Detalle ON t_contrato_detalle
(con_id  ASC,tin_id  ASC,cnd_correlativo  ASC,utc_Id  ASC);



ALTER TABLE t_contrato_detalle
	ADD CONSTRAINT  XPKContrato_Detalle PRIMARY KEY (con_id,tin_id,cnd_correlativo,utc_Id);



CREATE TABLE t_contrato_valorizacion
(
	cvl_fecha	  DATE  NULL ,
	cvl_id		  NUMBER  NOT NULL ,
	cva_id		  NUMBER  NULL ,
	Alcance		  VARCHAR2(20)  NULL ,
	cva_monto	  NUMBER(14,2)   DEFAULT  0 NOT NULL ,
	Fecha_Inicio	  DATE  NULL ,
	Duración	  NUMBER   DEFAULT  0 NULL ,
	tin_id		  NUMBER  NOT NULL ,
	con_id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKContrato_Etapa ON t_contrato_valorizacion
(cvl_id  ASC,tin_id  ASC,con_id  ASC);



ALTER TABLE t_contrato_valorizacion
	ADD CONSTRAINT  XPKContrato_Etapa PRIMARY KEY (cvl_id,tin_id,con_id);



CREATE TABLE t_empresa_supervisora
(
	sup_nombre	  VARCHAR2(100)  NOT NULL ,
	sup_descripcion	  VARCHAR2(100)  NOT NULL ,
	sup_id		  NUMBER  NOT NULL ,
	sup_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	sup_fecha_alta	  DATE  NULL ,
	sup_fecha_cambio  DATE  NULL ,
	sup_fecha_baja	  DATE  NULL ,
	sup_terminal	  VARCHAR2(20)  NULL ,
	sup_usuario_alta  VARCHAR2(20)  NULL ,
	sup_usuario_cambio  VARCHAR2(20)  NULL ,
	sup_usuario_baja  VARCHAR2(20)  NULL ,
	sup_telefono	  VARCHAR2(15)  NULL ,
	sup_nro_documento  VARCHAR2(20)  NULL ,
	sup_direccion	  VARCHAR2(20)  NULL ,
	sup_correo	  VARCHAR2(20)  NULL ,
	sup_representante_legal  VARCHAR2(20)  NULL ,
	crg_id		  NUMBER  NULL ,
	tdo_id		  NUMBER  NULL 
);



CREATE UNIQUE INDEX XPKEmpresa_Supervisora ON t_empresa_supervisora
(sup_id  ASC);



ALTER TABLE t_empresa_supervisora
	ADD CONSTRAINT  XPKEmpresa_Supervisora PRIMARY KEY (sup_id);



CREATE TABLE t_exp_reconocimiento
(
	erc_std		  VARCHAR2(20)  NOT NULL ,
	erc_concepto	  NUMBER(14,2)  NULL ,
	erc_valor_total_expediente  NUMBER(14,2)  NULL ,
	erc_valor_bruto	  NUMBER(14,2)  NULL ,
	erc_porcentaje_amortizacion  NUMBER(14,2)  NULL ,
	erc_valor_igv	  NUMBER(14,2)  NULL ,
	erc_valor_total	  NUMBER(14,2)  NULL ,
	mon_id		  NUMBER  NULL ,
	erc_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	erc_fecha_alta	  DATE  NULL ,
	erc_usuario_alta  VARCHAR2(20)  NULL ,
	erc_fecha_cambio  DATE  NULL ,
	erc_usuario_cambio  VARCHAR2(20)  NULL ,
	erc_fecha_baja	  DATE  NULL ,
	erc_usuario_baja  VARCHAR2(20)  NULL ,
	erc_terminal	  VARCHAR2(20)  NULL ,
	imp_id		  NUMBER  NULL ,
	IGV		  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKExpediente_de_reconocimient ON t_exp_reconocimiento
(erc_std  ASC);



ALTER TABLE t_exp_reconocimiento
	ADD CONSTRAINT  XPKExpediente_de_reconocimient PRIMARY KEY (erc_std);



CREATE TABLE t_exp_reconocimiento_detalle
(
	erd_valor_total	  NUMERIC(14,2)  NOT NULL ,
	cnv_id		  NUMBER  NULL ,
	mon_id		  NUMBER  NULL ,
	erd_id		  NUMBER  NOT NULL ,
	erc_std		  VARCHAR2(20)  NOT NULL 
);



CREATE UNIQUE INDEX XPKExpediente_de_reconocimient ON t_exp_reconocimiento_detalle
(erd_id  ASC,erc_std  ASC);



ALTER TABLE t_exp_reconocimiento_detalle
	ADD CONSTRAINT  XPKExpediente_de_reconocimient PRIMARY KEY (erd_id,erc_std);



CREATE TABLE t_impuesto
(
	imp_nombre	  VARCHAR2(100)  NOT NULL ,
	imp_descripcion	  VARCHAR2(100)  NOT NULL ,
	imp_id		  NUMBER  NOT NULL ,
	imp_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	imp_fecha_alta	  DATE  NULL ,
	imp_fecha_cambio  DATE  NULL ,
	imp_fecha_baja	  DATE  NULL ,
	imp_terminal	  VARCHAR2(20)  NULL ,
	imp_usuario_alta  VARCHAR2(20)  NULL ,
	imp_usuario_cambio  VARCHAR2(20)  NULL ,
	imp_usuario_baja  VARCHAR2(20)  NULL ,
	imp_porcentaje	  NUMBER(14,2)  NOT NULL 
);



CREATE UNIQUE INDEX XPKImpuesto ON t_impuesto
(imp_id  ASC);



ALTER TABLE t_impuesto
	ADD CONSTRAINT  XPKImpuesto PRIMARY KEY (imp_id);



CREATE TABLE t_infraestructura_tipo
(
	tin_nombre	  VARCHAR2(50)  NOT NULL ,
	tin_descripcion	  VARCHAR2(100)  NOT NULL ,
	tin_id		  NUMBER  NOT NULL ,
	tin_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	tin_fecha_alta	  DATE  NULL ,
	tin_usuario_alta  VARCHAR2(20)  NULL ,
	tin_fecha_cambio  DATE  NULL ,
	tin_usuario_cambio  VARCHAR2(20)  NULL ,
	tin_fecha_baja	  DATE  NULL ,
	tin_usuario_baja  VARCHAR2(20)  NULL ,
	tin_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKInfraestructura_Tipo ON t_infraestructura_tipo
(tin_id  ASC);



ALTER TABLE t_infraestructura_tipo
	ADD CONSTRAINT  XPKInfraestructura_Tipo PRIMARY KEY (tin_id);



CREATE TABLE t_infraestructura_tipo_plantil
(
	tin_id		  NUMBER  NOT NULL ,
	utc_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	utc_fecha_alta	  DATE  NULL ,
	utc_usuario_alta  VARCHAR2(20)  NULL ,
	utc_fecha_cambio  DATE  NULL ,
	utc_usuario_cambio  VARCHAR2(20)  NULL ,
	utc_fecha_baja	  DATE  NULL ,
	utc_usuario_baja  VARCHAR2(20)  NULL ,
	utc_terminal	  VARCHAR2(20)  NULL ,
	utc_Id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKInfraestructura_Tipo_de_Pla ON t_infraestructura_tipo_plantil
(tin_id  ASC,utc_Id  ASC);



ALTER TABLE t_infraestructura_tipo_plantil
	ADD CONSTRAINT  XPKInfraestructura_Tipo_de_Pla PRIMARY KEY (tin_id,utc_Id);



CREATE TABLE t_inversion
(
	inv_nombre	  VARCHAR2(100)  NOT NULL ,
	inv_descripcion	  VARCHAR2(100)  NOT NULL ,
	inv_id		  NUMBER  NOT NULL ,
	inv_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	inv_fecha_alta	  DATE  NULL ,
	inv_fecha_cambio  DATE  NULL ,
	inv_fecha_baja	  DATE  NULL ,
	inv_terminal	  VARCHAR2(20)  NULL ,
	tiv_id		  NUMBER  NULL ,
	inv_usuario_alta  VARCHAR2(20)  NULL ,
	inv_usuario_cambio  VARCHAR2(20)  NULL ,
	inv_usuario_baja  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKInversion ON t_inversion
(inv_id  ASC);



ALTER TABLE t_inversion
	ADD CONSTRAINT  XPKInversion PRIMARY KEY (inv_id);



CREATE TABLE t_inversion_tipo
(
	tiv_nombre	  VARCHAR2(100)  NOT NULL ,
	tiv_descripcion	  VARCHAR2(100)  NOT NULL ,
	tiv_id		  NUMBER  NOT NULL ,
	tiv_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	tiv_fecha_alta	  DATE  NULL ,
	tiv_usuario_alta  VARCHAR2(20)  NULL ,
	tiv_fecha_cambio  DATE  NULL ,
	tiv_usuario_cambio  VARCHAR2(20)  NULL ,
	tiv_fecha_baja	  DATE  NULL ,
	tiv_usuario_baja  VARCHAR2(20)  NULL ,
	tiv_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKInversion_Tipo ON t_inversion_tipo
(tiv_id  ASC);



ALTER TABLE t_inversion_tipo
	ADD CONSTRAINT  XPKInversion_Tipo PRIMARY KEY (tiv_id);



CREATE TABLE t_inversion_tipo_descripcion
(
	itd_nombre	  VARCHAR2(100)  NOT NULL ,
	itd_descripcion	  VARCHAR2(100)  NOT NULL ,
	itd_id		  NUMBER  NOT NULL ,
	itd_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	itd_fecha_alta	  DATE  NULL ,
	itd_usuario_alta  VARCHAR2(20)  NULL ,
	itd_fecha_cambio  DATE  NULL ,
	itd_usuario_cambio  VARCHAR2(20)  NULL ,
	itd_fecha_baja	  DATE  NULL ,
	itd_usuario_baja  VARCHAR2(20)  NULL ,
	itd_terminal	  VARCHAR2(20)  NULL ,
	tiv_id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKInversion_Tipo_Descripcion ON t_inversion_tipo_descripcion
(itd_id  ASC,tiv_id  ASC);



ALTER TABLE t_inversion_tipo_descripcion
	ADD CONSTRAINT  XPKInversion_Tipo_Descripcion PRIMARY KEY (itd_id,tiv_id);



CREATE TABLE t_men
(
	men_id		  NUMBER  NOT NULL ,
	men_nombre	  VARCHAR2(4000)  NOT NULL ,
	men_formulario	  VARCHAR2(4000)  NOT NULL ,
	men_padre	  NUMBER  NULL ,
	men_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	men_fecha_alta	  DATE  NULL ,
	men_usuario_alta  VARCHAR2(20)  NULL ,
	men_fecha_cambio  DATE  NULL ,
	men_usuario_cambio  VARCHAR2(20)  NULL ,
	men_fecha_baja	  DATE  NULL ,
	men_usuario_baja  VARCHAR2(20)  NULL ,
	men_terminal	  VARCHAR2(20)  NULL ,
	Descripcion	  VARCHAR2(4000)  NOT NULL 
);



CREATE UNIQUE INDEX XPKOpciones_de_la_aplicación ON t_men
(men_id  ASC);



ALTER TABLE t_men
	ADD CONSTRAINT  XPKOpciones_de_la_aplicación PRIMARY KEY (men_id);



CREATE TABLE t_modalidad_concesion
(
	mco_nombre	  VARCHAR2(100)  NOT NULL ,
	mco_descripcion	  VARCHAR2(100)  NOT NULL ,
	mco_id		  NUMBER  NOT NULL ,
	mco_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	mco_fecha_alta	  DATE  NULL ,
	mco_usuario_alta  VARCHAR2(20)  NULL ,
	mco_fecha_cambio  DATE  NULL ,
	mco_usuario_cambio  VARCHAR2(20)  NULL ,
	mco_fecha_baja	  DATE  NULL ,
	mco_usuario_baja  VARCHAR2(20)  NULL ,
	mco_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKModalidad_de_Concesión ON t_modalidad_concesion
(mco_id  ASC);



ALTER TABLE t_modalidad_concesion
	ADD CONSTRAINT  XPKModalidad_de_Concesión PRIMARY KEY (mco_id);



CREATE TABLE t_moneda
(
	mon_nombre	  VARCHAR2(50)  NOT NULL ,
	mon_id		  NUMBER  NOT NULL ,
	mon_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	mon_fecha_alta	  DATE  NULL ,
	mon_usuario_alta  VARCHAR2(20)  NULL ,
	mon_fecha_cambio  DATE  NULL ,
	mon_usuario_cambio  VARCHAR2(20)  NULL ,
	mon_fecha_baja	  DATE  NULL ,
	mon_usuario_baja  VARCHAR2(20)  NULL ,
	mon_terminal	  VARCHAR2(20)  NULL ,
	mon_simbolo	  VARCHAR2(3)  NULL 
);



CREATE UNIQUE INDEX XPKMoneda ON t_moneda
(mon_id  ASC);



ALTER TABLE t_moneda
	ADD CONSTRAINT  XPKMoneda PRIMARY KEY (mon_id);



CREATE TABLE t_rol
(
	rol_nombre	  VARCHAR2(100)  NOT NULL ,
	rol_descripcion	  VARCHAR2(100)  NOT NULL ,
	rol_id		  NUMBER  NOT NULL ,
	rol_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	rol_fecha_alta	  DATE  NULL ,
	rol_usuario_alta  VARCHAR2(20)  NULL ,
	rol_fecha_cambio  DATE  NULL ,
	rol_usuario_cambio  VARCHAR2(20)  NULL ,
	rol_fecha_baja	  DATE  NULL ,
	rol_usuario_baja  VARCHAR2(20)  NULL ,
	rol_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKRol ON t_rol
(rol_id  ASC);



ALTER TABLE t_rol
	ADD CONSTRAINT  XPKRol PRIMARY KEY (rol_id);



CREATE TABLE t_rol_opciones
(
	men_id		  NUMBER  NOT NULL ,
	rol_id		  NUMBER  NOT NULL ,
	tro_consultar	  NUMBER   DEFAULT  0 NOT NULL ,
	tro_agregar	  NUMBER   DEFAULT  0 NOT NULL ,
	tro_modificar	  NUMBER   DEFAULT  0 NOT NULL ,
	tro_eliminar	  NUMBER   DEFAULT  0 NOT NULL ,
	tro_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	tro_fecha_alta	  DATE  NULL ,
	tro_usuario_alta  VARCHAR2(20)  NULL ,
	tro_fecha_cambio  DATE  NULL ,
	tro_usuario_cambio  VARCHAR2(20)  NULL ,
	tro_fecha_baja	  DATE  NULL ,
	tro_usuario_baja  VARCHAR2(20)  NULL ,
	tro_terminal	  VARCHAR2(20)  NULL ,
	rxo_id		  NUMBER  NOT NULL 
);



CREATE UNIQUE INDEX XPKOpciones_por_rol ON t_rol_opciones
(rxo_id  ASC);



ALTER TABLE t_rol_opciones
	ADD CONSTRAINT  XPKOpciones_por_rol PRIMARY KEY (rxo_id);



CREATE TABLE t_tipo_cambio
(
	tdc_importe_venta  NUMBER(14,3)   DEFAULT  1 NOT NULL ,
	tdc_importe_compra  NUMBER(14,3)   DEFAULT  1 NULL ,
	tdc_fecha	  DATE  NOT NULL ,
	mon_id		  NUMBER  NOT NULL ,
	tdc_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	tdc_fecha_alta	  DATE  NULL ,
	tdc_usuario_alta  VARCHAR2(20)  NULL ,
	tdc_fecha_cambio  DATE  NULL ,
	tdc_usuario_cambio  VARCHAR2(20)  NULL ,
	tdc_fecha_baja	  DATE  NULL ,
	tdc_usuario_baja  VARCHAR2(20)  NULL ,
	tdc_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKTipo_de_cambio ON t_tipo_cambio
(tdc_fecha  ASC,mon_id  ASC);



ALTER TABLE t_tipo_cambio
	ADD CONSTRAINT  XPKTipo_de_cambio PRIMARY KEY (tdc_fecha,mon_id);



CREATE TABLE t_tipo_documento
(
	tdo_nombre	  VARCHAR2(100)  NOT NULL ,
	tdo_descripcion	  VARCHAR2(100)  NOT NULL ,
	tdo_id		  NUMBER  NOT NULL ,
	tdo_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	tdo_fecha_alta	  DATE  NULL ,
	tdo_fecha_cambio  DATE  NULL ,
	tdo_fecha_baja	  DATE  NULL ,
	tdo_terminal	  VARCHAR2(20)  NULL ,
	tdo_usuario_alta  VARCHAR2(20)  NULL ,
	tdo_usuario_cambio  VARCHAR2(20)  NULL ,
	tdo_usuario_baja  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKTipo_de_documento ON t_tipo_documento
(tdo_id  ASC);



ALTER TABLE t_tipo_documento
	ADD CONSTRAINT  XPKTipo_de_documento PRIMARY KEY (tdo_id);


CREATE TABLE t_universo_temas_contrato
(
	utc_Id		  NUMBER  NOT NULL ,
	utc_nombre	  VARCHAR2(50)  NOT NULL ,
	utc_descripcion	  VARCHAR2(4000)  NOT NULL ,
	utc_tipo_dato	  VARCHAR2(1) NOT NULL,
	utc_todaslasinfraestructuras  NUMBER   DEFAULT  1 NOT NULL ,
	utc_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	utc_fecha_alta	  DATE  NULL ,
	utc_usuario_alta  VARCHAR2(20)  NULL ,
	utc_fecha_cambio  DATE  NULL ,
	utc_usuario_cambio  VARCHAR2(20)  NULL ,
	utc_fecha_baja	  DATE  NULL ,
	utc_usuario_baja  VARCHAR2(20)  NULL ,
	utc_terminal	  VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPKUniverso_Temas_Contrato ON t_universo_temas_contrato
(utc_Id  ASC);



ALTER TABLE t_universo_temas_contrato
	ADD CONSTRAINT  XPKUniverso_Temas_Contrato PRIMARY KEY (utc_Id);



CREATE TABLE t_usuario
(
	usu_id		  NUMBER  NOT NULL ,
	usu_nombre	  VARCHAR2(100)  NOT NULL ,
	usu_estado	  NUMBER   DEFAULT  0 NOT NULL ,
	usu_fecha_alta	  DATE  NULL ,
	usu_usuario_alta  VARCHAR2(20)  NULL ,
	usu_fecha_cambio  DATE  NULL ,
	usu_usuario_cambio  VARCHAR2(20)  NULL ,
	usu_fecha_baja	  DATE  NULL ,
	usu_usuario_baja  VARCHAR2(20)  NULL ,
	usu_terminal	  VARCHAR2(20)  NULL ,
	usu_esexterno	  NUMBER   DEFAULT  0 NOT NULL ,
	rol_id		  NUMBER  NOT NULL ,
	usu_contrasenya	  VARCHAR2(20)  NOT NULL ,
	crg_id		  NUMBER  NULL 
);



CREATE UNIQUE INDEX Usuario_uk ON t_usuario(usu_id  ASC);



ALTER TABLE t_usuario ADD CONSTRAINT  Usuario_pk PRIMARY KEY (usu_id);

/*
SELECT COUNT(*) FROM T_USUARIO;

INSERT INTO "OSITRAN"."T_USUARIO" (USU_ID, USU_NOMBRE, USU_ESTADO, USU_USUARIO_ALTA, USU_USUARIO_CAMBIO, USU_USUARIO_BAJA, USU_TERMINAL, USU_ESEXTERNO, ROL_ID, 
USU_CONTRASENYA, CRG_ID) VALUES (1, '1', 1, '1', '1', '1', '1', 1, '1', '1', '1')

*/

