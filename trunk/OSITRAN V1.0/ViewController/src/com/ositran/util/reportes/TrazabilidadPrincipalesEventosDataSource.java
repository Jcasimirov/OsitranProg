package com.ositran.util.reportes;

import com.ositran.model.reportes.InversionesTipoConceptoDetalle;

import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import com.ositran.model.reportes.TrazabilidadPrincipalesEventos;

public class TrazabilidadPrincipalesEventosDataSource implements JRDataSource {
    private int index = -1;
    private List<TrazabilidadPrincipalesEventos> listadoTrazabilidadPrincipalesEventos;

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < getDatos().size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;
        String fieldName = jrf.getName();

        if (fieldName.equals("nomConcesion")) {
            return value = getDatos().get(index).getNomConcesion();
        } else if (fieldName.equals("nomConcesionario")) {
            return value = getDatos().get(index).getNomConcesionario();
        } else if (fieldName.equals("nomTipoInfraestructura")) {
            return value = getDatos().get(index).getNomTipoInfraestructura();
        } else if (fieldName.equals("nomModalidad")) {
            return value = getDatos().get(index).getNomModalidad();
        }  else if (fieldName.equals("nroValorizacion")) {
            return value = getDatos().get(index).getNroValorizacion();
        } else if (fieldName.equals("fechaRegistro")) {
            return value = getDatos().get(index).getFechaRegistro();
        }
        //ING_VAL
        else if (fieldName.equals("ingval_nrohranio")) {
            return value = getDatos().get(index).getIngval_nrohranio();
        } else if (fieldName.equals("ingval_fechaRegistro")) {
            return value = getDatos().get(index).getIngval_fechaRegistro();
        } else if (fieldName.equals("ingval_montopresentado")) {
            return value = getDatos().get(index).getIngval_montopresentado();
        } else if (fieldName.equals("ingval_moneda")) {
            return value = getDatos().get(index).getIngval_moneda();
        }
        //derval
        else if (fieldName.equals("derval_nrooficio")) {
            return value = getDatos().get(index).getDerval_nrooficio();
        } else if (fieldName.equals("derval_nroregistro")) {
            return value = getDatos().get(index).getDerval_nroregistro();
        } else if (fieldName.equals("derval_plazodias")) {
            return value = getDatos().get(index).getDerval_plazodias();
        }else if (fieldName.equals("derval_fechalimite")) {
            return value = getDatos().get(index).getDerval_fechalimite();
        }
        //revssuper
        else if (fieldName.equals("revssuper_nrohranio")) {
            return value = getDatos().get(index).getRevssuper_nrohranio();
        } else if (fieldName.equals("revssuper_fecharegistro")) {
            return value = getDatos().get(index).getRevssuper_fecharegistro();
        } else if (fieldName.equals("revssuper_montorevisado")) {
            return value = getDatos().get(index).getRevssuper_montorevisado();
        }else if (fieldName.equals("revssuper_moneda")) {
            return value = getDatos().get(index).getRevssuper_moneda();
        }
        //recsup
        else if (fieldName.equals("recsupinv_nrooficio")) {
            return value = getDatos().get(index).getRecsupinv_nrooficio();
        } else if (fieldName.equals("recsupinv_nroregsalofi")) {
            return value = getDatos().get(index).getRecsupinv_nroregsalofi();
        } else if (fieldName.equals("recsupinv_totalreconocido")) {
            return value = getDatos().get(index).getRecsupinv_totalreconocido();
        }else if (fieldName.equals("recsupinv_totalconreajuste")) {
            return value = getDatos().get(index).getRecsupinv_totalconreajuste();
        }

        return value;
    }

    public List<TrazabilidadPrincipalesEventos> getDatos() {
        return listadoTrazabilidadPrincipalesEventos;
    }

    public void setDatos(List<TrazabilidadPrincipalesEventos> listadoTrazabilidadPrincipalesEventos) {
        this.listadoTrazabilidadPrincipalesEventos = listadoTrazabilidadPrincipalesEventos;
    }
}
