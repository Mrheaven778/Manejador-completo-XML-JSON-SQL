
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Vector;

public class Utilitis {
  public static Vector<String> modeloDatos = new Vector<>();
  public static Vector<String> datosXml = new Vector<>();

  public static void insertarModelo(Vector listaModelo) {
    // crearFichero(nombreFicharoModelo);
    listaModelo.add("nombre");
    listaModelo.add("fechaEvento");
    listaModelo.add("asistentes");
    listaModelo.add("tipoCocina");
    listaModelo.add("numeroJornadas");
    listaModelo.add("habitaciones");
    listaModelo.add("tipoMesa");
    listaModelo.add("comensalesMesa");
  }

  public static int leerEntero() {
    int entero = 0;
    try {
      entero = Integer.parseInt(leerCadena());
    } catch (Exception e) {
      System.out.println("No has introducido un número entero");
    }
    return entero;
  }

  public static String leerCadena() {
    String cadena = "";
    try {
      cadena = new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
    } catch (Exception e) {
      System.out.println("Error al leer la cadena");
    }
    return cadena;
  }

  public static void escribirFicheroJson(String ficheroEscrobir) {
    try (FileWriter fichero = new FileWriter(ficheroEscrobir); BufferedWriter escribir = new BufferedWriter(fichero)) {
      escribir.write("{\n" +
          "  \"reserva\":{\n" +
          "    \"nombre\":\"Julio Semper Barcena\",\n" +
          "    \"fechaEvento\":\"22/4/2023\",\n" +
          "    \"tipo\":\"Banquete\",\n" +
          "    \"asistentes\":\"5\",\n" +
          "    \"tipoCocina\":\"carta\",\n" +
          "    \"numeroJornadas\":\"18\",\n" +
          "    \"habitaciones\":\"4\",\n" +
          "    \"tipoMesa\":\"redonda\",\n" +
          "    \"comensalesMesa\":\"5\"\n" +
          "  }\n" +
          "}");
    } catch (Exception e) {
      e.printStackTrace();

    }
  }

  public static void escribirFicheroXML(String fichoEscrobir) {
    try (FileWriter fichero = new FileWriter(fichoEscrobir); BufferedWriter escribir = new BufferedWriter(fichero)) {
      escribir.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
          "<reserva>\n" +
          "    <nombre>Julio Semper Barcena</nombre>\n" +
          "    <fechaEvento>22/4/2023</fechaEvento>\n" +
          "    <tipo>Banquete</tipo>\n" +
          "    <asistentes>5</asistentes>\n" +
          "    <tipoCocina>carta</tipoCocina>\n" +
          "    <numeroJornadas>18</numeroJornadas>\n" +
          "    <habitaciones>4</habitaciones>\n" +
          "    <tipoMesa>redonda</tipoMesa>\n" +
          "    <comensalesMesa>5</comensalesMesa>\n" +
          "</reserva>");
    } catch (Exception e) {
      e.printStackTrace();

    }
  }

  public static Reserva leerReservaXML() {
    ReservaXML reservaXML = new ReservaXML();
    return reservaXML.leerReserva("reservas.xml");
  }

  public static Reserva leerReservaJSON() {
    ReservaJSON reservaJSON = new ReservaJSON();
    return reservaJSON.leerReserva("reservas.json");
  }

  public static void escribirReservaJSON(Reserva reserva) {
    ReservaJSON reservaJSON = new ReservaJSON();
    reservaJSON.escribirReserva(reserva, "JSON.json");
  }

  public static void escribirReservaXML(Reserva reserva) {
    ReservaXML reservaXML = new ReservaXML();
    reservaXML.escribirReserva("XML.xml");
  }
}
