
package quiroga.jonatan.parcial.dos;



public class Pelicula implements Comparable<Pelicula> {
    private String titulo;
    private String director;
    private int anio;
    private int duracion;
    private Genero genero;


    public Pelicula(String titulo, String director, int anio, int duracion, Genero genero) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.duracion = duracion;
        this.genero = genero;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAnio() {
        return anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    @Override
    public int compareTo(Pelicula otra) {
        return this.titulo.compareTo(otra.titulo);
    }


    @Override
    public String toString() {
        return "pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                ", duracion=" + duracion +
                ", genero=" + genero +
                '}';
    }
}

