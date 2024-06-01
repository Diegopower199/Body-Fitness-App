package Login;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SegundaParteRegistroUsuario {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelPeso;
    private JLabel labelAltura;
    private JLabel labelEdad;
    private JLabel labelGenero;
    private JLabel labelFondo;

    private JButton buttonCancelar;
    private JButton buttonAceptar;

    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JTextField textFieldEdad;

    private ButtonGroup buttonGroupGenero;

    private JRadioButton radioButtonHombre;
    private JRadioButton radioButtonMujer;

    public SegundaParteRegistroUsuario(String nombre, String email, String usuario, String contrasena) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 533);
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
            ImageIcon imagenLogo = new ImageIcon(
                    imageLogo.getScaledInstance(imageLogo.getWidth(), imageLogo.getHeight(), Image.SCALE_SMOOTH));
            labelLogo.setIcon(imagenLogo);
        } catch (IOException e) {
        }

        labelLogo.setBounds(98, 10, 229, 157);
        panel.add(labelLogo);

        labelPeso = new JLabel("<html>Introduzca su peso (en kg)<html>");
        labelPeso.setBounds(21, 222, 158, 23);
        panel.add(labelPeso);

        textFieldPeso = new JTextField();
        textFieldPeso.setBounds(243, 222, 96, 19);
        panel.add(textFieldPeso);
        textFieldPeso.setColumns(10);

        labelAltura = new JLabel("<html>Introduzca su altura (en cm)<html>");
        labelAltura.setBounds(21, 263, 158, 35);
        panel.add(labelAltura);

        textFieldAltura = new JTextField();
        textFieldAltura.setBounds(243, 271, 96, 19);
        panel.add(textFieldAltura);
        textFieldAltura.setColumns(10);

        labelEdad = new JLabel("<html>Introduzca su edad<html>");
        labelEdad.setBounds(21, 323, 158, 13);
        panel.add(labelEdad);

        textFieldEdad = new JTextField();
        textFieldEdad.setBounds(243, 317, 96, 19);
        panel.add(textFieldEdad);
        textFieldEdad.setColumns(10);

        labelGenero = new JLabel("<html>Seleccione su género<html>");
        labelGenero.setBounds(21, 364, 158, 13);
        panel.add(labelGenero);

        radioButtonHombre = new JRadioButton("<html>Masculino<html>");
        radioButtonHombre.setBounds(185, 357, 85, 23);
        radioButtonHombre.setOpaque(false);
        panel.add(radioButtonHombre);

        radioButtonMujer = new JRadioButton("<html>Femenino<html>");
        radioButtonMujer.setBounds(288, 357, 108, 23);
        radioButtonMujer.setOpaque(false);
        panel.add(radioButtonMujer);

        buttonGroupGenero = new ButtonGroup();
        buttonGroupGenero.add(radioButtonHombre);
        buttonGroupGenero.add(radioButtonMujer);

        buttonCancelar = new JButton("<html>Cancelar<html>");
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PanelUsuarioContrasena();
                frame.setVisible(false);
            }
        });
        buttonCancelar.setBounds(57, 426, 85, 21);
        panel.add(buttonCancelar);

        buttonAceptar = new JButton("<html>Siguiente<html>");
        buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean datosCorrectos = false;
                boolean datosBienIntroducidos = true;
                boolean numeroDecimal = false;

                double edad = 0;
                double peso = 0.0;
                double altura = 0.0;
                buttonGroupGenero.isSelected(null);

                if ((textFieldPeso.getText().equals("") || textFieldAltura.getText().equals("")
                        || textFieldEdad.getText().equals("")
                        || (!(radioButtonHombre.isSelected()) && !(radioButtonMujer.isSelected())))) {
                    JOptionPane.showMessageDialog(null,
                            "<html>¡Debes introducir en los 4 casilleros disponibles! aa<html>");
                } else if (!(textFieldPeso.getText().equals("")) || !(textFieldAltura.getText().equals(""))
                        || !(textFieldEdad.getText().equals(""))) {

                    if (textFieldAltura.getText().contains(",")) {
                        textFieldAltura.setText(textFieldAltura.getText().replace(",", "."));
                    }

                    if (textFieldPeso.getText().contains(",")) {
                        textFieldPeso.setText(textFieldPeso.getText().replace(",", "."));
                    }

                    try {
                        peso = Double.parseDouble(textFieldPeso.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "<html>Introduce en el peso números no letras<html>");
                        datosBienIntroducidos = false;
                    }

                    try {
                        altura = Double.parseDouble(textFieldAltura.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "<html>Introduce en la altura números no letras<html>");
                        datosBienIntroducidos = false;
                    }

                    try {
                        edad = Double.parseDouble(textFieldEdad.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null,
                                "<html>Introduce en la edad números enteros no decimales ni letras<html>");
                        numeroDecimal = true;
                        datosBienIntroducidos = false;
                    }

                    if (datosBienIntroducidos) {
                        if (peso < 0.0 || peso > 635.0) {
                            datosCorrectos = false;
                            JOptionPane.showMessageDialog(null,
                                    "<html>El peso no puede ser menor a 0 ni mayor a 635<html>");
                        } else {
                            if (altura < 53.3 || altura > 271.0) {
                                datosCorrectos = false;
                                JOptionPane.showMessageDialog(null,
                                        "<html>La altura no puede ser menor a 53.3 ni mayor a 271<html>");
                            } else {
                                if (edad % 1 != 0 || numeroDecimal) {
                                    JOptionPane.showMessageDialog(null,
                                            "<html>La edad no puede ser decimal, introduce otra edad<html>");
                                } else if (edad < 0.0 || edad > 122.0) {
                                    JOptionPane.showMessageDialog(null,
                                            "<html>La edad no puede ser menor a 0 ni mayor a 122<html>");
                                } else {
                                    datosCorrectos = true;
                                }
                            }
                        }
                    }

                    if (datosCorrectos) {
                        if (radioButtonHombre.isSelected()) {
                            double imcHombre = (peso) / (Math.pow(altura * 0.01, 2));

                            DecimalFormat df = new DecimalFormat("###.##");
                            double imcDosDecimales = Math.round(imcHombre * 100.0) / 100.0;
                            double porcentajeDeGrasaCorporal = ((1.2 * imcHombre)
                                    + (0.23 * Integer.parseInt(textFieldEdad.getText())) - (10.8 * 1) - 5.4);
                            double porcentajeGrasaDosDecimales = Math.round(porcentajeDeGrasaCorporal * 100.0) / 100.0;
                            if (porcentajeGrasaDosDecimales <= 0) {
                                JOptionPane.showMessageDialog(null,
                                        "<html>Error, tienes un porcentaje de grasa corporal negativo o igual a 0<html>");
                            } else {
                                if (datosCorrectos) {
                                    JOptionPane.showMessageDialog(null,
                                            "<html>Dados los datos introducidos, el índice de masa corporal (IMC) es: <html>"
                                                    + df.format(imcHombre));
                                    new EleccionOpciones(usuario, nombre, "", textFieldEdad.getText(),
                                            textFieldPeso.getText(),
                                            textFieldAltura.getText(), email, contrasena,
                                            String.valueOf(imcDosDecimales),
                                            String.valueOf(porcentajeGrasaDosDecimales), "Maculino");
                                    frame.setVisible(false);
                                }
                            }
                        } else if (radioButtonMujer.isSelected()) {
                            double imcMujer = (peso) / (Math.pow(altura * 0.01, 2));

                            DecimalFormat df = new DecimalFormat("###.##");
                            double imcDosDecimales = Math.round(imcMujer * 100.0) / 100.0;
                            double porcentajeDeGrasaCorporal = ((1.2 * imcMujer)
                                    + (0.23 * Integer.parseInt(textFieldEdad.getText())) - (10.8 * 0) - 5.4);
                            double porcentajeGrasaDosDecimales = Math.round(porcentajeDeGrasaCorporal * 100.0) / 100.0;
                            if (porcentajeGrasaDosDecimales < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "<html>Error, tienes un porcentaje de grasa corporal negativo o igual a 0<html>");
                            } else {
                                if (datosCorrectos) {
                                    JOptionPane.showMessageDialog(null,
                                            "<html>Dados los datos introducidos, el índice de masa corporal (IMC) es: <html>"
                                                    + df.format(imcMujer));

                                    new EleccionOpciones(usuario, nombre, "", textFieldEdad.getText(),
                                            textFieldPeso.getText(),
                                            textFieldAltura.getText(), email, contrasena,
                                            String.valueOf(imcDosDecimales),
                                            String.valueOf(porcentajeGrasaDosDecimales), "Femenino");
                                    frame.setVisible(false);
                                }
                            }
                        }
                    }
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