/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sion_
 */
@ManagedBean
@RequestScoped
@Entity
@Table(name="cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    @Column(length = 20, nullable = false)
    private String nome_cliente;
    @Column(length = 20, nullable = false)
    private String sobrenome_cliente;
    @Column(length = 14, nullable = false)
    private String cpf_cliente;
    @Column(length = 50, nullable = false)
    private String email_cliente;
    @Column(length = 16, nullable = false)
    private String login_cliente;
    @Column(length = 16, nullable = false)
    private String senha_cliente;
    @Column(length = 20)
    private String telefone_cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Animal> animais;

    public Cliente(String nome_cliente, String sobrenome_cliente, String cpf_cliente, String email_cliente, String login_cliente, String senha_cliente, String telefone_cliente, List<Animal> animais) {
        this.nome_cliente = nome_cliente;
        this.sobrenome_cliente = sobrenome_cliente;
        this.cpf_cliente = cpf_cliente;
        this.email_cliente = email_cliente;
        this.login_cliente = login_cliente;
        this.senha_cliente = senha_cliente;
        this.telefone_cliente = telefone_cliente;
        this.animais = animais;
    }

    @Deprecated
    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getSobrenome_cliente() {
        return sobrenome_cliente;
    }

    public void setSobrenome_cliente(String sobrenome_cliente) {
        this.sobrenome_cliente = sobrenome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getLogin_cliente() {
        return login_cliente;
    }

    public void setLogin_cliente(String login_cliente) {
        this.login_cliente = login_cliente;
    }

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cpf_cliente);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            return this.cpf_cliente.equals(c.cpf_cliente);
        }
        return false;
    }
    
    
    
    
    
}
