package enums;

public enum Size {

    PEQUEÑO(0,"pequeño"),
    MEDIANO(1,"mediano"),
    GRANDE(2,"grande");
    private final int entero;
    private final String cadena;
    Size(int entero,String cadena) {
        this.entero = entero;
        this.cadena = cadena;
    }

    public int getEntero() {
        return entero;
    }

    public static Size equivalente(int valor) {
        Size tam = null;
        for (Size size : Size.values()) {
            if (size.getEntero() == valor) tam = size;
        }
        return tam;
    }

    public String getCadena() {
        return cadena;
    }
}
