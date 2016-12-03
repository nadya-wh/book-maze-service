package com.kolyadko_polovtseva.book_maze.service.impl;


import com.kolyadko_polovtseva.book_maze.dao.UserRepository;
import com.kolyadko_polovtseva.book_maze.dao.UserRoleRepository;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import com.kolyadko_polovtseva.book_maze.service.exception.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userDAO;
    private final UserRoleRepository userRoleDAO;

    public UserServiceImpl(UserRepository userDAO, UserRoleRepository userRoleDAO) {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public void save(User user, String role) throws ServiceException {
        UserRole userRole = userRoleDAO.findUserRoleByRoleName(role);
        user.setUserRole(userRole);
        userDAO.save(user);

    }

    @Override
    public User find(String login, String password) throws ServiceException {
        return userDAO.findUserByLoginAndPassword(login, password);
    }

}
