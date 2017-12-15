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
import model.AnimalModel;
import model.entidades.Animal;

/**
 *
 * @author sion_
 */
@ManagedBean
@ViewScoped
public class AnimalController {
    
    private final AnimalModel animalHibernate;
    private Animal cadAnimal;
    private Animal selectedAnimal;
    
    public AnimalController() {
        this.animalHibernate = new AnimalModel();
        this.cadAnimal = new Animal();
    }
    
    public String insert() {
        this.animalHibernate.insert(this.cadAnimal);
        this.cadAnimal = new Animal();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O animal foi inserido com sucesso!"));
        return "index.xhtml";
    }
    
    public Animal recovered() {
        return this.animalHibernate.recovered(this.selectedAnimal.getId_animal());
    }
    
    public String update() {
        this.animalHibernate.update(this.selectedAnimal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O animal foi atualizado com sucesso!"));
        return "index.xhtml";
    }
    
    public String delete() {
        this.animalHibernate.delete(this.selectedAnimal);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O animal foi deletado com sucesso!"));
        return "index.xhtml";
    }
    
    public List<Animal> recoveredAll() {
        return this.animalHibernate.recoveredAll();
    }

    public Animal getCadAnimal() {
        return cadAnimal;
    }

    public void setCadAnimal(Animal cadAnimal) {
        this.cadAnimal = cadAnimal;
    }

    public Animal getSelectedAnimal() {
        return selectedAnimal;
    }

    public void setSelectedAnimal(Animal selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }
    
    
    
}
