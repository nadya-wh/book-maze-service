package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.RegisterRecord;
import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nadez on 12/10/2016.
 */
public interface RegisterRecordRepository extends CrudRepository<RegisterRecord, Integer> {
    List<RegisterRecord> findRegisterRecordsByUser(User user);
}
