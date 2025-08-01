package controlador;

import java.util.Scanner;
import modelo.Tablero;
import vista.Consola;

public class Controlador {

    private Tablero tablero;
    private Consola vista;
    private boolean juegoTerminado;
    private Scanner scanner;

    public Controlador() {
        int filas = 10;       // Tamaño del tablero
        int columnas = 10;    // Número de columnas
        int minas = 10;       // Número de minas

        tablero = new Tablero(filas, columnas, minas);
        vista = new Consola();
        juegoTerminado = false;
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        vista.mostrarTablero(tablero);
        while (!juegoTerminado) {
            try {
                String entrada = vista.pedirAccion();
                procesarEntrada(entrada);
                vista.mostrarTablero(tablero);

                if (tablero.juegoTerminado()) {
                    vista.mostrarMensaje(tablero.jugadorGano()
                            ? "¡Felicidades! Has ganado."
                            : "¡BOOM! Pisaste una mina. Fin del juego.");
                    juegoTerminado = true;
                }
            } catch (Exception e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void procesarEntrada(String entrada) throws Exception {
        entrada = entrada.trim().toUpperCase();

        if (entrada.startsWith("M ")) {
            // Marcar casilla
            String coord = entrada.substring(2).trim();
            int[] pos = parsearCoordenada(coord);
            tablero.marcar(pos[0], pos[1]);
        } else {
            // Descubrir casilla
            int[] pos = parsearCoordenada(entrada);
            tablero.descubrir(pos[0], pos[1]);
        }
    }

    /**
     * Convierte coordenada tipo "D5" a índices [fila,col] base cero.
     */
    private int[] parsearCoordenada(String coord) throws Exception {
        if (coord.length() < 2)
            throw new Exception("Formato de coordenada inválido.");

        char letraFila = coord.charAt(0);
        if (letraFila < 'A' || letraFila > 'J')
            throw new Exception("Fila fuera de rango (A-J).");

        int fila = letraFila - 'A';

        String strCol = coord.substring(1);
        int col;
        try {
            col = Integer.parseInt(strCol) - 1;
        } catch (NumberFormatException e) {
            throw new Exception("Columna inválida.");
        }

        if (col < 0 || col >= tablero.getColumnas())
            throw new Exception("Columna fuera de rango.");

        return new int[]{fila, col};
    }
}
