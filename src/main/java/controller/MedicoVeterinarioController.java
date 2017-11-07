package controller;

import java.util.List;
import model.MedicoVeterinario;
import model.implementations.MedicoVeterinarioHibernateDAO;

/**
 *
 * @author sion_
 */
public class MedicoVeterinarioController {
    
    private static MedicoVeterinarioHibernateDAO instance = null;
    
    public static MedicoVeterinarioHibernateDAO getInstance() {
        if (instance == null) {
            instance = new MedicoVeterinarioHibernateDAO();
        }
        return instance;
    }
    
    public static void adicionar(MedicoVeterinario mv) {
        instance.adicionar(mv);
    }
    
    public static void deletar(MedicoVeterinario mv) {
        instance.deletar(mv);
    }
    
    public static void alterar(MedicoVeterinario mv) {
        instance.deletar(mv);
    }
    
    public static MedicoVeterinario recuperar(int id) {
        return instance.recuperar(id);
    }
    
    public static List<MedicoVeterinario> recuperarTodos() {
        return instance.recuperarTodos();
    }
    
}
