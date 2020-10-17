package com.isidroevc.hibernate.repository;

import com.isidroevc.hibernate.entity.User;
import org.hibernate.HibernateException;

import java.util.List;

public interface IUserRepository {

    public long createUser(User user) throws HibernateException;

    public User getUser(long id) throws HibernateException;

    public List<User> listAllUsers() throws HibernateException;

}