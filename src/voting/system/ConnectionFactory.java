package voting.system;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory  {
    public static final String URL = "jdbc:mysql://localhost:3306/voting";
    public static final String USER = "root";
    public static final String PASS = "root";
    String pass;


     /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
      try {
          Connection con = DriverManager.getConnection(URL, USER, PASS);
          return con;
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
    /**
     * Test Connection
     * @param args
     */
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }


}