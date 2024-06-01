package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import FuncionamientoAplicacion.PantallaPrincipalUsuario;
import FuncionamientoAplicacionEntrenador.PantallaPrincipalEntrenador;
import InformacionPersona.Entrenadores;
import InformacionPersona.Usuario;

public class PanelUsuarioContrasena {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageFondo;
    private BufferedImage imageLogo;

    private JLabel labelLogo;
    private JLabel labelUsuario;
    private JLabel labelContrasena;
    private JLabel labelSeleccion;
    private JLabel labelFondo;

    private JButton buttonEntrar;
    private JButton buttonRegistrarte;
    private JButton buttonOlvidarContrasena;

    private JTextField textFieldUsuarioPersonaIntroducido;

    private JPasswordField passwordFieldContrasenaPersonaIntroducido;

    private ButtonGroup buttonGroupTipoUsuario;

    private JRadioButton radioButtonUsuario;
    private JRadioButton radioButtonEntrenador;

    private boolean usuarioContrasenaCorrectas = false;

    public PanelUsuarioContrasena() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelLogo = new JLabel();
        imageLogo = null;

        try {
            imageLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
            ImageIcon im = new ImageIcon(imageLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
            labelLogo.setIcon(im);
        } catch (Exception e) {
        }

        labelLogo.setBounds(352, 10, 70, 65);
        panel.add(labelLogo);

        labelUsuario = new JLabel("<html>Usuario<html>");
        labelUsuario.setBounds(55, 58, 71, 14);
        panel.add(labelUsuario);

        textFieldUsuarioPersonaIntroducido = new JTextField();
        textFieldUsuarioPersonaIntroducido.setBounds(155, 56, 124, 20);
        panel.add(textFieldUsuarioPersonaIntroducido);
        textFieldUsuarioPersonaIntroducido.setColumns(10);

        labelContrasena = new JLabel("<html>Contrase\u00F1a<html>");
        labelContrasena.setBounds(55, 101, 71, 14);
        panel.add(labelContrasena);

        passwordFieldContrasenaPersonaIntroducido = new JPasswordField();
        passwordFieldContrasenaPersonaIntroducido.setColumns(10);
        passwordFieldContrasenaPersonaIntroducido.setBounds(155, 99, 124, 20);
        panel.add(passwordFieldContrasenaPersonaIntroducido);

        buttonEntrar = new JButton("<html>Entrar<html>");
        buttonEntrar.setBounds(55, 171, 89, 23);
        buttonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldUsuarioPersonaIntroducido.getText().equals("")
                        || new String(passwordFieldContrasenaPersonaIntroducido.getPassword()).equals("")
                        || (!(radioButtonEntrenador.isSelected()) && !(radioButtonUsuario.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "<html>Introduce los datos<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (radioButtonUsuario.isSelected()) {
                        Usuario informacionUsuario = Usuario
                                .recuperarUsuario(textFieldUsuarioPersonaIntroducido.getText());

                        if (informacionUsuario != null) {
                            if (informacionUsuario.getUsuario().equals(textFieldUsuarioPersonaIntroducido.getText())
                                    && informacionUsuario.getContrasena()
                                            .equals((new String(
                                                    passwordFieldContrasenaPersonaIntroducido.getPassword())))) {
                                usuarioContrasenaCorrectas = true;
                            }
                        }

                        if (!(usuarioContrasenaCorrectas)) {
                            JOptionPane.showMessageDialog(null, "<html>Usuario o contraseña incorrecta<html>", null,
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            informacionUsuario.mostrarInformacionUsuario();
                            new PantallaPrincipalUsuario(informacionUsuario);
                            frame.setVisible(false);
                        }
                    }

                    else if (radioButtonEntrenador.isSelected()) {
                        Entrenadores informacionEntrenador = Entrenadores
                                .recuperarUsuarioEntrenador(textFieldUsuarioPersonaIntroducido.getText());

                        if (informacionEntrenador != null) {
                            if (informacionEntrenador.getUsuarioEntrenador()
                                    .equals(textFieldUsuarioPersonaIntroducido.getText())
                                    && informacionEntrenador.getContrasena()
                                            .equals((new String(
                                                    passwordFieldContrasenaPersonaIntroducido.getPassword())))) {
                                usuarioContrasenaCorrectas = true;
                            }
                        }

                        if (!(usuarioContrasenaCorrectas)) {
                            JOptionPane.showMessageDialog(null, "<html>Usuario o contraseña incorrecta<html>", null,
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            informacionEntrenador.mostrarInformacionEntrenador();
                            new PantallaPrincipalEntrenador(informacionEntrenador);
                            frame.setVisible(false);
                        }
                    }
                }
            }
        });
        panel.add(buttonEntrar);

        buttonRegistrarte = new JButton("<html>Registrarse<html>");
        buttonRegistrarte.setBounds(163, 171, 120, 23);
        buttonRegistrarte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(radioButtonEntrenador.isSelected()) && !(radioButtonUsuario.isSelected())) {
                    JOptionPane.showMessageDialog(null, "<html>Debes seleccionar como te vas a registrar<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else if (radioButtonUsuario.isSelected()) {
                    new RegistroUsuarioNuevo();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "<html>No se puede registrar como entrenador<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buttonRegistrarte);

        buttonOlvidarContrasena = new JButton("<html>\u00BFOlvidaste tu contrase\u00F1a?<html>");
        buttonOlvidarContrasena.setForeground(Color.BLUE);
        buttonOlvidarContrasena.setBounds(85, 205, 161, 23);
        buttonOlvidarContrasena.setOpaque(false);
        buttonOlvidarContrasena.setBorder(null);
        buttonOlvidarContrasena.setFocusPainted(false);
        buttonOlvidarContrasena.setBorderPainted(false);
        buttonOlvidarContrasena.setContentAreaFilled(false);
        buttonOlvidarContrasena.setOpaque(true);
        buttonOlvidarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new OlvidarContrasena();
            }
        });
        panel.add(buttonOlvidarContrasena);

        labelSeleccion = new JLabel("Soy:");
        labelSeleccion.setBounds(55, 144, 45, 13);
        panel.add(labelSeleccion);

        radioButtonUsuario = new JRadioButton("Usuario");
        radioButtonUsuario.setOpaque(false);
        radioButtonUsuario.setBounds(273, 140, 103, 21);
        panel.add(radioButtonUsuario);

        radioButtonEntrenador = new JRadioButton("Entrenador");
        radioButtonEntrenador.setOpaque(false);
        radioButtonEntrenador.setBounds(143, 140, 103, 21);
        panel.add(radioButtonEntrenador);

        buttonGroupTipoUsuario = new ButtonGroup();
        buttonGroupTipoUsuario.add(radioButtonEntrenador);
        buttonGroupTipoUsuario.add(radioButtonUsuario);

        labelFondo = new JLabel();
        imageFondo = null;

        try {
            imageFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
            ImageIcon im = new ImageIcon(
                    imageFondo.getScaledInstance(imageFondo.getWidth(), imageFondo.getHeight(), Image.SCALE_SMOOTH));
            labelFondo.setIcon(im);
        } catch (Exception e) {
        }

        labelFondo.setBounds(0, 0, 1024, 640);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}