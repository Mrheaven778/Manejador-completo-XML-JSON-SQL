
// Clase ReservaXML.java
import java.io.*;
import java.util.Vector;

public class ReservaXML {
  public void escribirReserva(String nombreFichero) {

    try (FileWriter fichero = new FileWriter(nombreFichero);
        BufferedWriter escribir = new BufferedWriter(fichero)) {
      StringBuilder db = new StringBuilder();
      int contador = 0;
      for (String dato : Utilitis.datosXml) {
        db.append(
            "<" + Utilitis.modeloDatos.get(contador) + ">" + dato + "</" + Utilitis.modeloDatos.get(contador) + ">\n");
        contador++;
      }
      db.toString();
      escribir.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<reserva>\n" + db + "</reserva>\n");
    } catch (Exception e) {
      e.printStackTrace();

    }

  }

  public Reserva leerReserva(String nombreFichero) {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

      String linea;
      Vector<String> valores = new Vector<>();
      Utilitis.insertarModelo(valores);
      Reserva reserva = new Reserva();
      while ((linea = br.readLine()) != null) {
        for (String valor : valores) {
          String startTag = "<" + valor + ">";
          String endTag = "</" + valor + ">";
          Utilitis.modeloDatos.add(valor);
          int startIndex = linea.indexOf(startTag);
          int endIndex = linea.indexOf(endTag);
          if (startIndex != -1 && endIndex != -1) {
            String dato = linea.substring(startIndex + startTag.length(), endIndex).trim();
            switch (valor) {
              case "nombre":
                reserva.setNombre(dato);
                break;
              case "fechaEvento":
                reserva.setFechaEvento(dato);
                break;
              case "asistentes":
                reserva.setAsistentes(dato);
                break;
              case "tipoCocina":
                reserva.setTipoCocina(dato);
                break;
              case "numeroJornadas":
                reserva.setNumeroJornadas(dato);
                break;
              case "habitaciones":
                reserva.setHabitaciones(dato);
                break;
              case "tipoMesa":
                reserva.setTipoMesa(dato);
                break;
              case "comensalesMesa":
                reserva.setComensalesMesa(dato);
                break;
            }
            Utilitis.datosXml.add(dato);
          }
        }
      }
      Reservas.reservasTotales.add(reserva);
      return reserva;

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}