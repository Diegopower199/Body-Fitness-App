package DietasCuatroComidasDelDia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Miercoles {

    private static ArrayList<Miercoles> listaDietasMiercoles = new ArrayList<Miercoles>();

    private String tipoDieta;
    private String diaDeLaSemana;
    private String desayuno;
    private String comida;
    private String almuerzo;
    private String cena;

    public Miercoles(String tipoDieta, String diaDeLaSemana, String desayuno, String comida, String almuerzo,
            String cena) {
        this.tipoDieta = tipoDieta;
        this.diaDeLaSemana = diaDeLaSemana;
        this.desayuno = desayuno;
        this.comida = comida;
        this.almuerzo = almuerzo;
        this.cena = cena;

        listaDietasMiercoles.add(this);
    }

    public static int tamanoDietasGanarPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
            if (listaDietasMiercoles.get(pos).tipoDieta.equals("Ganar peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasMantenerme() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
            if (listaDietasMiercoles.get(pos).tipoDieta.equals("Mantenerme")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoDietasPerderPeso() {
        int tamano = 0;

        for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
            if (listaDietasMiercoles.get(pos).tipoDieta.equals("Perder peso")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static void recuperarTodasLasDietasMiercoles() {
        for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
            System.out.println(listaDietasMiercoles.get(pos).tipoDieta);
            System.out.println(listaDietasMiercoles.get(pos).diaDeLaSemana);
            System.out.println(listaDietasMiercoles.get(pos).desayuno);
            System.out.println(listaDietasMiercoles.get(pos).comida);
            System.out.println(listaDietasMiercoles.get(pos).almuerzo);
            System.out.println(listaDietasMiercoles.get(pos).cena);
        }
    }

    public static ArrayList<String> dietaAleatorioMiercoles(String tipoDietaUsuario) {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaDietasMiercoles.size()));

        while (!(tipoDietaUsuario.equals(listaDietasMiercoles.get(numeroAleatorioPrimero).tipoDieta))) {
            numeroAleatorioPrimero = (int) (Math.random() * (listaDietasMiercoles.size()));
        }

        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).tipoDieta);
        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).diaDeLaSemana);
        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).desayuno);
        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).comida);
        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).almuerzo);
        ejercicio.add(listaDietasMiercoles.get(numeroAleatorioPrimero).cena);

        return ejercicio;
    }

    public static void eliminarDietaMiercoles(String nombreDesayunoEliminar) {
        if (listaDietasMiercoles.size() > 1) {
            for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
                if (listaDietasMiercoles.get(pos).desayuno.equals(nombreDesayunoEliminar)) {
                    listaDietasMiercoles.remove(pos);
                    pos = listaDietasMiercoles.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas dietas, solo queda 1<html>");
        }
    }

    public static boolean existeDieta(String desayuno) {
        for (int pos = 0; pos < listaDietasMiercoles.size(); pos++) {
            if (listaDietasMiercoles.get(pos).desayuno.equals(desayuno)) {
                return true;
            }
        }

        return false;
    }

}
