package enums;

public enum Operacion {
    ALTA("Alta"),
    ALTAPERRO("perro"),
    ALTAGATO("gato"),
    ALTALORO("loro"),
    CONSULTA("Consulta"),
    CONSULTAPERRO("Consulta perro"),
    CONSULTAGATO("Consulta pato"),
    CONSULTALORO("Consulta loro");


    private final String text;

    Operacion(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
