package modelo;

import java.io.Serializable;

public class Casilla implements Serializable {
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada;
    private int numero;

    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.numero = 0;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void ponerMina() {
        this.tieneMina = true;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        this.descubierta = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void marcar() {
        this.marcada = !this.marcada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
