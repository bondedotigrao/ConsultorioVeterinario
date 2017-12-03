/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Animal;
import model.implementations.AnimalHibernateDAO;

/**
 *
 * @author sion_
 */
public class AnimalController {
    
    private static AnimalHibernateDAO instance = null;
    
    public static AnimalHibernateDAO getInstance() {
        if(instance == null) {
            instance = new AnimalHibernateDAO();
        } 
        return instance;
    }
    
    public static void create(Animal animal) {
        instance.create(animal);
    }
    
    public static void delete(Animal animal) {
        instance.delete(animal);
    }
    
    public static Animal readAnimal(int id) {
        return instance.read(id);
    }
    
    public static void update(Animal animal) {
        instance.update(animal);
    }
    
    public static List<Animal> readAllAnimais() {
        return instance.readAll();
    }
}
