/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Consulta;
import model.implementations.ConsultaHibernateDAO;

/**
 *
 * @author sion_
 */
public class ConsultaController {
    
    private static ConsultaHibernateDAO instance = null;

    public static ConsultaHibernateDAO getInstance() {
        if (instance == null) {
            instance = new ConsultaHibernateDAO();
        }
        return instance;
    }

    public static void adicionar(Consulta consulta) {
        instance.adicionar(consulta);
    }

    public static void deletar(Consulta consulta) {
        instance.deletar(consulta);
    }

    public static Consulta recuperar(int id) {
        return instance.recuperar(id);
    }

    public static void alterar(Consulta consulta) {
        instance.alterar(consulta);
    }

    public static List<Consulta> recuperarTodos() {
        return instance.recuperarTodos();
    }
    
}
