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
@Table(name = "AuthorDetails")
public class AuthorDetails implements Serializable{

    @Id
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "is_alive")
    private boolean isAlive;

    @OneToOne
    @MapsId
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and setters

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}