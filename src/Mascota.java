public abstract  class Mascota {
    private int clave, telefono, prioridad;
    private String dueño, nombre, direccion;
    public float calcularCostoConsulta(int prioridad, float costo){
        float total=0;
        switch (prioridad){
            case 0-> total=costo*1.1f;
            case 1-> total=costo;
            case 2-> total=costo*0.9f;
        }
        return total;
    }
}
