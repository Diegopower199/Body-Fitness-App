package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

public class EliminarVideo {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelEliminarVideos;
    private JLabel labelLinkVideo;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonEliminarVideo;

    private JTextField textFieldLinkVideo;

    public EliminarVideo(Entrenadores informacionEntrenador) {
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

        labelEliminarVideos = new JLabel("<html>ELIMINAR VIDEOS<html>");
        labelEliminarVideos.setHorizontalAlignment(SwingConstants.CENTER);
        labelEliminarVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelEliminarVideos.setBounds(0, 11, 424, 67);
        panel.add(labelEliminarVideos);

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

        buttonEliminarVideo = new JButton("<html>Eliminar video<html>");
        buttonEliminarVideo.setBounds(235, 159, 130, 35);
        buttonEliminarVideo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldLinkVideo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Debes introducir el link del video<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (textFieldLinkVideo.getText().contains("www.youtube.com/watch?v=")) {
                        new PantallaPrincipalEntrenador(informacionEntrenador);
                        frame.setVisible(false);

                        File archivo = null;
                        File temp = null;

                        try {
                            archivo = new File("data.txt");
                            temp = new File("temp.txt");

                            try (BufferedReader br = new BufferedReader(new FileReader(archivo));
                                    BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
                                String linea;

                                while ((linea = br.readLine()) != null) {
                                    if (!linea.equals(textFieldLinkVideo.getText())) {
                                        bw.write(linea);
                                        bw.newLine();
                                    }
                                }
                            }

                            if (archivo.delete()) {
                                if (!temp.renameTo(archivo)) {
                                    throw new IOException("<html>No se pudo renombrar el archivo<html>");
                                }
                            } else {
                                throw new IOException("<html>No se pudo borrar el archivo original<html>");
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html>Debes introducir un video disponible de Youtube<html>", null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(buttonEliminarVideo);

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
