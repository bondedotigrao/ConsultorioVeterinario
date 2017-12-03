package model.implementations;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.ClienteDAO;

/**
 *
 * @author Sebastian
 */
public class ClienteHibernateDAO implements ClienteDAO {

    private SessionFactory sessions = null;
    private static ClienteHibernateDAO instance = null;
    private EntityManagerFactory emf = null;

    public static ClienteHibernateDAO getInstance() {

        if (instance == null) {
            instance = new ClienteHibernateDAO();
        }

        return instance;
    }

    public ClienteHibernateDAO() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void create(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Cliente read(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Cliente) session.getSession().createQuery("From Cliente Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
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
            
        } catch (Exception alteraClienteException) {
            System.out.println(alteraClienteException.getMessage() + "\nAlgo de inesperado aconteceu ao alterar o cliente");
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
    public List<Cliente> readAll() {
        Session session = this.sessions.openSession();
        List<Cliente> listaCliente = new ArrayList();
        try {

            listaCliente = session.createQuery("FROM Cliente").list();
        } catch (Exception e) {
            System.out.println("Erro!");
        } finally {
            session.close();
        }

        return listaCliente;

    }

}
