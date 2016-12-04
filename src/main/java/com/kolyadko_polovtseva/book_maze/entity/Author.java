package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.sym.Name;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 25.11.2016.
 */
@Entity
@Table(name = "author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Author implements Serializable {

    @Id
    @Column(name = "id_author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    @JsonProperty("books")
    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "author_id_author", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "book_id_book",
                    nullable = false, updatable = false)})
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "book_author", joinColumns = {
//            @JoinColumn(name = "author_id_author", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "book_id_book",
//                    nullable = false)})
    private Set<Book> books;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (!idAuthor.equals(author.idAuthor)) return false;
        if (!firstName.equals(author.firstName)) return false;
        if (!lastName.equals(author.lastName)) return false;
        return books != null ? books.equals(author.books) : author.books == null;

    }

    @Override
    public int hashCode() {
        int result = idAuthor.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}