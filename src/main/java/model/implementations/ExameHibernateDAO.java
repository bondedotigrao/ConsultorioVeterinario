/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.implementations;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Exame;
import model.interfaces.ExameDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class ExameHibernateDAO implements ExameDAO{
    
    private SessionFactory sessions = null;
    private static ExameHibernateDAO instance = null;
    private EntityManagerFactory emf = null;
    
    public static ExameHibernateDAO getInstance() {
        
        if (instance == null) {
            instance = new ExameHibernateDAO();
        }
        return instance;
    }
    
    public ExameHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void create(Exame exame) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.persist(exame);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Exame read(int id) {
        Session session = this.sessions.openSession();
        try {
            return (Exame) session.getSession().createQuery("FROM Exame WHERE id_exame" + id).getResultList().get(0);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Exame exame) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.update(exame);
            t.commit();
        } catch (Exception alteraExameException) {
            System.out.println(alteraExameException.getMessage() + "\nAlgo de inesperado aconteceu ao alterar o exame!");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Exame exame) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try {
            session.delete(exame);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Exame> readAll() {
        Session session = this.sessions.openSession();
        
        try {
            return (List) session.getSession().createQuery("");
        } finally {
            session.close();
        }
    }
    
    
    
}
