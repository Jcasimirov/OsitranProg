package com.ositran.dao;

import com.ositran.model.InvAvn;
import com.ositran.model.ValorizacionNotificacion;

import java.sql.SQLException;

import java.util.List;

public interface NotificacionDAO {
    public List<InvAvn> ListarDeclaraciones() throws SQLException;
    public String NotificarInversion(InvAvn invAvn, ValorizacionNotificacion valorizacionNotificacion) throws SQLException;
    public List<InvAvn> obtenerDeclaracionesxIdContrato(int idcontrato) throws SQLException;
    public List<InvAvn> ListarDeclaracionesSupervContratoCompromiso(int contratoCompromisoId) throws SQLException;
}
