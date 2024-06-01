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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import InformacionPersona.Usuario;

public class RegistroUsuarioNuevo {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelRegistrarte;
    private JLabel labelNombre;
    private JLabel labelEmail;
    private JLabel labelUsuario;
    private JLabel labelContrasena;
    private JLabel labelConfirmarContrasena;
    private JLabel labelFondo;

    private JButton buttonAnterior;
    private JButton buttonRegistrarse;

    private JTextField textFieldNombre;
    private JTextField textFieldEmail;
    private JTextField textFieldUsuario;

    private JPasswordField passwordFieldContrasena;
    private JPasswordField passwordFieldConfirmarContrasena;

    private boolean usuarioDisponible = true;

    public RegistroUsuarioNuevo() {
        frame = new JFrame();
        frame.setBounds(100, 100, 479, 582);
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

        labelRegistrarte = new JLabel("<html>Registrarse<html>");
        labelRegistrarte.setBounds(185, 11, 86, 35);
        panel.add(labelRegistrarte);

        labelNombre = new JLabel("<html>Nombre<html>");
        labelNombre.setBounds(46, 70, 62, 22);
        panel.add(labelNombre);

        labelEmail = new JLabel("<html>E-mail<html>");
        labelEmail.setBounds(46, 136, 62, 22);
        panel.add(labelEmail);

        labelUsuario = new JLabel("<html>Usuario<html>");
        labelUsuario.setBounds(46, 201, 62, 31);
        panel.add(labelUsuario);

        labelContrasena = new JLabel("<html>Contrase\u00F1a<html>");
        labelContrasena.setBounds(46, 268, 86, 31);
        panel.add(labelContrasena);

        labelConfirmarContrasena = new JLabel("<html>Confirmar contrase\u00F1a<html>");
        labelConfirmarContrasena.setBounds(46, 349, 137, 22);
        panel.add(labelConfirmarContrasena);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(46, 91, 293, 31);
        panel.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(46, 155, 293, 31);
        panel.add(textFieldEmail);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setColumns(10);
        textFieldUsuario.setBounds(46, 226, 293, 31);
        panel.add(textFieldUsuario);

        passwordFieldContrasena = new JPasswordField();
        passwordFieldContrasena.setColumns(10);
        passwordFieldContrasena.setBounds(46, 301, 293, 31);
        panel.add(passwordFieldContrasena);

        passwordFieldConfirmarContrasena = new JPasswordField();
        passwordFieldConfirmarContrasena.setColumns(10);
        passwordFieldConfirmarContrasena.setBounds(46, 382, 293, 31);
        panel.add(passwordFieldConfirmarContrasena);

        buttonAnterior = new JButton("<html>Atrás<html>");
        buttonAnterior.setBackground(Color.LIGHT_GRAY);
        buttonAnterior.setForeground(Color.BLACK);
        buttonAnterior.setBounds(46, 487, 110, 35);
        buttonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new PanelUsuarioContrasena();
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAnterior);

        buttonRegistrarse = new JButton("<html>Registrarse<html>");
        buttonRegistrarse.setBackground(Color.LIGHT_GRAY);
        buttonRegistrarse.setForeground(Color.BLACK);
        buttonRegistrarse.setBounds(250, 487, 110, 35);
        buttonRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldNombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe poner su nombre", null, JOptionPane.ERROR_MESSAGE);
                } else if (textFieldEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe poner su correo electrónico", null,
                            JOptionPane.ERROR_MESSAGE);
                } else if (textFieldUsuario.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe poner un usuario", null, JOptionPane.ERROR_MESSAGE);
                } else if (new String(passwordFieldContrasena.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe poner una contraseña", null, JOptionPane.ERROR_MESSAGE);
                } else if (new String(passwordFieldConfirmarContrasena.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe confirmar la contraseña anterior", null,
                            JOptionPane.ERROR_MESSAGE);
                } else if ((!(textFieldEmail.getText().contains("@gmail.com"))
                        && !(textFieldEmail.getText().contains("@outlook.es"))
                        && !(textFieldEmail.getText().contains("@yahoo.com"))
                        && !(textFieldEmail.getText().contains("@hotmail.com")))) {
                    JOptionPane.showMessageDialog(null,
                            "Debes poner un correo existente, con Outlook, Gmail, Hotmail o Yahoo", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (new String(passwordFieldContrasena.getPassword())
                            .equals(new String(passwordFieldConfirmarContrasena.getPassword()))) {
                        if (Usuario.existeUsuario(textFieldUsuario.getText())) {
                            JOptionPane.showMessageDialog(null, "Este usuario ya existe, introduce otro nuevo", null,
                                    JOptionPane.ERROR_MESSAGE);
                            usuarioDisponible = false;
                        } else {
                            usuarioDisponible = true;
                        }

                        if (usuarioDisponible) {
                            new SegundaParteRegistroUsuario(textFieldNombre.getText(), textFieldEmail.getText(),
                                    textFieldUsuario.getText(), new String(passwordFieldContrasena.getPassword()));
                            frame.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonRegistrarse);

        labelFondo = new JLabel();
        imageFondo = null;

        try {
            imageFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
            ImageIcon im = new ImageIcon(
                    imageFondo.getScaledInstance(imageFondo.getWidth(), imageFondo.getHeight(), Image.SCALE_SMOOTH));
            labelFondo.setIcon(im);
        } catch (Exception e) {
        }

        labelFondo.setBounds(0, 0, 479, 582);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}
