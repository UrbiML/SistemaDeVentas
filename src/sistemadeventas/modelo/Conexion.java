
package sistemadeventas.modelo;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class Conexion {
    
    Connection con;
    public Connection getConnection() {
        try {
            String myBD = "jdbc:mysql://localhost:3306/sistemaventas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    
}