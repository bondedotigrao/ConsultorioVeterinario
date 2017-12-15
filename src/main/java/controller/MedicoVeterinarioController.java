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
import model.MedicoVeterinarioModel;
import model.entidades.MedicoVeterinario;

/**
 *
 * @author sion_
 */
@ManagedBean
@ViewScoped
public class MedicoVeterinarioController {
    
    private final MedicoVeterinarioModel medicoHibernate;
    private MedicoVeterinario cadMedico;
    private MedicoVeterinario selectedMedico;
    
    public MedicoVeterinarioController() {
        this.medicoHibernate = new MedicoVeterinarioModel();
        this.cadMedico = new MedicoVeterinario();
    }
    
    public String insert() {
        this.medicoHibernate.insert(this.cadMedico);
        this.cadMedico = new MedicoVeterinario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O médico veterinário foi inserido com sucesso!"));
        return "index.xhtml";
    }
    
    public MedicoVeterinario recovered() {
        return this.medicoHibernate.recovered(this.selectedMedico.getId_medico());
    }
    
    public String update() {
        this.medicoHibernate.update(this.selectedMedico);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O médico veterinário foi atualizado com sucesso!"));
        return "index.xhtml";
    }
    
    public String delete() {
        this.medicoHibernate.delete(this.selectedMedico);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O médico veterinário foi deletado com sucesso!"));
        return "index.xhtml";
    }
    
    public List<MedicoVeterinario> recoveredAll() {
        return this.medicoHibernate.recoveredAll();
    }
    
    public MedicoVeterinario recoveredCPF() {
        return this.medicoHibernate.recoveredCPF(this.selectedMedico.getCpf_medico());
    }
    
    public MedicoVeterinario recoveredCRMV() {
        return this.medicoHibernate.recoveredCRMV(this.selectedMedico.getCrmv());
    }

    public MedicoVeterinario getCadMedico() {
        return cadMedico;
    }

    public void setCadMedico(MedicoVeterinario cadMedico) {
        this.cadMedico = cadMedico;
    }

    public MedicoVeterinario getSelectedMedico() {
        return selectedMedico;
    }

    public void setSelectedMedico(MedicoVeterinario selectedMedico) {
        this.selectedMedico = selectedMedico;
    }
    
    
    
}
