package TiposEjerciciosClases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tonificar {

    public static ArrayList<Tonificar> listaEjerciciosTonificar = new ArrayList<Tonificar>();

    private String tipoEntrenamiento;
    private String nombreGrupoMuscular;
    private String nombreEjercicio;
    private String descripcionEjercicio;
    private String seriesEjercicio;
    private String repeticionesEjercicio;
    private String direccionImagenEjercicio;
    private String direccionVideoEjercicio;

    public Tonificar(String tipoEntrenamiento, String nombreGrupoMuscular, String nombreEjercicio,
            String descripcionEjercicio, String seriesEjercicio, String repeticionesEjercicio,
            String direccionImagenEjercicio, String direccionVideoEjercicio) {
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.nombreGrupoMuscular = nombreGrupoMuscular;
        this.nombreEjercicio = nombreEjercicio;
        this.descripcionEjercicio = descripcionEjercicio;
        this.seriesEjercicio = seriesEjercicio;
        this.repeticionesEjercicio = repeticionesEjercicio;
        this.direccionImagenEjercicio = direccionImagenEjercicio;
        this.direccionVideoEjercicio = direccionVideoEjercicio;

        listaEjerciciosTonificar.add(this);
    }

    public static ArrayList<String> tresEjercicioAleatorioTonificar() {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaEjerciciosTonificar.size()));
        int numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosTonificar.size()));
        int numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosTonificar.size()));

        while (numeroAleatorioSegundo == numeroAleatorioPrimero) {
            numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosTonificar.size()));
        }

        while (numeroAleatorioTercero == numeroAleatorioPrimero || numeroAleatorioTercero == numeroAleatorioSegundo) {
            numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosTonificar.size()));
        }

        // Primer ejercicio
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).nombreEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).seriesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioPrimero).direccionVideoEjercicio);

        // Segundo ejercicio
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).nombreEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).descripcionEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).seriesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioSegundo).direccionVideoEjercicio);

        // Tercer ejercicio
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).nombreEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).seriesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosTonificar.get(numeroAleatorioTercero).direccionVideoEjercicio);

        return ejercicio;
    }

    public static void eliminarEjercicioTonificar(String nombreEjercicioEliminar) {
        if (listaEjerciciosTonificar.size() > 1) {
            for (int pos = 0; pos < listaEjerciciosTonificar.size(); pos++) {
                if (listaEjerciciosTonificar.get(pos).nombreEjercicio.equals(nombreEjercicioEliminar)) {
                    listaEjerciciosTonificar.remove(pos);
                    pos = listaEjerciciosTonificar.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas ejercicios, solo queda 1<html>");
        }
    }

    public static boolean existeEntrenamiento(String nombreEjercicio) {
        for (int pos = 0; pos < listaEjerciciosTonificar.size(); pos++) {
            if (listaEjerciciosTonificar.get(pos).nombreEjercicio.equals(nombreEjercicio)) {
                return true;
            }
        }

        return false;
    }

    public static int tamanoEntrenamientoAbdominales() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosTonificar.size(); pos++) {
            if (listaEjerciciosTonificar.get(pos).nombreGrupoMuscular.equals("Abdominales")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoEntrenamientoGluteos() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosTonificar.size(); pos++) {
            if (listaEjerciciosTonificar.get(pos).nombreGrupoMuscular.equals("Gluteos")) {
                tamano++;
            }
        }

        return tamano;
    }

}
