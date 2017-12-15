
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sion_
 */
public class Nova {
    
    public static void main(String[] args) {
        
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    // Check database version
    String sql = "select version()";

    //String result = (String) session.createSQLQuery(sql).getQueryReturns();
    //System.out.println(result);

    session.getTransaction().commit();
    session.close();
        
    }
    
}
