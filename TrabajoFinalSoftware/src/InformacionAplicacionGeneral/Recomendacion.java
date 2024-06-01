package InformacionAplicacionGeneral;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Recomendacion {

    private static ArrayList<Recomendacion> listaRecomendacion;

    private String numeroRecomendacion;
    private String tipoEntrenamiento;
    private String grupoMuscular;
    private String nombreEjercicio;
    private String recomendacion;

    public Recomendacion(String numeroRecomendacion, String tipoEntrenamiento, String grupoMuscular,
            String nombreEjercicio, String recomendacion) {
        this.numeroRecomendacion = numeroRecomendacion;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.grupoMuscular = grupoMuscular;
        this.nombreEjercicio = nombreEjercicio;
        this.recomendacion = recomendacion;

        listaRecomendacion.add(this);
    }

    public static void leerRecomendacionDeBaseDatos() {
        try {
            URL urlLectura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/recomendacion.json?print=pretty");
            HttpURLConnection conexionLectura = (HttpURLConnection) urlLectura.openConnection();
            conexionLectura.setRequestMethod("GET");

            switch (conexionLectura.getResponseCode()) {
                case HttpURLConnection.HTTP_OK:
                    StringBuilder resultado = new StringBuilder();
                    InputStream in = new BufferedInputStream(conexionLectura.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        resultado.append(line).append("\n");
                    }

                    cargarRecomendacionEnArray(resultado.toString());
                    break;
                default:
                    System.out.println("Error de conexión. Codigo Respuesta: " + conexionLectura.getResponseCode());
                    break;
            }

            conexionLectura.disconnect();
        } catch (MalformedURLException ex) {
            System.err.println("MalformedURLException: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }
    }

    private static void cargarRecomendacionEnArray(String cadenaJSON) {
        char[] chars = cadenaJSON.toCharArray();

        listaRecomendacion = new ArrayList<Recomendacion>();
        Boolean primeraLlaveNivel_1 = false;
        Boolean primeraLlaveNivel_2 = false;
        Boolean abiertaComilla = false;
        Boolean dato_1_pendiente = true;
        Boolean dato_2_pendiente = true;
        Boolean dato_3_pendiente = true;
        Boolean dato_4_pendiente = true;
        String valorDato_1 = "";
        String valorDato_2 = "";
        String valorDato_3 = "";
        String valorDato_4 = "";
        String valorDato_5 = "";
        String cadenaValor = "";
        Boolean clavePendiente = true;

        for (char ch : chars) {
            if ((!primeraLlaveNivel_1) && ch == '{') {
                primeraLlaveNivel_1 = true;
            } else if (primeraLlaveNivel_1 && !(primeraLlaveNivel_2) && ch == '}') {
                break;
            } else if (primeraLlaveNivel_1 && ch == '{') {
                primeraLlaveNivel_2 = true;
            } else if (primeraLlaveNivel_2 && ch == '}') {
                primeraLlaveNivel_2 = false;
            } else if (!abiertaComilla && ch == '"') {
                abiertaComilla = true;
                cadenaValor = "";
            } else if (abiertaComilla && ch != '"') {
                cadenaValor = cadenaValor + ch;
            } else if (abiertaComilla && ch == '"') {
                abiertaComilla = false;

                if (dato_1_pendiente) {
                    dato_1_pendiente = false;
                    valorDato_1 = cadenaValor;

                } else if (dato_2_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_2_pendiente = false;
                        valorDato_2 = cadenaValor;
                    }
                } else if (dato_3_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_3_pendiente = false;
                        valorDato_3 = cadenaValor;
                    }
                } else if (dato_4_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_4_pendiente = false;
                        valorDato_4 = cadenaValor;
                    }
                } else {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        valorDato_5 = cadenaValor;
                        new Recomendacion(valorDato_1, valorDato_2, valorDato_3, valorDato_4, valorDato_5);

                        dato_1_pendiente = true;
                        dato_2_pendiente = true;
                        dato_3_pendiente = true;
                        dato_4_pendiente = true;
                    }
                }
            }
        }
    }

    public static void guardarRecomendacionEnBaseDatos() {
        String comillaDoble = "\"";
        String cadenaJSON = "{";

        for (int i = 0; i < listaRecomendacion.size(); i++) {
            cadenaJSON = cadenaJSON + comillaDoble + listaRecomendacion.get(i).numeroRecomendacion + comillaDoble
                    + ":{";
            cadenaJSON = cadenaJSON + comillaDoble + "01-Tipo entrenamiento" + comillaDoble + ":" + comillaDoble
                    + listaRecomendacion.get(i).tipoEntrenamiento + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "02-Grupo Muscular" + comillaDoble + ":" + comillaDoble
                    + listaRecomendacion.get(i).grupoMuscular + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "03-Nombre Ejercicio" + comillaDoble + ":" + comillaDoble
                    + listaRecomendacion.get(i).nombreEjercicio + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "04-Recomendacion" + comillaDoble + ":" + comillaDoble
                    + listaRecomendacion.get(i).recomendacion + comillaDoble;

            if (i != listaRecomendacion.size() - 1) {
                cadenaJSON = cadenaJSON + "},";
            } else {
                cadenaJSON = cadenaJSON + "}";
            }
        }

        cadenaJSON = cadenaJSON + "}";

        URL urlEscritura;
        try {
            urlEscritura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/recomendacion.json");
            HttpURLConnection conexionEscritura = (HttpURLConnection) urlEscritura.openConnection();
            conexionEscritura.setRequestMethod("PUT");
            conexionEscritura.setRequestProperty("Content-Type", "application/json; utf-8");
            conexionEscritura.setRequestProperty("Accept", "application/json");
            conexionEscritura.setDoOutput(true);
            byte[] salida = cadenaJSON.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = conexionEscritura.getOutputStream();
            stream.write(salida);

            conexionEscritura.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Recomendacion recuperarRecomendacion(String nombreUsuario) {
        for (int pos = 0; pos < listaRecomendacion.size(); pos++) {
            if (listaRecomendacion.get(pos).numeroRecomendacion.equals(nombreUsuario)) {
                return listaRecomendacion.get(pos);
            }
        }

        return null;
    }

    public static int tamanoArray() {
        return listaRecomendacion.size();
    }

    public void mostrarInformacionRecomendacion() {
        System.out.println("numeroRecomendacion " + numeroRecomendacion);
        System.out.println("tipoEntrenamiento " + tipoEntrenamiento);
        System.out.println("grupoMuscular " + grupoMuscular);
        System.out.println("nombreEjercicio " + nombreEjercicio);
        System.out.println("recomendacion " + recomendacion);
    }

}