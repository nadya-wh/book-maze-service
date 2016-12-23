package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "register")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRecord implements Serializable {

    @Id
    @Column(name = "id_register")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegister;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_book_id")
    private LibraryBook libraryBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login")
    private User user;

    @Column(name = "reserve_date")
    private Date reserveDate;

    @Column(name = "return_deadline")
    private Date returnDeadline;

    @Column(name = "was_returned")
    private Boolean wasReturned;

    public Integer getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Integer idRegister) {
        this.idRegister = idRegister;
    }

    public LibraryBook getLibraryBook() {
        return libraryBook;
    }

    public void setLibraryBook(LibraryBook libraryBook) {
        this.libraryBook = libraryBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(Date returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public Boolean getWasReturned() {
        return wasReturned;
    }

    public void setWasReturned(Boolean wasReturned) {
        this.wasReturned = wasReturned;
    }
}