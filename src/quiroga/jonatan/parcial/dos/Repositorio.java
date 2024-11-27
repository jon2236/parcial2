
package quiroga.jonatan.parcial.dos;

import java.util.List;

public interface Repositorio<T> {
    boolean agregar(T item);
    boolean eliminar(T item);
    List<T> obtenerTodos();
}
