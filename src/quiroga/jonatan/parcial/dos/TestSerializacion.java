package quiroga.jonatan.parcial.dos;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestSerializacion {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba de serialización...");

        // Lista de películas de prueba
        List<Pelicula> peliculasPrueba = List.of(
            new Pelicula("Inception", "Christopher Nolan", 2010, 148, Genero.ACCION),
            new Pelicula("The Godfather", "Francis Ford Coppola", 1972, 175, Genero.DRAMA),
            new Pelicula("Toy Story", "John Lasseter", 1995, 81, Genero.COMEDIA)
        );

        String archivoPrueba = "peliculas_prueba.json";
        Serializadora<Pelicula> serializadoraPrueba = new Serializadora<Pelicula>(){};

        // Intentar serializar
        try {
            System.out.println("Intentando guardar el archivo JSON de prueba en: " + archivoPrueba);
            serializadoraPrueba.serializarJSON(peliculasPrueba, archivoPrueba);
            System.out.println("Archivo JSON de prueba guardado exitosamente.");

            // Intentar deserializar
            List<Pelicula> deserializadasPrueba = serializadoraPrueba.deserializarJSON(archivoPrueba, Pelicula[].class);
            System.out.println("\nCatálogo de prueba deserializado:");
            deserializadasPrueba.forEach(System.out::println);
            System.out.println("Archivo JSON de prueba leído exitosamente.");

            System.out.println("Archivo JSON de prueba guardado en: " + new File(archivoPrueba).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ocurrió un error durante la serialización/deserialización de prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
