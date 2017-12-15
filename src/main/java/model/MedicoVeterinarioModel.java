/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entidades.MedicoVeterinario;
import model.hibernate.MedicoVeterinarioHibernateDAO;
import model.interfaces.DAO;
import model.interfaces.MedicoVeterinarioDAO;

/**
 *
 * @author sion_
 */
public class MedicoVeterinarioModel {
    
    private final DAO<MedicoVeterinario> dao;
    
    public MedicoVeterinarioModel() {
        this.dao = MedicoVeterinarioHibernateDAO.getInstance();
    }
    
    public void insert(MedicoVeterinario medico) {
        if (((MedicoVeterinarioDAO) dao).recoveredCPF(medico.getCpf_medico()) == null) {
            dao.insert(medico);
        }
    }

    public MedicoVeterinario recovered(Integer id) {
        if (id == null) {
            return null;
        }
        return ((MedicoVeterinarioDAO) dao).recovered(id);
    }
    
    public void update(MedicoVeterinario medico) {
        if (((MedicoVeterinarioDAO) dao).recovered(medico.getId_medico()) != null) {
            dao.update(medico);
        }
    }

    public void delete(MedicoVeterinario medico) {
        if (((MedicoVeterinarioDAO) dao).recovered(medico.getId_medico()) != null) {
            dao.delete(medico);
        }
    }

    public List<MedicoVeterinario> recoveredAll() {
        return ((MedicoVeterinarioDAO)dao).recoveredAll();
    }

    public MedicoVeterinario recoveredCPF(String cpfMedico) {
        if (cpfMedico == null) {
            return null;
        }
        return ((MedicoVeterinarioDAO) dao).recoveredCPF(cpfMedico);
    }
    
    public MedicoVeterinario recoveredCRMV(String crmvMedico) {
        if (crmvMedico == null) {
            return null;
        }
        return ((MedicoVeterinarioDAO) dao).recoveredCRMV(crmvMedico);
    }
    
}
