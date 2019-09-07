
package capaDatos;

import java.sql.*;

public class DBConnection {
    
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/bdprogramacion";
    private final String user = "postgres";
    private final String password = "USAT2019";
    private Connection connection = null;
    private Statement statement = null;
    
    public void conectarBD() throws Exception {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectar a la base de datos");
        }
    }
    
    public void desconectarBD() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Error al desconectar a la base de datos");
        }
    }
    
    public void ejecutarBD(String query) throws Exception {
        try {
            conectarBD();
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta");
        } finally {
            if (connection != null) desconectarBD();
        }
    }
    
    public ResultSet consultarBD(String query) throws Exception {
        ResultSet rs = null;
        try {
            conectarBD();
            rs = connection.createStatement().executeQuery(query);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta");
        } finally {
            if (connection != null) desconectarBD();
        }
    }
    
}
