package Login;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import InformacionPersona.Usuario;

public class EleccionOpciones {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelObjetivos;
    private JLabel labelDieta;
    private JLabel labelRutina;
    private JLabel labelFondo;

    private JButton buttonCancelar;
    private JButton buttonAceptar;

    private ButtonGroup buttonGroupTipoDieta;
    private ButtonGroup buttonGroupTipoRutina;

    private JRadioButton radioButtonGanarPeso;
    private JRadioButton radioButtonMantenerPeso;
    private JRadioButton radioButtonPerderPeso;
    private JRadioButton radioButtonGanarMusculatura;
    private JRadioButton radioButtonTonificar;
    private JRadioButton radioButtonDefinir;

    public EleccionOpciones(String usuario, String nombre, String apellidos, String edad, String peso, String altura,
            String email, String contrasena, String IMC, String porcentajeGrasaDosDecimales, String sexo) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 533);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelObjetivos = new JLabel("<html>\u00BFCu\u00E1les son tus objetivos?<html>");
        labelObjetivos.setBounds(146, 152, 157, 13);
        panel.add(labelObjetivos);

        labelLogo = new JLabel();
        imageLogo = null;

        try {
            imageLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
            ImageIcon imagenLogo = new ImageIcon(
                    imageLogo.getScaledInstance(imageLogo.getWidth(), imageLogo.getHeight(), Image.SCALE_SMOOTH));
            labelLogo.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        labelLogo.setBounds(98, 10, 229, 157);
        panel.add(labelLogo);

        labelDieta = new JLabel("<html>DIETA<html>");
        labelDieta.setBounds(41, 202, 45, 13);
        panel.add(labelDieta);

        radioButtonGanarPeso = new JRadioButton("<html>Ganar peso<html>");
        radioButtonGanarPeso.setOpaque(false);
        radioButtonGanarPeso.setBounds(19, 221, 103, 21);
        panel.add(radioButtonGanarPeso);

        radioButtonMantenerPeso = new JRadioButton("<html>Mantener peso<html>");
        radioButtonMantenerPeso.setOpaque(false);
        radioButtonMantenerPeso.setBounds(19, 278, 164, 21);
        panel.add(radioButtonMantenerPeso);

        radioButtonPerderPeso = new JRadioButton("<html>Perder peso<html>");
        radioButtonPerderPeso.setOpaque(false);
        radioButtonPerderPeso.setBounds(19, 335, 103, 21);
        panel.add(radioButtonPerderPeso);

        buttonGroupTipoDieta = new ButtonGroup();
        buttonGroupTipoDieta.add(radioButtonGanarPeso);
        buttonGroupTipoDieta.add(radioButtonMantenerPeso);
        buttonGroupTipoDieta.add(radioButtonPerderPeso);

        labelRutina = new JLabel("<html>RUTINA<html>");
        labelRutina.setBounds(282, 202, 45, 13);
        panel.add(labelRutina);

        radioButtonGanarMusculatura = new JRadioButton("<html>Ganar musculatura<html>");
        radioButtonGanarMusculatura.setOpaque(false);
        radioButtonGanarMusculatura.setBounds(259, 221, 157, 21);
        panel.add(radioButtonGanarMusculatura);

        radioButtonTonificar = new JRadioButton("<html>Tonificar<html>");
        radioButtonTonificar.setOpaque(false);
        radioButtonTonificar.setBounds(259, 278, 103, 21);
        panel.add(radioButtonTonificar);

        radioButtonDefinir = new JRadioButton("<html>Definir<html>");
        radioButtonDefinir.setOpaque(false);
        radioButtonDefinir.setBounds(259, 335, 103, 21);
        panel.add(radioButtonDefinir);

        buttonGroupTipoRutina = new ButtonGroup();
        buttonGroupTipoRutina.add(radioButtonGanarMusculatura);
        buttonGroupTipoRutina.add(radioButtonTonificar);
        buttonGroupTipoRutina.add(radioButtonDefinir);

        buttonCancelar = new JButton("<html>Anterior<html>");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SegundaParteRegistroUsuario(nombre, email, usuario, contrasena);
            }
        });
        buttonCancelar.setBounds(57, 426, 85, 21);
        panel.add(buttonCancelar);

        buttonAceptar = new JButton("<html>Fin<html>");
        buttonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((radioButtonGanarPeso.isSelected() || radioButtonMantenerPeso.isSelected()
                        || radioButtonPerderPeso.isSelected())
                        && (radioButtonGanarMusculatura.isSelected() || radioButtonTonificar.isSelected()
                                || radioButtonDefinir.isSelected())) {

                    String dieta = "";
                    String tipoEntrenamiento = "";
                    if (radioButtonGanarPeso.isSelected()) {
                        dieta = "Ganar peso";
                    } else if (radioButtonMantenerPeso.isSelected()) {
                        dieta = "Mantenerme";
                    } else if (radioButtonPerderPeso.isSelected()) {
                        dieta = "Perder peso";
                    }

                    if (radioButtonGanarMusculatura.isSelected()) {
                        tipoEntrenamiento = "Ganar musculo";
                    } else if (radioButtonTonificar.isSelected()) {
                        tipoEntrenamiento = "Tonificar";
                    } else if (radioButtonDefinir.isSelected()) {
                        tipoEntrenamiento = "Definir";
                    }

                    new Usuario(usuario, nombre, "", edad, peso, altura, email, contrasena, IMC,
                            porcentajeGrasaDosDecimales, tipoEntrenamiento, sexo, dieta);
                    Usuario.guardarUsuariosEnBaseDatos();
                    frame.setVisible(false);
                    new PanelUsuarioContrasena();
                } else if (!radioButtonGanarPeso.isSelected() || !radioButtonMantenerPeso.isSelected()
                        || !radioButtonPerderPeso.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Debe seleccionar una opción de las tres posibles en ambas columnas de opciones<html>");
                } else if (!radioButtonGanarMusculatura.isSelected() || !radioButtonTonificar.isSelected()
                        || !radioButtonDefinir.isSelected()) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Debe seleccionar una opción de las tres posibles en ambas columnas de opciones<html>");
                }
            }
        });
        buttonAceptar.setBounds(257, 426, 85, 21);
        panel.add(buttonAceptar);

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
