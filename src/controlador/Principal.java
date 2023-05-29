package controlador;

import enums.Operacion;
import modelo.Gato;
import modelo.Loro;
import modelo.Mascota;
import modelo.Perro;
import vista.Vista;

import java.io.*;

public class Principal {

    private static Vista vista;
    private static Mascota mascota;

    private static final File filePerros = new File("Perros.txt");
    private static final File fileGatos = new File("Gatos.txt");
    private static final File fileLoros = new File("Loros.txt");

    public static void main(String[] args) {
        vista = new Vista();

        try {
            filePerros.createNewFile();
            fileGatos.createNewFile();
            fileLoros.createNewFile();
        } catch (IOException e) {
            vista.mensajeError();
            vista.dispose();
        }
    }

    /**
     * Guarda una mascota en un archivo específico basado en la operación proporcionada.
     *
     * @param op la operación de guardado a realizar (ALTAPERRO, ALTAGATO, ALTALORO).
     * @throws Exception sí ocurre un error al realizar el guardado.
     */
    public static void guardar(Operacion op) throws Exception {
        FileWriter fileWriter;
        File file = null;
        switch (op) {
            case ALTAPERRO -> {
                mascota = new Perro(vista.obtenerClave(),
                        vista.obtenerTelefono(),
                        vista.obtenerPrioridad(),
                        vista.obtenerDueño(),
                        vista.obtenerNombre(),
                        vista.obtenerDireccion(),
                        vista.obtenerEdad(),
                        vista.obtenerRaza(),
                        vista.obtenerTam());
                file = filePerros;
            }
            case ALTAGATO -> {
                mascota = new Gato(vista.obtenerClave(),
                        vista.obtenerTelefono(),
                        vista.obtenerPrioridad(),
                        vista.obtenerDueño(),
                        vista.obtenerNombre(),
                        vista.obtenerDireccion(),
                        vista.obtenerEdad(),
                        vista.obtenerColor(),
                        vista.obtenerTamaño());

                file = fileGatos;
            }
            case ALTALORO -> {
                mascota = new Loro(vista.obtenerClave(),
                        vista.obtenerTelefono(),
                        vista.obtenerPrioridad(),
                        vista.obtenerDueño(),
                        vista.obtenerNombre(),
                        vista.obtenerDireccion(),
                        vista.obtenerEdad(),
                        vista.obtenerVolar(),
                        vista.obtenerCantar(),
                        vista.obtenerColores());
                file = fileLoros;
            }
        }
        if (file == null) {
            return;
        }
        fileWriter = new FileWriter(file, true);
        fileWriter.append(mascota.obtenerInfo()).append("\n");
        fileWriter.close();
    }

    /**
     * Realiza una consulta de datos basada en el tipo de operación proporcionado.
     *
     * @param a la operación de consulta a realizar (CONSULTAPERRO, CONSULTAGATO, CONSULTALORO).
     * @throws Exception si ocurre un error al realizar la consulta.
     */
    public static void consultar(Operacion a) throws Exception {
        FileReader fileReader;
        File file = null;
        switch (a) {
            case CONSULTAPERRO -> file = filePerros;
            case CONSULTAGATO -> file = fileGatos;
            case CONSULTALORO -> file = fileLoros;
        }
        if (file == null) {
            return;
        }
        fileReader = new FileReader(file);

        StringBuilder builder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.lines().forEach(s -> builder.append(s).append("\n"));
        vista.mostrarConsulta(builder.toString());
    }
}
