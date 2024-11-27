package quiroga.jonatan.parcial.dos;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.io.Reader;
import java.util.List;

public interface Serializadora<T> {
    default void serializarJSON(List<T> lista, String archivo) throws IOException {
        try (Writer writer = new FileWriter(archivo)) {
            Gson gson = new Gson();
            gson.toJson(lista, writer);
        }
    }

    default List<T> deserializarJSON(String archivo, Class<T[]> clazz) throws IOException {
        try (Reader reader = new FileReader(archivo)) {
            Gson gson = new Gson();
            T[] array = gson.fromJson(reader, clazz);
            return List.of(array);
        }
    }
}
