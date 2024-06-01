package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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

import DietasCuatroComidasDelDia.Domingo;
import DietasCuatroComidasDelDia.Jueves;
import DietasCuatroComidasDelDia.Lunes;
import DietasCuatroComidasDelDia.Martes;
import DietasCuatroComidasDelDia.Miercoles;
import DietasCuatroComidasDelDia.Sabado;
import DietasCuatroComidasDelDia.Viernes;
import InformacionAplicacionGeneral.Dietas;
import InformacionPersona.Entrenadores;

public class AnadirDietas {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelAnadirDieta;
    private JLabel labelTipoDieta;
    private JLabel labelDiaSemana;
    private JLabel labelDesayuno;
    private JLabel labelComida;
    private JLabel labelAlmuerzo;
    private JLabel labelCena;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonAnadir;

    private JTextField textFieldTipoDieta;
    private JTextField textFieldDiaSemana;
    private JTextField textFieldDesayuno;
    private JTextField textFieldComida;
    private JTextField textFieldAlmuerzo;
    private JTextField textFieldCena;

    public AnadirDietas(Entrenadores informacionEntrenador) {
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

        labelAnadirDieta = new JLabel("<html>A\u00F1adir Dieta<html>");
        labelAnadirDieta.setHorizontalAlignment(SwingConstants.CENTER);
        labelAnadirDieta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelAnadirDieta.setBounds(114, 10, 240, 20);
        panel.add(labelAnadirDieta);

        labelTipoDieta = new JLabel("<html>Tipo de dieta<html>");
        labelTipoDieta.setBounds(66, 56, 90, 17);
        panel.add(labelTipoDieta);

        labelDiaSemana = new JLabel("<html>D\u00EDa de la semana<html>");
        labelDiaSemana.setBounds(66, 92, 103, 14);
        panel.add(labelDiaSemana);

        textFieldTipoDieta = new JTextField();
        textFieldTipoDieta.setBounds(179, 50, 147, 20);
        panel.add(textFieldTipoDieta);
        textFieldTipoDieta.setColumns(10);

        textFieldDiaSemana = new JTextField();
        textFieldDiaSemana.setBounds(179, 86, 147, 20);
        panel.add(textFieldDiaSemana);
        textFieldDiaSemana.setColumns(10);

        labelDesayuno = new JLabel("<html>Desayuno<html>");
        labelDesayuno.setBounds(66, 125, 70, 14);
        panel.add(labelDesayuno);

        textFieldDesayuno = new JTextField();
        textFieldDesayuno.setBounds(179, 119, 147, 20);
        panel.add(textFieldDesayuno);
        textFieldDesayuno.setColumns(10);

        labelComida = new JLabel("<html>Comida<html>");
        labelComida.setBounds(66, 153, 46, 14);
        panel.add(labelComida);

        labelAlmuerzo = new JLabel("<html>Almuerzo<html>");
        labelAlmuerzo.setBounds(66, 183, 70, 14);
        panel.add(labelAlmuerzo);

        labelCena = new JLabel("<html>Cena<html>");
        labelCena.setBounds(66, 214, 46, 14);
        panel.add(labelCena);

        textFieldComida = new JTextField();
        textFieldComida.setBounds(179, 147, 147, 20);
        panel.add(textFieldComida);
        textFieldComida.setColumns(10);

        textFieldAlmuerzo = new JTextField();
        textFieldAlmuerzo.setBounds(179, 177, 147, 20);
        panel.add(textFieldAlmuerzo);
        textFieldAlmuerzo.setColumns(10);

        textFieldCena = new JTextField();
        textFieldCena.setBounds(179, 208, 147, 20);
        panel.add(textFieldCena);
        textFieldCena.setColumns(10);

        buttonAtras = new JButton("<html>Atr\u00E1s<html>");
        buttonAtras.setBounds(12, 238, 89, 23);
        buttonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        buttonAnadir = new JButton("<html>A\u00F1adir<html>");
        buttonAnadir.setBounds(335, 238, 89, 23);
        buttonAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textFieldTipoDieta.getText().equals("") || textFieldDiaSemana.getText().equals("")
                        || textFieldDesayuno.getText().equals("") || textFieldComida.getText().equals("")
                        || textFieldAlmuerzo.getText().equals("") || textFieldCena.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null,
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String tipoDieta = textFieldTipoDieta.getText();
                    String primeraLetra = tipoDieta.substring(0, 1);
                    String restoDeLetras = tipoDieta.substring(1, tipoDieta.length());

                    primeraLetra = primeraLetra.toUpperCase();
                    tipoDieta = primeraLetra + restoDeLetras;

                    if (tipoDieta.equals("Ganar peso") || tipoDieta.equals("Mantenerme")
                            || tipoDieta.equals("Perder peso")) {
                        String diaDeLaSemana = textFieldDiaSemana.getText();
                        primeraLetra = diaDeLaSemana.substring(0, 1);
                        restoDeLetras = diaDeLaSemana.substring(1, diaDeLaSemana.length());
                        primeraLetra = primeraLetra.toUpperCase();
                        diaDeLaSemana = primeraLetra + restoDeLetras;

                        if (diaDeLaSemana.equals("Lunes") || diaDeLaSemana.equals("Martes")
                                || diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Jueves")
                                || diaDeLaSemana.equals("Viernes") || diaDeLaSemana.equals("Sabado")
                                || diaDeLaSemana.equals("Sábado") || diaDeLaSemana.equals("Domingo")) {

                            if (diaDeLaSemana.equals("Lunes")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Lunes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Lunes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Lunes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Martes")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Martes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Martes.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Martes.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Martes.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Martes.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Martes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Martes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Miercoles")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Miercoles(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Miercoles(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Miercoles(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Jueves")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Jueves(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Jueves(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Jueves(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Viernes")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Viernes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Viernes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Viernes(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Sabado(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Sabado(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Sabado(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            } else if (diaDeLaSemana.equals("Domingo")) {
                                if (tipoDieta.equals("Ganar peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1),
                                            textFieldCena.getText());
                                    new Domingo(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Mantenerme")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1),
                                            textFieldCena.getText());
                                    new Domingo(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                } else if (tipoDieta.equals("Perder peso")) {
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Desayuno " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1),
                                            textFieldDesayuno.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Comida " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1),
                                            textFieldComida.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Almuerzo " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1),
                                            textFieldAlmuerzo.getText());
                                    Dietas.anadirNivel3(tipoDieta, diaDeLaSemana,
                                            "-Cena " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1),
                                            textFieldCena.getText());
                                    new Domingo(tipoDieta, diaDeLaSemana, textFieldDesayuno.getText(),
                                            textFieldComida.getText(), textFieldAlmuerzo.getText(),
                                            textFieldCena.getText());
                                }
                            }
                            Dietas.guardarDietasEnBaseDatos();
                        }
                    }
                    new PantallaPrincipalEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAnadir);

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