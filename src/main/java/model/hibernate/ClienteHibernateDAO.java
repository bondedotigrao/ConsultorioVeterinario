/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate;

import java.util.List;
import model.entidades.Cliente;
import model.interfaces.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class ClienteHibernateDAO implements ClienteDAO {

    private SessionFactory sessions;
    private static ClienteHibernateDAO instance;

    public static ClienteHibernateDAO getInstance() {
        if (instance != null) {
            instance = new ClienteHibernateDAO();
        }

        return instance;
    }

    public ClienteHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public Cliente recoveredCPF(String cpfCliente) {
        Session session = this.sessions.openSession();
        try {
            return (Cliente) session.getSession().createQuery("FROM Cliente WHERE cpf_cliente='"+cpfCliente+"'").getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Cliente recovered(int id) {
        Session session = this.sessions.openSession();
        try {
            return (Cliente) session.getSession().createQuery("FROM Cliente WHERE id_cliente=" + id).getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Cliente> recoveredAll() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.getSession().createQuery("FROM Cliente").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
