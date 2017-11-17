/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sion_
 */
public class Cirurgia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_cirurgia;
    @Column(nullable = false)
    private String tipo_cirurgia;
    @Temporal(TemporalType.DATE)
    private Date data_cirurgia;
    @Temporal(TemporalType.TIME)
    private Time horario_cirurgia;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_medico", referencedColumnName = "id")
    private MedicoVeterinario medico;
    
    public Cirurgia(String tipo_cirurgia, Date data_cirurgia, Time horario_cirurgia, Animal animal, MedicoVeterinario medico) {
        this.tipo_cirurgia = tipo_cirurgia;
        this.data_cirurgia = data_cirurgia;
        this.horario_cirurgia = horario_cirurgia;
        this.animal = animal;
        this.medico = medico;
    }
    
    public Cirurgia() {
        
    }

    public int getId_cirurgia() {
        return id_cirurgia;
    }

    public String getTipo_cirurgia() {
        return tipo_cirurgia;
    }

    public void setTipo_cirurgia(String tipo_cirurgia) {
        this.tipo_cirurgia = tipo_cirurgia;
    }

    public Date getData_cirurgia() {
        return data_cirurgia;
    }

    public void setData_cirurgia(Date data_cirurgia) {
        this.data_cirurgia = data_cirurgia;
    }

    public Time getHorario_cirurgia() {
        return horario_cirurgia;
    }

    public void setHorario_cirurgia(Time horario_cirurgia) {
        this.horario_cirurgia = horario_cirurgia;
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
