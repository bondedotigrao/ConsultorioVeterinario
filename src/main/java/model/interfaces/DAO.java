package model.interfaces;

import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface DAO <T> {
    
    public void create(T t);
    public T read(int id);
    public void update(T t);
    public void delete(T t);
    public List<T> readAll();
    
}
