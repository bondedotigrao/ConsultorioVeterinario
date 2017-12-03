package model.implementations;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Consulta;
import model.interfaces.ConsultaDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class ConsultaHibernateDAO implements ConsultaDAO{
    
    private SessionFactory sessions = null;
    private static ConsultaHibernateDAO instance = null;
    private EntityManagerFactory emf = null;

    public static ConsultaHibernateDAO getInstance() {

        if (instance == null) {
            instance = new ConsultaHibernateDAO();
        }

        return instance;
    }

    public ConsultaHibernateDAO() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void create(Consulta consulta) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(consulta);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Consulta read(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Consulta) session.getSession().createQuery("From Consulta Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
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

        } catch (Exception alteraClienteException) {
            System.out.println(alteraClienteException.getMessage() + "\nAlgo de inesperado aconteceu ao alterar a consulta");
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
    public List<Consulta> readAll() {
        Session session = this.sessions.openSession();
        List<Consulta> listaCliente = new ArrayList();
        try {

            listaCliente = session.createQuery("FROM Consulta").list();
        } catch (Exception e) {
            System.out.println("Erro!");
        } finally {
            session.close();
        }

        return listaCliente;

    }
    
}
