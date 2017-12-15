/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.hibernate;

import java.util.List;
import model.entidades.MedicoVeterinario;
import model.interfaces.MedicoVeterinarioDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class MedicoVeterinarioHibernateDAO implements MedicoVeterinarioDAO{

    private SessionFactory sessions;
    private static MedicoVeterinarioHibernateDAO instance;
    
    public static MedicoVeterinarioHibernateDAO getInstance() {
        if (instance != null) {
            instance = new MedicoVeterinarioHibernateDAO();
        }
        
        return instance;
    }
    
    public MedicoVeterinarioHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }
    
    @Override
    public MedicoVeterinario recoveredCPF(String cpfMedico) {
        Session session = this.sessions.openSession();
        try {
            return (MedicoVeterinario) session.getSession().createQuery("FROM Medico WHERE cpf_medico='"+cpfMedico+"'").getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public MedicoVeterinario recoveredCRMV(String crmvMedico) {
        Session session = this.sessions.openSession();
        try {
            return (MedicoVeterinario) session.getSession().createQuery("FROM Medico WHERE crmv='"+crmvMedico+"'").getResultList().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }    }

    @Override
    public void insert(MedicoVeterinario medico) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(medico);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public MedicoVeterinario recovered(int id) {
        Session session = this.sessions.openSession();
        try {
            return (MedicoVeterinario) session.getSession().createQuery("FROM MedicoVeterinario WHERE id_medico=" + id).getResultList().get(0);
        } catch (Exception e) {
            System.out.println("erro!");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(MedicoVeterinario medico) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(medico);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(MedicoVeterinario medico) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(medico);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<MedicoVeterinario> recoveredAll() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.getSession().createQuery("FROM Medico").getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
