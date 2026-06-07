package saps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public boolean registrar(Usuario u) {
        String sql = "INSERT INTO usuarios (username, password, nombre_completo, rol) VALUES (?, SHA2(?, 256), ?, ?)";
        
        try (Connection con = Conexion.getConexion()) {
            
            if (con == null) {
                JOptionPane.showMessageDialog(null, 
                    "Error de Conexión: No se pudo conectar a MySQL.\nVerifica que XAMPP/WampServer esté encendido.", 
                    "Fallo de Conexión", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, u.getUsername());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getNombreCompleto());
                ps.setString(4, u.getRol());
                
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error de MySQL al Registrar: " + e.getMessage(), 
                "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = SHA2(?, 256)";
        
        try (Connection con = Conexion.getConexion()) {
            
            if (con == null) {
                JOptionPane.showMessageDialog(null, 
                    "Error de Conexión: No se puede validar el inicio de sesión porque no hay comunicación con MySQL.", 
                    "Fallo de Conexión", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Usuario u = new Usuario();
                        u.setIdUsuario(rs.getInt("id_usuario"));
                        u.setUsername(rs.getString("username"));
                        u.setNombreCompleto(rs.getString("nombre_completo"));
                        u.setRol(rs.getString("rol"));
                        return u;
                    }
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error de MySQL en Login: " + e.getMessage(), 
                "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}