/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate;

import java.util.List;
import model.entidades.Consulta;
import model.interfaces.ConsultaDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class ConsultaHibernateDAO implements ConsultaDAO {

    private SessionFactory sessions;
    private static ConsultaHibernateDAO instance;

    public static ConsultaHibernateDAO getInstance() {
        if (instance != null) {
            instance = new ConsultaHibernateDAO();
        }

        return instance;
    }

    public ConsultaHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void insert(Consulta consulta) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(consulta);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Consulta recovered(int id) {
        Session session = this.sessions.openSession();
        try {
            return (Consulta) session.getSession().createQuery("FROM Consulta WHERE id_consulta=" + id).getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Consulta consulta) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(consulta);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Consulta consulta) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(consulta);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Consulta> recoveredAll() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.getSession().createQuery("FROM Consulta").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
