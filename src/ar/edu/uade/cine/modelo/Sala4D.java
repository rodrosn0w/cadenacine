package ar.edu.uade.cine.modelo;

public class Sala4D extends Sala {

    private float precioEfectosEspeciales;
    private float precioCostoComida;

    public Sala4D(int numeroSala, int cantAsientos, float precioSalaBase, float precioEfectosEspeciales, float precioCostoComida) {
        super(numeroSala, cantAsientos, precioSalaBase);
        this.precioEfectosEspeciales = precioEfectosEspeciales;
        this.precioCostoComida = precioCostoComida;
    }

    @Override
    protected float costoEntrada() {
        return (precioSalaBase + precioEfectosEspeciales + precioCostoComida) / cantAsientos;
    }

    @Override
    protected boolean puedoProyectar(Pelicula pelicula) {
        return pelicula.permitisProyeccion4D();
    }
}
