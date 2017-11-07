/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Endereco;
import model.implementations.EnderecoHibernateDAO;

/**
 *
 * @author sion_
 */
public class EnderecoController {
    
    private static EnderecoHibernateDAO instance = null;
    
    public static EnderecoHibernateDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoHibernateDAO();
        }
        return instance;
    }
    
    public static void adicionar(Endereco endereco) {
        instance.adicionar(endereco);
    }
    
    public static void deletar(Endereco endereco) {
        instance.deletar(endereco);
    }
    
    public static void alterar(Endereco endereco) {
        instance.deletar(endereco);
    }
    
    public static Endereco recuperar(int id) {
        return instance.recuperar(id);
    }
    
    public static List<Endereco> recuperarTodos() {
        return instance.recuperarTodos();
    }
    
}
