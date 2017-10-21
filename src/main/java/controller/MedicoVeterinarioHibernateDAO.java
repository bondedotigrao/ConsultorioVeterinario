package controller;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.MedicoVeterinario;
import model.MedicoVeterinarioDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sebastian
 */
public class MedicoVeterinarioHibernateDAO implements MedicoVeterinarioDAO{
    
    private SessionFactory sessions = null;
    private static MedicoVeterinarioHibernateDAO instance = null;
    private EntityManagerFactory emf = null;

    public static MedicoVeterinarioHibernateDAO getInstance() {

        if (instance == null) {
            instance = new MedicoVeterinarioHibernateDAO();
        }

        return instance;
    }

    public MedicoVeterinarioHibernateDAO() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(MedicoVeterinario mv) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(mv);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public MedicoVeterinario recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (MedicoVeterinario) session.getSession().createQuery("From MedicoVeterinario Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }

    }

    @Override
    public void alterar(MedicoVeterinario t) {
    }

    @Override
    public void deletar(MedicoVeterinario mv) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(mv);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List recuperarTodos() {
        
        Session session = this.sessions.openSession();

        try {

            return (List) session.getSession().createQuery("");

        } finally {

            session.close();
        }

    }
    
}
