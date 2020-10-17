package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.repository.CommonRepository;
import com.isidroevc.hibernate.config.HibernateConfig;
import com.isidroevc.hibernate.entity.Materia;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.SessionFactory;
public class RepositorioCentral {
  protected SessionFactory sessionFactory;

  public RepositorioCentral() {
      this.sessionFactory = HibernateConfig.getSessionFactory();
  }


  
  public Materia findMateria(long id) throws HibernateException {
      Session session = this.sessionFactory.getCurrentSession();
      Transaction transaction = session.beginTransaction();
      try {
          Materia materia = (Materia)session.get(Materia.class, id);
          transaction.commit();
          return materia;
      }catch (Exception ex) {
          transaction.rollback();
          throw ex;
      } finally {
          session.close();
      } 
  }

  
  public List<Materia> obtenerMaterias() throws HibernateException {
      Session session = this.sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
          List<Materia> materias = session.createCriteria(Materia.class).list();
          transaction.commit();
          return materias;
      }catch (Exception ex) {
          transaction.rollback();
          throw ex;
      } finally {
          session.close();
      } 
  }

  public Long crear(Materia materia) {
    Session session  = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Long id = (Long) session.save(materia);
        transaction.commit();
        return id;
    } catch(Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }
  }

  public Long actualizar(Materia materia) {
    Session session  = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Long id = (Long) session.save(materia);
        transaction.commit();
        return id;
    } catch(Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }
  }

  public void deleteMateria(Long id) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Materia materia = (Materia)session.get(Materia.class, id);
        if (materia == null) {
            return;
        }
        session.remove(materia);
        transaction.commit();
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }      
}

public void updateMateria(Materia materia) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        session.update(materia);
        transaction.commit();
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }  
}

}