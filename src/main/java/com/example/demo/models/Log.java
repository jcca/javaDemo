package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import java.util.Date;

public abstract class Log {
    @JsonIgnore
    Date fechaAlta;

    @JsonIgnore
    @Column(name = "id_usuario_alta")
    Long usuarioAltaId;

    @JsonIgnore
    Date fechaBaja;

    @JsonIgnore
    @Column(name = "id_usuario_baja")
    Long usuarioBajaId;

    @JsonIgnore
    Date fechaDesde;

    @JsonIgnore
    @Column(name = "id_usuario_desde")
    Long usuarioDesdeId;

    @JsonIgnore
    Date fechaHasta;

    @JsonIgnore
    @Column(name = "id_usuario_hasta")
    Long usuarioHastaId;

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Long getUsuarioAltaId() {
        return usuarioAltaId;
    }

    public void setUsuarioAltaId(Long usuarioAltaId) {
        this.usuarioAltaId = usuarioAltaId;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Long getUsuarioBajaId() {
        return usuarioBajaId;
    }

    public void setUsuarioBajaId(Long usuarioBajaId) {
        this.usuarioBajaId = usuarioBajaId;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Long getUsuarioDesdeId() {
        return usuarioDesdeId;
    }

    public void setUsuarioDesdeId(Long usuarioDesdeId) {
        this.usuarioDesdeId = usuarioDesdeId;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Long getUsuarioHastaId() {
        return usuarioHastaId;
    }

    public void setUsuarioHastaId(Long usuarioHastaId) {
        this.usuarioHastaId = usuarioHastaId;
    }
}
