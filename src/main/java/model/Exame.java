/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.ejb.Timeout;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
public class Exame implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_exame;
    @Column(nullable = false)
    private String tipo_exame;
    @Temporal(TemporalType.DATE)
    private Date data_exame;
    @Temporal(TemporalType.TIME)
    private Time horario_exame;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_medico", referencedColumnName = "id")
    private MedicoVeterinario medico;
    
    public Exame(String tipo_exame, Date data_exame, Time horario_exame, Animal animal, MedicoVeterinario medico) {
        this.tipo_exame = tipo_exame;
        this.data_exame = data_exame;
        this.horario_exame = horario_exame;
        this.animal = animal;
        this.medico = medico;
    }
    
    public Exame() {
        
    }

    public int getId_exame() {
        return id_exame;
    }

    public String getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(String tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    public Date getData_exame() {
        return data_exame;
    }

    public void setData_exame(Date data_exame) {
        this.data_exame = data_exame;
    }

    public Time getHorario_exame() {
        return horario_exame;
    }

    public void setHorario_exame(Time horario_exame) {
        this.horario_exame = horario_exame;
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
