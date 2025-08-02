package modelo.excepciones;

public class CasillaMarcadaException extends Exception {
    public CasillaMarcadaException() {
        super("La casilla está marcada y no puede descubrirse.");
    }
}
