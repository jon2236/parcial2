
package quiroga.jonatan.parcial.dos;


import java.util.Comparator;

public class ComparadorDirectorPelicula implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {
        return p1.getDirector().compareTo(p2.getDirector());
    }
}

