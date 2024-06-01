package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Viernes {

    private static ArrayList<Viernes> listaDietasViernes = new ArrayList<Viernes>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Viernes(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasViernes.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
            if (listaDietasViernes.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
            if (listaDietasViernes.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
            if (listaDietasViernes.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasViernes() {
        for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
            System.out.println(listaDietasViernes.get(pos).tipoDieta);
            System.out.println(listaDietasViernes.get(pos).diaDeLaSemana);
            System.out.println(listaDietasViernes.get(pos).desayuno);
            System.out.println(listaDietasViernes.get(pos).comida);
            System.out.println(listaDietasViernes.get(pos).almuerzo);
            System.out.println(listaDietasViernes.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioViernes(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasViernes.size()));

        while (!(tipoDietaUsuario.equals(listaDietasViernes.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasViernes.size()));
        }

        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasViernes.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaViernes(String nombreDesayunoEliminar) {
        if (listaDietasViernes.size() > 1) {
            for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
                if (listaDietasViernes.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasViernes.remove(pos);
                    pos = listaDietasViernes.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasViernes.size(); pos++) {
            if (listaDietasViernes.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
