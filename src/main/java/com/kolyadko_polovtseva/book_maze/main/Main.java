package com.kolyadko_polovtseva.book_maze.main;

import com.kolyadko_polovtseva.book_maze.controller.UserController;
import com.kolyadko_polovtseva.book_maze.search.LuceneUtil;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.CategoryService;
import com.kolyadko_polovtseva.book_maze.service.impl.CategoryServiceImpl;
import com.kolyadko_polovtseva.book_maze.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by nadez on 11/24/2016.
 */

@SpringBootApplication
@ComponentScan("com.kolyadko_polovtseva.book_maze")
@EnableJpaRepositories("com.kolyadko_polovtseva.book_maze.dao")
@EntityScan("com.kolyadko_polovtseva.book_maze.entity")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        new LuceneUtil().prepare();
    }
}
