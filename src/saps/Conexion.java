package saps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {    
    private static final String BD = "saps_db";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD + "?useSSL=false&serverTimezone=UTC";    
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456@mario.com"; 

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa en la BD: " + BD);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MySQL (verifica las librerías).");
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar conectar a la base de datos.");
        }
        return con;
    }
}