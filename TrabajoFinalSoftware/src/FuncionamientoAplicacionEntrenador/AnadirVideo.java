package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

public class AnadirVideo {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelAnadirVideos;
    private JLabel labelLinkVideo;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonAnadirVideo;

    private JTextField textFieldLinkVideo;

    public AnadirVideo(Entrenadores informacionEntrenador) {
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
            ImageIcon imagenLogo = new ImageIcon(imageLogo.getScaledInstance(90, 71, Image.SCALE_SMOOTH));
            labelLogo.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        labelLogo.setBounds(346, 11, 90, 71);
        panel.add(labelLogo);

        labelAnadirVideos = new JLabel("<html>A\u00D1ADIR VIDEOS<html>");
        labelAnadirVideos.setHorizontalAlignment(SwingConstants.CENTER);
        labelAnadirVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAnadirVideos.setBounds(0, 11, 424, 67);
        panel.add(labelAnadirVideos);

        labelLinkVideo = new JLabel("<html>Link Video<html>");
        labelLinkVideo.setBounds(49, 86, 72, 20);
        panel.add(labelLinkVideo);

        textFieldLinkVideo = new JTextField();
        textFieldLinkVideo.setBounds(157, 86, 153, 20);
        panel.add(textFieldLinkVideo);
        textFieldLinkVideo.setColumns(10);

        buttonAtras = new JButton("<html>Atr\u00E1s <html>");
        buttonAtras.setBounds(87, 159, 92, 35);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new PantallaPrincipalEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAtras);

        buttonAnadirVideo = new JButton("<html>A\u00F1adir video<html>");
        buttonAnadirVideo.setBounds(235, 159, 113, 35);
        buttonAnadirVideo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldLinkVideo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Debes introducir el link del video<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (textFieldLinkVideo.getText().contains("www.youtube.com/watch?v=")) {
                        new PantallaPrincipalEntrenador(informacionEntrenador);
                        frame.setVisible(false);

                        FileWriter fichero = null;
                        PrintWriter pw = null;
                        File archivo = null;

                        try {
                            archivo = new File("data.txt");
                            fichero = new FileWriter(archivo, true);
                            pw = new PrintWriter(fichero);

                            pw.write(textFieldLinkVideo.getText() + "\n");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                if (null != fichero)
                                    fichero.close();
                            } catch (Exception ex2) {
                                ex2.printStackTrace();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html>Debes introducir un video disponible de Youtube<html>", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(buttonAnadirVideo);

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
