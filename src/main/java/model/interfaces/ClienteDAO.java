/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import model.entidades.Cliente;

/**
 *
 * @author sion_
 */
public interface ClienteDAO extends DAO<Cliente>{
    
    public Cliente recoveredCPF(String cpfCliente);
    
}
