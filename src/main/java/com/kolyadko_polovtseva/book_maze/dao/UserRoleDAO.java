package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import com.kolyadko_polovtseva.book_maze.domain.UserRole;

/**
 * Created by nadez on 11/27/2016.
 */
public interface UserRoleDAO extends AbstractDAO<UserRole>{
    UserRole find (String roleName) throws DAOException;
}
