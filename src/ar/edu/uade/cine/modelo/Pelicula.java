package ar.edu.uade.cine.modelo;

public class Pelicula {

    private String nombrePelicula;
    private Clase clase;
    private boolean permiteMenores;

    public Pelicula(String nombrePelicula, Clase clase, boolean permiteMenores) {
        this.nombrePelicula = nombrePelicula;
        this.clase = clase;
        this.permiteMenores = permiteMenores;
    }

    public boolean sosPelicula(String nombrePelicula) {
        return this.nombrePelicula.equals(nombrePelicula);
    }

    public boolean permitisProyeccion4D() {
        return clase == Clase.PREMIADA;
    }

    public boolean permitisProyeccion3D() {
        return clase == Clase.PREMIADA || clase == Clase.BEST_SELLER;
    }

    public boolean permitisProyeccion2D() {
        return clase == Clase.PREMIADA || clase == Clase.BEST_SELLER || clase == Clase.CLASE_Z;
    }
}
