package com.example.APIAdoptame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name ="animales")
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String tipo;
    private int edad;
    private String descripcion;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "refugio_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Refugio refugio;

    @ManyToOne
    @JoinColumn(name = "adoptante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Adoptante adoptante;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
}
