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

        ClienteHibernateDAO chd = new ClienteHibernateDAO();

        System.out.println(chd.recuperarTodos() + "\n");

    }

}
