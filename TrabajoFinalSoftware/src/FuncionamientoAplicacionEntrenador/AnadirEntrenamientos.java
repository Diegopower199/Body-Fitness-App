package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import InformacionAplicacionGeneral.Entrenamiento;
import InformacionPersona.Entrenadores;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;

public class AnadirEntrenamientos {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelAnadirEntrenamiento;
    private JLabel labelTipoDeEntrenamiento;
    private JLabel labelGrupoMuscular;
    private JLabel labelNombreDelEjercicio;
    private JLabel labelDescripcionEjercicio;
    private JLabel labelSeries;
    private JLabel labelRepeticiones;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonAnadir;

    private JTextField textFieldTipoEntrenamiento;
    private JTextField textFieldGrupoMuscular;
    private JTextField textFieldNombreEjercicio;
    private JTextField textFieldDescripcionEjercicio;
    private JTextField textFieldSeries;
    private JTextField textFieldRepeticiones;

    public AnadirEntrenamientos(Entrenadores informacionEntrenador) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelLogo = new JLabel();
        imageLogo = null;

        try {
            imageLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
            ImageIcon imagenLogo = new ImageIcon(imageLogo.getScaledInstance(90, 71, Image.SCALE_SMOOTH));
            labelLogo.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        labelLogo.setBounds(346, 11, 90, 71);
        panel.add(labelLogo);

        labelAnadirEntrenamiento = new JLabel("<html>A\u00F1adir Entrenamiento<html>");
        labelAnadirEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        labelAnadirEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAnadirEntrenamiento.setBounds(96, 11, 273, 28);
        panel.add(labelAnadirEntrenamiento);

        textFieldTipoEntrenamiento = new JTextField();
        textFieldTipoEntrenamiento.setColumns(10);
        textFieldTipoEntrenamiento.setBounds(163, 49, 147, 20);
        panel.add(textFieldTipoEntrenamiento);

        textFieldGrupoMuscular = new JTextField();
        textFieldGrupoMuscular.setColumns(10);
        textFieldGrupoMuscular.setBounds(163, 80, 147, 20);
        panel.add(textFieldGrupoMuscular);

        labelTipoDeEntrenamiento = new JLabel("<html>Tipo de entrenamiento<html>");
        labelTipoDeEntrenamiento.setBounds(39, 52, 147, 17);
        panel.add(labelTipoDeEntrenamiento);

        textFieldNombreEjercicio = new JTextField();
        textFieldNombreEjercicio.setColumns(10);
        textFieldNombreEjercicio.setBounds(163, 111, 147, 20);
        panel.add(textFieldNombreEjercicio);

        labelGrupoMuscular = new JLabel("<html>Grupo muscular<html>");
        labelGrupoMuscular.setBounds(39, 81, 113, 17);
        panel.add(labelGrupoMuscular);

        labelNombreDelEjercicio = new JLabel("<html>Nombre del ejercicio<html>");
        labelNombreDelEjercicio.setBounds(39, 110, 125, 26);
        panel.add(labelNombreDelEjercicio);

        buttonAtras = new JButton("<html>Atr\u00E1s<html>");
        buttonAtras.setBounds(27, 239, 89, 23);
        buttonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        labelDescripcionEjercicio = new JLabel("<html>Descripci\u00F3n del ejercicio<html>");
        labelDescripcionEjercicio.setBounds(39, 144, 125, 26);
        panel.add(labelDescripcionEjercicio);

        textFieldDescripcionEjercicio = new JTextField();
        textFieldDescripcionEjercicio.setBounds(162, 148, 148, 20);
        panel.add(textFieldDescripcionEjercicio);
        textFieldDescripcionEjercicio.setColumns(10);

        labelSeries = new JLabel("<html>Series<html>");
        labelSeries.setBounds(39, 176, 58, 26);
        panel.add(labelSeries);

        labelRepeticiones = new JLabel("<html>Repeticiones<html>");
        labelRepeticiones.setBounds(39, 208, 77, 29);
        panel.add(labelRepeticiones);

        textFieldSeries = new JTextField();
        textFieldSeries.setBounds(163, 179, 147, 20);
        panel.add(textFieldSeries);
        textFieldSeries.setColumns(10);

        textFieldRepeticiones = new JTextField();
        textFieldRepeticiones.setBounds(163, 210, 147, 20);
        panel.add(textFieldRepeticiones);
        textFieldRepeticiones.setColumns(10);

        buttonAnadir = new JButton("<html>A\u00F1adir<html>");
        buttonAnadir.setBounds(347, 239, 89, 23);
        buttonAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldTipoEntrenamiento.getText().equals("") || textFieldGrupoMuscular.getText().equals("")
                        || textFieldNombreEjercicio.getText().equals("")
                        || textFieldDescripcionEjercicio.getText().equals("")
                        || textFieldSeries.getText().equals("") || textFieldRepeticiones.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String tipoEntrenamiento = textFieldTipoEntrenamiento.getText();
                    String primeraLetra = tipoEntrenamiento.substring(0, 1);
                    String restoDeLetras = tipoEntrenamiento.substring(1, tipoEntrenamiento.length());

                    primeraLetra = primeraLetra.toUpperCase();
                    tipoEntrenamiento = primeraLetra + restoDeLetras;

                    if (tipoEntrenamiento.equals("Definir") || tipoEntrenamiento.equals("Ganar musculo")
                            || tipoEntrenamiento.equals("Tonificar")) {
                        String grupoMuscular = textFieldGrupoMuscular.getText();
                        primeraLetra = grupoMuscular.substring(0, 1);
                        restoDeLetras = grupoMuscular.substring(1, grupoMuscular.length());

                        primeraLetra = primeraLetra.toUpperCase();
                        grupoMuscular = primeraLetra + restoDeLetras;

                        if (grupoMuscular.equals("Hombros y espalda") || grupoMuscular.equals("Pierna")
                                || grupoMuscular.equals("Brazo") || grupoMuscular.equals("Pecho")
                                || grupoMuscular.equals("Abdominales") || grupoMuscular.equals("Glúteos")
                                || grupoMuscular.equals("Gluteos")) {
                            String nombreEjercicio = textFieldNombreEjercicio.getText();
                            primeraLetra = nombreEjercicio.substring(0, 1);
                            restoDeLetras = nombreEjercicio.substring(1, nombreEjercicio.length());

                            primeraLetra = primeraLetra.toUpperCase();
                            nombreEjercicio = primeraLetra + restoDeLetras;

                            if (tipoEntrenamiento.equals("Definir")) {
                                if (grupoMuscular.equals("Hombros y espalda")) {
                                    new Definir(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Imagen ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Video ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),
                                            "");
                                } else if (grupoMuscular.equals("Pierna")) {
                                    new Definir(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento
                                            .anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                                    "-Direccion Imagen ejercicio "
                                                            + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                                    "");
                                    Entrenamiento
                                            .anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                                    "-Direccion Video ejercicio "
                                                            + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),
                                                    "");
                                }
                            } else if (tipoEntrenamiento.equals("Ganar musculo")) {
                                if (grupoMuscular.equals("Brazo")) {
                                    new GanarMusculo(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Imagen ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Video ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),
                                            "");
                                } else if (grupoMuscular.equals("Pecho")) {
                                    new GanarMusculo(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Imagen ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Video ejercicio "
                                                    + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),
                                            "");
                                }
                            } else if (tipoEntrenamiento.equals("Tonificar")) {
                                if (grupoMuscular.equals("Abdominales")) {
                                    new Tonificar(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Imagen ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Video ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),
                                            "");
                                } else if (grupoMuscular.equals("Gluteos") || grupoMuscular.equals("Glúteos")) {
                                    new Tonificar(tipoEntrenamiento, grupoMuscular, nombreEjercicio,
                                            textFieldDescripcionEjercicio.getText(), textFieldSeries.getText(),
                                            textFieldRepeticiones.getText(), "", "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Nombre ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            nombreEjercicio);
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Descripcion ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            textFieldDescripcionEjercicio.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Series ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            textFieldSeries.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Repeticiones ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            textFieldRepeticiones.getText());
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Imagen ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            "");
                                    Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular,
                                            "-Direccion Video ejercicio "
                                                    + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),
                                            "");
                                }
                            }
                            Entrenamiento.guardarEntrenamientosEnBaseDatos();
                        }
                    }
                    new PantallaPrincipalEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAnadir);

        labelFondo = new JLabel();
        imageFondo = null;

        try {
            imageFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
            ImageIcon im = new ImageIcon(
                    imageFondo.getScaledInstance(imageFondo.getWidth(), imageFondo.getHeight(), Image.SCALE_SMOOTH));
            labelFondo.setIcon(im);
        } catch (Exception e) {
        }

        labelFondo.setBounds(0, 0, 436, 496);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}
