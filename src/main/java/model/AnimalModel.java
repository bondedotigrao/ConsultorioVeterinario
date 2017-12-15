/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entidades.Animal;
import model.hibernate.AnimalHibernateDAO;
import model.interfaces.AnimalDAO;
import model.interfaces.DAO;

/**
 *
 * @author sion_
 */
public class AnimalModel {
    
    private final DAO<Animal> dao;

    public AnimalModel() {
        this.dao = AnimalHibernateDAO.getInstance();
    }
    
    public void insert(Animal animal) {
        if (((AnimalDAO) dao).recovered(animal.getId_animal()) == null) {
            dao.insert(animal);
        }
    }

    public Animal recovered(Integer id) {
        if (id == null) {
            return null;
        }
        return ((AnimalDAO) dao).recovered(id);
    }
    
    public void update(Animal animal) {
        if (((AnimalDAO) dao).recovered(animal.getId_animal()) != null) {
            dao.update(animal);
        }
    }

    public void delete(Animal animal) {
        if (((AnimalDAO) dao).recovered(animal.getId_animal()) != null) {
            dao.delete(animal);
        }
    }

    public List<Animal> recoveredAll() {
        return ((AnimalDAO)dao).recoveredAll();
    }
    
}
