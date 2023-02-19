/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecti.services;

import java.util.List;
 
public interface InterfaceService <V> {
    public void ajouter(V v);
    public List<V> getAll();
    public List<V> findById(int id);
    
}
