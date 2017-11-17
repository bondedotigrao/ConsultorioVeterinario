package controller;

import java.util.List;
import model.Cliente;
import model.implementations.ClienteHibernateDAO;

/**
 *
 * @author sion_
 */
public class ClienteController {

    private static ClienteHibernateDAO instance = null;

    public static ClienteHibernateDAO getInstance() {
        if (instance == null) {
            instance = new ClienteHibernateDAO();
        }
        return instance;
    }

    public static void adicionar(Cliente cliente) {
        instance.adicionar(cliente);
    }

    public static void deletar(Cliente cliente) {
        instance.deletar(cliente);
    }

    public static Cliente recuperar(int id) {
        return instance.recuperar(id);
    }

    public static void alterar(Cliente cliente) {
        instance.alterar(cliente);
    }

    public static List<Cliente> recuperarTodos() {
        return instance.recuperarTodos();
    }

}
