/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Cirurgia;
import model.implementations.CirurgiaHibernateDAO;

/**
 *
 * @author sion_
 */
public class CirurgiaController {
    
    private static CirurgiaHibernateDAO instance = null;
    
    public static CirurgiaHibernateDAO getInstance() {
        if(instance == null) {
            instance = new CirurgiaHibernateDAO();
        }
        return instance;
    }
    
    public static void create(Cirurgia cirurgia) {
        instance.create(cirurgia);
    }
    
    public static void delete(Cirurgia cirurgia) {
        instance.delete(cirurgia);
    }
    
    public static Cirurgia readCirurgia(int id) {
        return instance.read(id);
    }
    
    public static void update(Cirurgia cirurgia) {
        instance.update(cirurgia);
    }
    
    public static List<Cirurgia> readAllCirurgias() {
        return instance.readAll();
    }
    
}
