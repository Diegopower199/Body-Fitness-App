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

public class Dietas {

    private static ArrayList<BinomioClaveValor> listaDietasFormatoFireBase = new ArrayList<BinomioClaveValor>();
    private static char[] caracteresDeEntrada;
    private static int indiceChar = 0;

    public static void leerDietasDeBaseDatos() {
        try {
            URL urlLectura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/dieta.json?print=pretty");
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

                    cargarDietasEnArray(resultado.toString());
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

    private static void cargarDietasEnArray(String cadenaJSON) {
        caracteresDeEntrada = cadenaJSON.toCharArray();

        indiceChar = 0;
        Boolean primeraLlaveNoEncontrada = true;

        while (primeraLlaveNoEncontrada) {
            if (caracteresDeEntrada[indiceChar] == '{') {
                leerDietas(listaDietasFormatoFireBase, 0);
                primeraLlaveNoEncontrada = false;
            } else {
                indiceChar++;
            }
        }

        visualizarNivelDeDatos(listaDietasFormatoFireBase, "");
    }

    private static void leerDietas(ArrayList<BinomioClaveValor> listaEntrenamientosFormatoFireBasePorSubnivel,
            int numeroLlavesAbiertas) {
        BinomioClaveValor nuevoBinomio = new BinomioClaveValor();
        listaEntrenamientosFormatoFireBasePorSubnivel.add(nuevoBinomio);
        String cadenaClave = "";
        String cadenaValor = "";
        Boolean claveNoProcesada = true;
        Boolean valorNoProcesado = true;
        int numeroDoblesComillas = 0;
        char caracter = caracteresDeEntrada[indiceChar];

        if (caracter == '{') {
            indiceChar++; // Avanzamos desde la llave de apertura.
            numeroLlavesAbiertas++;
        }

        while (caracter != '"') {
            indiceChar++;
            caracter = caracteresDeEntrada[indiceChar];
        }

        while (claveNoProcesada) {
            caracter = caracteresDeEntrada[indiceChar];

            if (caracter == '"') {
                numeroDoblesComillas++;
                indiceChar++;
            } else if (caracter == ':' && numeroDoblesComillas > 1) {
                nuevoBinomio.clave = cadenaClave;
                indiceChar++; // Avanzamos desde los 2 puntos :.
                claveNoProcesada = false;
            } else {
                if (numeroDoblesComillas < 2) {
                    cadenaClave = cadenaClave + caracteresDeEntrada[indiceChar];
                }

                indiceChar++;
            }
        }

        numeroDoblesComillas = 0;
        caracter = caracteresDeEntrada[indiceChar];

        while (caracter == ' ') {
            indiceChar++;
            caracter = caracteresDeEntrada[indiceChar];
        }

        if (caracter == '{') {
            nuevoBinomio.tipoValor = 2;
            leerDietas(nuevoBinomio.valorArrayBinomiosClaveValor, numeroLlavesAbiertas);
        } else {
            while (valorNoProcesado) {
                caracter = caracteresDeEntrada[indiceChar];

                if (caracter == '"') {
                    numeroDoblesComillas++;
                    indiceChar++;
                } else if ((caracter == ',' || caracter == '}') && numeroDoblesComillas > 1) {
                    nuevoBinomio.valorString = cadenaValor;
                    valorNoProcesado = false;
                } else {
                    if (numeroDoblesComillas < 2) {
                        cadenaValor = cadenaValor + caracteresDeEntrada[indiceChar];
                    }

                    indiceChar++;
                }
            }
        }

        caracter = caracteresDeEntrada[indiceChar];

        while (caracter != ',' && caracter != '}') {
            indiceChar++;
            caracter = caracteresDeEntrada[indiceChar];
        }

        if (caracteresDeEntrada[indiceChar] == '}') {
            indiceChar++; // Avanzamos desde la llave de cierre }.
            return;
        } else if (caracteresDeEntrada[indiceChar] == ',') {
            indiceChar++; // Avanzamos desde la coma.
            leerDietas(listaEntrenamientosFormatoFireBasePorSubnivel, numeroLlavesAbiertas);
        }

        return;
    }

    private static void visualizarNivelDeDatos(ArrayList<BinomioClaveValor> listaSubnivel, String indentacion) {
        for (int i = 0; i < listaSubnivel.size(); i++) {
            if (listaSubnivel.get(i).tipoValor == 2) {
                visualizarNivelDeDatos(listaSubnivel.get(i).valorArrayBinomiosClaveValor, indentacion + "......");
            }
        }

        return;
    }

    public static void guardarDietasEnBaseDatos() {
        String cadenaJSON = anadirNivelDeDatos(listaDietasFormatoFireBase);

        try {
            URL urlEscritura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/dieta.json");
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

    private static String anadirNivelDeDatos(ArrayList<BinomioClaveValor> listaSubnivel) {
        String comillaDoble = "\"";
        String cadenaJSON = "{";

        for (int i = 0; i < listaSubnivel.size(); i++) {
            cadenaJSON = cadenaJSON + comillaDoble + listaSubnivel.get(i).clave + comillaDoble + ":";

            if (listaSubnivel.get(i).tipoValor == 1) {
                cadenaJSON = cadenaJSON + comillaDoble + listaSubnivel.get(i).valorString + comillaDoble;
            } else {
                cadenaJSON = cadenaJSON + anadirNivelDeDatos(listaSubnivel.get(i).valorArrayBinomiosClaveValor);
            }

            if (i != listaSubnivel.size() - 1) {
                cadenaJSON = cadenaJSON + ",";
            }
        }

        cadenaJSON = cadenaJSON + "}";

        return cadenaJSON;
    }

    public static Boolean anadirNivel1(String nuevaClaveNivel1) {
        BinomioClaveValor nuevoBinomio = new BinomioClaveValor();
        listaDietasFormatoFireBase.add(nuevoBinomio);
        nuevoBinomio.clave = nuevaClaveNivel1;
        nuevoBinomio.tipoValor = 2;
        visualizarNivelDeDatos(listaDietasFormatoFireBase, "");

        return true;
    }

    public static Boolean anadirNivel2(String claveNivel1, String nuevaClaveNivel2) {
        for (int indice = 0; indice < listaDietasFormatoFireBase.size(); indice++) {
            if (listaDietasFormatoFireBase.get(indice).clave.equals(claveNivel1)) {
                BinomioClaveValor nuevoBinomio = new BinomioClaveValor();
                nuevoBinomio.clave = nuevaClaveNivel2;
                nuevoBinomio.tipoValor = 2;
                listaDietasFormatoFireBase.get(indice).valorArrayBinomiosClaveValor.add(nuevoBinomio);
                visualizarNivelDeDatos(listaDietasFormatoFireBase, "");
                return true;
            }
        }

        return false;
    }

    public static Boolean anadirNivel3(String claveNivel1, String claveNivel2, String nuevaClaveNivel3,
            String nuevoValorNivel3) {
        for (int indiceNivel1 = 0; indiceNivel1 < listaDietasFormatoFireBase.size(); indiceNivel1++) {
            if (listaDietasFormatoFireBase.get(indiceNivel1).clave.equals(claveNivel1)) {
                for (int indiceNivel2 = 0; indiceNivel2 < listaDietasFormatoFireBase
                        .get(indiceNivel1).valorArrayBinomiosClaveValor.size(); indiceNivel2++) {
                    if (listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                            .get(indiceNivel2).clave.equals(claveNivel2)) {

                        int tamanoArray = listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                .get(indiceNivel2).valorArrayBinomiosClaveValor.size() + 1;
                        BinomioClaveValor nuevoBinomio = new BinomioClaveValor();

                        if (tamanoArray < 10) {
                            nuevoBinomio.clave = "000" + tamanoArray + nuevaClaveNivel3;

                            nuevoBinomio.tipoValor = 1;
                            nuevoBinomio.valorString = nuevoValorNivel3;
                        } else if (tamanoArray >= 10 && tamanoArray < 100) {
                            nuevoBinomio.clave = "00" + tamanoArray + nuevaClaveNivel3;

                            nuevoBinomio.tipoValor = 1;
                            nuevoBinomio.valorString = nuevoValorNivel3;
                        }

                        listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                .get(indiceNivel2).valorArrayBinomiosClaveValor.add(nuevoBinomio);
                        visualizarNivelDeDatos(listaDietasFormatoFireBase, "");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static ArrayList<String> recuperarValoresNivel3(String claveNivel1, String claveNivel2) {
        ArrayList<String> resultado = new ArrayList<String>();

        for (int indiceNivel1 = 0; indiceNivel1 < listaDietasFormatoFireBase.size(); indiceNivel1++) {
            if (listaDietasFormatoFireBase.get(indiceNivel1).clave.equals(claveNivel1)) {
                for (int indiceNivel2 = 0; indiceNivel2 < listaDietasFormatoFireBase
                        .get(indiceNivel1).valorArrayBinomiosClaveValor.size(); indiceNivel2++) {
                    if (listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                            .get(indiceNivel2).clave.equals(claveNivel2)) {
                        for (int indiceNivel3 = 0; indiceNivel3 < listaDietasFormatoFireBase
                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                .get(indiceNivel2).valorArrayBinomiosClaveValor.size(); indiceNivel3++) {
                            resultado.add(listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).valorString);
                        }
                    }
                }
            }
        }

        return resultado;
    }

    public static ArrayList<BinomioClaveValor> eliminarBinomiosNivel3(String claveNivel1, String claveNivel2,
            String nombreEjercicioEliminar) {
        ArrayList<BinomioClaveValor> resultado = new ArrayList<BinomioClaveValor>();
        boolean cambiarPosicionesEjercicioEncontrado = false;
        int posicionDato = 0;

        for (int indiceNivel1 = 0; indiceNivel1 < listaDietasFormatoFireBase.size(); indiceNivel1++) {
            if (listaDietasFormatoFireBase.get(indiceNivel1).clave.equals(claveNivel1)) {
                for (int indiceNivel2 = 0; indiceNivel2 < listaDietasFormatoFireBase
                        .get(indiceNivel1).valorArrayBinomiosClaveValor.size(); indiceNivel2++) {
                    if (listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                            .get(indiceNivel2).clave.equals(claveNivel2)) {
                        for (int indiceNivel3 = 0; indiceNivel3 < listaDietasFormatoFireBase
                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                .get(indiceNivel2).valorArrayBinomiosClaveValor.size(); indiceNivel3++) {
                            BinomioClaveValor nuevoBinomio = new BinomioClaveValor();
                            nuevoBinomio.clave = listaDietasFormatoFireBase
                                    .get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).clave;
                            nuevoBinomio.tipoValor = 1;
                            nuevoBinomio.valorString = listaDietasFormatoFireBase
                                    .get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).valorString;
                            if (nuevoBinomio.valorString.equals(nombreEjercicioEliminar)) {
                                int posicionGuion = listaDietasFormatoFireBase
                                        .get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).clave
                                        .indexOf("-");
                                String sSubCadena = listaDietasFormatoFireBase
                                        .get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).clave
                                        .substring(0, posicionGuion);
                                posicionDato = Integer.parseInt(sSubCadena);

                                listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.remove(indiceNivel3);
                                listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.remove(indiceNivel3);
                                listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.remove(indiceNivel3);
                                listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                        .get(indiceNivel2).valorArrayBinomiosClaveValor.remove(indiceNivel3);

                                cambiarPosicionesEjercicioEncontrado = true;
                            }

                            if (listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.size() > indiceNivel3) {
                                if (cambiarPosicionesEjercicioEncontrado) {

                                    if (posicionDato < 10) {
                                        int posicionGuion = nuevoBinomio.clave.indexOf("-");

                                        nuevoBinomio.clave = "000" + posicionDato
                                                + listaDietasFormatoFireBase
                                                        .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel3).clave.substring(posicionGuion);
                                        nuevoBinomio.valorString = listaDietasFormatoFireBase
                                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .get(indiceNivel3).valorString;

                                        listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .set(indiceNivel3, nuevoBinomio);

                                        posicionDato++;
                                    } else if (posicionDato >= 10 && posicionDato < 100) {
                                        int posicionGuion = nuevoBinomio.clave.indexOf("-");

                                        nuevoBinomio.clave = "00" + posicionDato
                                                + listaDietasFormatoFireBase
                                                        .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel3).clave.substring(posicionGuion);
                                        nuevoBinomio.valorString = listaDietasFormatoFireBase
                                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .get(indiceNivel3).valorString;

                                        listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .set(indiceNivel3, nuevoBinomio);

                                        posicionDato++;
                                    } else if (posicionDato >= 100 && posicionDato <= 1000) {
                                        int posicionGuion = nuevoBinomio.clave.indexOf("-");

                                        nuevoBinomio.clave = "0" + posicionDato
                                                + listaDietasFormatoFireBase
                                                        .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                        .get(indiceNivel3).clave.substring(posicionGuion);
                                        nuevoBinomio.valorString = listaDietasFormatoFireBase
                                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .get(indiceNivel3).valorString;

                                        listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                                                .get(indiceNivel2).valorArrayBinomiosClaveValor
                                                .set(indiceNivel3, nuevoBinomio);

                                        posicionDato++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return resultado;
    }

    public static ArrayList<BinomioClaveValor> recuperarBinomiosNivel3(String claveNivel1, String claveNivel2) {
        ArrayList<BinomioClaveValor> resultado = new ArrayList<BinomioClaveValor>();

        for (int indiceNivel1 = 0; indiceNivel1 < listaDietasFormatoFireBase.size(); indiceNivel1++) {
            if (listaDietasFormatoFireBase.get(indiceNivel1).clave.equals(claveNivel1)) {
                for (int indiceNivel2 = 0; indiceNivel2 < listaDietasFormatoFireBase
                        .get(indiceNivel1).valorArrayBinomiosClaveValor.size(); indiceNivel2++) {
                    if (listaDietasFormatoFireBase.get(indiceNivel1).valorArrayBinomiosClaveValor
                            .get(indiceNivel2).clave.equals(claveNivel2)) {
                        for (int indiceNivel3 = 0; indiceNivel3 < listaDietasFormatoFireBase
                                .get(indiceNivel1).valorArrayBinomiosClaveValor
                                .get(indiceNivel2).valorArrayBinomiosClaveValor.size(); indiceNivel3++) {
                            BinomioClaveValor nuevoBinomio = new BinomioClaveValor();
                            nuevoBinomio.clave = listaDietasFormatoFireBase
                                    .get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).clave;
                            nuevoBinomio.tipoValor = 1;
                            nuevoBinomio.valorString = listaDietasFormatoFireBase
                                    .get(indiceNivel1).valorArrayBinomiosClaveValor
                                    .get(indiceNivel2).valorArrayBinomiosClaveValor.get(indiceNivel3).valorString;

                            resultado.add(nuevoBinomio);
                        }
                    }
                }
            }
        }

        return resultado;
    }

}
