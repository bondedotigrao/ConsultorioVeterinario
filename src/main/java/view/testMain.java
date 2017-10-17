package view;

import model.Cliente;
import repositorios.ClienteHibernate;

/**
 *
 * @author Sebastian
 */
public class testMain {
    
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente(0, "novo clinte", "000.000.000-00", "novoCliente@ifpe.com", "1234", "(00)0000-0000","rua novo cliente 000");
        
        ClienteHibernate.getInstance().adicionar(cliente);
        
    }
    
}

//        this.id = id;
//        this.nome = nome;
//        this.cpf = cpf;
//        this.email = email;
//        this.senha = senha;
//        this.telefone = telefone;
//        this.endereco = endereco;
