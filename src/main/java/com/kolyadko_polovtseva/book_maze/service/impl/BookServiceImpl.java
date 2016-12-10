package com.kolyadko_polovtseva.book_maze.service.impl;

import com.kolyadko_polovtseva.book_maze.dao.BookRepository;
import com.kolyadko_polovtseva.book_maze.dao.CategoryRepository;
import com.kolyadko_polovtseva.book_maze.dao.LibraryBookRepository;
import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nadez on 12/4/2016.
 */
@Component("BookServiceImpl")
@Transactional
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final LibraryBookRepository libraryBookRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, LibraryBookRepository libraryBookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.libraryBookRepository = libraryBookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }

    @Override
    public List<Book> findByCategory(Integer categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        return bookRepository.findBooksByCategory(category);
    }

    @Override
    public Book find(Integer bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(String bookId) {
        return libraryBookRepository.findOne(bookId);
    }

    @Override
    public LibraryBook findLibraryBook(Book book) {
        return libraryBookRepository.findLibraryBookByBook(book);
    }



}
