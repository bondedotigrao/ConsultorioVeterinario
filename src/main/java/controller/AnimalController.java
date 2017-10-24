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
    
    public static void adicionar(Animal animal) {
        instance.adicionar(animal);
    }
    
    public static void deletar(Animal animal) {
        instance.deletar(animal);
    }
    
    public static Animal recuperar(int id) {
        return instance.recuperar(id);
    }
    
    public static void alterar(Animal animal) {
        instance.alterar(animal);
    }
    
    public static List<Animal> recuperarTodos() {
        return instance.recuperarTodos();
    }
}
