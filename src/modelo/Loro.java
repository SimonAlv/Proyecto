package modelo;

import java.util.List;

public class Loro extends Mascota {
    private final boolean volar;
    private final boolean cantar;
    private final List<String> colores;
    private final float costoConsulta = 300;

    /**
     * Crea una instancia de la clase Loro con los datos proporcionados.
     *
     * @param clave     la clave del loro.
     * @param telefono  el teléfono asociado al loro.
     * @param prioridad la prioridad del loro.
     * @param dueño     el nombre del dueño del loro.
     * @param nombre    el nombre del loro.
     * @param direccion la dirección del dueño del loro.
     * @param edad      la edad del loro.
     * @param volar     indica si el loro puede volar.
     * @param cantar    indica si el loro puede cantar.
     * @param colores   la lista de colores del loro.
     */
    public Loro(int clave, int telefono, int prioridad, String dueño, String nombre, String direccion, int edad, boolean volar, boolean cantar, List<String> colores) {
        super(clave, telefono, prioridad, dueño, nombre, direccion, edad);
        this.volar = volar;
        this.cantar = cantar;
        this.colores = colores;
    }

    /**
     * Devuelve la información completa del loro, incluyendo su información básica, colores, capacidad de vuelo, capacidad de canto,
     * costo de consulta y costo total.
     *
     * @return la información completa del loro.
     */
    @Override
    public String obtenerInfo() {
        return super.obtenerInfoG() + "Color(es): " + colores + ", " + "Vuela: " + volar + ", " + "Canta: " + cantar + ", Costo de consulta: " + costoConsulta + ", Costo total: " + calcularCostoConsulta(costoConsulta);
    }
}
