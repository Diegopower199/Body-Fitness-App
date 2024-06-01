package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Martes {

    private static ArrayList<Martes> listaDietasMartes = new ArrayList<Martes>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Martes(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasMartes.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
            if (listaDietasMartes.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
            if (listaDietasMartes.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
            if (listaDietasMartes.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasMartes() {
        for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
            System.out.println(listaDietasMartes.get(pos).tipoDieta);
            System.out.println(listaDietasMartes.get(pos).diaDeLaSemana);
            System.out.println(listaDietasMartes.get(pos).desayuno);
            System.out.println(listaDietasMartes.get(pos).comida);
            System.out.println(listaDietasMartes.get(pos).almuerzo);
            System.out.println(listaDietasMartes.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioMartes(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasMartes.size()));

        while (!(tipoDietaUsuario.equals(listaDietasMartes.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasMartes.size()));
        }

        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasMartes.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaMartes(String nombreDesayunoEliminar) {
        if (listaDietasMartes.size() > 1) {
            for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
                if (listaDietasMartes.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasMartes.remove(pos);
                    pos = listaDietasMartes.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasMartes.size(); pos++) {
            if (listaDietasMartes.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
