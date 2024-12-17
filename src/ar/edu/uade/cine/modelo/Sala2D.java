package ar.edu.uade.cine.modelo;

public class Sala2D extends Sala {
    public Sala2D(int numeroSala, int cantAsientos, float precioSalaBase) {
        super(numeroSala, cantAsientos, precioSalaBase);
    }

    @Override
    protected float costoEntrada() {
        return precioSalaBase / cantAsientos;
    }

    @Override
    protected boolean puedoProyectar(Pelicula pelicula) {
        return pelicula.permitisProyeccion2D();
    }

}
