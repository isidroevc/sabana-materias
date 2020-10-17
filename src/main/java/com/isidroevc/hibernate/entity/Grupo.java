package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
@Entity
@Table(name="grupo")
public class Grupo {

    @Id
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="numero_alumnos")
    private Integer numeroAlumnos;

    public Grupo() {

    }

    public Grupo(String nombre, int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getNombre() {
      return this.nombre;
    }

    public void setNumeroAlumnos(Integer numeroAlumnos) {
      this.numeroAlumnos = numeroAlumnos;
    }

    public Integer getNumeroAlumnos() {
      return this.numeroAlumnos;
    }


}