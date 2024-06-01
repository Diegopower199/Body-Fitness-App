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

public class CambiarDatos {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarParametrosFisicos;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;
    private JButton buttonCambiarAltura;
    private JButton buttonCambiarPeso;
    private JButton buttonCambiarGenero;

    public CambiarDatos(Usuario informacionUsuario) {
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

        labelCambiarParametrosFisicos = new JLabel("<html>CAMBIAR PARÁMETROS FÍSICOS<html>");
        labelCambiarParametrosFisicos.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarParametrosFisicos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarParametrosFisicos.setBounds(24, 25, 365, 13);
        panel.add(labelCambiarParametrosFisicos);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalUsuario(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        buttonFinalizar = new JButton("<html>Finalizar<html>");
        buttonFinalizar.setBounds(341, 232, 85, 21);
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalUsuario(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonFinalizar);

        buttonCambiarAltura = new JButton("<html>CAMBIAR ALTURA<html>");
        buttonCambiarAltura.setBounds(134, 70, 156, 31);
        buttonCambiarAltura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarDatosAltura(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarAltura);

        buttonCambiarPeso = new JButton("<html>CAMBIAR PESO<html>");
        buttonCambiarPeso.setBounds(134, 111, 156, 31);
        buttonCambiarPeso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarDatosPeso(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarPeso);

        buttonCambiarGenero = new JButton("<html>CAMBIAR GÉNERO<html>");
        buttonCambiarGenero.setBounds(134, 151, 156, 31);
        buttonCambiarGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarDatosGenero(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarGenero);

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
