package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.domain.User;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nadez on 11/24/2016.
 */
@RestController
public class UserController {
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public ResponseEntity<User> signIn(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password) {

        User user = userService.find(login, password);
        if (user != null) {

        }
        return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
    }
}
