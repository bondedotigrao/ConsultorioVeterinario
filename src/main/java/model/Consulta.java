/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author sion_
 */
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_consulta;
    @Column
    private Date datahora_consulta;
    @OneToOne
    @JoinColumn(nullable = false, name = "cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name = "cod_medico", referencedColumnName = "id_medico")
    private MedicoVeterinario medico;

    public Consulta(Date datahora_consulta, Animal animal, MedicoVeterinario medico) {
        this.datahora_consulta = datahora_consulta;
        this.animal = animal;
        this.medico = medico;
    }

    public Consulta() {
    }

    public int getId_consulta() {
        return id_consulta;
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

    public MedicoVeterinario getMedico() {
        return medico;
    }

    public void setMedico(MedicoVeterinario medico) {
        this.medico = medico;
    }

    

    

}
