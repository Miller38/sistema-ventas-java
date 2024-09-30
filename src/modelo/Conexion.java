package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miller
 */
public class Conexion {

    // Definir la variable de conexión y los parámetros de conexión
    private Connection con;
    private final String url = "jdbc:mysql://localhost:33065/bd_sistema_ventas?useSSL=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "";

    // Método para conectar a la base de datos
    public Connection Conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar establecer la conexión
            con = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            // Mostrar el error si ocurre
            e.printStackTrace();
        }

        // Retornar la conexión
        return con;
    }
}
