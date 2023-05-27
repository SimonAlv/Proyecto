
public class Perro extends Mascota{
    public enum Size {
        GRANDE,MEDIANO,PEQUEÑO
    }

    public Perro(String raza, Size tamaño, int costoConsulta) {
        this.raza = raza;
        this.tamaño = tamaño;
        this.costoConsulta = costoConsulta;
    }

    String raza;
    Size tamaño;
    int costoConsulta;
}
