
package quiroga.jonatan.parcial.dos;

import java.util.Comparator;


public class ComparadorDuracionPelicula implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {
        return Integer.compare(p1.getDuracion(), p2.getDuracion());
    }
}
