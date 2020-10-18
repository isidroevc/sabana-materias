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
@Table(name="profesor_tiene_materia_en_horario_con_grupo")
public class ProfesorTieneMateriaEnHorarioConGrupo {

    @Id
    private long id;
    @Column(name="id_profesor")
    private Long idProfesor;

    @Column(name="id_materia")
    private Long idMateria;

    @Column(name="id_horario")
    private Long idHorario;

    @Column(name="id_aula")
    private Long idAula;

    @Column(name="id_grupo")
    private Long idGrupo;

    public ProfesorTieneMateriaEnHorarioConGrupo() {}
    public ProfesorTieneMateriaEnHorarioConGrupo(
      Long idProfesor,
      Long idMateria,
      Long idHorario,
      Long idAula,
      Long idGrupo
    ) {
      this.idProfesor = idProfesor;
      this.idMateria = idMateria;
      this.idHorario = idHorario;
      this.idAula = idAula;
      this.idGrupo = idGrupo;
    }

    public Long getId() {
        return this.id;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id",  insertable=false, updatable=false)
    private User profesor;

    public void setProfesor(User profesor) {
      this.profesor = profesor;
    }

    public User getProfesor() {
      return this.profesor;
    }

    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id",  insertable=false, updatable=false)
    private Materia materia;

    public void setMateria(Materia materia) {
      this.materia = materia;
    }

    public Materia getMateria() {
      return this.materia;
    }

    @ManyToOne
    @JoinColumn(name = "id_aula", referencedColumnName = "id",  insertable=false, updatable=false)
    private Aula aula;

    public void setAula(Aula aula) {
      this.aula = aula;
    }

    public Aula getAula() {
      return this.aula;
    }

    
    @ManyToOne
    @JoinColumn(name = "id_horario", referencedColumnName = "id",  insertable=false, updatable=false)
    private Horario horario;

    public void setMateria(Horario horario) {
      this.horario = horario;
    }

    public Horario getHorario() {
      return this.horario;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id",  insertable=false, updatable=false)
    private Grupo grupo;

    public void setMateria(Grupo grupo) {
      this.grupo = grupo;
    }

    public Grupo getGrupo() {
      return this.grupo;
    }
}