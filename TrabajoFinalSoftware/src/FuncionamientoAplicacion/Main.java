package FuncionamientoAplicacion;

import java.util.ArrayList;

import DietasCuatroComidasDelDia.Domingo;
import DietasCuatroComidasDelDia.Jueves;
import DietasCuatroComidasDelDia.Lunes;
import DietasCuatroComidasDelDia.Martes;
import DietasCuatroComidasDelDia.Miercoles;
import DietasCuatroComidasDelDia.Sabado;
import DietasCuatroComidasDelDia.Viernes;
import InformacionAplicacionGeneral.Dietas;
import InformacionAplicacionGeneral.Entrenamiento;
import InformacionAplicacionGeneral.Recomendacion;
import InformacionPersona.Entrenadores;
import InformacionPersona.Usuario;
import Login.PanelUsuarioContrasena;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;

public class Main {

    public static void main(String[] args) {
        long inicio = System.nanoTime();
        long fin;
        Usuario.leerUsuariosDeBaseDatos();
        Entrenamiento.leerEntrenamientosDeBaseDatos();
        Dietas.leerDietasDeBaseDatos();
        Entrenadores.leerUsuariosEntrenadoresDeBaseDatos();
        Recomendacion.leerRecomendacionDeBaseDatos();

        anadirInformacionClasesGruposMusculares("Definir", "Hombros y espalda",
                Entrenamiento.recuperarValoresNivel3("Definir", "Hombros y espalda"));
        anadirInformacionClasesGruposMusculares("Definir", "Pierna",
                Entrenamiento.recuperarValoresNivel3("Definir", "Pierna"));

        anadirInformacionClasesGruposMusculares("Ganar musculo", "Brazo",
                Entrenamiento.recuperarValoresNivel3("Ganar musculo", "Brazo"));
        anadirInformacionClasesGruposMusculares("Ganar musculo", "Pecho",
                Entrenamiento.recuperarValoresNivel3("Ganar musculo", "Pecho"));

        anadirInformacionClasesGruposMusculares("Tonificar", "Abdominales",
                Entrenamiento.recuperarValoresNivel3("Tonificar", "Abdominales"));
        anadirInformacionClasesGruposMusculares("Tonificar", "Gluteos",
                Entrenamiento.recuperarValoresNivel3("Tonificar", "Gluteos"));

        anadirInformacionClasesDietas("Ganar peso", "Lunes", Dietas.recuperarValoresNivel3("Ganar peso", "Lunes"));
        anadirInformacionClasesDietas("Ganar peso", "Martes", Dietas.recuperarValoresNivel3("Ganar peso", "Martes"));
        anadirInformacionClasesDietas("Ganar peso", "Miercoles",
                Dietas.recuperarValoresNivel3("Ganar peso", "Miercoles"));
        anadirInformacionClasesDietas("Ganar peso", "Jueves", Dietas.recuperarValoresNivel3("Ganar peso", "Jueves"));
        anadirInformacionClasesDietas("Ganar peso", "Viernes", Dietas.recuperarValoresNivel3("Ganar peso", "Viernes"));
        anadirInformacionClasesDietas("Ganar peso", "Sabado", Dietas.recuperarValoresNivel3("Ganar peso", "Sabado"));
        anadirInformacionClasesDietas("Ganar peso", "Domingo", Dietas.recuperarValoresNivel3("Ganar peso", "Domingo"));

        anadirInformacionClasesDietas("Perder peso", "Lunes", Dietas.recuperarValoresNivel3("Perder peso", "Lunes"));
        anadirInformacionClasesDietas("Perder peso", "Martes", Dietas.recuperarValoresNivel3("Perder peso", "Martes"));
        anadirInformacionClasesDietas("Perder peso", "Miercoles",
                Dietas.recuperarValoresNivel3("Perder peso", "Miercoles"));
        anadirInformacionClasesDietas("Perder peso", "Jueves", Dietas.recuperarValoresNivel3("Perder peso", "Jueves"));
        anadirInformacionClasesDietas("Perder peso", "Viernes",
                Dietas.recuperarValoresNivel3("Perder peso", "Viernes"));
        anadirInformacionClasesDietas("Perder peso", "Sabado", Dietas.recuperarValoresNivel3("Perder peso", "Sabado"));
        anadirInformacionClasesDietas("Perder peso", "Domingo",
                Dietas.recuperarValoresNivel3("Perder peso", "Domingo"));

        anadirInformacionClasesDietas("Mantenerme", "Lunes", Dietas.recuperarValoresNivel3("Mantenerme", "Lunes"));
        anadirInformacionClasesDietas("Mantenerme", "Martes", Dietas.recuperarValoresNivel3("Mantenerme", "Martes"));
        anadirInformacionClasesDietas("Mantenerme", "Miercoles",
                Dietas.recuperarValoresNivel3("Mantenerme", "Miercoles"));
        anadirInformacionClasesDietas("Mantenerme", "Jueves", Dietas.recuperarValoresNivel3("Mantenerme", "Jueves"));
        anadirInformacionClasesDietas("Mantenerme", "Viernes", Dietas.recuperarValoresNivel3("Mantenerme", "Viernes"));
        anadirInformacionClasesDietas("Mantenerme", "Sabado", Dietas.recuperarValoresNivel3("Mantenerme", "Sabado"));
        anadirInformacionClasesDietas("Mantenerme", "Domingo", Dietas.recuperarValoresNivel3("Mantenerme", "Domingo"));

        fin = System.nanoTime();

        System.out.println("TIEMPO: " + (double) (fin - inicio) + " segundos");

        new PanelUsuarioContrasena();
    }

    public static void anadirInformacionClasesGruposMusculares(String tipoEntrenamiento, String nombreGrupoMuscular,
            ArrayList<String> valores) {
        int posElementos = 0;
        while (posElementos < valores.size()) {
            if (nombreGrupoMuscular.equals("Hombros y espalda") || nombreGrupoMuscular.equals("Pierna")) {
                new Definir(tipoEntrenamiento, nombreGrupoMuscular, valores.get(posElementos),
                        valores.get(posElementos + 1), valores.get(posElementos + 2), valores.get(posElementos + 3),
                        valores.get(posElementos + 4), valores.get(posElementos + 5));
                posElementos = posElementos + 6;
            } else if (nombreGrupoMuscular.equals("Brazo") || nombreGrupoMuscular.equals("Pecho")) {
                new GanarMusculo(tipoEntrenamiento, nombreGrupoMuscular, valores.get(posElementos),
                        valores.get(posElementos + 1), valores.get(posElementos + 2), valores.get(posElementos + 3),
                        valores.get(posElementos + 4), valores.get(posElementos + 5));
                posElementos = posElementos + 6;
            } else if (nombreGrupoMuscular.equals("Abdominales") || nombreGrupoMuscular.equals("Gluteos")) {
                new Tonificar(tipoEntrenamiento, nombreGrupoMuscular, valores.get(posElementos),
                        valores.get(posElementos + 1), valores.get(posElementos + 2), valores.get(posElementos + 3),
                        valores.get(posElementos + 4), valores.get(posElementos + 5));
                posElementos = posElementos + 6;
            }
        }
    }

    public static void anadirInformacionClasesDietas(String tipoDieta, String diaDeLaSemana,
            ArrayList<String> valores) {
        int posElementos = 0;

        while (posElementos < valores.size()) {
            if (diaDeLaSemana.equals("Lunes")) {
                new Lunes(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Martes")) {
                new Martes(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Miercoles")) {
                new Miercoles(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Jueves")) {
                new Jueves(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Viernes")) {
                new Viernes(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Sabado")) {
                new Sabado(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            } else if (diaDeLaSemana.equals("Domingo")) {
                new Domingo(tipoDieta, diaDeLaSemana, valores.get(posElementos), valores.get(posElementos + 1),
                        valores.get(posElementos + 2), valores.get(posElementos + 3));
                posElementos = posElementos + 4;
            }
        }
    }

}