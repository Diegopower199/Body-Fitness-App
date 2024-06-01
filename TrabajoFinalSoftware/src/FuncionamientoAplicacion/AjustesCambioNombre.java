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

public class AjustesCambioNombre {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarNombre;
    private JLabel labelIntroducirNombre;
    private JLabel labelConfirmarNombre;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private JTextField textFieldNombre;
    private JTextField textFieldConfirmacionNombre;

    public AjustesCambioNombre(Usuario informacionUsuario) {
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

        labelCambiarNombre = new JLabel("<html>CAMBIAR NOMBRE<html>");
        labelCambiarNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCambiarNombre.setBounds(122, 39, 183, 25);
        panel.add(labelCambiarNombre);

        labelIntroducirNombre = new JLabel("<html>Introduce un nuevo nombre:<html>");
        labelIntroducirNombre.setBounds(45, 96, 170, 13);
        panel.add(labelIntroducirNombre);

        labelConfirmarNombre = new JLabel("<html>Confirme su nombre:<html>");
        labelConfirmarNombre.setBounds(45, 142, 154, 13);
        panel.add(labelConfirmarNombre);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new Ajustes(informacionUsuario);
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
                if (textFieldNombre.getText().equals("") || textFieldConfirmacionNombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else {
                    if (textFieldNombre.getText().equals(textFieldConfirmacionNombre.getText())) {
                        informacionUsuario.setNombre(textFieldNombre.getText());
                        Usuario.guardarUsuariosEnBaseDatos();
                        new Ajustes(informacionUsuario);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Los nombres no coinciden", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonFinalizar);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(225, 92, 183, 21);
        panel.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldConfirmacionNombre = new JTextField();
        textFieldConfirmacionNombre.setColumns(10);
        textFieldConfirmacionNombre.setBounds(225, 138, 183, 21);
        panel.add(textFieldConfirmacionNombre);

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
