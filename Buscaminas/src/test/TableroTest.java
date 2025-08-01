package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import modelo.Tablero;
import modelo.Casilla; // O la ruta completa de tu paquete donde esté Casilla

public class TableroTest {

    private Tablero tablero;

    @Before
    public void setUp() {
        tablero = new Tablero(5, 5, 3); // Tamaño 5x5 con 3 minas
    }

    @Test
    public void testMarcarDesmarcar() {
        Casilla c = tablero.getCasilla(2, 2);

        assertFalse("La casilla no debería estar marcada inicialmente", c.estaMarcada());

        tablero.marcar(2, 2);
        assertTrue("La casilla debería estar marcada", c.estaMarcada());

        tablero.marcar(2, 2);
        assertFalse("La casilla debería estar desmarcada después de marcarla de nuevo", c.estaMarcada());
    }

    @Test
    public void testDescubrirMinaTerminaJuego() {
        tablero.getCasilla(0, 0).ponerMina();

        tablero.descubrir(0, 0);
        assertTrue("El juego debería terminar al descubrir una mina", tablero.juegoTerminado());
    }

    @Test
    public void testDescubrirFueraDeRangoNoRompe() {
        try {
            tablero.descubrir(-1, -1);
            tablero.marcar(-1, -1);
            tablero.descubrir(999, 999);
            tablero.marcar(999, 999);
        } catch (Exception e) {
            fail("No debería lanzar excepción al operar fuera de rango, solo ignorar.");
        }
    }

    @Test
    public void testJugadorGanaCuandoTodasLasNoMinasEstanDescubiertas() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (!tablero.getCasilla(i, j).tieneMina()) {
                    tablero.descubrir(i, j);
                }
            }
        }
        assertTrue("El jugador debería haber ganado al descubrir todas las no-minas", tablero.jugadorGano());
        assertFalse("El juego no debería estar terminado por mina si ganó", tablero.juegoTerminado());
    }

    @Test
    public void testDescubrirCasillaVaciaExpande() {
        tablero.descubrir(2, 2);
        assertTrue("La casilla debería estar descubierta", tablero.getCasilla(2, 2).estaDescubierta());
    }
}
