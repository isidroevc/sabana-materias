package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.repository.CommonRepository;
import com.isidroevc.hibernate.entity.Alumno;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;

public class AlumnoRepository extends CommonRepository implements IAlumnoRepository {

    @Override
    public Long createAlumno(Alumno alumno) throws HibernateException {
        return super.saveEntity(alumno);
    }

    @Override
    public Alumno getAlumno(long id) throws HibernateException {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Alumno alumno = (Alumno)session.get(Alumno.class, id);
            transaction.commit();
            return alumno;
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        } 
    }

    @Override
    public List<Alumno> listAllAlumnos() throws HibernateException {
        Session session = this.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
        try {
            List<Alumno> leads = session.createCriteria(Alumno.class).list();
            transaction.commit();
            return leads;
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        } 
    }

    public void deleteAlumno(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Alumno alumno = (Alumno)session.get(Alumno.class, id);
            if (alumno == null) {
                return;
            }
            session.remove(alumno);
            transaction.commit();
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }      
    }

    public void updateAlumno(Alumno alumno) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(alumno);
            transaction.commit();
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }  
    }

}