
// Clase ReservaJSON.java
import java.io.*;
import java.util.Vector;

public class ReservaJSON {
  public void escribirReserva(Reserva reserva, String nombreFichero) {
    try (FileWriter fichero = new FileWriter(nombreFichero); BufferedWriter escribir = new BufferedWriter(fichero)) {
      StringBuilder sb = new StringBuilder();

      sb.append("\t\"nombre\": \"" + reserva.getNombre() + "\",\n");
      sb.append("\t\"fechaEventp\": \"" + reserva.getFechaEvento() + "\",\n");
      sb.append("\t\"asistentes\": \"" + reserva.getAsistentes() + "\",\n");
      sb.append("\t\"tipoCocina\": \"" + reserva.getTipoCocina() + "\",\n");
      sb.append("\t\"numeroJornadas\": \"" + reserva.getNumeroJornadas() + "\",\n");
      sb.append("\t\"habitaciones\": \"" + reserva.getHabitaciones() + "\",\n");
      sb.append("\t\"tipoMesa\": \"" + reserva.getTipoMesa() + "\",\n");
      sb.append("\t\"comensalesMesa\": \"" + reserva.getComensalesMesa() + "\"\n");
      sb.toString();
      escribir.write("{\n \"reserva\":{ \n" + sb + "\t}\n}");
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
          String startTag = "\"" + valor + "\":\"";

          String endTag = "\",";

          Utilitis.modeloDatos.add(valor);
          int startIndex = linea.indexOf(startTag);
          int endIndex = linea.indexOf(endTag);
          if (startIndex == -1 || endIndex == -1) {
            endTag = "\"";
            endIndex = linea.indexOf(endTag, startIndex + startTag.length());
          }
          if (startIndex != -1 && endIndex != -1) {
            endTag = "\"";

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