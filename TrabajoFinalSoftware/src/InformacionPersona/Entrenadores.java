package InformacionPersona;

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

public class Entrenadores {

    private static ArrayList<Entrenadores> listaEntrenadores;

    private String usuarioEntrenador;
    private String nombre;
    private String apellidos;
    private String edad;
    private String email;
    private String contrasena;
    private String sexo;

    public Entrenadores(String usuarioEntrenador, String nombre, String apellidos, String edad, String email,
            String contrasena, String sexo) {
        this.usuarioEntrenador = usuarioEntrenador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.contrasena = contrasena;
        this.sexo = sexo;

        listaEntrenadores.add(this);
    }

    public static void leerUsuariosEntrenadoresDeBaseDatos() {
        try {
            URL urlLectura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/entrenadores.json?print=pretty");
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

                    cargarUsuariosEnArray(resultado.toString());
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

    private static void cargarUsuariosEnArray(String cadenaJSON) {
        char[] chars = cadenaJSON.toCharArray();

        listaEntrenadores = new ArrayList<Entrenadores>();
        Boolean primeraLlaveNivel_1 = false;
        Boolean primeraLlaveNivel_2 = false;
        Boolean abiertaComilla = false;
        Boolean dato_1_pendiente = true;
        Boolean dato_2_pendiente = true;
        Boolean dato_3_pendiente = true;
        Boolean dato_4_pendiente = true;
        Boolean dato_5_pendiente = true;
        Boolean dato_6_pendiente = true;
        String valorDato_1 = "";
        String valorDato_2 = "";
        String valorDato_3 = "";
        String valorDato_4 = "";
        String valorDato_5 = "";
        String valorDato_6 = "";
        String valorDato_7 = "";
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
                } else if (dato_5_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_5_pendiente = false;
                        valorDato_5 = cadenaValor;
                    }
                } else if (dato_6_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_6_pendiente = false;
                        valorDato_6 = cadenaValor;
                    }
                } else {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        valorDato_7 = cadenaValor;
                        new Entrenadores(valorDato_1, valorDato_2, valorDato_3, valorDato_4, valorDato_5, valorDato_6,
                                valorDato_7);

                        dato_1_pendiente = true;
                        dato_2_pendiente = true;
                        dato_3_pendiente = true;
                        dato_4_pendiente = true;
                        dato_5_pendiente = true;
                        dato_6_pendiente = true;
                    }
                }
            }
        }
    }

    public static void guardarUsuariosEntrenadoresEnBaseDatos() {
        String comillaDoble = "\"";
        String cadenaJSON = "{";

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            cadenaJSON = cadenaJSON + comillaDoble + listaEntrenadores.get(i).usuarioEntrenador + comillaDoble + ":{";
            cadenaJSON = cadenaJSON + comillaDoble + "01-Nombre" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).nombre + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "02-Apellidos" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).apellidos + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "03-Edad" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).edad + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "04-Email" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).email + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "05-Contraseña" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).contrasena + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "06-Sexo" + comillaDoble + ":" + comillaDoble
                    + listaEntrenadores.get(i).sexo + comillaDoble;

            if (i != listaEntrenadores.size() - 1) {
                cadenaJSON = cadenaJSON + "},";
            } else {
                cadenaJSON = cadenaJSON + "}";
            }
        }

        cadenaJSON = cadenaJSON + "}";

        URL urlEscritura;
        try {
            urlEscritura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/entrenadores.json");
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

    public static Entrenadores recuperarUsuarioEntrenador(String nombreUsuario) {
        for (int pos = 0; pos < listaEntrenadores.size(); pos++) {
            if (listaEntrenadores.get(pos).usuarioEntrenador.equals(nombreUsuario)) {
                return listaEntrenadores.get(pos);
            }
        }

        return null;
    }

    public void mostrarInformacionEntrenador() {
        System.out.println("Usuario entrenador " + usuarioEntrenador);
        System.out.println("Nombre " + nombre);
        System.out.println("Apellidos " + apellidos);
        System.out.println("Edad " + edad);
        System.out.println("Email " + email);
        System.out.println("Contrasena " + contrasena);
        System.out.println("Sexo " + sexo);
    }

    public String getUsuarioEntrenador() {
        return usuarioEntrenador;
    }

    public void setUsuarioEntrenador(String usuarioEntrenador) {
        this.usuarioEntrenador = usuarioEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
