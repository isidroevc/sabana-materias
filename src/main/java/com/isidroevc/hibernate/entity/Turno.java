package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
@Entity
@Table(name="turno")
public class Turno {

    @Id
    private long id;
    @Column(name="nombre")
    private String nombre;

    public Turno() {

    }

    public Turno(String nombre) {
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

    @OneToMany
    @JoinColumn(name = "id_turno", referencedColumnName = "id")
    private List<Horario> horarios;

    public void setHorarios(List<Horario> horarios) {
      this.horarios = horarios;
    }

    public List<Horario> getHorarios() {
      return this.horarios;
    }
}