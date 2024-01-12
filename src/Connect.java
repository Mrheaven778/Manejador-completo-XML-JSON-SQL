import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
  private String url = "";
  private String username;
  private String password;
  private Connection con;

  Connect(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public void connect() {
    try {
      this.con = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void disconnect() {
    try {
      if (this.con != null && !this.con.isClosed()) {
        this.con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void select(String query) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        System.out.println("Valor: " + rs.getString("nombre"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void insert(String query) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(String query) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String getUrl() {
    return this.url;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public Connection getConnection() {
    return this.con;
  }
}