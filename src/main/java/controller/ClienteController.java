package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cliente;
import model.implementations.ClienteHibernateDAO;

/**
 *
 * @author sion_
 */
@ManagedBean(name="clienteController")
@SessionScoped
public class ClienteController {
    
    private List<Cliente> repositorioCliente = null;
    private Cliente selectedCliente;
    
    public ClienteController(){
        ClienteHibernateDAO chd = new ClienteHibernateDAO();
        this.repositorioCliente = chd.readAll();
        this.selectedCliente = new Cliente();
    }

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

    public List<Cliente> getRepositorioCliente() {
        return repositorioCliente;
    }

    public void setRepositorioCliente(List<Cliente> repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    

}
