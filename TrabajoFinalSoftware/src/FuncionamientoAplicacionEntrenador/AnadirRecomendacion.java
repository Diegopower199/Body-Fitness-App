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

import InformacionAplicacionGeneral.Recomendacion;
import InformacionPersona.Entrenadores;
import InformacionPersona.Usuario;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;

public class AnadirRecomendacion {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelRecomendacion;
    private JLabel labelTipoEntrenamiento;
    private JLabel labelGrupoMuscular;
    private JLabel labelNombreEjercicio;
    private JLabel labelAnadirRecomendacion;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonSiguiente;

    private JTextField textFieldTipoEntrenamiento;
    private JTextField textFieldGrupoMuscular;
    private JTextField textFieldNombreEjercicio;
    private JTextField textFieldAnadirRecomendacion;

    public Usuario usuario;
    public Entrenadores entrenador;

    public AnadirRecomendacion(Entrenadores informacionEntrenador) {
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

        labelRecomendacion = new JLabel("<html>AÑADIR RECOMENDACIÓN<html>");
        labelRecomendacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);
        labelRecomendacion.setBounds(10, 10, 416, 21);
        panel.add(labelRecomendacion);

        labelTipoEntrenamiento = new JLabel("<html>Tipo de entrenamiento: <html>");
        labelTipoEntrenamiento.setBounds(51, 44, 134, 13);
        panel.add(labelTipoEntrenamiento);

        textFieldTipoEntrenamiento = new JTextField();
        textFieldTipoEntrenamiento.setBounds(195, 41, 148, 19);
        panel.add(textFieldTipoEntrenamiento);
        textFieldTipoEntrenamiento.setColumns(10);

        labelGrupoMuscular = new JLabel("<html>Grupo muscular: <html>");
        labelGrupoMuscular.setBounds(51, 87, 134, 13);
        panel.add(labelGrupoMuscular);

        textFieldGrupoMuscular = new JTextField();
        textFieldGrupoMuscular.setColumns(10);
        textFieldGrupoMuscular.setBounds(195, 84, 148, 19);
        panel.add(textFieldGrupoMuscular);

        labelNombreEjercicio = new JLabel("<html>Nombre ejercicio: <html>");
        labelNombreEjercicio.setBounds(51, 134, 134, 13);
        panel.add(labelNombreEjercicio);

        textFieldNombreEjercicio = new JTextField();
        textFieldNombreEjercicio.setColumns(10);
        textFieldNombreEjercicio.setBounds(195, 131, 148, 19);
        panel.add(textFieldNombreEjercicio);

        labelAnadirRecomendacion = new JLabel("<html>Añadir recomendación: <html>");
        labelAnadirRecomendacion.setBounds(51, 177, 134, 13);
        panel.add(labelAnadirRecomendacion);

        textFieldAnadirRecomendacion = new JTextField();
        textFieldAnadirRecomendacion.setBounds(195, 177, 148, 43);
        panel.add(textFieldAnadirRecomendacion);
        textFieldAnadirRecomendacion.setColumns(10);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new PantallaPrincipalEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAtras);

        buttonSiguiente = new JButton("<html>Finalizar<html>");
        buttonSiguiente.setBounds(341, 232, 85, 21);
        buttonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldTipoEntrenamiento.getText().equals("") || textFieldGrupoMuscular.getText().equals("")
                        || textFieldNombreEjercicio.getText().equals("")
                        || textFieldAnadirRecomendacion.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else {
                    if (textFieldTipoEntrenamiento.getText().equals("Definir")
                            || textFieldTipoEntrenamiento.getText().equals("Ganar musculo")
                            || textFieldTipoEntrenamiento.getText().equals("Tonificar")) {
                        if (textFieldGrupoMuscular.getText().equals("Hombros y espalda")
                                || textFieldGrupoMuscular.getText().equals("Pierna")
                                || textFieldGrupoMuscular.getText().equals("Brazo")
                                || textFieldGrupoMuscular.getText().equals("Pecho")
                                || textFieldGrupoMuscular.getText().equals("Abdominales")
                                || textFieldGrupoMuscular.getText().equals("Glúteos")
                                || textFieldGrupoMuscular.getText().equals("Gluteos")) {

                            if (Definir.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
                                new Recomendacion("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1),
                                        textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(),
                                        textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
                                Recomendacion.guardarRecomendacionEnBaseDatos();
                                new PantallaPrincipalEntrenador(informacionEntrenador);
                                frame.setVisible(false);
                            } else if (GanarMusculo.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
                                new Recomendacion("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1),
                                        textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(),
                                        textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
                                Recomendacion.guardarRecomendacionEnBaseDatos();
                                new PantallaPrincipalEntrenador(informacionEntrenador);
                                frame.setVisible(false);
                            } else if (Tonificar.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
                                new Recomendacion("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1),
                                        textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(),
                                        textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
                                Recomendacion.guardarRecomendacionEnBaseDatos();
                                new PantallaPrincipalEntrenador(informacionEntrenador);
                                frame.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "<html>El nombre del ejercicio no existe, inténtelo de nuevo<html>", null,
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "<html>El grupo muscular no existe, intentalo de nuevo<html>", null,
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html>El tipo de entrenamiento no existe, intentalo de nuevo<html>", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonSiguiente);

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