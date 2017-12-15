/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.ClienteModel;
import model.entidades.Cliente;

/**
 *
 * @author sion_
 */
@ManagedBean
@ViewScoped
public class ClienteController {
    
    private final ClienteModel clienteHibernate;
    private Cliente cadCliente;
    private Cliente selectedCliente;
    
    public ClienteController() {
        this.clienteHibernate = new ClienteModel();
        this.cadCliente = new Cliente();
    }
    
    public String insert() {
        this.clienteHibernate.insert(this.cadCliente);
        this.cadCliente = new Cliente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente foi inserido com sucesso!"));
        return "index.xhtml";
    }
    
    public Cliente recovered() {
        return this.clienteHibernate.recovered(this.selectedCliente.getId_cliente());
    }
    
    public String update() {
        this.clienteHibernate.update(this.selectedCliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente foi atualizado com sucesso!"));
        return "index.xhtml";
    }
    
    public String delete() {
        this.clienteHibernate.delete(this.selectedCliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O cliente foi deletado com sucesso!"));
        return "index.xhtml";
    }
    
    public List<Cliente> recoveredAll() {
        return this.clienteHibernate.recoveredAll();
    }
    
    public Cliente recoveredCPF() {
        return this.clienteHibernate.recoveredCPF(this.selectedCliente.getCpf_cliente());
    }

    public Cliente getCadCliente() {
        return cadCliente;
    }

    public void setCadCliente(Cliente cadCliente) {
        this.cadCliente = cadCliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    
    
}
