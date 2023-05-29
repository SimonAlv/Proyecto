package vista;

import enums.Operacion;
import enums.Size;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static controlador.Principal.consultar;
import static controlador.Principal.guardar;
import static enums.Size.equivalente;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Vista extends JFrame {

    private JPanel panel;
    private JButton altaButton;
    private JButton consultaButton;
    private JButton salirButton;
    private JPanel menu;
    private JPanel menu_mascotas;
    private JButton perroButton;
    private JButton regresarMenuButton;
    private JButton loroButton;
    private JButton gatoButton;
    private JPanel alta;
    private JPanel consulta;
    private JButton regresarAltaMenuButton;
    private JTextField textField1;
    private JComboBox textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textFieldP1;
    private JComboBox textFieldP2;
    private JTextField textFieldG1;
    private JTextField textFieldG2;
    private JTextField textFieldL1;
    private JComboBox textFieldL2;
    private JButton guardarButton;
    private JTextArea textArea1;
    private JTextField textField7;
    private JButton regresarConsultaMenuButton;
    private JComboBox textFieldL3;
    private JLabel menu_mascotas_label;
    private JLabel consulta_label;
    private Operacion operacion;
    private JLabel tituloAltaLabel;
    private JLabel labelG1;
    private JLabel labelP2;
    private JLabel labelP1;
    private JLabel labelG2;
    private JLabel labelL1;
    private JLabel labelL2;
    private JLabel labelL3;

    public Vista() {
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        altaButton.addActionListener(e -> {
            operacion = Operacion.ALTA;
            menu_mascotas_label.setText(" Selecciona una mascota para dar de alta ");
            switchPaneAToB(menu, menu_mascotas);
        });
        consultaButton.addActionListener(e -> {
            operacion = Operacion.CONSULTA;
            menu_mascotas_label.setText(" Selecciona un archivo para consultar ");
            switchPaneAToB(menu, menu_mascotas);
        });
        salirButton.addActionListener(e -> this.dispose());
        perroButton.addActionListener(e -> {
            ejecutarOperacion(Operacion.ALTAPERRO, Operacion.CONSULTAPERRO);
            mostrarPanel(operacion);
        });
        gatoButton.addActionListener(e -> {
            ejecutarOperacion(Operacion.ALTAGATO, Operacion.CONSULTAGATO);
            mostrarPanel(operacion);
        });
        loroButton.addActionListener(e -> {
            ejecutarOperacion(Operacion.ALTALORO, Operacion.CONSULTALORO);
            mostrarPanel(operacion);
        });
        regresarMenuButton.addActionListener(e -> switchPaneAToB(menu_mascotas, menu));
        regresarAltaMenuButton.addActionListener(e -> {
            switchPaneAToB(alta, menu_mascotas);
            operacion = Operacion.ALTA;
        });
        guardarButton.addActionListener(e -> {
            try {
                guardar(operacion);
            } catch (Exception ex) {
                mensajeError();
            }
            operacion = null;
            switchPaneAToB(alta, menu);
        });

        regresarConsultaMenuButton.addActionListener(e -> {
            switchPaneAToB(consulta, menu_mascotas);
            operacion = Operacion.CONSULTA;
        });

    }

    public int obtenerClave() {
        return parseInt(textField1.getText());
    }

    public int obtenerPrioridad() {
        return textField2.getSelectedIndex() + 1;
    }

    public String obtenerNombre() {
        return textField3.getText();
    }

    public String obtenerDueño() {
        return textField4.getText();
    }

    public int obtenerEdad() {
        return parseInt(textField5.getText());
    }

    public int obtenerTelefono() {
        return parseInt(textField6.getText());
    }

    public String obtenerDireccion() {
        return textField7.getText();
    }

    public String obtenerRaza() {
        return textFieldP1.getText();
    }

    public Size obtenerTam() {
        return equivalente(textFieldP2.getSelectedIndex());
    }

    public String obtenerColor() {
        return textFieldG1.getText();
    }

    public float obtenerTamaño() {
        return parseFloat(textFieldG2.getText());
    }

    public List<String> obtenerColores() {
        StringTokenizer tokenizer = new StringTokenizer(textFieldL1.getText(), ",");
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    public boolean obtenerVolar() {
        boolean vuela;
        vuela = textFieldL2.getSelectedIndex() == 0;
        return vuela;
    }

    public boolean obtenerCantar() {
        boolean vuela;
        vuela = textFieldL3.getSelectedIndex() == 0;
        return vuela;
    }

    public void mostrarConsulta(String texto) {
        this.textArea1.setText(texto);
    }

    public void mensajeError() {
        showMessageDialog(null, "Ocurrió un error", "Error", ERROR_MESSAGE);
    }

    //-------------------------------
    private void ejecutarOperacion(Operacion o, Operacion o1) {
        switch (operacion) {
            case ALTA -> {
                operacion = o;
                tituloAltaLabel.setText(" Ingresa los datos del " + o.getText() + " ");
                switchPaneAToB(menu_mascotas, alta);
            }
            case CONSULTA -> {
                try {
                    consultar(o1);
                } catch (Exception ex) {
                    mensajeError();
                }
                consulta_label.setText(o1.getText());
                switchPaneAToB(menu_mascotas, consulta);
            }
        }

    }

    private void switchPaneAToB(JPanel a, JPanel b) {
        b.setVisible(true);
        a.setVisible(false);
    }

    private void mostrarPanel(Operacion operacion) {
        textFieldP1.setVisible(false);
        textFieldP2.setVisible(false);
        labelP1.setVisible(false);
        labelP2.setVisible(false);

        textFieldG1.setVisible(false);
        textFieldG2.setVisible(false);
        labelG1.setVisible(false);
        labelG2.setVisible(false);

        textFieldL1.setVisible(false);
        textFieldL2.setVisible(false);
        textFieldL3.setVisible(false);
        labelL1.setVisible(false);
        labelL2.setVisible(false);
        labelL3.setVisible(false);

        switch (operacion) {
            case ALTAPERRO -> {
                textFieldP1.setVisible(true);
                textFieldP2.setVisible(true);
                labelP1.setVisible(true);
                labelP2.setVisible(true);
            }
            case ALTAGATO -> {
                textFieldG1.setVisible(true);
                textFieldG2.setVisible(true);
                labelG1.setVisible(true);
                labelG2.setVisible(true);
            }
            case ALTALORO -> {
                textFieldL1.setVisible(true);
                textFieldL2.setVisible(true);
                textFieldL3.setVisible(true);
                labelL1.setVisible(true);
                labelL2.setVisible(true);
                labelL3.setVisible(true);
            }
        }
    }


}
