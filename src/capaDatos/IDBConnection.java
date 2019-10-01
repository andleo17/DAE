
package capaDatos;

import java.sql.*;

public interface IDBConnection {
    
    String DRIVER = "org.postgresql.Driver";
    String DATABASE = "bdprogramacion";
    String HOST = "localhost";
    String PORT = "5432";
    String URL = String.format("jdbc:postgresql://%s:%s/%s", HOST, PORT, DATABASE);
    String USER = "postgres";
    String PASSWORD = "USAT2019";
    //String PASSWORD = "123456789";
    
    static Connection conectarBD() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
