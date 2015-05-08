package com.ositran.util.reportes;

/*
 * Clase: EmpSupInfDataSource
 * Descripcion: Esta clase sirve para enlazar un listado simple de EmpSupInf con Jasperreports
 * Autor: E. Alfredo Panitz R.
 * Fecha: 30/04/2015
 */

import com.ositran.model.reportes.EmpSupInf;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class EmpSupInfDataSource implements JRDataSource {
    
    private int index = -1;
    private List<EmpSupInf> listadoEmpSupInf;

    @Override
    public boolean next() throws JRException {
        index++;
        return (index<getListadoEmpSupInf().size());
    }
    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();
        
        if(fieldName.equals("nomTipInfraestructura")){
            value = getListadoEmpSupInf().get(index).getNomTipInfraestructura();
        }else if(fieldName.equals("nomConcesion")){
            value = getListadoEmpSupInf().get(index).getNomConcesion();
        }else if(fieldName.equals("nomModalidad")){
            value = getListadoEmpSupInf().get(index).getNomModalidad();
        }else if(fieldName.equals("nomEmpSupervisora")){
            value = getListadoEmpSupInf().get(index).getNomEmpSupervisora();
        }
        
        return value; 
    }

    public List<EmpSupInf> getListadoEmpSupInf() {
        return listadoEmpSupInf;
    }

    public void setListadoEmpSupInf(List<EmpSupInf> listadoEmpSupInf) {
        this.listadoEmpSupInf = listadoEmpSupInf;
    }
}
