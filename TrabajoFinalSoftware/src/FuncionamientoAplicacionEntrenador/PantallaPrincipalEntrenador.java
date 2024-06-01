package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;
import Login.PanelUsuarioContrasena;

public class PantallaPrincipalEntrenador {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;
    private BufferedImage imageAjustes;
    private BufferedImage imageDietas;
    private BufferedImage imageCambiarDietas;
    private BufferedImage imageCambiarEntrenamiento;
    private BufferedImage imageCambiarDatos;
    private BufferedImage imageRutinas;
    private BufferedImage imageAnadirVideos;
    private BufferedImage imageEliminarVideos;

    private JLabel labelLogo;
    private JLabel labelNombre;
    private JLabel labelApellidos;
    private JLabel labelSaludo;
    private JLabel labelEslogan;
    private JLabel labelEdad;
    private JLabel labelSexo;
    private JLabel labelFecha;
    private JLabel labelDietas;
    private JLabel labelCambiarDietas;
    private JLabel labelCambiarEntrenamiento;
    private JLabel labelCambiarDatos;
    private JLabel labelRutinas;
    private JLabel labelAnadirVideos;
    private JLabel labelEliminarVideos;
    private JLabel labelFondo;

    private JButton buttonAjustes;
    private JButton buttonAnadirDietas;
    private JButton buttonEliminarDietas;
    private JButton buttonEliminarEntrenamientos;
    private JButton buttonCambiarDatos;
    private JButton buttonAnadirEntrenamientos;
    private JButton buttonAnadirVideos;
    private JButton buttonEliminarVideos;
    private JButton buttonCerrarSesion;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String fecha = dtf.format(LocalDateTime.now());

    public PantallaPrincipalEntrenador(Entrenadores informacionEntrenador) {
        frame = new JFrame();
        frame.setBounds(100, 100, 1920, 1080);
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
            ImageIcon im = new ImageIcon(imageLogo.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
            labelLogo.setIcon(im);
        } catch (Exception e) {
        }

        labelLogo.setBounds(22, 24, 62, 57);
        panel.add(labelLogo);

        buttonAjustes = new JButton();
        imageAjustes = null;

        try {
            imageAjustes = ImageIO.read(getClass().getResource("/ajustes.png"));
            ImageIcon im = new ImageIcon(imageAjustes.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
            buttonAjustes.setIcon(im);
        } catch (Exception e) {
        }

        buttonAjustes.setBounds(22, 265, 62, 57);
        buttonAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AjustesEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAjustes);

        labelSaludo = new JLabel("<html>Hola, " + informacionEntrenador.getNombre());
        labelSaludo.setBounds(117, 10, 153, 26);
        panel.add(labelSaludo);

        labelEslogan = new JLabel("<html>\u00A1Consigue el cuerpo que quieres!<html>");
        labelEslogan.setBounds(117, 46, 210, 13);
        panel.add(labelEslogan);

        labelNombre = new JLabel("<html>Nombre: " + informacionEntrenador.getNombre() + "<html>");
        labelNombre.setBounds(1198, 119, 109, 13);
        panel.add(labelNombre);

        labelApellidos = new JLabel(informacionEntrenador.getApellidos());
        labelApellidos.setBounds(1298, 119, 109, 13);
        panel.add(labelApellidos);

        labelEdad = new JLabel("<html>Edad: " + informacionEntrenador.getEdad() + " años<html>");
        labelEdad.setBounds(1198, 251, 178, 32);
        panel.add(labelEdad);

        labelSexo = new JLabel("<html>Sexo: " + informacionEntrenador.getSexo() + "<html>");
        labelSexo.setBounds(1198, 280, 133, 38);
        panel.add(labelSexo);

        labelFecha = new JLabel(fecha);
        labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));

        labelFecha.setBounds(930, 24, 160, 26);
        panel.add(labelFecha);

        buttonAnadirDietas = new JButton();
        imageDietas = null;

        try {
            imageDietas = ImageIO.read(getClass().getResource("/Dietas.jpg"));
            ImageIcon im = new ImageIcon(imageDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonAnadirDietas.setIcon(im);
        } catch (Exception e) {
        }

        buttonAnadirDietas.setBounds(135, 86, 133, 121);
        buttonAnadirDietas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnadirDietas(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAnadirDietas);

        labelDietas = new JLabel("<html>AÑADIR DIETA<html>");
        labelDietas.setHorizontalAlignment(SwingConstants.CENTER);
        labelDietas.setBounds(145, 220, 123, 13);
        panel.add(labelDietas);

        buttonEliminarDietas = new JButton();
        imageCambiarDietas = null;

        try {
            imageCambiarDietas = ImageIO.read(getClass().getResource("/cambiarDieta.png"));
            ImageIcon imagenCD = new ImageIcon(imageCambiarDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonEliminarDietas.setIcon(imagenCD);
        } catch (Exception e) {
        }

        buttonEliminarDietas.setBounds(135, 265, 133, 121);
        buttonEliminarDietas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarDietas(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonEliminarDietas);

        labelCambiarDietas = new JLabel("<html>QUITAR DIETA<html>");
        labelCambiarDietas.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarDietas.setBounds(135, 396, 130, 23);
        panel.add(labelCambiarDietas);

        buttonEliminarEntrenamientos = new JButton();
        imageCambiarEntrenamiento = null;

        try {
            imageCambiarEntrenamiento = ImageIO.read(getClass().getResource("/cambiarEntrenamiento.png"));
            ImageIcon imagenCE = new ImageIcon(
                    imageCambiarEntrenamiento.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonEliminarEntrenamientos.setIcon(imagenCE);
        } catch (Exception e) {
        }

        buttonEliminarEntrenamientos.setBounds(461, 265, 133, 121);
        buttonEliminarEntrenamientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarEntrenamientos(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonEliminarEntrenamientos);

        labelCambiarEntrenamiento = new JLabel("<html>QUITAR ENTRENAMIENTO<html>");
        labelCambiarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarEntrenamiento.setBounds(438, 396, 178, 23);
        panel.add(labelCambiarEntrenamiento);

        buttonCambiarDatos = new JButton();
        imageCambiarDatos = null;

        try {
            imageCambiarDatos = ImageIO.read(getClass().getResource("/cambiarDatos.png"));
            ImageIcon imagenCDS = new ImageIcon(imageCambiarDatos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonCambiarDatos.setIcon(imagenCDS);
        } catch (Exception e) {
        }

        buttonCambiarDatos.setBounds(461, 439, 133, 121);
        buttonCambiarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnadirRecomendacion(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarDatos);

        labelCambiarDatos = new JLabel("<html>AÑADIR RECOMENDACIÓN<html>");
        labelCambiarDatos.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarDatos.setBounds(438, 570, 178, 23);
        panel.add(labelCambiarDatos);

        buttonAnadirVideos = new JButton();
        imageAnadirVideos = null;

        try {
            imageAnadirVideos = ImageIO.read(getClass().getResource("/anadirVideo.png"));
            ImageIcon imagenAV = new ImageIcon(imageAnadirVideos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonAnadirVideos.setIcon(imagenAV);
        } catch (Exception e) {
        }

        buttonAnadirVideos.setBounds(811, 86, 133, 121);
        buttonAnadirVideos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AnadirVideo(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAnadirVideos);

        labelAnadirVideos = new JLabel("<html>AÑADIR VÍDEOS<html>");
        labelAnadirVideos.setHorizontalAlignment(SwingConstants.CENTER);
        labelAnadirVideos.setBounds(814, 210, 130, 23);
        panel.add(labelAnadirVideos);

        buttonEliminarVideos = new JButton();
        imageEliminarVideos = null;

        try {
            imageEliminarVideos = ImageIO.read(getClass().getResource("/eliminarVideo.png"));
            ImageIcon imagenEV = new ImageIcon(imageEliminarVideos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonEliminarVideos.setIcon(imagenEV);
        } catch (Exception e) {
        }

        buttonEliminarVideos.setBounds(811, 265, 133, 121);
        buttonEliminarVideos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarVideo(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonEliminarVideos);

        labelEliminarVideos = new JLabel("<html>ELIMINAR VÍDEOS<html>");
        labelEliminarVideos.setHorizontalAlignment(SwingConstants.CENTER);
        labelEliminarVideos.setBounds(814, 396, 130, 23);
        panel.add(labelEliminarVideos);

        buttonAnadirEntrenamientos = new JButton();
        imageRutinas = null;

        try {
            imageRutinas = ImageIO.read(getClass().getResource("/Rutinas.jpg"));
            ImageIcon im = new ImageIcon(imageRutinas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonAnadirEntrenamientos.setIcon(im);
        } catch (Exception e) {
        }

        buttonAnadirEntrenamientos.setBounds(461, 86, 133, 121);
        buttonAnadirEntrenamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AnadirEntrenamientos(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAnadirEntrenamientos);

        labelRutinas = new JLabel("<html>AÑADIR ENTRENAMIENTO<html>");
        labelRutinas.setHorizontalAlignment(SwingConstants.CENTER);
        labelRutinas.setBounds(438, 217, 178, 38);
        panel.add(labelRutinas);

        buttonCerrarSesion = new JButton("Cerrar Sesión");
        buttonCerrarSesion.setBounds(724, 24, 115, 35);
        buttonCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que quiere cerrar sesión?", "Alerta!",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" },
                        "Sí");
                if (resp == 0) {
                    new PanelUsuarioContrasena();
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonCerrarSesion);

        labelFondo = new JLabel();
        imageFondo = null;
        labelFondo.setBounds(0, 0, 1550, 900);

        try {
            imageFondo = ImageIO.read(getClass().getResource("/fondo_pantallaprincipal (medidas).png"));
            ImageIcon im = new ImageIcon(imageFondo.getScaledInstance(labelFondo.getWidth(),
                    labelFondo.getHeight(), Image.SCALE_SMOOTH));
            labelFondo.setIcon(im);
        } catch (Exception e) {
        }

        panel.add(labelFondo);

        frame.setVisible(true);
    }

}