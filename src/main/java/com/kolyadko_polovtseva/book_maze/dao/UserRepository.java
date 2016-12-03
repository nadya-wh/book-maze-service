package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.Category;
import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nadez on 12/3/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findUserByLoginAndPassword(String login, String password);
}
