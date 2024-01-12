public class App {

  public static void main(String[] args) {
    Utilitis.escribirFicheroJson("reservas.json");
    Utilitis.escribirFicheroXML("reservas.xml");
    System.out.println("Bienvenido al programa de reservas");
    System.out.println("Que desas leer un xml o un json?\n1 leer xml 2 leer json");
    int opcion = Utilitis.leerEntero();
    Reserva reserva = null;
    if (opcion == 1) {
      reserva = Utilitis.leerReservaXML();
    } else if (opcion == 2) {
      reserva = Utilitis.leerReservaJSON();
    }
    if (reserva != null) {
      System.out.println("En que deseas convertir la reserva?\n1 json 2 xml 3 insertar en la base de datos");
      opcion = Utilitis.leerEntero();
      if (opcion == 1) {
        Utilitis.escribirReservaJSON(reserva);
      } else if (opcion == 2) {
        Utilitis.escribirReservaXML(reserva);
      } else if (opcion == 3) {
        Reservas.insertarReservaDB(reserva);
      }
    }
  }
}
