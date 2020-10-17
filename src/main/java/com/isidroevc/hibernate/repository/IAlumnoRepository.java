package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.entity.Alumno;
import org.hibernate.HibernateException;

import java.util.List;

public interface IAlumnoRepository {

    public Long createAlumno(Alumno lead) throws HibernateException;

    public Alumno getAlumno(long id) throws HibernateException;

    public List<Alumno> listAllAlumnos() throws HibernateException;

}