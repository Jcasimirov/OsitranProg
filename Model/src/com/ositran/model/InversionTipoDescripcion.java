package com.ositran.model;
    
    import java.io.Serializable;
    import java.util.Date;
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Id;
    import javax.persistence.Table;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import javax.persistence.UniqueConstraint;
    import org.hibernate.annotations.GenericGenerator;
    import org.hibernate.annotations.Parameter;
    
    @Entity(name = "InversionTipoDescripcion")
    @Table(name = "T_INVERSION_TIPO_DESCRIPCION",uniqueConstraints = @UniqueConstraint(columnNames = {"DTI_ID"}))
    @GenericGenerator(name = "generator", strategy = "sequence-identity", parameters = @Parameter(name = "sequence", value = "INVERSIONTIPODESCRIPCION_SEC"))
    
    public class InversionTipoDescripcion implements Serializable {
        private static final long serialVersionUID = -1816130139407701837L;
        @Column(name = "DTI_DESCRIPCION", nullable = false, length = 100)
        private String itdDescripcion;
        @Column(name = "DTI_ESTADO", nullable = false)
        private int itdEstado;
        @Temporal(TemporalType.DATE)
        @Column(name = "DTI_FECHA_ALTA")
        private Date itdFechaAlta;
        @Temporal(TemporalType.DATE)
        @Column(name = "DTI_FECHA_BAJA")
        private Date itdFechaBaja;
        @Temporal(TemporalType.DATE)
        @Column(name = "DTI_FECHA_CAMBIO")
        private Date itdFechaCambio;
        @Id
        @GeneratedValue(generator = "generator")
        @Column(name = "DTI_ID", nullable = false)
        private int itdId;
        @Column(name = "DTI_NOMBRE", nullable = false, length = 100)
        private String itdNombre;
        @Column(name = "DTI_TERMINAL", length = 20)
        private String itdTerminal;
        @Column(name = "DTI_USUARIO_ALTA", length = 20)
        private String itdUsuarioAlta;
        @Column(name = "DTI_USUARIO_BAJA", length = 20)
        private String itdUsuarioBaja;
        @Column(name = "DTI_USUARIO_CAMBIO", length = 20)
        private String itdUsuarioCambio;
        @Column(name = "TIV_ID", nullable = false)
        private int tivId;
    
        public InversionTipoDescripcion() {
        }
    
        public InversionTipoDescripcion(String itdDescripcion, int itdEstado, Date itdFechaAlta, Date itdFechaBaja,
                                         Date itdFechaCambio, int itdId, String itdNombre, String itdTerminal,
                                         String itdUsuarioAlta, String itdUsuarioBaja, String itdUsuarioCambio,
                                         int tivId) {
            this.itdDescripcion = itdDescripcion;
            this.itdEstado = itdEstado;
            this.itdFechaAlta = itdFechaAlta;
            this.itdFechaBaja = itdFechaBaja;
            this.itdFechaCambio = itdFechaCambio;
            this.itdId = itdId;
            this.itdNombre = itdNombre;
            this.itdTerminal = itdTerminal;
            this.itdUsuarioAlta = itdUsuarioAlta;
            this.itdUsuarioBaja = itdUsuarioBaja;
            this.itdUsuarioCambio = itdUsuarioCambio;
            this.tivId = tivId;
        }
    
        public String getItdDescripcion() {
            return itdDescripcion;
        }
    
        public void setItdDescripcion(String itdDescripcion) {
            this.itdDescripcion = itdDescripcion;
        }
    
        public int getItdEstado() {
            return itdEstado;
        }
    
        public void setItdEstado(int itdEstado) {
            this.itdEstado = itdEstado;
        }
    
        public Date getItdFechaAlta() {
            return itdFechaAlta;
        }
    
        public void setItdFechaAlta(Date itdFechaAlta) {
            this.itdFechaAlta = itdFechaAlta;
        }
    
        public Date getItdFechaBaja() {
            return itdFechaBaja;
        }
    
        public void setItdFechaBaja(Date itdFechaBaja) {
            this.itdFechaBaja = itdFechaBaja;
        }
    
        public Date getItdFechaCambio() {
            return itdFechaCambio;
        }
    
        public void setItdFechaCambio(Date itdFechaCambio) {
            this.itdFechaCambio = itdFechaCambio;
        }
    
        public int getItdId() {
            return itdId;
        }
    
        public void setItdId(int itdId) {
            this.itdId = itdId;
        }
    
        public String getItdNombre() {
            return itdNombre;
        }
    
        public void setItdNombre(String itdNombre) {
            this.itdNombre = itdNombre;
        }
    
        public String getItdTerminal() {
            return itdTerminal;
        }
    
        public void setItdTerminal(String itdTerminal) {
            this.itdTerminal = itdTerminal;
        }
    
        public String getItdUsuarioAlta() {
            return itdUsuarioAlta;
        }
    
        public void setItdUsuarioAlta(String itdUsuarioAlta) {
            this.itdUsuarioAlta = itdUsuarioAlta;
        }
    
        public String getItdUsuarioBaja() {
            return itdUsuarioBaja;
        }
    
        public void setItdUsuarioBaja(String itdUsuarioBaja) {
            this.itdUsuarioBaja = itdUsuarioBaja;
        }
    
        public String getItdUsuarioCambio() {
            return itdUsuarioCambio;
        }
    
        public void setItdUsuarioCambio(String itdUsuarioCambio) {
            this.itdUsuarioCambio = itdUsuarioCambio;
        }
    
        public int getTivId() {
            return tivId;
        }
    
        public void setTivId(int tivId) {
            this.tivId = tivId;
        }
    }