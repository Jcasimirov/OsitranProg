package com.ositran.util.reportes;

import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesInversiones;
import com.ositran.model.reportes.EmpSupInfAeropuerto;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ControlPlazosFlujoValorizacionesInversionesDataSource implements JRDataSource {
    private int index = -1;
    private List<ControlPlazosFlujoValorizacionesInversiones> listadoControlPlazoFlujoValorizacionesInversiones;

    public ControlPlazosFlujoValorizacionesInversionesDataSource() {
        super();
    }

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

        if (fieldName.equals("nomConcesion")) {
            value = getDatos().get(index).getNomConcesion();
        } else if (fieldName.equals("nroValorizacion")) {
            value = getDatos().get(index).getNroValorizacion();
        } else if (fieldName.equals("fechaRegistro")) {
            value = getDatos().get(index).getFechaRegistro();
        }
        ////
        else if (fieldName.equals("ingval_pl")) {
            value = getDatos().get(index).getIngval_pl();
        } else if (fieldName.equals("ingval_est")) {
            value = getDatos().get(index).getIngval_est();
        }  else if (fieldName.equals("ingval_v")) {
            value = getDatos().get(index).getIngval_v();
        }
        ////
        else if (fieldName.equals("derval_fr")) {
            value = getDatos().get(index).getDerval_fr();
        } else if (fieldName.equals("derval_est")) {
            value = getDatos().get(index).getDerval_est();
        }
        ///
        else if (fieldName.equals("revssuper_fr")) {
            value = getDatos().get(index).getRevssuper_fr();
        } else if (fieldName.equals("revssuper_est")) {
            value = getDatos().get(index).getRevssuper_est();
        } else if (fieldName.equals("revssuper_v")) {
            value = getDatos().get(index).getRevssuper_v();
        }
        ///
        else if (fieldName.equals("recsupinv_fr")) {
            value = getDatos().get(index).getRecsupinv_fr();
        } else if (fieldName.equals("recsupinv_est")) {
            value = getDatos().get(index).getRecsupinv_est();
        } else if (fieldName.equals("recsupinv_v")) {
            value = getDatos().get(index).getRecsupinv_v();
        }

        return value;
    }

    public List<ControlPlazosFlujoValorizacionesInversiones> getDatos() {
        return listadoControlPlazoFlujoValorizacionesInversiones;
    }

    public void setDatos(List<ControlPlazosFlujoValorizacionesInversiones> listadoAvaInvConConc) {
        this.listadoControlPlazoFlujoValorizacionesInversiones = listadoAvaInvConConc;
    }
}
