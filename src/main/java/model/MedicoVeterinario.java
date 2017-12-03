package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "medicoveterinario")
public class MedicoVeterinario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_medico;
    @Column(length = 50, nullable = false)
    private String nome_medico;
    @Column(length = 50, nullable = false)
    private String sobrenome_medico;
    @Column(length = 14, nullable = false)
    private String cpf_medico;
    @Column(length = 60, nullable = false)
    private String email_medico;
    @Column(length = 10)
    private String crmv;

    public MedicoVeterinario(String nome_medico, String sobrenome_medico, String cpf_medico, String email_medico, String crmv) {
        this.nome_medico = nome_medico;
        this.sobrenome_medico = sobrenome_medico;
        this.cpf_medico = cpf_medico;
        this.email_medico = email_medico;
        this.crmv = crmv;
    }

    public MedicoVeterinario() {

    }

    public int getId_medico() {
        return id_medico;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getSobrenome_medico() {
        return sobrenome_medico;
    }

    public void setSobrenome_medico(String sobrenome_medico) {
        this.sobrenome_medico = sobrenome_medico;
    }

    public String getCpf_medico() {
        return cpf_medico;
    }

    public void setCpf_medico(String cpf_medico) {
        this.cpf_medico = cpf_medico;
    }

    public String getEmail_medico() {
        return email_medico;
    }

    public void setEmail_medico(String email_medico) {
        this.email_medico = email_medico;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

}
