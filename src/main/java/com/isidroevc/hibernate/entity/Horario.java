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
    @Column(name="detalle")
    private String detalle;
    @Column(name="dias")
    private String dias;
    @Column(name="id_turno")
    private Integer idTurno;
    public Horario() {

    }

    public Horario(String detalle) {
        this.detalle = detalle;
    }

    public Long getId() {
        return this.id;
    }

    public void setDetalle(String detalle) {
      this.detalle = detalle;
    }

    public String getDetalle() {
      return this.detalle;
    }

    public void setDias(String dias) {
      this.dias = dias;
    }

    public String getDias() {
      return this.dias;
    }

    public void setIdTurno(Integer idTurno) {
      this.idTurno = idTurno;
    }

    public Integer getIdTurno() {
      return this.idTurno;
    }

    @ManyToOne
    @JoinColumn(name = "id_turno", referencedColumnName = "id", insertable=false, updatable=false)
    private Turno turno;

    public void setTurno(Turno turno) {
      this.turno = turno;
    }

    public Turno getTurno() {
      return this.turno;
    }
}