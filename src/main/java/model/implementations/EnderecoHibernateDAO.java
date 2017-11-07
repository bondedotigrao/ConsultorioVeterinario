package model.implementations;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Endereco;
import model.interfaces.EnderecoDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author sion_
 */
public class EnderecoHibernateDAO implements EnderecoDAO{
    
    private SessionFactory sessions = null;
    private static ClienteHibernateDAO instance = null;
    private EntityManagerFactory emf = null;

    public static ClienteHibernateDAO getInstance() {

        if (instance == null) {
            instance = new ClienteHibernateDAO();
        }

        return instance;
    }

    public EnderecoHibernateDAO() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Endereco endereco) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(endereco);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Endereco recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Endereco) session.getSession().createQuery("From Endereco Where id=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }

    }

    @Override
    public void alterar(Endereco endereco) {

        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {

            session.update(endereco);
            t.commit();

        } catch (Exception alteraClienteException) {
            System.out.println(alteraClienteException.getMessage() + "\nAlgo de inesperado aconteceu ao alterar o endereço");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Endereco endereco) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(endereco);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Endereco> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Endereco> listaCliente = new ArrayList();
        try {

            listaCliente = session.createQuery("FROM Endereco").list();
        } catch (Exception e) {
            System.out.println("Erro!");
        } finally {
            session.close();
        }

        return listaCliente;

    }
    
}
