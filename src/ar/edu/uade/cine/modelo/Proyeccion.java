package ar.edu.uade.cine.modelo;

public class Proyeccion {

    private Pelicula pelicula;
    private Sala sala;
    private String dia;
    private String hora;

    public Proyeccion(Pelicula pelicula, Sala sala, String dia, String hora) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.dia = dia;
        this.hora = hora;
    }

    public boolean sosProyectada(String dia, String hora) {
        return this.dia.equals(dia) && this.hora.equals(hora);
    }

}
