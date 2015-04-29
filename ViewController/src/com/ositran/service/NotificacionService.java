package com.ositran.service;


import com.ositran.vo.bean.InvAvnVO;
import com.ositran.vo.bean.InvReajusteVO;
import com.ositran.vo.bean.InvReconocimientoVO;
import com.ositran.vo.bean.InvVO;
import com.ositran.vo.bean.ValorizacionNotificacionVO;

import java.sql.SQLException;

import java.util.List;

public interface NotificacionService {
    public List<InvAvnVO> ListarDeclaraciones() throws SQLException;
    public String NotificarInversion(InvAvnVO invAvnVO, ValorizacionNotificacionVO valorizacionNotificacionVO) throws SQLException;
    public List<InvAvnVO> ListarDeclaracionesSupervContratoCompromiso(int contratoCompromisoId) throws SQLException;
    public List<InvAvnVO> obtenerDeclaracionesxIdContrato(int idcontrato) throws SQLException;
    public void updateRectificacion(InvAvnVO invAvnvo,List<InvReconocimientoVO> reconocimientoVO,List<InvReajusteVO> reajusteVO,InvVO invVO)throws Exception;

}
