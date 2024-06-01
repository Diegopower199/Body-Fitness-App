package TiposEjerciciosClases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Definir {

    public static ArrayList<Definir> listaEjerciciosDefinir = new ArrayList<Definir>();

    private String tipoEntrenamiento;
    private String nombreGrupoMuscular;
    private String nombreEjercicio;
    private String descripcionEjercicio;
    private String seriesEjercicio;
    private String repeticionesEjercicio;
    private String direccionImagenEjercicio;
    private String direccionVideoEjercicio;

    public Definir(String tipoEntrenamiento, String nombreGrupoMuscular, String nombreEjercicio,
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

        listaEjerciciosDefinir.add(this);
    }

    public static ArrayList<String> tresEjercicioAleatorioDefinir() {
        ArrayList<String> ejercicio = new ArrayList<String>();
        int numeroAleatorioPrimero = (int) (Math.random() * (listaEjerciciosDefinir.size()));
        int numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosDefinir.size()));
        int numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosDefinir.size()));

        while (numeroAleatorioSegundo == numeroAleatorioPrimero) {
            numeroAleatorioSegundo = (int) (Math.random() * (listaEjerciciosDefinir.size()));
        }

        while (numeroAleatorioTercero == numeroAleatorioPrimero || numeroAleatorioTercero == numeroAleatorioSegundo) {
            numeroAleatorioTercero = (int) (Math.random() * (listaEjerciciosDefinir.size()));
        }

        // Primer ejercicio
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).nombreEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).seriesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioPrimero).direccionVideoEjercicio);

        // Segundo ejercicio
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).nombreEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).descripcionEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).seriesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioSegundo).direccionVideoEjercicio);

        // Tercer ejercicio
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).tipoEntrenamiento);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).nombreGrupoMuscular);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).nombreEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).descripcionEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).seriesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).repeticionesEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).direccionImagenEjercicio);
        ejercicio.add(listaEjerciciosDefinir.get(numeroAleatorioTercero).direccionVideoEjercicio);

        return ejercicio;
    }

    public static void eliminarEjercicioDefinir(String nombreEjercicioEliminar) {
        if (listaEjerciciosDefinir.size() > 1) {
            for (int pos = 0; pos < listaEjerciciosDefinir.size(); pos++) {
                if (listaEjerciciosDefinir.get(pos).nombreEjercicio.equals(nombreEjercicioEliminar)) {
                    listaEjerciciosDefinir.remove(pos);
                    pos = listaEjerciciosDefinir.size();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html>No puedes eliminar mas ejercicios, solo queda 1<html>");
        }
    }

    public static int tamanoEntrenamientoHombrosYEspalda() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosDefinir.size(); pos++) {
            if (listaEjerciciosDefinir.get(pos).nombreGrupoMuscular.equals("Hombros y espalda")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static int tamanoEntrenamientoPierna() {
        int tamano = 0;
        for (int pos = 0; pos < listaEjerciciosDefinir.size(); pos++) {
            if (listaEjerciciosDefinir.get(pos).nombreGrupoMuscular.equals("Pierna")) {
                tamano++;
            }
        }

        return tamano;
    }

    public static boolean existeEntrenamiento(String nombreEjercicio) {
        for (int pos = 0; pos < listaEjerciciosDefinir.size(); pos++) {
            if (listaEjerciciosDefinir.get(pos).nombreEjercicio.equals(nombreEjercicio)) {
                return true;
            }
        }

        return false;
    }

}
