
package quiroga.jonatan.parcial.dos;

import java.util.Comparator;


public class ComparadorGeneroPelicula implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {
        return p1.getGenero().compareTo(p2.getGenero());
    }
}
