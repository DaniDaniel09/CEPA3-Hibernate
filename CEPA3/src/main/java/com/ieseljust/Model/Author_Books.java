/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Author_Books")
public class Author_Books implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;

    // Getters and setters

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
}