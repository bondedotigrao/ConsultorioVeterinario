package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Sebastian
 */
@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_animal;
    @JoinColumn(name = "id_dono")
    @ManyToOne
    private Cliente cliente;
    @Column(length = 20, nullable = false)
    private String animal;
    @Column(length = 20)
    private String raca;
    @Column(length = 30, nullable = false)
    private String nome;

    public Animal(Cliente dono, String animal, String raca, String nome) {
        this.cliente = dono;
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
        return cliente;
    }

    public void setDono(Cliente dono) {
        this.cliente = dono;
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

    @Override
    public String toString() {
        return "Animal{" + "id_animal=" + id_animal + ", cliente=" + cliente + ", animal=" + animal + ", raca=" + raca + ", nome=" + nome + '}';
    }
    
    

}
