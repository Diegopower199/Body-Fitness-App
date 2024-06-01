package Login;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IntroducirCodigoEmail {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelComprobarRecibirMensaje;
    private JLabel labelIngresaCodigo;
    private JLabel labelCodigoPatcha;
    private JLabel labelFondo;

    private JButton buttonCancelar;
    private JButton buttonContinuar;

    private JTextField textFieldCodigoIntroducido;

    public IntroducirCodigoEmail(String codigoAleatorio, String correoElectronico, String usuario) {
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

        labelComprobarRecibirMensaje = new JLabel("<html>Introduce el c\u00F3digo correctamente:<html>");
        labelComprobarRecibirMensaje.setBounds(55, 74, 357, 44);
        panel.add(labelComprobarRecibirMensaje);

        textFieldCodigoIntroducido = new JTextField();
        textFieldCodigoIntroducido.setColumns(10);
        textFieldCodigoIntroducido.setBounds(55, 114, 124, 35);
        panel.add(textFieldCodigoIntroducido);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(55, 171, 89, 23);
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PanelUsuarioContrasena();
                frame.setVisible(false);
            }
        });
        panel.add(buttonCancelar);

        buttonContinuar = new JButton("Continuar");
        buttonContinuar.setBounds(163, 171, 120, 23);
        buttonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldCodigoIntroducido.getText().equals(codigoAleatorio)) {
                    new RestablecerContrasena(usuario);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonContinuar);

        labelIngresaCodigo = new JLabel("<html>Ingresa el c\u00F3digo de seguridad<html>");
        labelIngresaCodigo.setBounds(25, 49, 168, 26);
        panel.add(labelIngresaCodigo);

        labelCodigoPatcha = new JLabel(codigoAleatorio);
        labelCodigoPatcha.setHorizontalAlignment(SwingConstants.CENTER);
        labelCodigoPatcha.setFont(new Font("Informal Roman", Font.BOLD | Font.ITALIC, 29));
        labelCodigoPatcha.setBounds(182, 36, 160, 39);
        panel.add(labelCodigoPatcha);

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
