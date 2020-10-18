package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.repository.CommonRepository;
import com.isidroevc.hibernate.config.HibernateConfig;
import com.isidroevc.hibernate.entity.Horario;
import com.isidroevc.hibernate.entity.Materia;
import com.isidroevc.hibernate.entity.Grupo;
import com.isidroevc.hibernate.entity.Aula;
import com.isidroevc.hibernate.entity.User;
import com.isidroevc.hibernate.entity.ProfesorTieneMateriaEnHorarioConGrupo;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

  public User findProfesor(long id) throws HibernateException {
    Session session = this.sessionFactory.getCurrentSession();
    Transaction transaction = session.beginTransaction();
    try {
        User materia = (User)session.get(User.class, id);
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

  public Long crearMateria(Materia materia) {
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



  public void eliminarMateria(Long id) {
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

public void actualizarMateria(Materia materia) {
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

public List<User> obtenerProfesores() throws HibernateException {
    String hql  = "FROM User u WHERE u.rol = :rol";
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Query query = session.createQuery(hql);
        query.setParameter("rol", "profesor");
        
        List results = query.list();
        
        transaction.commit();
        return results;
        
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }   
}

public List<Horario> obtenerHorarios() throws HibernateException {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        List<Horario> materias = session.createCriteria(Horario.class).list();
        transaction.commit();
        return materias;
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    } 
}

public List<Aula> obtenerAulas() throws HibernateException {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        List<Aula> materias = session.createCriteria(Aula.class).list();
        transaction.commit();
        return materias;
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    } 
}

public List<Grupo> obtenerGrupos() throws HibernateException {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        List<Grupo> materias = session.createCriteria(Grupo.class).list();
        transaction.commit();
        return materias;
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    } 
}


public Long crearRegistroHorario(ProfesorTieneMateriaEnHorarioConGrupo registro) {
    Session session  = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Long id = (Long) session.save(registro);
        transaction.commit();
        return id;
    } catch(Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }
  }

  public List<ProfesorTieneMateriaEnHorarioConGrupo> obtenerRegistrosHorario() throws HibernateException {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        List<ProfesorTieneMateriaEnHorarioConGrupo> materias = session.createCriteria(ProfesorTieneMateriaEnHorarioConGrupo.class).list();
        transaction.commit();
        return materias;
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    } 
}

public void eliminarRegistroHorario(Long id) {
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        ProfesorTieneMateriaEnHorarioConGrupo materia = (ProfesorTieneMateriaEnHorarioConGrupo)session.get(ProfesorTieneMateriaEnHorarioConGrupo.class, id);
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

public List<ProfesorTieneMateriaEnHorarioConGrupo> obtenerReporteProfesor(Long idProfesor) throws HibernateException {
    String hql  = "FROM ProfesorTieneMateriaEnHorarioConGrupo p WHERE p.idProfesor = :idProfesor";
    Session session = this.sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        Query query = session.createQuery(hql);
        query.setParameter("idProfesor", idProfesor);
        
        List results = query.list();
        
        transaction.commit();
        return results;
        
    }catch (Exception ex) {
        transaction.rollback();
        throw ex;
    } finally {
        session.close();
    }
}
}