package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.repository.CommonRepository;
import com.isidroevc.hibernate.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;

public class UserRepository extends CommonRepository implements IUserRepository {

    @Override
    public long createUser(User user) throws HibernateException {
        return super.saveEntity(user);
    }

    @Override
    public User getUser(long id) throws HibernateException {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = (User)session.get(User.class, new Long(id));
            transaction.commit();
            return user;
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        } 
    }

    @Override
    public List<User> listAllUsers() throws HibernateException {
        Session session = this.sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
        try {
            List<User> users = session.createCriteria(User.class).list();
            transaction.commit();
            return users;
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        } 
    }

    public void deleteUser(long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = (User)session.get(User.class, new Long(id));
            if (user == null) {
                return;
            }
            session.remove(user);
            transaction.commit();
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }      
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
        }catch (Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }  
    }

    public User getUserByUsername(String username) {
      String hql  = "FROM User u WHERE u.username = :username";
      Session session = this.sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      try {
          Query query = session.createQuery(hql);
          query.setParameter("username", username);
          
          List results = query.list();
          if (results.size() > 0) {
            transaction.commit();
            return (User)results.get(0);
          }
          transaction.commit();
          return null;
      }catch (Exception ex) {
          transaction.rollback();
          throw ex;
      } finally {
          session.close();
      }  
    }

}