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
    
    public static void create(MedicoVeterinario mv) {
        instance.create(mv);
    }
    
    public static void delete(MedicoVeterinario mv) {
        instance.delete(mv);
    }
    
    public static void update(MedicoVeterinario mv) {
        instance.update(mv);
    }
    
    public static MedicoVeterinario readMedicoVeterinario(int id) {
        return instance.read(id);
    }
    
    public static List<MedicoVeterinario> readAllMedicosVeterinarios() {
        return instance.readAll();
    }
    
}
