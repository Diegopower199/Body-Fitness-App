package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;

public class AjustesEntrenadorCambioGenero {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarGenero;
    private JLabel labelGenero;
    private JLabel labelGeneroActual;
    private JLabel labelNuevoGenero;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private ButtonGroup buttonGroupGeneros;

    private JRadioButton radioButtonGeneroMasculino;
    private JRadioButton radioButtonGeneroFemenino;

    public AjustesEntrenadorCambioGenero(Entrenadores informacionEntrenador) {
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
            ImageIcon im = new ImageIcon(imageLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
            labelLogo.setIcon(im);
        } catch (Exception e) {
        }

        labelLogo.setBounds(356, 10, 70, 65);
        panel.add(labelLogo);

        labelCambiarGenero = new JLabel("<html>CAMBIAR GÉNERO<html>");
        labelCambiarGenero.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarGenero.setBounds(27, 42, 365, 13);
        panel.add(labelCambiarGenero);

        labelGenero = new JLabel("<html>Su género:<html>");
        labelGenero.setBounds(61, 93, 93, 13);
        panel.add(labelGenero);

        labelGeneroActual = new JLabel(informacionEntrenador.getSexo());
        labelGeneroActual.setBounds(211, 93, 102, 13);
        panel.add(labelGeneroActual);

        labelNuevoGenero = new JLabel("<html>Seleccione su nuevo género:<html>");
        labelNuevoGenero.setBounds(61, 128, 191, 13);
        panel.add(labelNuevoGenero);

        radioButtonGeneroMasculino = new JRadioButton("<html>Masculino<html>");
        radioButtonGeneroMasculino.setBounds(92, 151, 103, 21);
        radioButtonGeneroMasculino.setOpaque(false);
        panel.add(radioButtonGeneroMasculino);

        radioButtonGeneroFemenino = new JRadioButton("<html>Femenino<html>");
        radioButtonGeneroFemenino.setBounds(225, 151, 103, 21);
        radioButtonGeneroFemenino.setOpaque(false);
        panel.add(radioButtonGeneroFemenino);

        buttonGroupGeneros = new ButtonGroup();
        buttonGroupGeneros.add(radioButtonGeneroMasculino);
        buttonGroupGeneros.add(radioButtonGeneroFemenino);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new AjustesEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAtras);

        buttonFinalizar = new JButton("<html>Finalizar<html>");
        buttonFinalizar.setBounds(341, 232, 85, 21);
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!radioButtonGeneroMasculino.isSelected() && !radioButtonGeneroFemenino.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else {
                    if (radioButtonGeneroMasculino.isSelected()) {
                        informacionEntrenador.setSexo("Masculino");
                    } else if (radioButtonGeneroFemenino.isSelected()) {
                        informacionEntrenador.setSexo("Femenino");
                    }
                    Entrenadores.guardarUsuariosEntrenadoresEnBaseDatos();
                    new AjustesEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonFinalizar);

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
