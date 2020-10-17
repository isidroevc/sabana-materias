package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
@Entity
@Table(name="horario")
public class Horario {

    @Id
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="id_turno")
    private Integer idTurno;

    public Horario() {

    }

    public Horario(String nombre, int idTurno) {
        this.idTurno = idTurno;
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

    public void setIdTurno(Integer idTurno) {
      this.idTurno = idTurno;
    }

    public Integer getIdTurno() {
      return this.idTurno;
    }

    @ManyToOne
    @JoinColumn(name = "idTurno", referencedColumnName = "id")
    private Turno turno;

    public void setTurno(Turno turno) {
      this.turno = turno;
    }

    public Turno getTurno() {
      return this.turno;
    }
}