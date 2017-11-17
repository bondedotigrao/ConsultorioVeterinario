package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Sebastian
 */
@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_animal;
    @JoinColumn(nullable = false, name = "id_dono", referencedColumnName = "id")
    @OneToOne
    private Cliente dono;
    @Column(length = 20, nullable = false)
    private String animal;
    @Column(length = 20)
    private String raca;
    @Column(length = 30, nullable = false)
    private String nome;

    public Animal(Cliente dono, String animal, String raca, String nome) {
        this.dono = dono;
        this.animal = animal;
        this.raca = raca;
        this.nome = nome;
    }

    public Animal() {
    }

    public int getId() {
        return id_animal;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
