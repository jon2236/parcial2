
package quiroga.jonatan.parcial.dos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Catalogo implements Repositorio<Pelicula>, Iterable<Pelicula> {
    private List<Pelicula> peliculas = new ArrayList<>();

    @Override
    public boolean agregar(Pelicula pelicula) {
        if (pelicula == null) throw new PeliculaNulaException("nno se puede agregr una peli nula.");
        return peliculas.add(pelicula);
    }

    @Override
    public boolean eliminar(Pelicula pelicula) {
        if (!peliculas.contains(pelicula)) throw new PeliculaNoEncontradaException("peli no encontrada.");
        return peliculas.remove(pelicula);
    }

    @Override
    public List<Pelicula> obtenerTodos() {
        if (peliculas.isEmpty()) throw new CatalogoVacioException("el catalogo esta vacio.");
        return new ArrayList<>(peliculas);
    }

    public void ordenarPor(Comparator<Pelicula> comparator) {
        Collections.sort(peliculas, comparator);
    }

    @Override
    public Iterator<Pelicula> iterator() {
        return peliculas.iterator();
    }
}

