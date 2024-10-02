
package modelo;

import java.util.List;

/**
 *
 * @author Miller
 */
public interface CRUD<T> {
    
   public List<T> listar();
    public int add(T obj);
    public int actualizar(T obj);
    public void eliminar(int id);
}
