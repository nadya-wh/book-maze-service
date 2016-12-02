package com.kolyadko_polovtseva.book_maze.dao.impl;

import com.kolyadko_polovtseva.book_maze.dao.SessionWrapper;
import com.kolyadko_polovtseva.book_maze.dao.UserRoleDAO;
import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by nadez on 11/27/2016.
 */
public class UserRoleDAOImpl implements UserRoleDAO {

    private static final UserRoleDAOImpl instance = new UserRoleDAOImpl();

    public static UserRoleDAOImpl getInstance() {
        return instance;
    }

    private static String FIND_USER_ROLE = "from UserRole where roleName = :roleName";


    @Override
    public UserRole find(String roleName) throws DAOException {
        Session session = null;
        try {
            session = SessionWrapper.getSessionFactory().openSession();
            Query query = session.createQuery(FIND_USER_ROLE);
            query.setParameter("roleName", roleName);
            List<UserRole> roles = query.list();
            if (roles.size() == 1) {
                return roles.get(0);
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
