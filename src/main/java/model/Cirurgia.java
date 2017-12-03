package model;

import java.io.Serializable;
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
public class Cirurgia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cirurgia;
    @Column(nullable = false)
    private String tipo_cirurgia;
    @Column
    private Date datahora_cirurgia;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_medico", referencedColumnName = "id_medico")
    private MedicoVeterinario medico;
    
    public Cirurgia(String tipo_cirurgia, Date datahora_cirurgia, Animal animal, MedicoVeterinario medico) {
        this.tipo_cirurgia = tipo_cirurgia;
        this.datahora_cirurgia = datahora_cirurgia;
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

    public Date getDatahora_cirurgia() {
        return datahora_cirurgia;
    }

    public void setDatahora_cirurgia(Date datahora_cirurgia) {
        this.datahora_cirurgia = datahora_cirurgia;
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
