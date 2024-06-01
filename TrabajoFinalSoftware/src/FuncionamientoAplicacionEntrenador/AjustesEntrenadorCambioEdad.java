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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;

public class AjustesEntrenadorCambioEdad {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarEdad;
    private JLabel labelIntroducirEdad;
    private JLabel labelConfirmarEdad;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private JTextField textFieldEdad;
    private JTextField textFieldConfirmacionEdad;

    public AjustesEntrenadorCambioEdad(Entrenadores informacionEntrenador) {
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

        labelLogo.setBounds(338, 17, 70, 65);
        panel.add(labelLogo);

        labelCambiarEdad = new JLabel("<html>CAMBIAR EDAD<html>");
        labelCambiarEdad.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCambiarEdad.setBounds(122, 39, 183, 25);
        panel.add(labelCambiarEdad);

        labelIntroducirEdad = new JLabel("<html>Introduce una nueva edad:<html>");
        labelIntroducirEdad.setBounds(45, 96, 170, 13);
        panel.add(labelIntroducirEdad);

        labelConfirmarEdad = new JLabel("<html>Confirme su edad:<html>");
        labelConfirmarEdad.setBounds(45, 142, 154, 13);
        panel.add(labelConfirmarEdad);

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
                boolean datosBienIntroducidos = true;
                double edad = 0;
                if (textFieldEdad.getText().equals("") || textFieldConfirmacionEdad.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else {
                    if (textFieldEdad.getText().equals(textFieldConfirmacionEdad.getText())) {
                        try {
                            edad = Double.parseDouble(textFieldEdad.getText());
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null,
                                    "<html>Introduce en la edad números enteros, no son válidos números decimales o caracteres<html>");
                            datosBienIntroducidos = false;
                        }

                        if (edad % 1 != 0) {
                            JOptionPane.showMessageDialog(null,
                                    "<html>La edad no puede ser decimal, introduce otra edad válida<html>");
                        }

                        else if (edad < 0.0 || edad > 122.0) {
                            JOptionPane.showMessageDialog(null,
                                    "<html>La edad no puede ser menor a 0 ni mayor a 122<html>");
                        } else if (datosBienIntroducidos) {
                            informacionEntrenador.setEdad(textFieldEdad.getText());
                            Entrenadores.guardarUsuariosEntrenadoresEnBaseDatos();
                            new AjustesEntrenador(informacionEntrenador);
                            frame.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las edades no coinciden", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonFinalizar);

        textFieldEdad = new JTextField();
        textFieldEdad.setBounds(225, 92, 183, 21);
        panel.add(textFieldEdad);
        textFieldEdad.setColumns(10);

        textFieldConfirmacionEdad = new JTextField();
        textFieldConfirmacionEdad.setColumns(10);
        textFieldConfirmacionEdad.setBounds(225, 138, 183, 21);
        panel.add(textFieldConfirmacionEdad);

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
