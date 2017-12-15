/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sion_
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name="animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_animal;
    @ManyToOne
    @JoinColumn(name="id_dono")
    private Cliente cliente;
    @Column(length = 20, nullable = false)
    private String nome_animal;
    @Column(length = 20, nullable = false)
    private String especie_animal;
    @Column(length = 20, nullable = false)
    private String raca_animal;

    public Animal(Cliente cliente, String nome_animal, String especie_animal, String raca_animal) {
        this.cliente = cliente;
        this.nome_animal = nome_animal;
        this.especie_animal = especie_animal;
        this.raca_animal = raca_animal;
    }

    @Deprecated
    public Animal() {
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getEspecie_animal() {
        return especie_animal;
    }

    public void setEspecie_animal(String especie_animal) {
        this.especie_animal = especie_animal;
    }

    public String getRaca_animal() {
        return raca_animal;
    }

    public void setRaca_animal(String raca_animal) {
        this.raca_animal = raca_animal;
    }
    
    @Override
    public boolean equals (Object o) {
        if (o instanceof Animal) {
            Animal a = (Animal) o;
            return this.cliente.getCpf_cliente().equals(a.cliente.getCpf_cliente());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cliente);
        return hash;
    }
    
    
    
}
