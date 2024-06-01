package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InformacionPersona.Usuario;

public class PantallaEjercicio3 {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageFondo;
    private BufferedImage imageLogo;

    private JLabel labelLogo;
    private JLabel labelEjercicio;
    private JLabel labelDescripcionEjercicio;
    private JLabel labelSeriesEjercicio;
    private JLabel labelRepeticionesEjercicio;
    private JLabel labelFotoEjercicio;
    private JLabel labelVideoEjercicio;
    private JLabel labelFondo;

    private JButton buttonAnterior;
    private JButton buttonFinalizar;

    private Dimension dim;

    public PantallaEjercicio3(Usuario informacionUsuario, ArrayList<String> tresEjercicios) {
        frame = new JFrame();
        frame.setMaximumSize(dim);
        frame.setBounds(100, 100, 1500, 830);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        dim = frame.getToolkit().getScreenSize();

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelLogo = new JLabel();
        imageLogo = null;

        try {
            imageLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
            ImageIcon imagenLogo = new ImageIcon(
                    imageLogo.getScaledInstance(imageLogo.getWidth(), imageLogo.getHeight(), Image.SCALE_SMOOTH));
            labelLogo.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        labelLogo.setBounds(10, 10, 229, 157);
        panel.add(labelLogo);

        labelEjercicio = new JLabel("<html>Ejercicio 3 " + tresEjercicios.get(18) + "<html>");
        labelEjercicio.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelEjercicio.setBounds(421, 64, 521, 53);
        panel.add(labelEjercicio);

        labelDescripcionEjercicio = new JLabel("<html>" + tresEjercicios.get(19) + "<html>");
        labelDescripcionEjercicio.setBounds(65, 192, 306, 64);
        panel.add(labelDescripcionEjercicio);

        labelSeriesEjercicio = new JLabel("<html>" + tresEjercicios.get(20) + "<html>");
        labelSeriesEjercicio.setBounds(65, 271, 229, 37);
        panel.add(labelSeriesEjercicio);

        labelRepeticionesEjercicio = new JLabel("<html>" + tresEjercicios.get(21) + "<html>");
        labelRepeticionesEjercicio.setBounds(65, 318, 229, 37);
        panel.add(labelRepeticionesEjercicio);

        labelFotoEjercicio = new JLabel();
        imageLogo = null;
        labelFotoEjercicio.setBounds(1087, 44, 209, 173);

        try {
            imageLogo = ImageIO.read(getClass().getResource(tresEjercicios.get(22)));
            ImageIcon imagenLogo = new ImageIcon(imageLogo.getScaledInstance(labelFotoEjercicio.getWidth(),
                    labelFotoEjercicio.getHeight(), Image.SCALE_SMOOTH));
            labelFotoEjercicio.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        panel.add(labelFotoEjercicio);

        labelVideoEjercicio = new JLabel("<html>" + tresEjercicios.get(23) + "<html>");
        labelVideoEjercicio.setBounds(406, 177, 671, 364);
        panel.add(labelVideoEjercicio);

        buttonAnterior = new JButton("<html>Anterior<html>");
        buttonAnterior.setBounds(148, 691, 85, 21);
        buttonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new PantallaEjercicio2(informacionUsuario, tresEjercicios);
            }
        });
        panel.add(buttonAnterior);

        buttonFinalizar = new JButton("<html>Finalizar entrenamiento<html>");
        buttonFinalizar.setBounds(772, 691, 170, 21);
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new PantallaPrincipalUsuario(informacionUsuario);
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

        labelFondo.setBounds(0, 0, 1536, 864);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}
