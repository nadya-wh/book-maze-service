package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import com.kolyadko_polovtseva.book_maze.entity.LibraryBook;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nadez on 12/10/2016.
 */
public interface LibraryBookRepository extends CrudRepository<LibraryBook, String> {

    LibraryBook findLibraryBookByBook(Book book);
}
