package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.config.HibernateConfig;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CommonRepository {

    protected SessionFactory sessionFactory;

    public CommonRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    protected Long saveEntity(Object obj) throws HibernateException {
        Session session  = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Long id = (Long) session.save(obj);
            transaction.commit();
            return id;
        } catch(Exception ex) {
            transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
}