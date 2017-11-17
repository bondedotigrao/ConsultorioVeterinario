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
    
    public static void adicionar(Cirurgia cirurgia) {
        instance.adicionar(cirurgia);
    }
    
    public static void deletar(Cirurgia cirurgia) {
        instance.deletar(cirurgia);
    }
    
    public static Cirurgia recuperar(int id) {
        return instance.recuperar(id);
    }
    
    public static void alterar(Cirurgia cirurgia) {
        instance.alterar(cirurgia);
    }
    
    public static List<Cirurgia> recuperarTodos() {
        return instance.recuperarTodos();
    }
    
}
