package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.entity.UserRole;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import com.kolyadko_polovtseva.book_maze.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nadez on 11/24/2016.
 */
@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    public static final String DATE_FORMAT = "MM/dd/yyyy";

    private UserService userService;

    public UserController() {
        userService = UserServiceImpl.getInstance();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/auth")
    public ResponseEntity<User> signIn(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password) {

        User user = userService.find(login, password);
        if (user == null) {
            user = new User();
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<User> signUp(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "firstName") String firstName,
                                       @RequestParam(value = "lastName") String lastName,
                                       @RequestParam(value = "birthDate")String birthDateString,
                                       @RequestParam(value = "libraryId") String libraryId) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Date birthDate = null;
        try {
            birthDate = df.parse(birthDateString);
        } catch (ParseException e) {
            logger.error(e);
        }
        User user = new User(login, password, libraryId, firstName, lastName, birthDate);
        userService.save(user, UserRole.USER);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
