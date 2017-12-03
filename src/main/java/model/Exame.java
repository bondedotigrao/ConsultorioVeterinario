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
public class Exame implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exame;
    @Column(nullable = false)
    private String tipo_exame;
    @Column
    private Date datahora_exame;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_animal", referencedColumnName = "id_animal")
    private Animal animal;
    @OneToOne
    @JoinColumn(nullable = false, name="cod_medico", referencedColumnName = "id_medico")
    private MedicoVeterinario medico;
    
    public Exame(String tipo_exame, Date datahora_exame, Animal animal, MedicoVeterinario medico) {
        this.tipo_exame = tipo_exame;
        this.datahora_exame = datahora_exame;
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

    public Date getDatahora_exame() {
        return datahora_exame;
    }

    public void setDatahora_exame(Date datahora_exame) {
        this.datahora_exame = datahora_exame;
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
