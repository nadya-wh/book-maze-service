package com.kolyadko_polovtseva.book_maze.controller;

import com.kolyadko_polovtseva.book_maze.entity.*;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import com.kolyadko_polovtseva.book_maze.service.RegisterRecordService;
import com.kolyadko_polovtseva.book_maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */

@RestController
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("RegisterRecordServiceImpl")
    private RegisterRecordService registerRecordService;


    @RequestMapping(method = RequestMethod.POST, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategoryPOST(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/category")
    public ResponseEntity<List<Book>> findByCategory(@RequestParam(value = "category") Integer categoryId) {
        return new ResponseEntity<>(bookService.findByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/books/reserved/mine")
    public ResponseEntity<List<RegisterRecord>> findReserved(@RequestParam(value = "userId") String token) {
        User user = new User();
        user.setLogin(token);
        return new ResponseEntity<>(registerRecordService.findByUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/books/reserved")
    public ResponseEntity<RegisterRecord> reserveBook(@RequestParam(value = "book") String bookId,
                                                      @RequestParam(value = "userId") String login,
                                                      @RequestParam(value = "token", defaultValue = "") String token) {
        User user = new User();
        user.setLogin(login);
//        Book book = bookService.find(bookId);
        LibraryBook libraryBook = bookService.findLibraryBook(bookId);
        if (libraryBook == null) {
            return new ResponseEntity<>(new RegisterRecord(), HttpStatus.FORBIDDEN);
        }

        RegisterRecord registerRecord = new RegisterRecord();
        registerRecord.setUser(user);
        registerRecord.setLibraryBook(libraryBook);
        registerRecord.setReserveDate(new Date());
        registerRecord.setReturnDeadline(new Date());
        registerRecord = registerRecordService.save(registerRecord);
        if (registerRecord.getIdRegister() != null) {
            return new ResponseEntity<>(registerRecord, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RegisterRecord(), HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/books/search")
    public ResponseEntity<List<Book>> search(@RequestParam(value = "query") String query) {
        Iterable<Book> books = bookService.search(query);
        List<Book> bookList = new ArrayList<>();
        books.forEach(bookList::add);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
//    public ResponseEntity<Book> createBook(@RequestParam(value = "bookName") String bookName) {
//
//    }


}
