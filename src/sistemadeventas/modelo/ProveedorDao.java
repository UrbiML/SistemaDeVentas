
package sistemadeventas.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs; 
    
    
    public boolean RegistrarProveedor(Proveedor pr) {
        String sql = "INSERT INTO proveedores(ruc, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            return true;
            
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public List ListarProveedor() {
        List<Proveedor> listaPr = new ArrayList();
        String sql = "SELECT * FROM proveedores";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getString("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon(rs.getString("razon"));
                listaPr.add(pr);
            }
            
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        return listaPr;
    }
    
    public boolean EliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id = ?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;            
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarProveedor(Proveedor pr) {
        String sql = "UPDATE proveedores SET ruc=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.setInt(6, pr.getId());
            ps.execute();
            return true;
                        
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch(SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
