package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Sebastian
 */
@Entity
public class Cliente extends Pessoa {

    @Column(length = 20)
    private String telefone;

    public Cliente(int id, String nomeP, String nomeS, String cpf, String email, String telefone) {
        super(id, nomeP, nomeS, cpf, email);
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

    @Override
    public String toString() {
        return "Cliente{" + "telefone=" + telefone + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return true;
    }

}
