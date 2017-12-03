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

    public static void create(Cliente cliente) {
        instance.create(cliente);
    }

    public static void delete(Cliente cliente) {
        instance.delete(cliente);
    }

    public static Cliente readCliente(int id) {
        return instance.read(id);
    }

    public static void update(Cliente cliente) {
        instance.update(cliente);
    }

    public static List<Cliente> readAllClientes() {
        return instance.readAll();
    }

}
