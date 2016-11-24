package com.kolyadko_polovtseva.book_maze.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionWrapper {
    private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        }
       return sessionFactory;
    }
}
