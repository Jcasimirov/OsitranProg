package com.ositran.vo.bean;

public class AvanceInversionWebDetalleVO {
    private static final long serialVersionUID = 4990163357962044635L;
    private int cvaId;
    private int iwcId;
    private int iwdId;
    private Long iwdIgv;
    private Long iwdNeto;
    private Long iwdTotal;

    public AvanceInversionWebDetalleVO() {
    }

    public AvanceInversionWebDetalleVO(int cvaId, int iwcId, int iwdId, Long iwdIgv, Long iwdNeto,
                                      Long iwdTotal) {
        this.cvaId = cvaId;
        this.iwcId = iwcId;
        this.iwdId = iwdId;
        this.iwdIgv = iwdIgv;
        this.iwdNeto = iwdNeto;
        this.iwdTotal = iwdTotal;
    }

    public int getCvaId() {
        return cvaId;
    }

    public void setCvaId(int cvaId) {
        this.cvaId = cvaId;
    }

    public int getIwcId() {
        return iwcId;
    }

    public void setIwcId(int iwcId) {
        this.iwcId = iwcId;
    }

    public int getIwdId() {
        return iwdId;
    }

    public void setIwdId(int iwdId) {
        this.iwdId = iwdId;
    }

    public Long getIwdIgv() {
        return iwdIgv;
    }

    public void setIwdIgv(Long iwdIgv) {
        this.iwdIgv = iwdIgv;
    }

    public Long getIwdNeto() {
        return iwdNeto;
    }

    public void setIwdNeto(Long iwdNeto) {
        this.iwdNeto = iwdNeto;
    }

    public Long getIwdTotal() {
        return iwdTotal;
    }

    public void setIwdTotal(Long iwdTotal) {
        this.iwdTotal = iwdTotal;
    }
   
   
   
}
