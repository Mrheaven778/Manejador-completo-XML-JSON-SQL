import java.util.Vector;

public class Reservas {
  public static Vector<Reserva> reservasTotales = new Vector<>();

  public static void insertarReservaDB(Reserva reserva) {
    Connect con = new Connect("jdbc:mysql://localhost:3306/reservas_db", "root", "root");
    con.connect();
    con.insert(
        "INSERT INTO Reservas (nombre, fecha_evento, tipo_cocina, n_jornadas, n_habitaciones, tipo_mesa, n_comensales) VALUES ('"
            + reserva.getNombre() + "', '"
            + reserva.getFechaEvento() + "', '"
            + reserva.getTipoCocina() + "', '"
            + reserva.getNumeroJornadas() + "', '"
            + reserva.getHabitaciones() + "', '"
            + reserva.getTipoMesa() + "', '"
            + reserva.getComensalesMesa() + "')");
    con.disconnect();
    System.out.println("Reserva insertada en la base de datos");
  }
}
