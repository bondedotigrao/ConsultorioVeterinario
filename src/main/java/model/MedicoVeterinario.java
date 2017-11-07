package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name="medico_veterinario")
public class MedicoVeterinario extends Pessoa{
    
    @Column(length = 10)
    private String crmv;
    
    public MedicoVeterinario(String nomeP, String nomeS, String cpf, String email, String crmv) {
        super(nomeP, nomeS, cpf, email);
        this.crmv = crmv;
    }
    
    public MedicoVeterinario() {
        
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    @Override
    public String toString() {
        return "MedicoVeterinario{" + "crmv=" + crmv + '}';
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
        final MedicoVeterinario other = (MedicoVeterinario) obj;
        if (!Objects.equals(this.crmv, other.crmv)) {
            return false;
        }
        return true;
    }
    
    
    
}
