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
@Table(name="ProfesorTieneMateriaEnHorarioConGrupo")
public class ProfesorTieneMateriaEnHorarioConGrupo {

    @Id
    private long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="id_profesor")
    private Integer idProfesor;

    @Column(name="id_materia")
    private Integer idMateria;

    @Column(name="id_horario")
    private Integer idHorario;

    @Column(name="id_aula")
    private Integer idAula;

    @Column(name="id_grupo")
    private Integer idGrupo;


    public ProfesorTieneMateriaEnHorarioConGrupo() {

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

    @ManyToOne
    @JoinColumn(name = "idProfesor", referencedColumnName = "id")
    private User profesor;

    public void setProfesor(User profesor) {
      this.profesor = profesor;
    }

    public User getProfesor() {
      return this.profesor;
    }

    @ManyToOne
    @JoinColumn(name = "idMateria", referencedColumnName = "id")
    private Materia materia;

    public void setMateria(Materia materia) {
      this.materia = materia;
    }

    public Materia getMateria() {
      return this.materia;
    }

    
    @ManyToOne
    @JoinColumn(name = "idHorario", referencedColumnName = "id")
    private Horario horario;

    public void setMateria(Horario horario) {
      this.horario = horario;
    }

    public Horario getHorario() {
      return this.horario;
    }

    @ManyToOne
    @JoinColumn(name = "idGrupo", referencedColumnName = "id")
    private Grupo grupo;

    public void setMateria(Grupo grupo) {
      this.grupo = grupo;
    }

    public Grupo getGrupo() {
      return this.grupo;
    }
}