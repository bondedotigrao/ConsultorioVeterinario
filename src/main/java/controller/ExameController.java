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
    
    public static void adicionar(Exame exame) {
        instance.adicionar(exame);
    }
    
    public static void deletar(Exame exame) {
        instance.deletar(exame);
    }
    
    public static Exame recuperar(int id) {
        return instance.recuperar(id);
    }
    
    public static void alterar(Exame exame) {
        instance.alterar(exame);
    }
    
    public static List<Exame> recuperarTodos() {
        return instance.recuperarTodos();
    }
    
}
