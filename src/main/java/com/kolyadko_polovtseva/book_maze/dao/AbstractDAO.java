package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public interface AbstractDAO<T> {
    default void save(T entity) throws DAOException {
        Session session = null;
        try  {
            session = SessionWrapper.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }  catch (HibernateException e) {
            throw new DAOException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
