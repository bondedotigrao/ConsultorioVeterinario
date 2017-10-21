package controller;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Animal;
import model.AnimalDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Sebastian
 */
public class AnimalHibernateDAO implements AnimalDAO{
    
    private SessionFactory sessions = null;
    private static AnimalHibernateDAO instance = null;
    private EntityManagerFactory emf = null;

    public static AnimalHibernateDAO getInstance() {

        if (instance == null) {
            instance = new AnimalHibernateDAO();
        }

        return instance;
    }

    public AnimalHibernateDAO() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Animal animal) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(animal);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Animal recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Animal) session.getSession().createQuery("From Animal Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }

    }

    @Override
    public void alterar(Animal t) {
    }

    @Override
    public void deletar(Animal animal) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(animal);
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
