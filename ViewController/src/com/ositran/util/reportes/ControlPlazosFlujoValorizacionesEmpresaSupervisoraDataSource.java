package com.ositran.util.reportes;

import com.ositran.model.reportes.ControlPlazosFlujoValorizacionesEmpresaSupervisora;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource implements JRDataSource {
    private int index = -1;
    private List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> listadoControlPlazosFlujoValorizacionesEmpresaSupervisora;

    public ControlPlazosFlujoValorizacionesEmpresaSupervisoraDataSource() {
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

        if (fieldName.equals("nomEmpresaSupervisora")) {
            value = getDatos().get(index).getNomEmpresaSupervisora();
        } else if (fieldName.equals("nomConcesion")) {
            value = getDatos().get(index).getNomConcesion();
        } else if (fieldName.equals("nomModalidad")) {
            value = getDatos().get(index).getNomModalidad();
        } else if (fieldName.equals("nomTipoInfraestructura")) {
            value = getDatos().get(index).getNomTipoInfraestructura();
        }
        ////
        else if (fieldName.equals("pre_fecharegistro")) {
            value = getDatos().get(index).getPre_fecharegistro();
        } else if (fieldName.equals("pre_montopresentado")) {
            value = getDatos().get(index).getPre_montopresentado();
        } 
        ////
        else if (fieldName.equals("apro_fecharegistro")) {
            value = getDatos().get(index).getApro_fecharegistro();
        } else if (fieldName.equals("apro_montototalaprob")) {
            value = getDatos().get(index).getApro_montototalaprob();
        }
       

        return value;
    }

    public List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> getDatos() {
        return listadoControlPlazosFlujoValorizacionesEmpresaSupervisora;
    }

    public void setDatos(List<ControlPlazosFlujoValorizacionesEmpresaSupervisora> listadoAvaInvConConc) {
        this.listadoControlPlazosFlujoValorizacionesEmpresaSupervisora = listadoAvaInvConConc;
    }
}
