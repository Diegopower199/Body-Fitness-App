package Login;

import java.awt.BorderLayout;
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
import javax.swing.JPasswordField;

import InformacionPersona.Usuario;

public class RestablecerContrasena {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelNuevaContrasena;
    private JLabel labelFondo;
    private JLabel labelRestablecerContrasena;
    private JLabel labelConfirmarNuevaContrasena;

    private JButton buttonRestablecerContrasena;

    private JPasswordField passwordFieldNuevaContrasena;
    private JPasswordField passwordFieldConfirmarNuevaContrasena;

    public RestablecerContrasena(String usuario) {

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

        labelNuevaContrasena = new JLabel("<html>Introduce la nueva contrase\u00F1a<html>");
        labelNuevaContrasena.setBounds(55, 74, 357, 44);
        panel.add(labelNuevaContrasena);

        passwordFieldNuevaContrasena = new JPasswordField();
        passwordFieldNuevaContrasena.setColumns(10);
        passwordFieldNuevaContrasena.setBounds(55, 114, 327, 35);
        panel.add(passwordFieldNuevaContrasena);

        buttonRestablecerContrasena = new JButton("Restablecer contrase\u00F1a");
        buttonRestablecerContrasena.setBounds(80, 229, 238, 23);
        buttonRestablecerContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordFieldNuevaContrasena.getPassword())
                        .equals(new String(passwordFieldConfirmarNuevaContrasena.getPassword()))) {
                    Usuario.cambiarContrasenaUsuario(usuario, new String(passwordFieldNuevaContrasena.getPassword()));
                    Usuario.guardarUsuariosEnBaseDatos();
                    new PanelUsuarioContrasena();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", null,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buttonRestablecerContrasena);

        labelRestablecerContrasena = new JLabel("Restablece tu contrase\u00F1a");
        labelRestablecerContrasena.setBounds(55, 34, 208, 14);
        panel.add(labelRestablecerContrasena);

        passwordFieldConfirmarNuevaContrasena = new JPasswordField();
        passwordFieldConfirmarNuevaContrasena.setColumns(10);
        passwordFieldConfirmarNuevaContrasena.setBounds(55, 178, 327, 35);
        panel.add(passwordFieldConfirmarNuevaContrasena);

        labelConfirmarNuevaContrasena = new JLabel("<html>Confirma la nueva contrase\u00F1a<html>");
        labelConfirmarNuevaContrasena.setBounds(55, 149, 357, 35);
        panel.add(labelConfirmarNuevaContrasena);

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