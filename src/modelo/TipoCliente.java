
package modelo;

import datos.IDBConnection;
import static datos.IDBConnection.conectarBD;
import java.util.ArrayList;

public class TipoCliente implements IDBConnection {
    
    private int id;
    private String nombre;
    
    public static ArrayList<TipoCliente> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var tiposCliente = new ArrayList<TipoCliente>();
            var query = "SELECT * FROM tipo_cliente";
            var resultSet = connection.createStatement().executeQuery(query);
            
            while (resultSet.next()) {
                var tipoCliente = new TipoCliente();
                    tipoCliente.setId(resultSet.getInt("id"));
                    tipoCliente.setNombre(resultSet.getString("nombre"));
                    
                tiposCliente.add(tipoCliente);
            }
            
            return tiposCliente;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        
        if (getClass() != object.getClass()) return false;
        
        var aux = (TipoCliente) object;
        
        return this.id == aux.id;
    }
    
}
