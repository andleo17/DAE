
package capaNegocio;

import capaDatos.IDBConnection;
import static capaDatos.IDBConnection.conectarBD;
import java.util.ArrayList;

public class Marca implements IDBConnection {
    
    private int id;
    private String nombre;
    private boolean vigente;

    public static int generarCodigo() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT coalesce(MAX(id), 0) + 1 FROM marca;";
            var rs = connection.createStatement().executeQuery(query);
                rs.next();
                
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO marca VALUES (?, ?, ?);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                prepareStatement.setString(2, this.nombre);
                prepareStatement.setBoolean(3, this.vigente);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Marca buscar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM marca WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            var rs = prepareStatement.executeQuery();
            if (rs.next()) {
                var marca = new Marca();
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
        try (var connection = conectarBD()) {
            var query = "DELETE FROM marca WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Marca marca) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE marca SET nombre = ?, vigencia = ? WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, marca.getNombre());
                prepareStatement.setBoolean(2, this.vigente);
                prepareStatement.setInt(3, this.id);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE marca SET vigencia = FALSE WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static ArrayList<Marca> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var marcas = new ArrayList<Marca>();
            var query = "SELECT * FROM marca ORDER BY id;";
            var resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                var marca = new Marca();
                    marca.setId(resultSet.getInt("id"));
                    marca.setNombre(resultSet.getString("nombre"));
                    marca.setVigente(resultSet.getBoolean("vigencia"));
                    
                marcas.add(marca);
            }
            return marcas;
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

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
}
