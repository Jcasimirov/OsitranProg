package com.ositran.util.reportes;

import com.ositran.model.reportes.EmpSupInf;

import com.ositran.model.reportes.InversionesTipoConcepto;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import com.ositran.model.*;

public class InversionesTipoConceptoDataSource implements JRDataSource {
    
    private int index = -1;
    private List<InversionesTipoConcepto> listadoEmpSupInf;

    @Override
    public boolean next() throws JRException {
        index++;
        return (index<getDatos().size());
    }
    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();
        
        if(fieldName.equals("nomConcesion")){
          return  value = getDatos().get(index).getNomConcesion();
        }else if(fieldName.equals("nomConcesionario")){
          return  value = getDatos().get(index).getNomConcesionario();
        }else if(fieldName.equals("nomModalidad")){
          return  value = getDatos().get(index).getNomModalidad();
        }else if(fieldName.equals("nomTipoInfraestructura")){
          return  value = getDatos().get(index).getNomTipoInfraestructura();
        }else if(fieldName.equals("lstDetalle")){
          return  value = getDatos().get(index).getLstDetalle();
        }
        
        return value; 
    }

    public List<InversionesTipoConcepto> getDatos() {
        return listadoEmpSupInf;
    }

    public void setDatos(List<InversionesTipoConcepto> listadoEmpSupInf) {
        this.listadoEmpSupInf = listadoEmpSupInf;
    }
}
