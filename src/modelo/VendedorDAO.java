
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Miller
 */
public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    
    
    Conexion con = new Conexion();
    Connection acceso;
    
    public EntidadVendedor ValidarVendedor(String dni, String user){
        EntidadVendedor entidadVendedor = new EntidadVendedor();
        String sql = "SELECT * FROM tb_vendedor WHERE Dni=? AND User=?";
        
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            
            ps.setString(1, dni);
            ps.setString(2, user);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                entidadVendedor.setId(rs.getInt(1));    
                entidadVendedor.setDni(rs.getString(2));
                entidadVendedor.setNom(rs.getString(3));
                entidadVendedor.setTel(rs.getString(4));
                entidadVendedor.setEstado(rs.getString(5));
                entidadVendedor.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return entidadVendedor;
    }
    
}
