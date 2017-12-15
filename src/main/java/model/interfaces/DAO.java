/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;

/**
 *
 * @author sion_
 */
public interface DAO <T>{
    
    public void insert(T t);
    public T recovered(int id);
    public void update(T t);
    public void delete(T t);
    public List<T> recoveredAll();
    
}
