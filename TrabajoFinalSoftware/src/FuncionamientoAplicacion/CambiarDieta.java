package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import InformacionPersona.Usuario;

public class CambiarDieta {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarDieta;
    private JLabel labelDietaAcutal;
    private JLabel labelDietaActualElegida;
    private JLabel labelSeleccionarDieta;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private ButtonGroup buttonGroupTipoDieta;

    private JRadioButton radioButtonGanarPeso;
    private JRadioButton radioButtonMantenerPeso;
    private JRadioButton radioButtonPerderPeso;

    public CambiarDieta(Usuario informacionUsuario) {
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

        labelLogo.setBounds(338, 17, 70, 65);
        panel.add(labelLogo);

        labelCambiarDieta = new JLabel("<html>CAMBIAR DIETA SELECCIONADA<html>");
        labelCambiarDieta.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarDieta.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarDieta.setBounds(101, 49, 238, 13);
        panel.add(labelCambiarDieta);

        labelDietaAcutal = new JLabel("<html>Su dieta actual:<html>");
        labelDietaAcutal.setBounds(50, 82, 103, 34);
        panel.add(labelDietaAcutal);

        labelDietaActualElegida = new JLabel(informacionUsuario.getDietaElegida());
        labelDietaActualElegida.setBounds(145, 93, 90, 13);
        panel.add(labelDietaActualElegida);

        labelSeleccionarDieta = new JLabel("<html>Seleccione nueva dieta:<html>");
        labelSeleccionarDieta.setBounds(50, 122, 152, 26);
        panel.add(labelSeleccionarDieta);

        radioButtonGanarPeso = new JRadioButton("<html>Ganar peso<html>");
        radioButtonGanarPeso.setBounds(50, 161, 103, 21);
        radioButtonGanarPeso.setOpaque(false);
        panel.add(radioButtonGanarPeso);

        radioButtonMantenerPeso = new JRadioButton("<html>Mantener peso<html>");
        radioButtonMantenerPeso.setBounds(161, 161, 115, 21);
        radioButtonMantenerPeso.setOpaque(false);
        panel.add(radioButtonMantenerPeso);

        radioButtonPerderPeso = new JRadioButton("<html>Perder peso<html>");
        radioButtonPerderPeso.setBounds(291, 161, 103, 21);
        radioButtonPerderPeso.setOpaque(false);
        panel.add(radioButtonPerderPeso);

        buttonGroupTipoDieta = new ButtonGroup();
        buttonGroupTipoDieta.add(radioButtonGanarPeso);
        buttonGroupTipoDieta.add(radioButtonMantenerPeso);
        buttonGroupTipoDieta.add(radioButtonPerderPeso);

        buttonAtras = new JButton("<html>Atrás<html>");
        buttonAtras.setBounds(10, 232, 85, 21);
        buttonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" }, "Sí");
                if (resp == 0) {
                    new PantallaPrincipalUsuario(informacionUsuario);
                    frame.setVisible(false);
                }
            }
        });
        panel.add(buttonAtras);

        buttonFinalizar = new JButton("<html>Finalizar<html>");
        buttonFinalizar.setBounds(341, 232, 85, 21);
        buttonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!radioButtonGanarPeso.isSelected() && !radioButtonMantenerPeso.isSelected()
                        && !radioButtonPerderPeso.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
                } else {
                    if (radioButtonGanarPeso.isSelected()) {
                        informacionUsuario.setDietaElegida("Ganar peso");

                    } else if (radioButtonMantenerPeso.isSelected()) {
                        informacionUsuario.setDietaElegida("Mantenerme");

                    } else if (radioButtonPerderPeso.isSelected()) {
                        informacionUsuario.setDietaElegida("Perder peso");
                    }

                    Usuario.guardarUsuariosEnBaseDatos();
                    new PantallaPrincipalUsuario(informacionUsuario);
                    frame.setVisible(false);
                }
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

        labelFondo.setBounds(0, 0, 436, 496);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}
