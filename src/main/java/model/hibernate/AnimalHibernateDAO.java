/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate;

import java.util.List;
import model.entidades.Animal;
import model.interfaces.AnimalDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class AnimalHibernateDAO implements AnimalDAO{

    private SessionFactory sessions;
    private static AnimalHibernateDAO instance;
    
    public static AnimalHibernateDAO getInstance() {
        if (instance != null) {
            instance = new AnimalHibernateDAO();
        }
        
        return instance;
    }
    
    public AnimalHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }
    
    @Override
    public void insert(Animal animal) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(animal);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }    }

    @Override
    public Animal recovered(int id) {
        Session session = this.sessions.openSession();
        try {
            return (Animal) session.getSession().createQuery("FROM Animal WHERE id_animal=" + id).getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }    }

    @Override
    public void update(Animal animal) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(animal);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }    }

    @Override
    public void delete(Animal animal) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(animal);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }    }

    @Override
    public List<Animal> recoveredAll() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.getSession().createQuery("FROM Animal").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }    }
    
}
