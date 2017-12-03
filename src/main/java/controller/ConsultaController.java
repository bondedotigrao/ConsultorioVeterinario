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

    public static void create(Consulta consulta) {
        instance.create(consulta);
    }

    public static void delete(Consulta consulta) {
        instance.delete(consulta);
    }

    public static Consulta readConsulta(int id) {
        return instance.read(id);
    }

    public static void update(Consulta consulta) {
        instance.update(consulta);
    }

    public static List<Consulta> readAllConsultas() {
        return instance.readAll();
    }
    
}
