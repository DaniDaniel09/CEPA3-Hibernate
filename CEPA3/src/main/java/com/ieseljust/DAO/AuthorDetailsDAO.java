/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ieseljust.Model.AuthorDetails;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Daniel
 */
public class AuthorDetailsDAO {

    public void saveAuthorDetails(AuthorDetails authorDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(authorDetails);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void updateAuthorDetails(AuthorDetails authorDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(authorDetails);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }

    public void deleteAuthorDetails(AuthorDetails authorDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(authorDetails);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción
        }
    }
    public AuthorDetails getAuthorDetailsById(int authorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(AuthorDetails.class, authorId);
        }
    }

    public List<AuthorDetails> getAllAuthorDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<AuthorDetails> query = session.createQuery("FROM AuthorDetails", AuthorDetails.class);
            return query.list();
        }
    }
}