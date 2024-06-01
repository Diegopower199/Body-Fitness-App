package FuncionamientoAplicacion;

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

import InformacionPersona.Usuario;

public class CambiarDatosPeso {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarPeso;
    private JLabel labelPeso;
    private JLabel labelGeneroActual;
    private JLabel labelNuevoPeso;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private JTextField textFieldPeso;

    public CambiarDatosPeso(Usuario informacionUsuario) {
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

        labelCambiarPeso = new JLabel("<html>CAMBIAR PESO<html>");
        labelCambiarPeso.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarPeso.setBounds(27, 42, 365, 13);
        panel.add(labelCambiarPeso);

        labelPeso = new JLabel("<html>Su peso actual:<html>");
        labelPeso.setBounds(85, 97, 93, 13);
        panel.add(labelPeso);

        labelGeneroActual = new JLabel(informacionUsuario.getPeso() + " kg");
        labelGeneroActual.setBounds(235, 97, 102, 13);
        panel.add(labelGeneroActual);

        labelNuevoPeso = new JLabel("<html>Introduzca su nuevo peso:<html>");
        labelNuevoPeso.setBounds(85, 132, 191, 13);
        panel.add(labelNuevoPeso);

        textFieldPeso = new JTextField();
        textFieldPeso.setBounds(241, 129, 96, 19);
        panel.add(textFieldPeso);
        textFieldPeso.setColumns(10);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new CambiarDatos(informacionUsuario);
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
                double peso = 0.0;

                if (textFieldPeso.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Existen campos vacíos. Inténtelo de nuevo<html>");
                } else if (!(textFieldPeso.getText().equals(""))) {
                    if (textFieldPeso.getText().contains(",")) {
                        textFieldPeso.setText(textFieldPeso.getText().replace(",", "."));
                    }

                    try {
                        peso = Double.parseDouble(textFieldPeso.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "<html>Introduce en el peso numeros no letras<html>");
                        datosBienIntroducidos = false;
                    }

                    if (datosBienIntroducidos) {
                        peso = Double.parseDouble(textFieldPeso.getText());

                        if (peso < 0.0 || peso > 635.0) {
                            JOptionPane.showMessageDialog(null, "<html>Por favor, introduce un dato válido<html>");
                        } else {
                            informacionUsuario.setPeso(textFieldPeso.getText());
                            Usuario.guardarUsuariosEnBaseDatos();
                            new CambiarDatos(informacionUsuario);
                            frame.setVisible(false);
                        }
                    }
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
