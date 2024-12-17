package ar.edu.uade.cine.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.cine.modelo.exceptions.ProyeccionNoEncontradaException;
import ar.edu.uade.cine.modelo.exceptions.SalaNoDisponibleException;

public abstract class Sala {

    private int numeroSala;
    protected int cantAsientos;
    protected float precioSalaBase;
    protected List<Proyeccion> proyecciones;

    protected Sala(int numeroSala, int cantAsientos, float precioSalaBase) {
        this.numeroSala = numeroSala;
        this.cantAsientos = cantAsientos;
        this.precioSalaBase = precioSalaBase;
        this.proyecciones = new ArrayList<>();
    }

    public boolean sosSala(int numeroSala) {
        return this.numeroSala == numeroSala;
    }

    protected abstract float costoEntrada();
    
    protected abstract boolean puedoProyectar(Pelicula pelicula);

    public Proyeccion proyectar(Pelicula pelicula, String dia, String hora) throws SalaNoDisponibleException {
        if (estoyDisponible(dia, hora) && puedoProyectar(pelicula)) {
            Proyeccion proyeccion = new Proyeccion(pelicula, this, dia, hora);
            agregarProyeccion(proyeccion);
            return proyeccion;
        }
        throw new SalaNoDisponibleException();
    }

    private void agregarProyeccion(Proyeccion proyeccion) {
        proyecciones.add(proyeccion);
    }

    private boolean estoyDisponible(String dia, String hora) {
        for (Proyeccion proyeccion : proyecciones) {
            if (proyeccion.sosProyectada(dia, hora)) {
                return false;
            }
        }
        return true;
    }

    public float costoEntradaAPelicula(String dia, String hora) throws ProyeccionNoEncontradaException {
        for (Proyeccion proyeccion : proyecciones) {
            if (proyeccion.sosProyectada(dia, hora)) {
                return costoEntrada();
            }
        }
        throw new ProyeccionNoEncontradaException();
    }

}
