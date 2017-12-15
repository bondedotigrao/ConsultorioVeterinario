/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entidades.Cliente;
import model.hibernate.ClienteHibernateDAO;
import model.interfaces.ClienteDAO;
import model.interfaces.DAO;

/**
 *
 * @author sion_
 */
public class ClienteModel {

    private final DAO<Cliente> dao;

    public ClienteModel() {
        this.dao = ClienteHibernateDAO.getInstance();
    }

    public void insert(Cliente cliente) {
        if (((ClienteDAO) dao).recoveredCPF(cliente.getCpf_cliente()) == null) {
            dao.insert(cliente);
        }
    }

    public Cliente recovered(Integer id) {
        if (id == null) {
            return null;
        }
        return ((ClienteDAO) dao).recovered(id);
    }

    public void update(Cliente cliente) {
        if (((ClienteDAO) dao).recovered(cliente.getId_cliente()) != null) {
            dao.update(cliente);
        }
    }

    public void delete(Cliente cliente) {
        if (((ClienteDAO) dao).recovered(cliente.getId_cliente()) != null) {
            dao.delete(cliente);
        }
    }

    public List<Cliente> recoveredAll() {
        return ((ClienteDAO) dao).recoveredAll();
    }

    public Cliente recoveredCPF(String cpfCliente) {
        if (cpfCliente == null) {
            return null;
        }
        return ((ClienteDAO) dao).recoveredCPF(cpfCliente);
    }

}
