package quiroga.jonatan.parcial.dos;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class QuirogaJonatanParcialDos {

    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        try {
            // Agregar películas
            System.out.println("Agregando películas al catálogo...");
            try {
                catalogo.agregar(new Pelicula("Inception", "Christopher Nolan", 2010, 148, Genero.ACCION));
                catalogo.agregar(new Pelicula("The Godfather", "Francis Ford Coppola", 1972, 175, Genero.DRAMA));
                catalogo.agregar(new Pelicula("Toy Story", "John Lasseter", 1995, 81, Genero.COMEDIA));
                catalogo.agregar(new Pelicula("Pulp Fiction", "Quentin Tarantino", 1994, 154, Genero.COMEDIA));
                catalogo.agregar(new Pelicula("The Exorcist", "William Friedkin", 1973, 122, Genero.HORROR));
                System.out.println("Películas agregadas.");
            } catch (Exception e) {
                System.out.println("Error al agregar películas: " + e.getMessage());
            }

            // Intentar agregar una película nula
            System.out.println("Intentando agregar una película nula...");
            try {
                catalogo.agregar(null);
            } catch (PeliculaNulaException e) {
                System.out.println(e.getMessage());
            }

            // Mostrar catálogo inicial
            System.out.println("Catálogo inicial:");
            try {
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al mostrar catálogo inicial: " + e.getMessage());
            }

            // Ordenar y mostrar por título
            System.out.println("Ordenando y mostrando catálogo por título...");
            try {
                Collections.sort(catalogo.obtenerTodos());
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al ordenar por título: " + e.getMessage());
            }

            // Ordenar y mostrar por director
            System.out.println("Ordenando y mostrando catálogo por director...");
            try {
                catalogo.ordenarPor(new ComparadorDirectorPelicula());
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al ordenar por director: " + e.getMessage());
            }

            // Ordenar y mostrar por año
            System.out.println("Ordenando y mostrando catálogo por año...");
            try {
                catalogo.ordenarPor(new ComparadorAnioPelicula());
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al ordenar por año: " + e.getMessage());
            }

            // Ordenar y mostrar por género
            System.out.println("Ordenando y mostrando catálogo por género...");
            try {
                catalogo.ordenarPor(new ComparadorGeneroPelicula());
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al ordenar por género: " + e.getMessage());
            }

            // Ordenar y mostrar por duración
            System.out.println("Ordenando y mostrando catálogo por duración...");
            try {
                catalogo.ordenarPor(new ComparadorDuracionPelicula());
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al ordenar por duración: " + e.getMessage());
            }

            // Intentar eliminar una película no existente
            System.out.println("Intentando eliminar una película no existente...");
            try {
                catalogo.eliminar(new Pelicula("Avatar", "James Cameron", 2009, 162, Genero.ACCION));
            } catch (PeliculaNoEncontradaException e) {
                System.out.println(e.getMessage());
            }

            // Intentar recorrer un catálogo vacío
            System.out.println("Intentando recorrer un catálogo vacío...");
            try {
                Catalogo catalogoVacio = new Catalogo();
                catalogoVacio.obtenerTodos().forEach(System.out::println);
            } catch (CatalogoVacioException e) {
                System.out.println(e.getMessage());
            }

            // Eliminar una película existente
            System.out.println("Eliminando una película existente...");
            try {
                catalogo.eliminar(new Pelicula("Toy Story", "John Lasseter", 1995, 81, Genero.COMEDIA));
                System.out.println("Catálogo después de eliminar una película:");
                catalogo.obtenerTodos().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Error al eliminar una película existente: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            // Siempre intentar serializar el catálogo
            serializarCatalogo(catalogo);
        }
    }

    private static void serializarCatalogo(Catalogo catalogo) {
        System.out.println("Preparando para serializar el catálogo...");
        try {
            String archivo = "peliculas.json";
            System.out.println("Intentando guardar el archivo JSON en: " + archivo);
            Serializadora<Pelicula> serializadora = new Serializadora<Pelicula>(){};
            serializadora.serializarJSON(catalogo.obtenerTodos(), archivo);
            System.out.println("Archivo JSON guardado exitosamente.");

            List<Pelicula> deserializadas = serializadora.deserializarJSON(archivo, Pelicula[].class);
            System.out.println("\nCatálogo deserializado:");
            deserializadas.forEach(System.out::println);
            System.out.println("Archivo JSON leído exitosamente.");

            System.out.println("Archivo JSON guardado en: " + new File(archivo).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ocurrió un error durante la serialización/deserialización: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
