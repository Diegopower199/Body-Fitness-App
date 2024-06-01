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

public class EliminarDietas {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelEliminarDieta;
    private JLabel labelTipoDieta;
    private JLabel labelDiaSemana;
    private JLabel labelDesayuno;
    private JLabel labelComida;
    private JLabel labelAlmuerzo;
    private JLabel labelCena;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonEliminar;

    private JTextField textFieldTipoDieta;
    private JTextField textFieldDiaSemana;
    private JTextField textFieldDesayuno;
    private JTextField textFieldComida;
    private JTextField textFieldAlmuerzo;
    private JTextField textFieldCena;

    public EliminarDietas(Entrenadores informacionEntrenador) {
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

        labelEliminarDieta = new JLabel("<html>Eliminar Dieta<html>");
        labelEliminarDieta.setHorizontalAlignment(SwingConstants.CENTER);
        labelEliminarDieta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelEliminarDieta.setBounds(114, 10, 240, 20);
        panel.add(labelEliminarDieta);

        labelTipoDieta = new JLabel("<html>Tipo de dieta<html>");
        labelTipoDieta.setBounds(66, 56, 106, 25);
        panel.add(labelTipoDieta);

        labelDiaSemana = new JLabel("<html>D\u00EDa de la semana<html>");
        labelDiaSemana.setBounds(66, 92, 106, 17);
        panel.add(labelDiaSemana);

        textFieldTipoDieta = new JTextField();
        textFieldTipoDieta.setColumns(10);
        textFieldTipoDieta.setBounds(179, 53, 147, 20);
        panel.add(textFieldTipoDieta);

        textFieldDiaSemana = new JTextField();
        textFieldDiaSemana.setColumns(10);
        textFieldDiaSemana.setBounds(179, 89, 147, 20);
        panel.add(textFieldDiaSemana);

        labelDesayuno = new JLabel("<html>Desayuno<html>");
        labelDesayuno.setBounds(66, 125, 70, 14);
        panel.add(labelDesayuno);

        textFieldDesayuno = new JTextField();
        textFieldDesayuno.setColumns(10);
        textFieldDesayuno.setBounds(179, 122, 147, 20);
        panel.add(textFieldDesayuno);

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
        textFieldComida.setColumns(10);
        textFieldComida.setBounds(179, 150, 147, 20);
        panel.add(textFieldComida);

        textFieldAlmuerzo = new JTextField();
        textFieldAlmuerzo.setColumns(10);
        textFieldAlmuerzo.setBounds(179, 180, 147, 20);
        panel.add(textFieldAlmuerzo);

        textFieldCena = new JTextField();
        textFieldCena.setColumns(10);
        textFieldCena.setBounds(179, 211, 147, 20);
        panel.add(textFieldCena);

        buttonAtras = new JButton("<html>Atr\u00E1s<html>");
        buttonAtras.setBounds(12, 238, 89, 23);
        buttonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalEntrenador(informacionEntrenador);
                frame.setVisible(false);
            }
        });
        panel.add(buttonAtras);

        buttonEliminar = new JButton("<html>Eliminar<html>");
        buttonEliminar.setBounds(335, 238, 89, 23);
        buttonEliminar.addActionListener(new ActionListener() {
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
                                || diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Miércoles")
                                || diaDeLaSemana.equals("Jueves") || diaDeLaSemana.equals("Viernes")
                                || diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado")
                                || diaDeLaSemana.equals("Domingo")) {
                            String desayuno = textFieldDesayuno.getText();
                            primeraLetra = desayuno.substring(0, 1);
                            restoDeLetras = desayuno.substring(1, desayuno.length());

                            primeraLetra = primeraLetra.toUpperCase();
                            desayuno = primeraLetra + restoDeLetras;

                            if (Lunes.existeDieta(desayuno) || Martes.existeDieta(desayuno)
                                    || Miercoles.existeDieta(desayuno) || Jueves.existeDieta(desayuno)
                                    || Viernes.existeDieta(desayuno) || Sabado.existeDieta(desayuno)
                                    || Domingo.existeDieta(desayuno)) {

                                Dietas.eliminarBinomiosNivel3(tipoDieta, diaDeLaSemana, desayuno);
                                Dietas.guardarDietasEnBaseDatos();
                                if (diaDeLaSemana.equals("Lunes")) {
                                    Lunes.eliminarDietaLunes(desayuno);
                                } else if (diaDeLaSemana.equals("Martes")) {
                                    Martes.eliminarDietaMartes(desayuno);
                                } else if (diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Miércoles")) {
                                    Miercoles.eliminarDietaMiercoles(desayuno);
                                } else if (diaDeLaSemana.equals("Jueves")) {
                                    Jueves.eliminarDietaJueves(desayuno);
                                } else if (diaDeLaSemana.equals("Viernes")) {
                                    Viernes.eliminarDietaViernes(desayuno);
                                } else if (diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado")) {
                                    Sabado.eliminarDietaSabado(desayuno);
                                } else if (diaDeLaSemana.equals("Domingo")) {
                                    Domingo.eliminarDietaDomingo(desayuno);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Esta dieta no esta en nuestra base de datos, introduce otro por favor", null,
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    new PantallaPrincipalEntrenador(informacionEntrenador);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonEliminar);

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
