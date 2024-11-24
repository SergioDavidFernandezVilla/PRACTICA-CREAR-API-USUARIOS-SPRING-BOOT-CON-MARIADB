package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="dni")
    private String dni;

    @Column(name="sueldo")
    private Double sueldo;

    public Usuario () {}

    public Usuario(Long id,String nombre, String apellidos, String dni, Double sueldo){
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.sueldo=sueldo;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre= nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos (String apellidos) {
        this.apellidos= apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni (String dni) {
        this.dni = dni;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + ", sueldo=" + sueldo + "]";
    }
    }

