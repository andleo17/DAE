
package capaNegocio;

import capaDatos.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class Marca {
    
    private static final DBConnection connection = new DBConnection();
    private int id;
    private String nombre;
    private boolean vigente;

    public static int generarCodigo() throws Exception {
        try {
            String query = "SELECT coalesce(MAX(id), 0) + 1 FROM marca;";
            ResultSet rs = connection.consultarBD(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try {
            String query = "INSERT INTO marca VALUES (" + this.id + ", '" + this.nombre + "', " + this.vigente + ");";
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Marca buscar(int codigo) throws Exception {
        try {
            String query = "SELECT * FROM marca WHERE id = " + codigo;
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                Marca marca = new Marca();
                marca.setId(codigo);
                marca.setNombre(rs.getString("nombre"));
                marca.setVigente(rs.getBoolean("vigencia"));
                return marca;
            } else {
                throw new Exception("No se encontró la marca");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try {
            String query = "DELETE FROM marca WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Marca marca) throws Exception {
        try {
            String query = "UPDATE marca SET nombre = '" + marca.getNombre() + "', vigencia = " + marca.isVigente() + " WHERE id = " + this.id;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try {
            String query = "UPDATE marca SET vigencia = FALSE WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<Marca> listarTodo() throws Exception {
        ArrayList<Marca> marcas = new ArrayList();
        String query = "SELECT * FROM marca ORDER BY id;";
        ResultSet rs = connection.consultarBD(query);
        while (rs.next()) {
            Marca marca = new Marca();
            marca.setId(rs.getInt("id"));
            marca.setNombre(rs.getString("nombre"));
            marca.setVigente(rs.getBoolean("vigencia"));
            marcas.add(marca);
        }
        return marcas;
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

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
}
