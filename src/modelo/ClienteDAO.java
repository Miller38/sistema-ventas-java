
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miller
 */
public class ClienteDAO implements CRUD<Cliente>{
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
// Metodo para listar los clientes
    @Override
    public List<Cliente> listar() {
       List<Cliente> lista = new ArrayList<>();
       
       String sql = "SELECT  * FROM tb_cliente";
        try {
            con = cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                
                lista.add(c);
            }
        } catch (Exception e) {
                 e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
// metodo para agregar clientes
    @Override
    public int add(Cliente cliente) {
        
        int r = 0;
        String sql = "INSERT INTO tb_cliente (Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
             ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            
            r=ps.executeUpdate();
            
        } catch (Exception e) {     
             e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }   
        return r;
    }
// Metodo para actualizar clientes
    @Override
    public int actualizar(Cliente cliente) {
        
        int r = 0;
      String sql = "UPDATE tb_cliente SET Dni=?, Nombres=?, Direccion=?, Estado=?  WHERE IdCliente=?";
      
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
           ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.setInt(5, cliente.getId());
            
            r = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return r;
    }
// Metodo para eliminar el cliente
    @Override
    public void eliminar(int id) {
      String sql = "DELETE FROM tb_cliente WHERE IdCliente=?";
      
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
                 e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
    
}
