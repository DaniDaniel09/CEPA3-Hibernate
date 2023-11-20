/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ieseljust.Model.Books;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Daniel
 */
public class BooksDAO {

    public void saveBooks(Books books) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(books);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void updateBooks(Books books) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(books);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void deleteBooks(Books books) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(books);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }
    public Books getBooksById(int bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Books.class, bookId);
        }
    }

    public List<Books> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Books> query = session.createQuery("FROM Books", Books.class);
            return query.list();
        }
    }
}