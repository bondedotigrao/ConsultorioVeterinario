/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sion_
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name="medico")
public class MedicoVeterinario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_medico;
    @Column(length = 20, nullable = false)
    private String nome_medico;
    @Column(length = 20, nullable = false)
    private String sobrenome_medico;
    @Column(length = 14, nullable = false)
    private String cpf_medico;
    @Column(nullable = false)
    private String crmv;
    @Column(length = 50, nullable = false)
    private String email_medico;
    @Column(length = 16, nullable = false)
    private String login_medico;
    @Column(length = 16, nullable = false)
    private String senha_medico;

    public MedicoVeterinario(String nome_medico, String sobrenome_medico, String cpf_medico, String crmv, String email_medico, String login_medico, String senha_medico) {
        this.nome_medico = nome_medico;
        this.sobrenome_medico = sobrenome_medico;
        this.cpf_medico = cpf_medico;
        this.crmv = crmv;
        this.email_medico = email_medico;
        this.login_medico = login_medico;
        this.senha_medico = senha_medico;
    }

    @Deprecated
    public MedicoVeterinario() {
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEmail_medico() {
        return email_medico;
    }

    public void setEmail_medico(String email_medico) {
        this.email_medico = email_medico;
    }

    public String getLogin_medico() {
        return login_medico;
    }

    public void setLogin_medico(String login_medico) {
        this.login_medico = login_medico;
    }

    public String getSenha_medico() {
        return senha_medico;
    }

    public void setSenha_medico(String senha_medico) {
        this.senha_medico = senha_medico;
    }
    
    
    
}
