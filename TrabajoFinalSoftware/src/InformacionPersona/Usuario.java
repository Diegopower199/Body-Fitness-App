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

public class Usuario {

    private static ArrayList<Usuario> listaUsuarios;

    private String usuario;
    private String nombre;
    private String apellidos;
    private String edad;
    private String peso;
    private String altura;
    private String email;
    private String contrasena;
    private String IMC;
    private String porcentajeDeGrasaCorporal;
    private String entrenamientoElegido;
    private String sexo;
    private String dietaElegida;

    public Usuario(String usuario, String nombre, String apellidos, String edad, String peso, String altura,
            String email, String contrasena, String imc, String porcentajeGrasaCorporal, String entrenamientoElegido,
            String sexo, String dietaElegida) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
        this.contrasena = contrasena;
        this.IMC = imc;
        this.porcentajeDeGrasaCorporal = porcentajeGrasaCorporal;
        this.entrenamientoElegido = entrenamientoElegido;
        this.sexo = sexo;
        this.dietaElegida = dietaElegida;

        listaUsuarios.add(this);
    }

    public static void leerUsuariosDeBaseDatos() {
        try {
            URL urlLectura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/users.json?print=pretty");
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

        listaUsuarios = new ArrayList<Usuario>();
        Boolean primeraLlaveNivel_1 = false;
        Boolean primeraLlaveNivel_2 = false;
        Boolean abiertaComilla = false;
        Boolean dato_1_pendiente = true;
        Boolean dato_2_pendiente = true;
        Boolean dato_3_pendiente = true;
        Boolean dato_4_pendiente = true;
        Boolean dato_5_pendiente = true;
        Boolean dato_6_pendiente = true;
        Boolean dato_7_pendiente = true;
        Boolean dato_8_pendiente = true;
        Boolean dato_9_pendiente = true;
        Boolean dato_10_pendiente = true;
        Boolean dato_11_pendiente = true;
        Boolean dato_12_pendiente = true;
        String valorDato_1 = "";
        String valorDato_2 = "";
        String valorDato_3 = "";
        String valorDato_4 = "";
        String valorDato_5 = "";
        String valorDato_6 = "";
        String valorDato_7 = "";
        String valorDato_8 = "";
        String valorDato_9 = "";
        String valorDato_10 = "";
        String valorDato_11 = "";
        String valorDato_12 = "";
        String valorDato_13 = "";
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
                } else if (dato_7_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_7_pendiente = false;
                        valorDato_7 = cadenaValor;
                    }
                } else if (dato_8_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_8_pendiente = false;
                        valorDato_8 = cadenaValor;
                    }
                } else if (dato_9_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_9_pendiente = false;
                        valorDato_9 = cadenaValor;
                    }
                } else if (dato_10_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_10_pendiente = false;
                        valorDato_10 = cadenaValor;
                    }
                } else if (dato_11_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_11_pendiente = false;
                        valorDato_11 = cadenaValor;
                    }
                } else if (dato_12_pendiente) {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        dato_12_pendiente = false;
                        valorDato_12 = cadenaValor;
                    }
                } else {
                    if (clavePendiente) {
                        clavePendiente = false;
                    } else {
                        clavePendiente = true;
                        valorDato_13 = cadenaValor;
                        new Usuario(valorDato_1, valorDato_2, valorDato_3, valorDato_4, valorDato_5, valorDato_6,
                                valorDato_7, valorDato_8, valorDato_9, valorDato_10, valorDato_11, valorDato_12,
                                valorDato_13);

                        dato_1_pendiente = true;
                        dato_2_pendiente = true;
                        dato_3_pendiente = true;
                        dato_4_pendiente = true;
                        dato_5_pendiente = true;
                        dato_6_pendiente = true;
                        dato_7_pendiente = true;
                        dato_8_pendiente = true;
                        dato_9_pendiente = true;
                        dato_10_pendiente = true;
                        dato_11_pendiente = true;
                        dato_12_pendiente = true;
                    }
                }
            }
        }
    }

    public static void guardarUsuariosEnBaseDatos() {
        String comillaDoble = "\"";
        String cadenaJSON = "{";

        for (int i = 0; i < listaUsuarios.size(); i++) {
            cadenaJSON = cadenaJSON + comillaDoble + listaUsuarios.get(i).usuario + comillaDoble + ":{";
            cadenaJSON = cadenaJSON + comillaDoble + "01-Nombre" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).nombre + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "02-Apellidos" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).apellidos + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "03-Edad" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).edad + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "04-Peso" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).peso + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "05-Altura" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).altura + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "06-Email" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).email + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "07-Contraseña" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).contrasena + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "08-IMC" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).IMC + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "09-Porcentaje de grasa corporal" + comillaDoble + ":"
                    + comillaDoble + listaUsuarios.get(i).porcentajeDeGrasaCorporal + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "10-Entrenamiento elegido" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).entrenamientoElegido + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "11-Sexo" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).sexo + comillaDoble + ",";
            cadenaJSON = cadenaJSON + comillaDoble + "12-Dieta elegida" + comillaDoble + ":" + comillaDoble
                    + listaUsuarios.get(i).dietaElegida + comillaDoble;

            if (i != listaUsuarios.size() - 1) {
                cadenaJSON = cadenaJSON + "},";
            } else {
                cadenaJSON = cadenaJSON + "}";
            }
        }

        cadenaJSON = cadenaJSON + "}";

        URL urlEscritura;
        try {
            urlEscritura = new URL(
                    "https://ingenieriadesoftware-2d0da-default-rtdb.europe-west1.firebasedatabase.app/users.json");
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

    public static Usuario recuperarUsuario(String nombreUsuario) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(nombreUsuario)) {
                return listaUsuarios.get(pos);
            }
        }

        return null;
    }

    public static Usuario recuperarUsuarioConEmail(String emailUsuario) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).email.equals(emailUsuario)) {
                return listaUsuarios.get(pos);
            }
        }

        return null;
    }

    public static boolean existeUsuario(String nombreUsuario) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(nombreUsuario)) {
                return true;
            }
        }

        return false;
    }

    public static boolean existeCorreoConUsuario(String correoUsuario) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).email.equals(correoUsuario)) {
                return true;
            }
        }

        return false;
    }

    public static void cambiarContrasenaUsuario(String usuario, String contrasenaNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).contrasena = contrasenaNueva;
            }
        }
    }

    public static void cambiarNombreUsuario(String usuario, String nombreNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).nombre = nombreNueva;
            }
        }
    }

    public static void cambiarEdadUsuario(String usuario, String edadNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).edad = edadNueva;
            }
        }
    }

    public static void cambiarApellidoUsuario(String usuario, String apellidoNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).apellidos = apellidoNueva;
            }
        }
    }

    public static void cambiarEmailUsuario(String usuario, String emailNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).email = emailNueva;
            }
        }
    }

    public static void cambiarPesoUsuario(String usuario, String pesoNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).peso = pesoNueva;
            }
        }
    }

    public static void cambiarAlturaUsuario(String usuario, String alturaNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).altura = alturaNueva;
            }
        }
    }

    public static void cambiarEntrenamientoElegidoUsuario(String usuario, String entrenamientoElegidoNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).entrenamientoElegido = entrenamientoElegidoNueva;
            }
        }
    }

    public static void cambiarDietaElegidaUsuario(String usuario, String dietaElegidaNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).dietaElegida = dietaElegidaNueva;
            }
        }
    }

    public static void cambiarSexoUsuario(String usuario, String sexoNueva) {
        for (int pos = 0; pos < listaUsuarios.size(); pos++) {
            if (listaUsuarios.get(pos).usuario.equals(usuario)) {
                listaUsuarios.get(pos).sexo = sexoNueva;
            }
        }
    }

    public void mostrarInformacionUsuario() {
        System.out.println("Usuario " + usuario);
        System.out.println("Nombre " + nombre);
        System.out.println("Apellidos " + apellidos);
        System.out.println("Edad " + edad);
        System.out.println("Peso " + peso);
        System.out.println("Altura " + altura);
        System.out.println("Email " + email);
        System.out.println("Contrasena " + contrasena);
        System.out.println("IMC " + IMC);
        System.out.println("PorcentajeDeGrasaCorporal " + porcentajeDeGrasaCorporal);
        System.out.println("EntrenamientoElegido " + entrenamientoElegido);
        System.out.println("Sexo " + sexo);
    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String iMC) {
        IMC = iMC;
    }

    public String getPorcentajeDeGrasaCorporal() {
        return porcentajeDeGrasaCorporal;
    }

    public void setPorcentajeDeGrasaCorporal(String porcentajeDeGrasaCorporal) {
        this.porcentajeDeGrasaCorporal = porcentajeDeGrasaCorporal;
    }

    public String getEntrenamientoElegido() {
        return entrenamientoElegido;
    }

    public void setEntrenamientoElegido(String entrenamientoElegido) {
        this.entrenamientoElegido = entrenamientoElegido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDietaElegida() {
        return dietaElegida;
    }

    public void setDietaElegida(String dietaElegida) {
        this.dietaElegida = dietaElegida;
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
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

}
