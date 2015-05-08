package com.ositran.util.reportes;

import com.ositran.model.reportes.InversionesTipoConcepto;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

public class InversionesTipoConceptoDetalleDataSource implements JRDataSource {
    private int index = -1;
    private List<InversionesTipoConceptoDetalle> listadoEmpSupInf;

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < getDatos().size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();

        if (fieldName.equals("anio")) {
            return value = getDatos().get(index).getAnio();
        } else if (fieldName.equals("mes")) {
            return value = getDatos().get(index).getMes();
        } else if (fieldName.equals("nomConcepto")) {
            return value = getDatos().get(index).getNomConcepto();
        } else if (fieldName.equals("montoReconocido")) {
            return value = getDatos().get(index).getMontoReconocido();
        }

        return value;
    }

    public List<InversionesTipoConceptoDetalle> getDatos() {
        return listadoEmpSupInf;
    }

    public void setDatos(List<InversionesTipoConceptoDetalle> listadoEmpSupInf) {
        this.listadoEmpSupInf = listadoEmpSupInf;
    }
}
