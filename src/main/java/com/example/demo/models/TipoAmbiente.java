package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "res_tipo_ambientes")
public class TipoAmbiente extends Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 30)
    String nombre;
    @Column(length = 30)
    String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoAmbiente", fetch = FetchType.LAZY)
    Set<RestauranteAmbiente> restauranteAmbientes;

    public TipoAmbiente() {
        restauranteAmbientes = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<RestauranteAmbiente> getRestauranteAmbientes() {
        return restauranteAmbientes;
    }

    public void setRestauranteAmbientes(Set<RestauranteAmbiente> restauranteAmbientes) {
        this.restauranteAmbientes = restauranteAmbientes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipoAmbiente)) {
            return false;
        }
        TipoAmbiente ambiente = (TipoAmbiente) obj;

        return this.id != null && this.id.equals(ambiente.getId());
    }
}
