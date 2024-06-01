package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Domingo {

    private static ArrayList<Domingo> listaDietasDomingo = new ArrayList<Domingo>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Domingo(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasDomingo.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
            if (listaDietasDomingo.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
            if (listaDietasDomingo.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
            if (listaDietasDomingo.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasDomingo() {
        for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
            System.out.println(listaDietasDomingo.get(pos).tipoDieta);
            System.out.println(listaDietasDomingo.get(pos).diaDeLaSemana);
            System.out.println(listaDietasDomingo.get(pos).desayuno);
            System.out.println(listaDietasDomingo.get(pos).comida);
            System.out.println(listaDietasDomingo.get(pos).almuerzo);
            System.out.println(listaDietasDomingo.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioDomingo(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasDomingo.size()));

        while (!(tipoDietaUsuario.equals(listaDietasDomingo.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasDomingo.size()));
        }

        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasDomingo.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaDomingo(String nombreDesayunoEliminar) {
        if (listaDietasDomingo.size() > 1) {
            for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
                if (listaDietasDomingo.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasDomingo.remove(pos);
                    pos = listaDietasDomingo.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasDomingo.size(); pos++) {
            if (listaDietasDomingo.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
