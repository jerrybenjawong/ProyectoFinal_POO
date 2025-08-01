package modelo;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private int partidasJugadas;
    private int partidasGanadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void incrementarPartidasJugadas() {
        this.partidasJugadas++;
    }

    public void incrementarPartidasGanadas() {
        this.partidasGanadas++;
    }
}
