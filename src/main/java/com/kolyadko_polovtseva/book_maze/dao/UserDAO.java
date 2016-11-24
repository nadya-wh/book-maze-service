package com.kolyadko_polovtseva.book_maze.dao;


import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import com.kolyadko_polovtseva.book_maze.domain.User;


public interface UserDAO extends AbstractDAO<User> {

    User find(String login, String password) throws DAOException;
}
