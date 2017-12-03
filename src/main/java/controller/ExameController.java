/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Exame;
import model.implementations.ExameHibernateDAO;

/**
 *
 * @author sion_
 */
public class ExameController {
    
    private static ExameHibernateDAO instance = null;
    
    public static ExameHibernateDAO getInstance() {
        if(instance == null) {
            instance = new ExameHibernateDAO();
        }
        return instance;
    }
    
    public static void create(Exame exame) {
        instance.create(exame);
    }
    
    public static void delete(Exame exame) {
        instance.delete(exame);
    }
    
    public static Exame readExame(int id) {
        return instance.read(id);
    }
    
    public static void update(Exame exame) {
        instance.update(exame);
    }
    
    public static List<Exame> readAllExames() {
        return instance.readAll();
    }
    
}
