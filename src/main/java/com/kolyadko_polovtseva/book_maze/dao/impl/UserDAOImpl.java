package com.kolyadko_polovtseva.book_maze.dao.impl;


import com.kolyadko_polovtseva.book_maze.dao.SessionWrapper;
import com.kolyadko_polovtseva.book_maze.dao.UserDAO;
import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import com.kolyadko_polovtseva.book_maze.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class UserDAOImpl implements UserDAO {

    private static final UserDAOImpl instance = new UserDAOImpl();

    public static UserDAOImpl getInstance() {
        return instance;
    }

    private static String FIND_USER_LOGIN_PASSWORD = "from User where login = :login AND password = :password";


    @Override
    public User find(String login, String password) throws DAOException {
        Session session = null;
        try {
            session = SessionWrapper.getSessionFactory().openSession();
            Query query = session.createQuery(FIND_USER_LOGIN_PASSWORD);
            query.setParameter("login", login);
            query.setParameter("password", password);
            List<User> userList = query.list();
            if (userList.size() == 1) {
                return userList.get(0);
            }
        } catch (HibernateException e) {
            throw new DAOException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
