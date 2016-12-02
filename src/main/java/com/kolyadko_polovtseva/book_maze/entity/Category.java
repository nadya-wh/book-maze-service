package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 25.11.2016.
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
public class Category implements Serializable {
    @Id
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
//    @OneToMany
//    private Set<Book> books;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //    public Set<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Category)) return false;
//
//        Category category = (Category) o;
//
//        if (!idCategory.equals(category.idCategory)) return false;
//        if (!name.equals(category.name)) return false;
//        return books != null ? books.equals(category.books) : category.books == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idCategory.hashCode();
//        result = 31 * result + name.hashCode();
//        result = 31 * result + (books != null ? books.hashCode() : 0);
//        return result;
//    }
}