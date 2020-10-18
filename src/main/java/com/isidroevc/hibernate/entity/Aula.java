package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
@Entity
@Table(name="Aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;

    public Aula() {

    }

    public Aula(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
      this.id = id;
  }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getNombre() {
      return this.nombre;
    }

}