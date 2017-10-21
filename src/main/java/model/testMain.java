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
        
        Cliente cliente = new Cliente(2, "hkjdfsdfsfd", "3443jdsk", "lk435dsjfl", "888", "sdfsd453f","s435dkjlf");
        int id = 1;
        
        Animal a = new Animal(30, 0, "peixe", "chupa-peda", "beijoqueiro");
        MedicoVeterinario mv = new MedicoVeterinario(8, "mila", "6876235768", "mila@.com", "786876", "mg7868638");
        
        ClienteHibernateDAO ch = new ClienteHibernateDAO();
        AnimalHibernateDAO ah = new AnimalHibernateDAO();
        MedicoVeterinarioDAO mvh = new MedicoVeterinarioHibernateDAO();
        
       mvh.adicionar(mv);
        
        
    }
    
}
