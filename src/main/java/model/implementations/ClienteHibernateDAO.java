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
    public void adicionar(Cliente cliente) {
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
    public Cliente recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Cliente) session.getSession().createQuery("From Cliente Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }

    }

    @Override
    public void alterar(Cliente t) {
    }

    @Override
    public void deletar(Cliente cliente) {
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
    public List<Cliente> recuperarTodos() {
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