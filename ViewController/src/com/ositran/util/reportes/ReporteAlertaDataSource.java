package com.ositran.util.reportes;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import com.ositran.model.reportes.ReportAlerta;

public class ReporteAlertaDataSource implements JRDataSource {
    private int index = -1;
    private List<ReportAlerta> listadoReporteAlerta;

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < getDatos().size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();

        if (fieldName.equals("nomTipoAlerta")) {
            return value = getDatos().get(index).getNomTipoAlerta();
        } else if (fieldName.equals("nomTipoInfraestructura")) {
            return value = getDatos().get(index).getNomTipoInfraestructura();
        } else if (fieldName.equals("nomModalidad")) {
            return value = getDatos().get(index).getNomModalidad();
        } else if (fieldName.equals("nomConcesion")) {
            return value = getDatos().get(index).getNomConcesion();
        } else if (fieldName.equals("fechaLimite")) {
            return value = getDatos().get(index).getFechaLimite();
        } else if (fieldName.equals("cantEtapa")) {
            return value = getDatos().get(index).getCantEtapa();
        } else if (fieldName.equals("diasRestantes")) {
            return value = getDatos().get(index).getDiasRestantes();
        } else if (fieldName.equals("diasExceso")) {
                   return value = getDatos().get(index).getDiasExceso();
        } else if (fieldName.equals("nomEstado")) {
                   return value = getDatos().get(index).getNomEstado();
        }

        return value;
    }

    public List<ReportAlerta> getDatos() {
        return listadoReporteAlerta;
    }

    public void setDatos(List<ReportAlerta> listadoReporteAlerta) {
        this.listadoReporteAlerta = listadoReporteAlerta;
    }
}
