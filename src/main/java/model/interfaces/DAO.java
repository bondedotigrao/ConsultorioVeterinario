package model.interfaces;

import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface DAO <T> {
    
    public void adicionar(T t);
    public T recuperar(int id);
    public void alterar(T t);
    public void deletar(T t);
    public List<T> recuperarTodos();
    
}
