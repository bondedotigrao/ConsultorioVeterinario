/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
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
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_consulta;
    @Temporal(TemporalType.DATE)
    private Date data_consulta;
    @Temporal(TemporalType.TIME)
    private Time horario_consulta;
    @OneToOne
    @JoinColumn(nullable = false, name = "cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name = "cod_medico", referencedColumnName = "id")
    private MedicoVeterinario medico;

    public Consulta(Date data_consulta, Time horario_consulta, Animal animal, MedicoVeterinario medico) {
        this.data_consulta = data_consulta;
        this.horario_consulta = horario_consulta;
        this.animal = animal;
        this.medico = medico;
    }

    public Consulta() {
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public Date getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }

    public Time getHorario_consulta() {
        return horario_consulta;
    }

    public void setHorario_consulta(Time horario_consulta) {
        this.horario_consulta = horario_consulta;
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
