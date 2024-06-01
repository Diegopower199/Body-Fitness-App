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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import InformacionPersona.Usuario;

public class Ajustes {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarInfoPersonal;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonCambiarNombre;
    private JButton buttonCambiarApellidos;
    private JButton buttonCambiarEdad;
    private JButton buttonCambiarCorreo;
    private JButton buttonCambiarContrasena;

    public Ajustes(Usuario informacionUsuario) {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 382, 524);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        labelCambiarInfoPersonal = new JLabel("<html>CAMBIAR INFORMACIÓN PERSONAL<html>",
                SwingConstants.CENTER);
        labelCambiarInfoPersonal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCambiarInfoPersonal.setBounds(31, 35, 268, 28);
        panel.add(labelCambiarInfoPersonal);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 456, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalUsuario(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        buttonCambiarNombre = new JButton("<html>NOMBRE<html>");
        buttonCambiarNombre.setBounds(77, 89, 203, 37);
        buttonCambiarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesCambioNombre(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarNombre);

        buttonCambiarApellidos = new JButton("<html>APELLIDOS<html>");
        buttonCambiarApellidos.setBounds(77, 154, 203, 37);
        buttonCambiarApellidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesCambioApellidos(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarApellidos);

        buttonCambiarEdad = new JButton("<html>EDAD<html>");
        buttonCambiarEdad.setBounds(77, 221, 203, 37);
        buttonCambiarEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesCambioEdad(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarEdad);

        buttonCambiarCorreo = new JButton("<html>CORREO ELECTRÓNICO<html>");
        buttonCambiarCorreo.setBounds(77, 289, 203, 37);
        buttonCambiarCorreo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesCambioCorreo(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarCorreo);

        buttonCambiarContrasena = new JButton("<html>CONTRASEÑA<html>");
        buttonCambiarContrasena.setBounds(77, 360, 203, 37);
        buttonCambiarContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesCambioContrasena(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarContrasena);

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
