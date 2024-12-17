package ar.edu.uade.cine.modelo.exceptions;

public class SalaNoEncontradaException extends Exception {

    public SalaNoEncontradaException() {
        super("Sala no encontrada");
    }
}
