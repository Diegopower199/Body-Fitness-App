package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Sabado {

    private static ArrayList<Sabado> listaDietasSabado = new ArrayList<Sabado>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Sabado(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasSabado.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
            if (listaDietasSabado.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
            if (listaDietasSabado.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
            if (listaDietasSabado.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasSabado() {
        for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
            System.out.println(listaDietasSabado.get(pos).tipoDieta);
            System.out.println(listaDietasSabado.get(pos).diaDeLaSemana);
            System.out.println(listaDietasSabado.get(pos).desayuno);
            System.out.println(listaDietasSabado.get(pos).comida);
            System.out.println(listaDietasSabado.get(pos).almuerzo);
            System.out.println(listaDietasSabado.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioSabado(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasSabado.size()));

        while (!(tipoDietaUsuario.equals(listaDietasSabado.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasSabado.size()));
        }

        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasSabado.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaSabado(String nombreDesayunoEliminar) {
        if (listaDietasSabado.size() > 1) {
            for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
                if (listaDietasSabado.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasSabado.remove(pos);
                    pos = listaDietasSabado.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasSabado.size(); pos++) {
            if (listaDietasSabado.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
