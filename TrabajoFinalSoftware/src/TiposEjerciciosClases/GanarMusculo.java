package TiposEjerciciosClases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GanarMusculo {

    public static ArrayList<GanarMusculo> listaEjerciciosGanarMusculo = new ArrayList<GanarMusculo>();

    private String tipoEntrenamiento;
    private String nombreGrupoMuscular;
    private String nombreEjercicio;
    private String descripcionEjercicio;
    private String seriesEjercicio;
    private String repeticionesEjercicio;
    private String direccionImagenEjercicio;
    private String direccionVideoEjercicio;

    public GanarMusculo(String tipoEntrenamiento, String nombreGrupoMuscular, String nombreEjercicio,
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

        listaEjerciciosGanarMusculo.add(this);
    }

    public static ArrayList<String> tresEjercicioAleatorioGanarMusculo() {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaEjerciciosGanarMusculo.size()));
        int numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosGanarMusculo.size()));
        int numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosGanarMusculo.size()));

        while (numeroAleatorioSegundo == numeroAleatorioPrimero) {
            numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosGanarMusculo.size()));
        }

        while (numeroAleatorioTercero == numeroAleatorioPrimero || numeroAleatorioTercero == numeroAleatorioSegundo) {
            numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosGanarMusculo.size()));
        }

        // Primer ejercicio
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).nombreEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).seriesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioPrimero).direccionVideoEjercicio);

        // Segundo ejercicio
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).nombreEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).descripcionEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).seriesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioSegundo).direccionVideoEjercicio);

        // Tercer ejercicio
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).nombreEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).seriesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosGanarMusculo.get(numeroAleatorioTercero).direccionVideoEjercicio);

        return ejercicio;
    }

    public static void eliminarEjercicioGanarMusculo(String nombreEjercicioEliminar) {
        if (listaEjerciciosGanarMusculo.size() > 1) {
            for (int pos = 0; pos < listaEjerciciosGanarMusculo.size(); pos++) {
                if (listaEjerciciosGanarMusculo.get(pos).nombreEjercicio.equals(nombreEjercicioEliminar)) {
                    listaEjerciciosGanarMusculo.remove(pos);
                    pos = listaEjerciciosGanarMusculo.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas ejercicios, solo queda 1<html>");
        }
    }

    public static int tamanoEntrenamientoBrazo() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosGanarMusculo.size(); pos++) {
            if (listaEjerciciosGanarMusculo.get(pos).nombreGrupoMuscular.equals("Brazo")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoEntrenamientoPecho() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosGanarMusculo.size(); pos++) {
            if (listaEjerciciosGanarMusculo.get(pos).nombreGrupoMuscular.equals("Pecho")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static boolean existeEntrenamiento(String nombreEjercicio) {
        for (int pos = 0; pos < listaEjerciciosGanarMusculo.size(); pos++) {
            if (listaEjerciciosGanarMusculo.get(pos).nombreEjercicio.equals(nombreEjercicio)) {
                return true;
            }
        }

        return false;
    }

}
