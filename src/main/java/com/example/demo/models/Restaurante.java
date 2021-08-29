package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "res_restaurantes")
public class Restaurante extends Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    //@NotBlank(message = "Name is mandatory")
    @NotBlank(message = "Campo requerido")
    @Column(length = 30, unique = true)
    String nombre;

    @NotBlank(message = "Campo requerido")
    @Column(length = 30)
    String descripcion;
    @NotBlank(message = "debe contener 8 digitos")
    @Pattern(regexp="^[6-7]\\d{7}$",message="debe contener 8 digitos")
    String telefono;
    @Column(length = 30)
    String estado;
    @Column(length = 300)
    String logo;
    @Column(length = 30)
    String horario;
    @Column(length = 300)
    String latitud;
    @Column(length = 300)
    String longitud;
    @Column(length = 300)
    String direccion;

    //@JsonIgnoreProperties(value = {"restaurantes"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "res_restaurantes_tipos_comidas",
            joinColumns = @JoinColumn(name = "id_restaurante"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_comida"))
    Set<TipoComida> comidas;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
    Set<RestauranteAmbiente> restauranteAmbientes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "res_restaurante_ambientes",
            joinColumns = @JoinColumn(name = "id_restaurante"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_ambiente"))
    @Column(updatable = false, insertable = false)
    Set<TipoAmbiente> ambientes;

    // Date @Temporal


    public Restaurante() {
        comidas = new HashSet<>();
        restauranteAmbientes = new HashSet<>();
        ambientes = new HashSet<>();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<TipoComida> getComidas() {
        return comidas;
    }

    public void setComidas(Set<TipoComida> comidas) {
        this.comidas = comidas;
    }

    public Set<RestauranteAmbiente> getRestauranteAmbientes() {
        return restauranteAmbientes;
    }

    public void setRestauranteAmbientes(Set<RestauranteAmbiente> restauranteAmbientes) {
        this.restauranteAmbientes = restauranteAmbientes;
    }

    public Set<TipoAmbiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(Set<TipoAmbiente> ambientes) {
        this.ambientes = ambientes;
    }
}
