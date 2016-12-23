package com.kolyadko_polovtseva.book_maze.util;

import com.kolyadko_polovtseva.book_maze.entity.Author;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nadzeya_Polautsava on 12/4/2016.
 */

public class AuthorUtil {

    public static String toString(Set<Author> authors) {
        String names = "";
        for (Author a : authors) {
            names += a.getFirstName() + " " + a.getLastName() + "\n";
        }
        return names;
    }
}
