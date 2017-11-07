package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Sebastian
 */
@Entity
public class Cliente extends Pessoa {

    @Column(length = 20)
    private String telefone;

    public Cliente(String nomeP, String nomeS, String cpf, String email, String telefone) {
        super(nomeP, nomeS, cpf, email);
        this.telefone = telefone;
    }

    public Cliente() {

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
