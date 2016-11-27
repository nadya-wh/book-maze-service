package com.kolyadko_polovtseva.book_maze.main;

import com.kolyadko_polovtseva.book_maze.controller.UserController;
import com.kolyadko_polovtseva.book_maze.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by nadez on 11/24/2016.
 */

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
