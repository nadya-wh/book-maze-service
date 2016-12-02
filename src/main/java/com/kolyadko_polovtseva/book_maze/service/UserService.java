package com.kolyadko_polovtseva.book_maze.service;


import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.exception.ServiceException;

/**
 * Created by nadez on 10/22/2016.
 */
public interface UserService {

    void save(User user, String role) throws ServiceException;

    User find(String login, String password) throws ServiceException;
}
