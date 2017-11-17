package model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sebastian
 */
@Entity
public class Cliente extends Pessoa {

    @OneToMany
    private List<Animal> bichinhos;
    @Column(length = 20)
    private String telefone;

    public Cliente(String nomeP, String nomeS, String cpf, String email, List<Animal> bichinhos, String telefone) {
        super(nomeP, nomeS, cpf, email);
        this.bichinhos = bichinhos;
        this.telefone = telefone;
    }

    public Cliente() {

    }

    public List<Animal> getBichinhos() {
        return bichinhos;
    }

    public void setBichinhos(List<Animal> bichinhos) {
        this.bichinhos = bichinhos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "bichinhos=" + bichinhos + ", telefone=" + telefone + '}';
    }

}
