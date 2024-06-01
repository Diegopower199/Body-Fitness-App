package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Lunes {

    private static ArrayList<Lunes> listaDietasLunes = new ArrayList<Lunes>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Lunes(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo, String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasLunes.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
            if (listaDietasLunes.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
            if (listaDietasLunes.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
            if (listaDietasLunes.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasLunes() {
        for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
            System.out.println(listaDietasLunes.get(pos).tipoDieta);
            System.out.println(listaDietasLunes.get(pos).diaDeLaSemana);
            System.out.println(listaDietasLunes.get(pos).desayuno);
            System.out.println(listaDietasLunes.get(pos).comida);
            System.out.println(listaDietasLunes.get(pos).almuerzo);
            System.out.println(listaDietasLunes.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioLunes(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasLunes.size()));

        while (!(tipoDietaUsuario.equals(listaDietasLunes.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasLunes.size()));
        }

        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasLunes.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaLunes(String nombreDesayunoEliminar) {
        if (listaDietasLunes.size() > 1) {
            for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
                if (listaDietasLunes.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasLunes.remove(pos);
                    pos = listaDietasLunes.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasLunes.size(); pos++) {
            if (listaDietasLunes.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
