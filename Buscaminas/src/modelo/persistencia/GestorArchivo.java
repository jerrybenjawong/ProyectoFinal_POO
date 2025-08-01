package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Tablero;

public class GestorArchivo {

    public static void guardarTablero(Tablero tablero, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(tablero);
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }
    }

    public static Tablero cargarTablero(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Tablero) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la partida: " + e.getMessage());
            return null;
        }
    }
}
