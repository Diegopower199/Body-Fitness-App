package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;

public class AjustesEntrenador {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarInfoPersona;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonCambiarNombre;
    private JButton buttonCambiarApellidos;
    private JButton buttonCambiarEdad;
    private JButton buttonCambiarCorreo;
    private JButton buttonCambiarContrasena;
    private JButton buttonCambiarGenero;

    public AjustesEntrenador(Entrenadores informacionEntrenador) {
        frame = new JFrame();
        frame.setBounds(100, 100, 382, 524);
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
            ImageIcon im = new ImageIcon(imageLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
            labelLogo.setIcon(im);
        } catch (Exception e) {
        }

        labelLogo.setBounds(298, 10, 70, 65);
        panel.add(labelLogo);

        labelCambiarInfoPersona = new JLabel("<html>CAMBIAR INFORMACIÓN PERSONAL<html>", SwingConstants.CENTER);
        labelCambiarInfoPersona.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCambiarInfoPersona.setBounds(31, 35, 268, 28);
        panel.add(labelCambiarInfoPersona);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        buttonAtras.setBounds(10, 456, 85, 21);
        panel.add(buttonAtras);

        buttonCambiarNombre = new JButton("<html>NOMBRE<html>");
        buttonCambiarNombre.setBounds(77, 63, 203, 37);
        buttonCambiarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioNombre(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarNombre);

        buttonCambiarApellidos = new JButton("<html>APELLIDOS<html>");
        buttonCambiarApellidos.setBounds(77, 128, 203, 37);
        buttonCambiarApellidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioApellidos(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarApellidos);

        buttonCambiarEdad = new JButton("<html>EDAD<html>");
        buttonCambiarEdad.setBounds(77, 195, 203, 37);
        buttonCambiarEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioEdad(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarEdad);

        buttonCambiarCorreo = new JButton("<html>CORREO ELECTRÓNICO<html>");
        buttonCambiarCorreo.setBounds(77, 263, 203, 37);
        buttonCambiarCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioCorreo(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarCorreo);

        buttonCambiarContrasena = new JButton("<html>CONTRASEÑA<html>");
        buttonCambiarContrasena.setBounds(77, 334, 203, 37);
        buttonCambiarContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioContrasena(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarContrasena);

        buttonCambiarGenero = new JButton("<html>GÉNERO<html>");
        buttonCambiarGenero.setBounds(77, 398, 203, 37);
        buttonCambiarGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenadorCambioGenero(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarGenero);

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
