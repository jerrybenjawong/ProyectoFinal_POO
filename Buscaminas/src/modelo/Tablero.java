package modelo;

import java.io.Serializable;
import java.util.Random;

public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Casilla[][] casillas;
    private final int filas;
    private final int columnas;
    private final int minas;

    private boolean juegoTerminado;   // true cuando se pisa una mina

    public Tablero(int filas, int columnas, int minas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Dimensiones inválidas.");
        }
        if (minas < 0 || minas >= filas * columnas) {
            throw new IllegalArgumentException("Cantidad de minas inválida.");
        }

        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.juegoTerminado = false;

        this.casillas = new Casilla[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }

        colocarMinas();
        calcularNumeros();
    }

    /* ===================== LÓGICA PRINCIPAL ===================== */

    /** Descubre una casilla. Si tiene mina, marca fin de juego.
     *  Si es vacía (número 0), expande recursivamente. */
    public void descubrir(int fila, int col) {
        if (!posicionValida(fila, col)) return;

        Casilla c = casillas[fila][col];

        if (c.estaDescubierta() || c.estaMarcada()) return;

        c.descubrir();

        if (c.tieneMina()) {
            juegoTerminado = true;
            return;
        }

        // expansión si es 0
        if (c.getNumero() == 0) {
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (posicionValida(i, j)) {
                        descubrir(i, j);
                    }
                }
            }
        }
    }

    /** Marca / desmarca una casilla (toggle). */
    public void marcar(int fila, int col) {
        if (!posicionValida(fila, col)) return;

        Casilla c = casillas[fila][col];
        if (!c.estaDescubierta()) {
            c.marcar();
        }
    }

    /** true si ya pisaste una mina. */
    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    /** true si todas las casillas sin mina están descubiertas. */
    public boolean jugadorGano() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla c = casillas[i][j];
                if (!c.tieneMina() && !c.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* ===================== UTILIDADES INTERNAS ===================== */

    private void colocarMinas() {
        Random r = new Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int f = r.nextInt(filas);
            int c = r.nextInt(columnas);
            if (!casillas[f][c].tieneMina()) {
                casillas[f][c].ponerMina();
                colocadas++;
            }
        }
    }

    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina()) {
                    casillas[i][j].setNumero(contarMinasVecinas(i, j));
                }
            }
        }
    }

    private int contarMinasVecinas(int fila, int col) {
        int minasAlrededor = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (posicionValida(i, j) && casillas[i][j].tieneMina()) {
                    minasAlrededor++;
                }
            }
        }
        return minasAlrededor;
    }

    private boolean posicionValida(int fila, int col) {
        return fila >= 0 && fila < filas && col >= 0 && col < columnas;
    }

    /* ===================== GETTERS ===================== */

    public Casilla getCasilla(int fila, int col) {
        return casillas[fila][col];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getMinas() {
        return minas;
    }

    /** Útil si tu parseo usa este nombre antiguo. */
    public int getTAM() {
        return columnas;
    }
}
