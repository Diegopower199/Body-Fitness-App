package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DietasCuatroComidasDelDia.Domingo;
import DietasCuatroComidasDelDia.Jueves;
import DietasCuatroComidasDelDia.Lunes;
import DietasCuatroComidasDelDia.Martes;
import DietasCuatroComidasDelDia.Miercoles;
import DietasCuatroComidasDelDia.Sabado;
import DietasCuatroComidasDelDia.Viernes;
import InformacionPersona.Usuario;

public class MisDietas {

    private JFrame frame;

    private JPanel panel;

    private BufferedImage imageLogo;
    private BufferedImage imageFondo;

    private JLabel labelLogo;
    private JLabel labelDiasSemana;
    private JLabel labelDesayuno;
    private JLabel labelInformacionDesayuno;
    private JLabel labelComida;
    private JLabel labelInformacionComida;
    private JLabel labelAlmuerzo;
    private JLabel labelInformacionAlmuerzo;
    private JLabel labelCena;
    private JLabel labelInformacionCena;
    private JLabel labelFondo;

    private JButton buttonVolverMenuPrincipal;

    private Dimension dim;

    ArrayList<String> dieta = null;
    Calendar now = Calendar.getInstance();
    String[] dias = new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
    String diaSemana = dias[now.get(Calendar.DAY_OF_WEEK) - 2];

    public MisDietas(Usuario informacionUsuario) {
        frame = new JFrame();
        frame.setMaximumSize(dim);
        frame.setBounds(100, 100, 1500, 830);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        dim = frame.getToolkit().getScreenSize();

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

        labelLogo.setBounds(10, 10, 229, 157);
        panel.add(labelLogo);

        labelDiasSemana = new JLabel("<html>" + diaSemana + " " + now.get(Calendar.DATE) + "<html>");
        labelDiasSemana.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelDiasSemana.setBounds(600, 71, 204, 49);
        panel.add(labelDiasSemana);

        labelDesayuno = new JLabel("<html>DESAYUNO<html>");
        labelDesayuno.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDesayuno.setBounds(354, 223, 149, 13);
        panel.add(labelDesayuno);

        labelInformacionDesayuno = new JLabel("<html>Información desayuno<html>");
        labelInformacionDesayuno.setBounds(354, 273, 149, 13);
        panel.add(labelInformacionDesayuno);

        labelComida = new JLabel("<html>COMIDA<html>");
        labelComida.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelComida.setBounds(354, 439, 149, 13);
        panel.add(labelComida);

        labelInformacionComida = new JLabel("<html>Información comida<html>");
        labelInformacionComida.setBounds(354, 476, 149, 13);
        panel.add(labelInformacionComida);

        labelAlmuerzo = new JLabel("<html>ALMUERZO<html>");
        labelAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelAlmuerzo.setBounds(907, 223, 149, 13);
        panel.add(labelAlmuerzo);

        labelInformacionAlmuerzo = new JLabel("<html>Información almuerzo<html>");
        labelInformacionAlmuerzo.setBounds(907, 273, 149, 13);
        panel.add(labelInformacionAlmuerzo);

        labelCena = new JLabel("<html>CENA<html>");
        labelCena.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCena.setBounds(907, 439, 149, 13);
        panel.add(labelCena);

        labelInformacionCena = new JLabel("<html>Información cena<html>");
        labelInformacionCena.setBounds(907, 476, 149, 13);
        panel.add(labelInformacionCena);

        switch (diaSemana) {
            case "Lunes":
                dieta = Lunes.dietaAleatorioLunes(informacionUsuario.getDietaElegida());
                break;
            case "Martes":
                dieta = Martes.dietaAleatorioMartes(informacionUsuario.getDietaElegida());
                break;
            case "Miércoles":
                dieta = Miercoles.dietaAleatorioMiercoles(informacionUsuario.getDietaElegida());
                break;
            case "Jueves":
                dieta = Jueves.dietaAleatorioJueves(informacionUsuario.getDietaElegida());
                break;
            case "Viernes":
                dieta = Viernes.dietaAleatorioViernes(informacionUsuario.getDietaElegida());
                break;
            case "Sábado":
                dieta = Sabado.dietaAleatorioSabado(informacionUsuario.getDietaElegida());
                break;
            case "Domingo":
                dieta = Domingo.dietaAleatorioDomingo(informacionUsuario.getDietaElegida());
        }

        labelInformacionDesayuno.setText(dieta.get(2));
        labelInformacionComida.setText(dieta.get(3));
        labelInformacionAlmuerzo.setText(dieta.get(4));
        labelInformacionCena.setText(dieta.get(5));

        buttonVolverMenuPrincipal = new JButton("<html>Volver al menú<html>");
        buttonVolverMenuPrincipal.setBounds(781, 690, 162, 21);
        buttonVolverMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PantallaPrincipalUsuario(informacionUsuario);
                frame.setVisible(false);
            }
        });
        panel.add(buttonVolverMenuPrincipal);

        labelFondo = new JLabel();
        imageFondo = null;

        try {
            imageFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
            ImageIcon im = new ImageIcon(
                    imageFondo.getScaledInstance(imageFondo.getWidth(), imageFondo.getHeight(), Image.SCALE_SMOOTH));
            labelFondo.setIcon(im);
        } catch (Exception e) {
        }

        labelFondo.setBounds(0, 0, 1500, 830);
        panel.add(labelFondo);

        frame.setVisible(true);
    }

}
