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

public class CambiarEntrenamiento {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelCambiarEntrenamiento;
    private JLabel labelEntrenamientoActual;
    private JLabel labelEntrenamientoActualElegido;
    private JLabel labelSeleccionarEntrenamiento;
    private JLabel labelFondo;

    private JButton buttonAtras;
    private JButton buttonFinalizar;

    private ButtonGroup buttonGroupTipoEntrenamiento;

    private JRadioButton radioButtonGanarMusculatura;
    private JRadioButton radioButtonTonificar;
    private JRadioButton radioButtonDefinir;

    public CambiarEntrenamiento(Usuario informacionUsuario) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        labelLogo.setBounds(356, 10, 70, 65);
        panel.add(labelLogo);

        labelCambiarEntrenamiento = new JLabel("<html>CAMBIAR ENTRENAMIENTO SELECCIONADO<html>");
        labelCambiarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        labelCambiarEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
        labelCambiarEntrenamiento.setBounds(37, 46, 318, 13);
        panel.add(labelCambiarEntrenamiento);

        labelEntrenamientoActual = new JLabel("<html>Su entrenamiento actual:<html>");
        labelEntrenamientoActual.setBounds(50, 82, 174, 34);
        panel.add(labelEntrenamientoActual);

        labelEntrenamientoActualElegido = new JLabel(informacionUsuario.getEntrenamientoElegido());
        labelEntrenamientoActualElegido.setBounds(249, 93, 90, 13);
        panel.add(labelEntrenamientoActualElegido);

        labelSeleccionarEntrenamiento = new JLabel("<html>Seleccione un entrenamiento:<html>");
        labelSeleccionarEntrenamiento.setBounds(50, 122, 174, 26);
        panel.add(labelSeleccionarEntrenamiento);

        radioButtonGanarMusculatura = new JRadioButton("<html>Ganar musculatura<html>");
        radioButtonGanarMusculatura.setBounds(37, 161, 145, 21);
        radioButtonGanarMusculatura.setOpaque(false);
        panel.add(radioButtonGanarMusculatura);

        radioButtonTonificar = new JRadioButton("<html>Tonificar<html>");
        radioButtonTonificar.setBounds(184, 161, 115, 21);
        radioButtonTonificar.setOpaque(false);
        panel.add(radioButtonTonificar);

        radioButtonDefinir = new JRadioButton("<html>Definir<html>");
        radioButtonDefinir.setBounds(301, 161, 103, 21);
        radioButtonDefinir.setOpaque(false);
        panel.add(radioButtonDefinir);

        buttonGroupTipoEntrenamiento = new ButtonGroup();
        buttonGroupTipoEntrenamiento.add(radioButtonGanarMusculatura);
        buttonGroupTipoEntrenamiento.add(radioButtonTonificar);
        buttonGroupTipoEntrenamiento.add(radioButtonDefinir);

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
                if (!radioButtonGanarMusculatura.isSelected() && !radioButtonTonificar.isSelected()
                        && !radioButtonDefinir.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Existen campos vacios. Inténtelo de nuevo");
                } else {
                    if (radioButtonGanarMusculatura.isSelected()) {
                        informacionUsuario.setEntrenamientoElegido("Ganar musculo");
                    } else if (radioButtonTonificar.isSelected()) {
                        informacionUsuario.setEntrenamientoElegido("Tonificar");
                    } else if (radioButtonDefinir.isSelected()) {
                        informacionUsuario.setEntrenamientoElegido("Definir");
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
