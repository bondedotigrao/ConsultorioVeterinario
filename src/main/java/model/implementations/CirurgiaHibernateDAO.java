/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.implementations;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Cirurgia;
import model.interfaces.CirurgiaDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class CirurgiaHibernateDAO implements CirurgiaDAO{
    
    private SessionFactory sessions = null;
    private static CirurgiaHibernateDAO instance = null;
    private EntityManagerFactory emf = null;
    
    public static CirurgiaHibernateDAO getInstance() {
        
        if (instance == null) {
            instance = new CirurgiaHibernateDAO();
        }
        return instance;
    }
    
    public CirurgiaHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void create(Cirurgia cirurgia) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.persist(cirurgia);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Cirurgia read(int id) {
        Session session = this.sessions.openSession();
        try {
            return (Cirurgia) session.getSession().createQuery("FROM Cirurgia WHERE id_cirurgia" + id).getResultList().get(0);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Cirurgia cirurgia) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.update(cirurgia);
            t.commit();
        } catch (Exception alteraExameException) {
            System.out.println(alteraExameException.getMessage() + "\nAlgo de inesperado aconteceu ao alterar a cirurgia!");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Cirurgia Cirurgia) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.delete(Cirurgia);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Cirurgia> readAll() {
        Session session = this.sessions.openSession();
        
        try {
            return (List) session.getSession().createQuery("");
        } finally {
            session.close();
        }
    }
    
}
