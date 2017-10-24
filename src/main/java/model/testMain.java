package model;

import controller.AnimalHibernateDAO;
import controller.ClienteHibernateDAO;
import controller.MedicoVeterinarioHibernateDAO;

/**
 *
 * @author Sebastian
 */
public class testMain {

    public static void main(String[] args) {

        Cliente c = new Cliente(5, "Bradley", "779.234.654-90", "bradley@net.com", "ksfkjhk67", "(67)3345-9076", "Avenida Bandeirantes");
        
        ClienteHibernateDAO chd = new ClienteHibernateDAO();
        
        chd.adicionar(c);

    }

}