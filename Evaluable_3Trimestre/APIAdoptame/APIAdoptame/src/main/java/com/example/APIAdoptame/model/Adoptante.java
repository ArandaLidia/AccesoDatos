package com.example.APIAdoptame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "adoptantes")
public class Adoptante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String email;
    @Column
    private String direccion;
    @Column
    private String dni;


    @OneToMany(mappedBy = "adoptante", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Animal> animalesAdoptados;

    public Adoptante() {
    }

    public Adoptante(int id, String nombre, String telefono, String email, String direccion, String dni, List<Animal> animalesAdoptados) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.dni = dni;
        this.animalesAdoptados = animalesAdoptados;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public List<Animal> getAnimalesAdoptados() {
        return animalesAdoptados;
    }

    public void setAnimalesAdoptados(List<Animal> animalesAdoptados) {
        this.animalesAdoptados = animalesAdoptados;
    }
}
