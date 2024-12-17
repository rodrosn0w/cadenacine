package ar.edu.uade.cine.modelo;

public class Sala3D extends Sala {

    private float precioAlquilerAnteojos3D;

    public Sala3D(int numeroSala, int cantAsientos, float precioSalaBase, float precioAlquilerAnteojos3D) {
        super(numeroSala, cantAsientos, precioSalaBase);
        this.precioAlquilerAnteojos3D = precioAlquilerAnteojos3D;
    }

    @Override
    protected float costoEntrada() {
        return (precioSalaBase + precioAlquilerAnteojos3D) / cantAsientos;
    }

    @Override
    protected boolean puedoProyectar(Pelicula pelicula) {
        return pelicula.permitisProyeccion3D();
    }

}
