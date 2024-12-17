package ar.edu.uade.cine.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.cine.modelo.exceptions.PeliculaNoEncontradaException;
import ar.edu.uade.cine.modelo.exceptions.ProyeccionNoEncontradaException;
import ar.edu.uade.cine.modelo.exceptions.SalaNoDisponibleException;
import ar.edu.uade.cine.modelo.exceptions.SalaNoEncontradaException;

public class Cine {
    private static final Cine INSTANCE = new Cine();
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Proyeccion> proyecciones;

    private Cine() {
        this.peliculas = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.proyecciones = new ArrayList<>();
     }

    public static Cine getInstance() {
        return INSTANCE;
    }

    public void registrarProyeccion(String nombrePelicula, int numeroSala, String dia, String hora) throws PeliculaNoEncontradaException, SalaNoEncontradaException, SalaNoDisponibleException {
        Pelicula pelicula = buscarPelicula(nombrePelicula);
        Sala sala = buscarSala(numeroSala);
        
        Proyeccion proyeccion = sala.proyectar(pelicula, dia, hora);
        agregarProyeccion(proyeccion);
    }

    public float calcularCostoEntrada(int numeroSala, String dia, String hora) throws SalaNoEncontradaException, ProyeccionNoEncontradaException {
        Sala sala = buscarSala(numeroSala);
        return sala.costoEntradaAPelicula(dia, hora);
    }

    public void agregarPelicula(String nombrePelicula, Clase clase, boolean permiteMenores) {
        Pelicula pelicula = new Pelicula(nombrePelicula, clase, permiteMenores);
        peliculas.add(pelicula);
    }

    public void agregarSala2D(int numeroSala, int cantAsientos, float precioSalaBase) {
        Sala sala = new Sala2D(numeroSala, cantAsientos, precioSalaBase);
        salas.add(sala);
    }

    public void agregarSala3D(int numeroSala, int cantAsientos, float precioSalaBase, float precioAlquilerAnteojos3D) {
        Sala sala = new Sala3D(numeroSala, cantAsientos, precioSalaBase, precioAlquilerAnteojos3D);
        salas.add(sala);
    }

    public void agregarSala4D(int numeroSala, int cantAsientos, float precioSalaBase, float precioEfectosEspeciales, float precioComida) {
        Sala sala = new Sala4D(numeroSala, cantAsientos, precioSalaBase, precioEfectosEspeciales, precioComida);
        salas.add(sala);
    }

    private void agregarProyeccion(Proyeccion proyeccion) {
        proyecciones.add(proyeccion);
    }

    private Pelicula buscarPelicula(String nombrePelicula) throws PeliculaNoEncontradaException {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.sosPelicula(nombrePelicula)) {
                return pelicula;
            }
        }
        throw new PeliculaNoEncontradaException();
    }

    private Sala buscarSala(int numeroSala) throws SalaNoEncontradaException {
        for (Sala sala : salas) {
            if (sala.sosSala(numeroSala)) {
                return sala;
            }
        }
        throw new SalaNoEncontradaException();
    }
}
