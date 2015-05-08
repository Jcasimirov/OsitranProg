package com.ositran.util.reportes;

import com.ositran.model.reportes.AvaInvConConc;

import com.ositran.model.reportes.EmpSupInfAeropuerto;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class EmpSupInfAeropuertoDataSource implements JRDataSource {
    private int index = -1;
    private List<EmpSupInfAeropuerto> listadoEmpSupInfAeropuerto;

    public EmpSupInfAeropuertoDataSource() {
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
        } else if (fieldName.equals("nomModalidad")) {
            value = getDatos().get(index).getNomModalidad();
        } else if (fieldName.equals("nomAeropuerto")) {
            value = getDatos().get(index).getNomAeropuerto();
        } else if (fieldName.equals("nomInversion")) {
            value = getDatos().get(index).getNomInversion();
        } else if (fieldName.equals("nomEmpresaSupervisora")) {
            value = getDatos().get(index).getNomEmpresaSupervisora();
        } 

        return value;
    }

    public List<EmpSupInfAeropuerto> getDatos() {
        return listadoEmpSupInfAeropuerto;
    }

    public void setDatos(List<EmpSupInfAeropuerto> listadoAvaInvConConc) {
        this.listadoEmpSupInfAeropuerto = listadoAvaInvConConc;
    }
}
