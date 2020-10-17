package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
@Entity
@Table(name="materia")
public class Materia {

    @Id
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="creditos")
    private Integer creditos;

    public Materia() {

    }

    public Materia(String nombre, int creditos) {
        this.creditos = creditos;
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

    public void setCreditos(int creditos) {
      this.creditos = creditos;
    }

    public Integer getCreditos() {
      return this.creditos;
    }


}