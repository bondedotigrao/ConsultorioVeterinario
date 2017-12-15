/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import model.entidades.MedicoVeterinario;

/**
 *
 * @author sion_
 */
public interface MedicoVeterinarioDAO extends DAO<MedicoVeterinario>{
    
    public MedicoVeterinario recoveredCPF(String cpfMedico);
    public MedicoVeterinario recoveredCRMV(String crmvMedico);
    
}
