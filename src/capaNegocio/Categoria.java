
package capaNegocio;

import capaDatos.IDBConnection;
import static capaDatos.IDBConnection.conectarBD;
import java.util.ArrayList;

public class Categoria implements IDBConnection {
    
    private int id;
    private String nombre;
    private String descripcion;
    private boolean vigente;
    
    public static int generarCodigo() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT coalesce(MAX(id), 0) + 1 FROM categoria;";
            var resultSet = connection.createStatement().executeQuery(query);
                resultSet.next();
                
            return resultSet.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO categoria VALUES (?, ?, ?, ?);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                prepareStatement.setString(2, this.nombre);
                prepareStatement.setString(3, this.descripcion);
                prepareStatement.setBoolean(4, this.vigente);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Categoria buscar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM categoria WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var categoria = new Categoria();
                    categoria.setId(codigo);
                    categoria.setNombre(resultSet.getString("nombre"));
                    categoria.setDescripcion(resultSet.getString("descripcion"));
                    categoria.setVigente(resultSet.getBoolean("vigencia"));
                    
                return categoria;
            } else {
                throw new Exception("No se encontró la categoria");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "DELETE FROM categoria WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Categoria categoria) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE categoria SET nombre = ?, descripcion = ?, vigencia = ? WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, categoria.getNombre());
                prepareStatement.setString(2, categoria.getDescripcion());
                prepareStatement.setBoolean(3, categoria.isVigente());
                prepareStatement.setInt(1, this.id);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE categoria SET vigencia = FALSE WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Categoria> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var categorias = new ArrayList<Categoria>();
            var query = "SELECT * FROM categoria ORDER BY id;";
            var resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                var categoria = new Categoria();
                    categoria.setId(resultSet.getInt("id"));
                    categoria.setNombre(resultSet.getString("nombre"));
                    categoria.setDescripcion(resultSet.getString("descripcion"));
                    categoria.setVigente(resultSet.getBoolean("vigencia"));
                    
                categorias.add(categoria);
            }
            return categorias;
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
