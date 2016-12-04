package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */

@RestController
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategoryPOST(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategory(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }
}
