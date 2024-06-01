package Login;

import java.awt.BorderLayout;
import java.awt.Color;
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

import InformacionPersona.Usuario;

public class OlvidarContrasena {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelRecuperarCuenta;
    private JLabel labelEmail;
    private JLabel labelFondo;

    private JButton buttonBuscar;
    private JButton buttonCancelar;

    private JTextField textFieldEmail;

    private String[] abecedario = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };

    String codigoAleatorio = "";

    public OlvidarContrasena() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 312);
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

        labelLogo.setBounds(302, 28, 70, 65);
        panel.add(labelLogo);

        labelRecuperarCuenta = new JLabel("<html>Recupera la cuenta<html>");
        labelRecuperarCuenta.setBounds(46, 58, 138, 35);
        panel.add(labelRecuperarCuenta);

        labelEmail = new JLabel("<html>Introduce tu correo electr\u00F3nico para buscar tu cuenta.<html>");
        labelEmail.setBounds(46, 104, 313, 35);
        panel.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(46, 147, 293, 31);
        panel.add(textFieldEmail);

        buttonBuscar = new JButton("<html>Buscar<html>");
        buttonBuscar.setBackground(Color.LIGHT_GRAY);
        buttonBuscar.setForeground(Color.BLACK);
        buttonBuscar.setBounds(229, 188, 110, 35);
        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Usuario.existeCorreoConUsuario(textFieldEmail.getText())) {
                    codigoAleatorio = "";
                    for (int veces = 0; veces < 6; veces++) {
                        int getRandomNumero = (int) (Math.random() * (abecedario.length)) + 0;
                        codigoAleatorio = codigoAleatorio + abecedario[getRandomNumero];
                    }

                    Usuario user = Usuario.recuperarUsuarioConEmail(textFieldEmail.getText());
                    new IntroducirCodigoEmail(codigoAleatorio, textFieldEmail.getText(), user.getUsuario());
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Email no encontrado, introduce otro", null,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buttonBuscar);

        buttonCancelar = new JButton("<html>Cancelar<html>");
        buttonCancelar.setForeground(Color.BLACK);
        buttonCancelar.setBackground(Color.LIGHT_GRAY);
        buttonCancelar.setBounds(109, 189, 110, 35);
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PanelUsuarioContrasena();
                frame.setVisible(false);
            }
        });
        panel.add(buttonCancelar);

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
