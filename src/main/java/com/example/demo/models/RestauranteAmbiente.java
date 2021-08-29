package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "res_restaurante_ambientes")
public class RestauranteAmbiente extends Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "id_restaurante", updatable = false, insertable = false)
    private Long restauranteId;

    @Column(name = "id_tipo_ambiente", updatable = false, insertable = false)
    private Long tipoAmbienteId;

    //@JsonIgnoreProperties(value = {"restaurante"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante")
    Restaurante restaurante;

    //@JsonIgnoreProperties(value = {"tipoAmbiente"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ambiente")
    TipoAmbiente tipoAmbiente;

    int grade;

    public RestauranteAmbiente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Long getTipoAmbienteId() {
        return tipoAmbienteId;
    }

    public void setTipoAmbienteId(Long tipoAmbienteId) {
        this.tipoAmbienteId = tipoAmbienteId;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public TipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
