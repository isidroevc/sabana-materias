package com.isidroevc.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
@Entity
@Table(name="alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="numero_de_control")
    private String numeroDeControl;
    @Column(name="nombre")
    private String nombre;
    @Column(name="curso")
    private String curso;
    @Column(name="semestre")
    private int semestre;
    public Alumno() {

    }
    public Alumno(String numeroDeContorl, String nombre, String curso, int semestre) {
        this.numeroDeControl = numeroDeContorl;
        this.nombre = nombre;
        this.curso = curso;
        this.semestre = semestre;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroDeControl() {
        return this.numeroDeControl;
    }

    public void setNumeroDeControl(String numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}