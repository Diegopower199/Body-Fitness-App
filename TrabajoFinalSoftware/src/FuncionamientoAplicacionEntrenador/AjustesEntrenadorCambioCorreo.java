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

public class AjustesEntrenadorCambioCorreo {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarCorreo;
    private JLabel labelIntroducirCorreo;
    private JLabel labelConfirmarCorreo;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private JTextField textFieldCorreo;
    private JTextField textFieldConfirmacionCorreo;

    public AjustesEntrenadorCambioCorreo(Entrenadores informacionEntrenador) {
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

        labelCambiarCorreo = new JLabel("<html>CAMBIAR CORREO ELECTRÓNICO<html>");
        labelCambiarCorreo.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCambiarCorreo.setBounds(81, 40, 270, 25);
        panel.add(labelCambiarCorreo);

        labelIntroducirCorreo = new JLabel("<html>Introduce un nuevo correo:<html>");
        labelIntroducirCorreo.setBounds(45, 96, 170, 13);
        panel.add(labelIntroducirCorreo);

        labelConfirmarCorreo = new JLabel("<html>Confirme su correo:<html>");
        labelConfirmarCorreo.setBounds(45, 142, 154, 13);
        panel.add(labelConfirmarCorreo);

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
                if (textFieldCorreo.getText().equals("") || textFieldConfirmacionCorreo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else if ((!(textFieldCorreo.getText().contains("@gmail.com"))
                        && !(textFieldCorreo.getText().contains("@outlook.es"))
                        && !(textFieldCorreo.getText().contains("@yahoo.com"))
                        && !(textFieldCorreo.getText().contains("@hotmail.com")))) {
                    JOptionPane.showMessageDialog(null,
                            "Debes poner un correo existente, con Outlook, Gmail, Hotmail o Yahoo", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (textFieldCorreo.getText().equals(textFieldConfirmacionCorreo.getText())) {
                        informacionEntrenador.setEmail(textFieldCorreo.getText());
                        Entrenadores.guardarUsuariosEntrenadoresEnBaseDatos();
                        new AjustesEntrenador(informacionEntrenador);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Los correos no coinciden", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonFinalizar);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setBounds(225, 92, 183, 21);
        panel.add(textFieldCorreo);
        textFieldCorreo.setColumns(10);

        textFieldConfirmacionCorreo = new JTextField();
        textFieldConfirmacionCorreo.setColumns(10);
        textFieldConfirmacionCorreo.setBounds(225, 138, 183, 21);
        panel.add(textFieldConfirmacionCorreo);

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
