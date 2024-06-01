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

public class EliminarEntrenamientos {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelEliminarEntrenamiento;
    private JLabel labelTipoDeEntrenamiento;
    private JLabel labelGrupoMuscular;
    private JLabel labelNombreDelEjercicio;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonEliminar;

    private JTextField textFieldTipoEntrenamiento;
    private JTextField textFieldGrupoMuscular;
    private JTextField textFieldNombreEjercicio;

    public EliminarEntrenamientos(Entrenadores informacionEntrenador) {
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

        labelEliminarEntrenamiento = new JLabel("<html>Eliminar Entrenamiento<html>");
        labelEliminarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        labelEliminarEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelEliminarEntrenamiento.setBounds(30, 11, 414, 14);
        panel.add(labelEliminarEntrenamiento);

        textFieldTipoEntrenamiento = new JTextField();
        textFieldTipoEntrenamiento.setColumns(10);
        textFieldTipoEntrenamiento.setBounds(193, 70, 147, 20);
        panel.add(textFieldTipoEntrenamiento);

        textFieldGrupoMuscular = new JTextField();
        textFieldGrupoMuscular.setColumns(10);
        textFieldGrupoMuscular.setBounds(193, 105, 147, 20);
        panel.add(textFieldGrupoMuscular);

        labelTipoDeEntrenamiento = new JLabel("<html>Tipo de entrenamiento<html>");
        labelTipoDeEntrenamiento.setBounds(46, 70, 137, 24);
        panel.add(labelTipoDeEntrenamiento);

        textFieldNombreEjercicio = new JTextField();
        textFieldNombreEjercicio.setColumns(10);
        textFieldNombreEjercicio.setBounds(193, 141, 147, 20);
        panel.add(textFieldNombreEjercicio);

        labelGrupoMuscular = new JLabel("<html>Grupo muscular<html>");
        labelGrupoMuscular.setBounds(47, 105, 101, 25);
        panel.add(labelGrupoMuscular);

        labelNombreDelEjercicio = new JLabel("<html>Nombre del ejercicio<html>");
        labelNombreDelEjercicio.setBounds(47, 141, 136, 24);
        panel.add(labelNombreDelEjercicio);

        buttonAtras = new JButton("<html>Atr\u00E1s<html>");
        buttonAtras.setBounds(47, 216, 89, 23);
        buttonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        buttonEliminar = new JButton("<html>Eliminar<html>");
        buttonEliminar.setBounds(287, 216, 89, 23);
        buttonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldTipoEntrenamiento.getText().equals("") || textFieldGrupoMuscular.getText().equals("")
                        || textFieldNombreEjercicio.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    if (Definir.existeEntrenamiento(textFieldNombreEjercicio.getText())
                            || GanarMusculo.existeEntrenamiento(textFieldNombreEjercicio.getText())
                            || Tonificar.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
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
                                Entrenamiento.eliminarBinomiosNivel3(tipoEntrenamiento, grupoMuscular, nombreEjercicio);

                                if (tipoEntrenamiento.equals("Definir")) {
                                    Definir.eliminarEjercicioDefinir(nombreEjercicio);
                                } else if (tipoEntrenamiento.equals("Ganar musculo")) {
                                    GanarMusculo.eliminarEjercicioGanarMusculo(nombreEjercicio);
                                } else if (tipoEntrenamiento.equals("Tonificar")) {
                                    Tonificar.eliminarEjercicioTonificar(nombreEjercicio);
                                }
                                Entrenamiento.guardarEntrenamientosEnBaseDatos();
                            }
                        }
                        new PantallaPrincipalEntrenador(informacionEntrenador);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Ese entrenamiento no esta en nuestra base de datos, introduce otro por favor", null,
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonEliminar);

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
