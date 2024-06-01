package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jueves {

    private static ArrayList<Jueves> listaDietasJueves = new ArrayList<Jueves>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Jueves(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasJueves.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
            if (listaDietasJueves.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
            if (listaDietasJueves.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
            if (listaDietasJueves.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasJueves() {
        for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
            System.out.println(listaDietasJueves.get(pos).tipoDieta);
            System.out.println(listaDietasJueves.get(pos).diaDeLaSemana);
            System.out.println(listaDietasJueves.get(pos).desayuno);
            System.out.println(listaDietasJueves.get(pos).comida);
            System.out.println(listaDietasJueves.get(pos).almuerzo);
            System.out.println(listaDietasJueves.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioJueves(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasJueves.size()));

        while (!(tipoDietaUsuario.equals(listaDietasJueves.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasJueves.size()));
        }

        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasJueves.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaJueves(String nombreDesayunoEliminar) {
        if (listaDietasJueves.size() > 1) {
            for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
                if (listaDietasJueves.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasJueves.remove(pos);
                    pos = listaDietasJueves.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasJueves.size(); pos++) {
            if (listaDietasJueves.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
