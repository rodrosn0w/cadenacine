package ar.edu.uade.cine.modelo.exceptions;

public class SalaNoDisponibleException extends Exception {

    public SalaNoDisponibleException() {
        super("Sala no disponible");
    }
}
