
package capaNegocio;

import capaDatos.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class Categoria {
    
    private int id;
    private String nombre;
    private String descripcion;
    private boolean vigente;
    
    private static DBConnection connection = new DBConnection();
    
    public static int generarCodigo() throws Exception {
        try {
            String query = "SELECT coalesce(MAX(id), 0) + 1 FROM categoria;";
            ResultSet rs = connection.consultarBD(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try {
            String query = "INSERT INTO categoria VALUES (" + this.id + ", '" + this.nombre + "', '" + this.descripcion + "', " + this.vigente + ");";
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Categoria buscar(int codigo) throws Exception {
        try {
            String query = "SELECT * FROM categoria WHERE id = " + codigo;
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(codigo);
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setVigente(rs.getBoolean("vigencia"));
                return categoria;
            } else {
                throw new Exception("No se encontró la categoria");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try {
            String query = "DELETE FROM categoria WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Categoria categoria) throws Exception {
        try {
            String query = "UPDATE categoria SET nombre = '" + categoria.getNombre() + "', descripcion = '" + categoria.getDescripcion() + "', vigencia = " + categoria.isVigente() + " WHERE id = " + this.id;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try {
            String query = "UPDATE categoria SET vigencia = FALSE WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<Categoria> listarTodo() throws Exception {
        ArrayList<Categoria> categorias = new ArrayList();
        String query = "SELECT * FROM categoria ORDER BY id;";
        ResultSet rs = connection.consultarBD(query);
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setDescripcion(rs.getString("descripcion"));
            categoria.setVigente(rs.getBoolean("vigencia"));
            categorias.add(categoria);
        }
        return categorias;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
}
