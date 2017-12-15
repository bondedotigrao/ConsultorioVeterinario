/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sion_
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name="consulta")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_consulta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datahora_consulta;
    @OneToOne
    @JoinColumn(name="cod_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(name="cod_medico")
    private MedicoVeterinario medicoVeterinario;

    public Consulta(Date datahora_consulta, Animal animal, MedicoVeterinario medicoVeterinario) {
        this.datahora_consulta = datahora_consulta;
        this.animal = animal;
        this.medicoVeterinario = medicoVeterinario;
    }

    @Deprecated
    public Consulta() {
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public Date getDatahora_consulta() {
        return datahora_consulta;
    }

    public void setDatahora_consulta(Date datahora_consulta) {
        this.datahora_consulta = datahora_consulta;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public MedicoVeterinario getMedicoVeterinario() {
        return medicoVeterinario;
    }

    public void setMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
        this.medicoVeterinario = medicoVeterinario;
    }

    
    
    
    
}
