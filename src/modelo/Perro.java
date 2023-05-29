package modelo;

import enums.Size;

public class Perro extends Mascota {
    private final String raza;
    private final Size tamaño;
    private final float costoConsulta = 500;

    /**
     * Crea una instancia de la clase Perro con los datos proporcionados.
     *
     * @param clave     la clave del perro.
     * @param telefono  el teléfono asociado al perro.
     * @param prioridad la prioridad del perro.
     * @param dueño     el nombre del dueño del perro.
     * @param nombre    el nombre del perro.
     * @param direccion la dirección del dueño del perro.
     * @param edad      la edad del perro.
     * @param raza      la raza del perro.
     * @param tamaño    el tamaño del perro.
     */
    public Perro(int clave, int telefono, int prioridad, String dueño, String nombre, String direccion, int edad, String raza, Size tamaño) {
        super(clave, telefono, prioridad, dueño, nombre, direccion, edad);
        this.raza = raza;
        this.tamaño = tamaño;
    }

    /**
     * Devuelve la información completa del perro, incluyendo su información básica,
     * raza, tamaño, costo de consulta y costo total.
     *
     * @return la información completa del perro.
     */
    @Override
    public String obtenerInfo() {
        return super.obtenerInfoG() + "Raza: " + raza + ", Tamaño: " + tamaño.getCadena() + ", Costo de consulta: " + costoConsulta + ", Costo total: " + calcularCostoConsulta(costoConsulta);
    }
}
