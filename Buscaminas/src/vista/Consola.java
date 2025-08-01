package vista;

import java.util.Scanner;
import modelo.Casilla;
import modelo.Tablero;

public class Consola {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarTablero(Tablero tablero) {
        System.out.print("   ");
        for (int i = 1; i <= tablero.getTAM(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int fila = 0; fila < tablero.getTAM(); fila++) {
            System.out.print((char) ('A' + fila) + "  ");
            for (int col = 0; col < tablero.getTAM(); col++) {
                Casilla c = tablero.getCasilla(fila, col);
                if (c.estaDescubierta()) {
                    if (c.tieneMina()) System.out.print("* ");
                    else System.out.print(c.getNumero() + " ");
                } else if (c.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }

    public String pedirAccion() {
        System.out.println("Ingrese acción (Ej: D5 para descubrir, M D5 para marcar):");
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
