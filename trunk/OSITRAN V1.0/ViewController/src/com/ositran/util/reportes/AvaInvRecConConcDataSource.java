package com.ositran.util.reportes;

import com.ositran.model.reportes.AvaInvRecConConc;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class AvaInvRecConConcDataSource implements JRDataSource {
    public AvaInvRecConConcDataSource() {
        super();
    }
    
    private int index = -1;
    private List<AvaInvRecConConc> listadoAvaInvRecConConc;


    @Override
    public boolean next() throws JRException {
        // TODO Implement this method
        index++;
        return (index < getDatos().size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        // TODO Implement this method
        Object value = null;
        String fieldName = jrf.getName();

        if (fieldName.equals("tipoInfraestructura")) {
            value = getDatos().get(index).getTipoInfraestructura();
        } else if (fieldName.equals("infraConcesionada")) {
            value = getDatos().get(index).getInfraConcesionada();
        } else if (fieldName.equals("fechaIniConcesion")) {
            value = getDatos().get(index).getFechaIniConcesion();
        } else if (fieldName.equals("fechaPlazo")) {
            value = getDatos().get(index).getFechaPlazo();
        } else if (fieldName.equals("notaPlazo")) {
            value = getDatos().get(index).getNotaPlazo();
        } else if (fieldName.equals("fechaIniObras")) {
            value = getDatos().get(index).getFechaIniObras();
        } else if (fieldName.equals("totalCompromisoInv")) {
            value = getDatos().get(index).getTotalCompromisoInv();
        } else if (fieldName.equals("inversionEjecutadaAcumAnnio")) {
            value = getDatos().get(index).getInversionEjecutadaAcumAnnio();
        } else if (fieldName.equals("inversionReconocidaAnnio")) {
            value = getDatos().get(index).getInversionReconocidaAnnio();
        } else if (fieldName.equals("inversionAcumuladaAnnio")) {
            value = getDatos().get(index).getInversionAcumuladaAnnio();
        } else if (fieldName.equals("porcentajeCumplimiento")) {
            value = getDatos().get(index).getPorcentajeCumplimiento();
        } else if (fieldName.equals("inversionReconocidaMesUno")) {
            value = getDatos().get(index).getInversionReconocidaMesUno();
        } else if (fieldName.equals("inversionReconocidaMesDos")) {
            value = getDatos().get(index).getInversionReconocidaMesDos();
        }else if (fieldName.equals("inversionReconocidaMesTres")) {
            value = getDatos().get(index).getInversionReconocidaMesTres();
        }else if (fieldName.equals("sumaMeses")) {
            value = getDatos().get(index).getSumaMeses();
        }

        return value;
    }

    public List<AvaInvRecConConc> getDatos() {
        return listadoAvaInvRecConConc;
    }

    public void setDatos(List<AvaInvRecConConc> listadoAvaInvConConc) {
        this.listadoAvaInvRecConConc = listadoAvaInvConConc;
    }
}
