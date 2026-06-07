package saps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiarioDAO {

    public boolean insertar(Beneficiario b) {
        String sql = "INSERT INTO beneficiarios (curp, nombre, apellido, direccion, municipio) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, b.getCurp());
            ps.setString(2, b.getNombre());
            ps.setString(3, b.getApellido());
            ps.setString(4, b.getDirection());
            ps.setString(5, b.getMunicipio());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar beneficiario: " + e.getMessage());
            return false;
        }
    }

    public List<Beneficiario> listar() {
        List<Beneficiario> lista = new ArrayList<>();
        String sql = "SELECT * FROM beneficiarios";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Beneficiario b = new Beneficiario(
                    rs.getInt("id_beneficiario"),
                    rs.getString("curp"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getString("municipio")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar beneficiarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean modificar(Beneficiario b) {
        String sql = "UPDATE beneficiarios SET curp = ?, nombre = ?, apellido = ?, direccion = ?, municipio = ? WHERE id_beneficiario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, b.getCurp());
            ps.setString(2, b.getNombre());
            ps.setString(3, b.getApellido());
            ps.setString(4, b.getDirection());
            ps.setString(5, b.getMunicipio());
            ps.setInt(6, b.getIdBeneficiario());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar beneficiario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM beneficiarios WHERE id_beneficiario = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar beneficiario: " + e.getMessage());
            return false;
        }
    }
}