package com.kolyadko_polovtseva.book_maze.service.impl;


import com.kolyadko_polovtseva.book_maze.dao.UserDAO;
import com.kolyadko_polovtseva.book_maze.dao.UserRoleDAO;
import com.kolyadko_polovtseva.book_maze.dao.exception.DAOException;
import com.kolyadko_polovtseva.book_maze.dao.impl.UserDAOImpl;
import com.kolyadko_polovtseva.book_maze.dao.impl.UserRoleDAOImpl;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import com.kolyadko_polovtseva.book_maze.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();
    private UserDAO userDAO;
    private UserRoleDAO userRoleDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserServiceImpl() {
        this.userDAO = UserDAOImpl.getInstance();
        this.userRoleDAO = UserRoleDAOImpl.getInstance();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public void save(User user, String role) throws ServiceException {
        try {
            UserRole userRole = userRoleDAO.find(role);
            user.setUserRole(userRole);
            userDAO.save(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User find(String login, String password) throws ServiceException {
        try {
            return userDAO.find(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
