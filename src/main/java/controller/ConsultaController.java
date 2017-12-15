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
import model.ConsultaModel;
import model.entidades.Consulta;

/**
 *
 * @author sion_
 */
@ManagedBean
@ViewScoped
public class ConsultaController {
    
    private final ConsultaModel consultaHibernate;
    private Consulta cadConsulta;
    private Consulta selectedConsulta;
    
    public ConsultaController() {
        this.consultaHibernate = new ConsultaModel();
        this.cadConsulta = new Consulta();
    }
    
    public String insert() {
        this.consultaHibernate.insert(this.cadConsulta);
        this.cadConsulta = new Consulta();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A consulta foi marcada com sucesso!"));
        return "index.xhtml";
    }
    
    public Consulta recovered() {
        return this.consultaHibernate.recovered(this.selectedConsulta.getId_consulta());
    }

    public String update() {
        this.consultaHibernate.update(this.selectedConsulta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A consulta foi atualizada com sucesso!"));
        return "index.xhtml";
    }
    
    public String delete() {
        this.consultaHibernate.delete(this.selectedConsulta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A consulta foi deletada com sucesso!"));
        return "index.xhtml";
    }
    
    public List<Consulta> recoveredAll() {
        return this.consultaHibernate.recoveredAll();
    }

    public Consulta getCadConsulta() {
        return cadConsulta;
    }

    public void setCadConsulta(Consulta cadConsulta) {
        this.cadConsulta = cadConsulta;
    }

    public Consulta getSelectedConsulta() {
        return selectedConsulta;
    }

    public void setSelectedConsulta(Consulta selectedConsulta) {
        this.selectedConsulta = selectedConsulta;
    }
    
    
    
}
