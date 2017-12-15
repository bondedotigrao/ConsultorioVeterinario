/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entidades.Consulta;
import model.hibernate.ConsultaHibernateDAO;
import model.interfaces.ConsultaDAO;
import model.interfaces.DAO;

/**
 *
 * @author sion_
 */
public class ConsultaModel {
    
    private final DAO<Consulta> dao;
    
    public ConsultaModel() {
        this.dao = ConsultaHibernateDAO.getInstance();
    }
    
    public void insert(Consulta consulta) {
        if (((ConsultaDAO) dao).recovered(consulta.getId_consulta()) == null) {
            dao.insert(consulta);
        }
    }

    public Consulta recovered(Integer id) {
        if (id == null) {
            return null;
        }
        return ((ConsultaDAO) dao).recovered(id);
    }
    
    public void update(Consulta consulta) {
        if (((ConsultaDAO) dao).recovered(consulta.getId_consulta()) != null) {
            dao.update(consulta);
        }
    }

    public void delete(Consulta consulta) {
        if (((ConsultaDAO) dao).recovered(consulta.getId_consulta()) != null) {
            dao.delete(consulta);
        }
    }

    public List<Consulta> recoveredAll() {
        return ((ConsultaDAO)dao).recoveredAll();
    }
    
}
