package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by nadez on 12/2/2016.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();
}
