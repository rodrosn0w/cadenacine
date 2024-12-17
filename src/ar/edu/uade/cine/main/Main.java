package ar.edu.uade.cine.main;

import ar.edu.uade.cine.modelo.Cine;
import ar.edu.uade.cine.modelo.Clase;
import ar.edu.uade.cine.modelo.exceptions.PeliculaNoEncontradaException;
import ar.edu.uade.cine.modelo.exceptions.ProyeccionNoEncontradaException;
import ar.edu.uade.cine.modelo.exceptions.SalaNoDisponibleException;
import ar.edu.uade.cine.modelo.exceptions.SalaNoEncontradaException;

public class Main {
    public static void main(String[] args) {
        Cine.getInstance().agregarPelicula("El Padrino", Clase.PREMIADA, false);
        Cine.getInstance().agregarPelicula("Sharknado", Clase.CLASE_Z, false);
        Cine.getInstance().agregarPelicula("Intensamente 2", Clase.BEST_SELLER, true);

        Cine.getInstance().agregarSala2D(1, 60, 600000f);
        Cine.getInstance().agregarSala3D(2, 50, 1000000f, 500000);
        Cine.getInstance().agregarSala4D(3, 20, 30000000, 1000000, 100000);

        registrarProyeccion("El Padrino", 1, "Lunes", "10:00");
        registrarProyeccion("Sharknado", 2, "Lunes", "15:00"); // ClaseZ no puede en sala 3D
        registrarProyeccion("Intensamente 2", 3, "Lunes", "20:00"); // Best Seller no puede en sala 4D
        registrarProyeccion("Sharknado", 1, "Lunes", "10:00"); // Sala ocupada por El Padrino
        registrarProyeccion("Sharknado", 1, "Martes", "10:00");
        registrarProyeccion("Intensamente 2", 2, "Martes", "20:00");
        registrarProyeccion("El Padrino", 3, "Lunes", "10:00");

        try {
            System.out.println("Costo entrada 4D: " + Cine.getInstance().calcularCostoEntrada(3, "Lunes", "10:00"));
            System.out.println("Costo entrada 3D: " + Cine.getInstance().calcularCostoEntrada(2, "Martes", "20:00"));
            System.out.println("Costo entrada 2D: " + Cine.getInstance().calcularCostoEntrada(1, "Lunes", "10:00"));
        } catch (SalaNoEncontradaException | ProyeccionNoEncontradaException e) {
            e.printStackTrace();
        }
    }

    private static void registrarProyeccion(String nombrePelicula, int numeroSala, String dia, String hora) {
        try {
            Cine.getInstance().registrarProyeccion(nombrePelicula, numeroSala, dia, hora);
        } catch (PeliculaNoEncontradaException | SalaNoEncontradaException | SalaNoDisponibleException e) {
            System.out.println(e.getMessage() + ": peli= " + nombrePelicula + ", sala= " + numeroSala + ", dia= " + dia + ", hora= " + hora);
        }
    }
}
