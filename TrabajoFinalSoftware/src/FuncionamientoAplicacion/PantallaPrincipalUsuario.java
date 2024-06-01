package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import InformacionPersona.Usuario;
import Login.PanelUsuarioContrasena;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;

public class PantallaPrincipalUsuario {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;
    private BufferedImage imageAjustes;
    private BufferedImage imageCalendario;
    private BufferedImage imageDietas;
    private BufferedImage imageCambiarDietas;
    private BufferedImage imageCambiarEntrenamiento;
    private BufferedImage imageCambiarDatos;
    private BufferedImage imageRutinas;

    private JLabel labelLogo;
    private JLabel labelNombre;
    private JLabel labelApellidos;
    private JLabel labelSaludo;
    private JLabel labelEslogan;
    private JLabel labelAltura;
    private JLabel labelPeso;
    private JLabel labelEdad;
    private JLabel labelSexo;
    private JLabel labelIMC;
    private JLabel labelIntervalosIMC;
    private JLabel labelGrasaCorporal;
    private JLabel labelFecha;
    private JLabel labelDietas;
    private JLabel labelCambiarDietas;
    private JLabel labelCambiarEntrenamiento;
    private JLabel labelCambiarDatos;
    private JLabel labelRutinas;
    private JLabel labelFondo;

    private JButton buttonAjustes;
    private JButton buttonCalendario;
    private JButton buttonDietas;
    private JButton buttonCambiarDietas;
    private JButton buttonCambiarEntrenamiento;
    private JButton buttonCambiarDatos;
    private JButton buttonRutinas;
    private JButton buttonCerrarSesion;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String fecha = dtf.format(LocalDateTime.now());

    public PantallaPrincipalUsuario(Usuario informacionUsuario) {
        frame = new JFrame();
        frame.setBounds(100, 100, 1920, 1080);
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
            ImageIcon im = new ImageIcon(imageLogo.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
            labelLogo.setIcon(im);
        } catch (Exception e) {
        }

        labelLogo.setBounds(10, 24, 79, 87);
        panel.add(labelLogo);

        buttonAjustes = new JButton();
        imageAjustes = null;

        try {
            imageAjustes = ImageIO.read(getClass().getResource("/ajustes.png"));
            ImageIcon im = new ImageIcon(imageAjustes.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
            buttonAjustes.setIcon(im);
        } catch (Exception e) {
        }

        buttonAjustes.setBounds(10, 143, 62, 57);
        buttonAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ajustes(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAjustes);

        buttonCalendario = new JButton();
        imageCalendario = null;

        try {
            imageCalendario = ImageIO.read(getClass().getResource("/calendario.png"));
            ImageIcon im = new ImageIcon(imageCalendario.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
            buttonCalendario.setIcon(im);
        } catch (Exception e) {
        }

        buttonCalendario.setBounds(10, 243, 62, 57);
        buttonCalendario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCalendario.setEnabled(false);
                JOptionPane.showMessageDialog(null, "<html>Funcionalidad disponible próximamente<html>");
            }
        });
        panel.add(buttonCalendario);

        labelSaludo = new JLabel("<html>Hola, " + informacionUsuario.getNombre());
        labelSaludo.setBounds(116, 10, 153, 26);
        panel.add(labelSaludo);

        labelEslogan = new JLabel("<html>\u00A1Consigue el cuerpo que quieres!<html>");
        labelEslogan.setBounds(116, 46, 210, 13);
        panel.add(labelEslogan);

        labelNombre = new JLabel("<html>Nombre: " + informacionUsuario.getNombre() + "<html>");
        labelNombre.setBounds(1256, 143, 109, 13);
        panel.add(labelNombre);

        labelApellidos = new JLabel(informacionUsuario.getApellidos());
        labelApellidos.setBounds(1356, 143, 109, 13);
        panel.add(labelApellidos);

        labelAltura = new JLabel("<html>Altura: " + informacionUsuario.getAltura() + " cm<html>");
        labelAltura.setBounds(1187, 206, 155, 38);
        panel.add(labelAltura);

        labelPeso = new JLabel("<html>Peso: " + informacionUsuario.getPeso() + " kg<html>");
        labelPeso.setBounds(1187, 249, 109, 26);
        panel.add(labelPeso);

        labelEdad = new JLabel("<html>Edad: " + informacionUsuario.getEdad() + " años<html>");
        labelEdad.setBounds(1187, 276, 178, 32);
        panel.add(labelEdad);

        labelSexo = new JLabel("<html>Sexo: " + informacionUsuario.getSexo() + "<html>");
        labelSexo.setBounds(1187, 305, 133, 38);
        panel.add(labelSexo);

        labelIMC = new JLabel("<html>Índice Masa Corporal (IMC): " + informacionUsuario.getIMC() + "<html>");
        labelIMC.setBounds(1187, 453, 210, 26);
        panel.add(labelIMC);

        labelIntervalosIMC = new JLabel();
        float imc = Float.parseFloat(informacionUsuario.getIMC());
        if (imc < 18.5) {
            labelIntervalosIMC = new JLabel("<html>Bajo Peso<html>");
            labelIntervalosIMC.setBounds(1187, 512, 100, 13);
            labelIntervalosIMC.setForeground(Color.BLUE);
        } else if (imc >= 18.5 && imc <= 24.9) {
            labelIntervalosIMC = new JLabel("<html>Peso Normal<html>");
            labelIntervalosIMC.setBounds(1187, 512, 100, 13);
            labelIntervalosIMC.setForeground(Color.GREEN);
        } else if (imc >= 25 && imc <= 29.9) {
            labelIntervalosIMC = new JLabel("<html>Sobrepeso<html>");
            labelIntervalosIMC.setBounds(1187, 512, 100, 13);
            labelIntervalosIMC.setForeground(Color.YELLOW);
        } else if (imc >= 30.0) {
            labelIntervalosIMC = new JLabel("<html>Obesidad<html>");
            labelIntervalosIMC.setBounds(1187, 512, 100, 13);
            labelIntervalosIMC.setForeground(Color.RED);
        }
        panel.add(labelIntervalosIMC);

        labelGrasaCorporal = new JLabel(
                "<html>Porcentaje Grasa Corporal: " + informacionUsuario.getPorcentajeDeGrasaCorporal() + " %<html>");
        labelGrasaCorporal.setBounds(1187, 393, 210, 38);
        panel.add(labelGrasaCorporal);

        labelFecha = new JLabel(fecha);
        labelFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelFecha.setBounds(943, 23, 148, 36);
        panel.add(labelFecha);

        buttonDietas = new JButton();
        imageDietas = null;

        try {
            imageDietas = ImageIO.read(getClass().getResource("/Dietas.jpg"));
            ImageIcon im = new ImageIcon(imageDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonDietas.setIcon(im);
        } catch (Exception e) {
        }

        buttonDietas.setBounds(149, 179, 133, 121);
        buttonDietas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MisDietas(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonDietas);

        labelDietas = new JLabel("<html>MIS DIETAS<html>");
        labelDietas.setBounds(180, 309, 70, 13);
        panel.add(labelDietas);

        buttonCambiarDietas = new JButton();
        imageCambiarDietas = null;

        try {
            imageCambiarDietas = ImageIO.read(getClass().getResource("/cambiarDieta.png"));
            ImageIcon imagenCD = new ImageIcon(imageCambiarDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonCambiarDietas.setIcon(imagenCD);
        } catch (Exception e) {
        }

        buttonCambiarDietas.setBounds(149, 358, 133, 121);
        buttonCambiarDietas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarDieta(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarDietas);

        labelCambiarDietas = new JLabel("<html>CAMBIAR DIETAS<html>");
        labelCambiarDietas.setBounds(165, 489, 130, 23);
        panel.add(labelCambiarDietas);

        buttonCambiarEntrenamiento = new JButton();
        imageCambiarEntrenamiento = null;

        try {
            imageCambiarEntrenamiento = ImageIO.read(getClass().getResource("/cambiarEntrenamiento.png"));
            ImageIcon imagenCE = new ImageIcon(
                    imageCambiarEntrenamiento.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonCambiarEntrenamiento.setIcon(imagenCE);
        } catch (Exception e) {
        }

        buttonCambiarEntrenamiento.setBounds(415, 358, 133, 121);
        buttonCambiarEntrenamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarEntrenamiento(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarEntrenamiento);

        labelCambiarEntrenamiento = new JLabel("<html>CAMBIAR ENTRENAMIENTO<html>");
        labelCambiarEntrenamiento.setBounds(401, 489, 200, 23);
        panel.add(labelCambiarEntrenamiento);

        buttonCambiarDatos = new JButton();
        imageCambiarDatos = null;

        try {
            imageCambiarDatos = ImageIO.read(getClass().getResource("/cambiarDatos.png"));
            ImageIcon imagenCDS = new ImageIcon(imageCambiarDatos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonCambiarDatos.setIcon(imagenCDS);
        } catch (Exception e) {
        }

        buttonCambiarDatos.setBounds(684, 359, 133, 121);
        buttonCambiarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CambiarDatos(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonCambiarDatos);

        labelCambiarDatos = new JLabel("<html>ACTUALIZAR DATOS<html>");
        labelCambiarDatos.setBounds(692, 489, 130, 23);
        panel.add(labelCambiarDatos);

        buttonRutinas = new JButton();
        imageRutinas = null;

        try {
            imageRutinas = ImageIO.read(getClass().getResource("/Rutinas.jpg"));
            ImageIcon im = new ImageIcon(imageRutinas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
            buttonRutinas.setIcon(im);
        } catch (Exception e) {
        }

        buttonRutinas.setBounds(684, 179, 133, 121);
        buttonRutinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> tresEjercicios = new ArrayList<String>();
                if (informacionUsuario.getEntrenamientoElegido().equals("Definir")) {
                    tresEjercicios = Definir.tresEjercicioAleatorioDefinir();
                } else if (informacionUsuario.getEntrenamientoElegido().equals("Ganar Musculo")) {
                    tresEjercicios = GanarMusculo.tresEjercicioAleatorioGanarMusculo();
                } else if (informacionUsuario.getEntrenamientoElegido().equals("Tonificar")) {
                    tresEjercicios = Tonificar.tresEjercicioAleatorioTonificar();
                }

                new PantallaEjercicio1(informacionUsuario, tresEjercicios);
                frame.setVisible(false);
            }
        });
        panel.add(buttonRutinas);

        labelRutinas = new JLabel("<html>MIS RUTINAS<html>");
        labelRutinas.setBounds(713, 309, 100, 13);
        panel.add(labelRutinas);

        buttonCerrarSesion = new JButton("Cerrar Sesion");
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