/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ieseljust.Model.Author;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Daniel
 */
public class AuthorDAO {

    public void saveAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }

    public void updateAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void deleteAuthor(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }
    public Author getAuthorById(int authorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Author.class, authorId);
        }
    }

    public List<Author> getAllAuthors() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery("FROM Author", Author.class);
            return query.list();
        }
    }
    public List<Author> getAllAuthorsWithBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery("FROM Author a LEFT JOIN FETCH a.books", Author.class);
            return query.list();
        }
    }
}
