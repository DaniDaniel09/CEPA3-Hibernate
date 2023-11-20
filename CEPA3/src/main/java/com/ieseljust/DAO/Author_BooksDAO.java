/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ieseljust.Model.Author_Books;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Daniel
 */
public class Author_BooksDAO {

    public void saveAuthor_Books(Author_Books authorBooks) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(authorBooks);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void updateAuthor_Books(Author_Books authorBooks) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(authorBooks);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void deleteAuthor_Books(Author_Books authorBooks) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(authorBooks);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }
    public Author_Books getAuthor_BooksById(int authorId, int bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author_Books> query = session.createQuery(
                    "FROM Author_Books WHERE author_id = :authorId AND book_id = :bookId",
                    Author_Books.class
            );
            query.setParameter("authorId", authorId);
            query.setParameter("bookId", bookId);
            return query.uniqueResult();
        }
    }

    public List<Author_Books> getAllAuthor_Books() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author_Books> query = session.createQuery("FROM Author_Books", Author_Books.class);
            return query.list();
        }
    }
}
