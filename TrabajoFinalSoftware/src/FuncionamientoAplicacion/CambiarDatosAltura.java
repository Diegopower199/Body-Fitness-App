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

public class CambiarDatosAltura {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarAltura;
    private JLabel labelAltura;
    private JLabel labelAlturaActual;
    private JLabel labelNuevoAltura;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private JTextField textFieldAltura;

    public CambiarDatosAltura(Usuario informacionUsuario) {
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

        labelCambiarAltura = new JLabel("<html>CAMBIAR ALTURA<html>");
        labelCambiarAltura.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarAltura.setBounds(27, 42, 365, 13);
        panel.add(labelCambiarAltura);

        labelAltura = new JLabel("<html>Su altura actual:<html>");
        labelAltura.setBounds(61, 102, 282, 13);
        panel.add(labelAltura);

        labelAlturaActual = new JLabel(informacionUsuario.getAltura() + " cm");
        labelAlturaActual.setBounds(214, 100, 115, 13);
        panel.add(labelAlturaActual);

        labelNuevoAltura = new JLabel("<html>Introduzca su nueva altura (en cm):<html>");
        labelNuevoAltura.setBounds(61, 130, 239, 26);
        panel.add(labelNuevoAltura);

        textFieldAltura = new JTextField();
        textFieldAltura.setBounds(279, 134, 96, 19);
        panel.add(textFieldAltura);
        textFieldAltura.setColumns(10);

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
                double altura = 0.0;
                boolean datosBienIntroducidos = true;

                if (textFieldAltura.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Existen campos vacíos. Inténtelo de nuevo<html>");
                } else if (!(textFieldAltura.getText().equals(""))) {
                    if (textFieldAltura.getText().contains(",")) {
                        textFieldAltura.setText(textFieldAltura.getText().replace(",", "."));
                    }

                    try {
                        altura = Double.parseDouble(textFieldAltura.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "<html>Introduce en la altura números, no letras<html>");
                        datosBienIntroducidos = false;
                    }

                    if (datosBienIntroducidos) {
                        if (altura < 53.3 || altura > 271.0) {
                            JOptionPane.showMessageDialog(null, "<html>Por favor, introduce un dato válido<html>");
                        } else {
                            informacionUsuario.setAltura(textFieldAltura.getText());
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
