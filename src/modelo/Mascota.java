package modelo;

public abstract class Mascota {
    protected int clave, telefono, prioridad, edad;
    protected String dueño, nombre, direccion;

    /**
     * Crea una instancia de la clase Mascota con los datos proporcionados.
     *
     * @param clave     la clave de la mascota.
     * @param telefono  el teléfono asociado a la mascota.
     * @param prioridad la prioridad de la mascota.
     * @param dueño     el nombre del dueño de la mascota.
     * @param nombre    el nombre de la mascota.
     * @param direccion la dirección del dueño de la mascota.
     * @param edad      la edad de la mascota.
     */
    public Mascota(int clave, int telefono, int prioridad, String dueño, String nombre, String direccion, int edad) {
        this.clave = clave;
        this.telefono = telefono;
        this.prioridad = prioridad;
        this.dueño = dueño;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
    }

    /**
     * Calcula el costo total de la consulta basado en el costo proporcionado
     * y la prioridad de la mascota.
     *
     * @param costo el costo base de la consulta.
     * @return el costo total de la consulta.
     */
    public float calcularCostoConsulta(float costo) {
        float total = 0;
        switch (prioridad) {
            case 1 -> total = costo * 1.1f;
            case 2 -> total = costo;
            case 3 -> total = costo * 0.9f;
        }
        return total;
    }

    /**
     * Obtiene la información básica de la mascota, incluyendo su clave,
     * prioridad, nombre, dueño, edad, teléfono y dirección.
     *
     * @return la información básica de la mascota.
     */
    public String obtenerInfoG() {
        return "Clave: " + clave + ", " +
                "Prioridad: " + prioridad + ", " +
                "Nombre: " + nombre + ", " +
                "Dueño: " + dueño + ", " +
                "Edad: " + edad + ", " +
                "Telefono: " + telefono + ", " +
                "Direccion: " + direccion + ", "
                ;
    }

    /**
     * Devuelve la información de la mascota.
     *
     * @return la información de la mascota.
     */
    public abstract String obtenerInfo();

}
