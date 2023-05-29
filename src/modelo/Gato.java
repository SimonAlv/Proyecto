package modelo;

public class Gato extends Mascota {
    private final String color;
    private final float tamaño;
    private final float costoConsulta = 400;

    /**
     * Crea una instancia de la clase Gato con los datos proporcionados.
     *
     * @param clave     la clave del gato.
     * @param telefono  teléfono el teléfono asociado al gato.
     * @param prioridad la prioridad del gato.
     * @param dueño     el nombre del dueño del gato.
     * @param nombre    el nombre del gato.
     * @param direccion la dirección del dueño del gato.
     * @param edad      la edad del gato.
     * @param color     el color del gato.
     * @param tamaño    el tamaño del gato.
     */
    public Gato(int clave, int telefono, int prioridad, String dueño, String nombre, String direccion, int edad, String color, float tamaño) {
        super(clave, telefono, prioridad, dueño, nombre, direccion, edad);
        this.color = color;
        this.tamaño = tamaño;
    }

    /**
     * Devuelve la información completa del gato, incluyendo su información básica,
     * color, tamaño, costo de consulta y costo total.
     *
     * @return la información completa del gato.
     */
    @Override
    public String obtenerInfo() {
        return super.obtenerInfoG() + "Color: " + color + ", " + "Tamaño: " + tamaño + ", Costo de consulta: " + costoConsulta + ", Costo total: " + calcularCostoConsulta(costoConsulta);
    }
}
