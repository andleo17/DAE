
package capaNegocio;

import capaDatos.IDBConnection;
import static capaDatos.IDBConnection.conectarBD;
import java.util.ArrayList;

public class Producto implements IDBConnection {
    
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;
    private boolean vigente;
    private Marca marca;
    private Categoria categoria;

    public static int generarCodigo() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT coalesce(MAX(id), 0) + 1 FROM producto;";
            var resultSet = connection.createStatement().executeQuery(query);
                resultSet.next();
                
            return resultSet.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                prepareStatement.setString(2, this.nombre);
                prepareStatement.setString(3, this.descripcion);
                prepareStatement.setFloat(4, this.precio);
                prepareStatement.setInt(5, this.stock);
                prepareStatement.setBoolean(6, this.vigente);
                prepareStatement.setInt(7, this.marca.getId());
                prepareStatement.setInt(8, this.categoria.getId());
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Producto buscar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM producto "
                    + "INNER JOIN marca ON producto.marca_id = marca.id "
                    + "INNER JOIN categoria ON producto.categoria_id = categoria.id "
                    + "WHERE producto.id = ?;";
            
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var producto = new Producto();
                    producto.setId(resultSet.getInt(1));
                    producto.setNombre(resultSet.getString(2));
                    producto.setDescripcion(resultSet.getString(3));
                    producto.setPrecio(resultSet.getFloat(4));
                    producto.setStock(resultSet.getInt(5));
                    producto.setVigente(resultSet.getBoolean(6));
                    
                var marca = new Marca();
                    marca.setId(9);
                    marca.setNombre(resultSet.getString(10));
                    marca.setVigente(resultSet.getBoolean(11));
                    producto.setMarca(marca);
                    
                var categoria = new Categoria();
                    categoria.setId(resultSet.getInt(12));
                    categoria.setNombre(resultSet.getString(13));
                    categoria.setDescripcion(resultSet.getString(14));
                    categoria.setVigente(resultSet.getBoolean(15));
                    producto.setCategoria(categoria);
                    
                return producto;
            } else
                throw new Exception("No se encontró la marca");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "DELETE FROM producto WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Producto producto) throws Exception {
        try (var connection = conectarBD()) {
            String query = "UPDATE producto " +
                "SET nombre = ?, descripcion = ?, precio = ?, stock = ?, vigencia = ?, " +
                "marca_id = ?, categoria_id = ? " +
                "WHERE id = ?;";
            
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, producto.getNombre());
                prepareStatement.setString(2, producto.getDescripcion());
                prepareStatement.setFloat(3, producto.getPrecio());
                prepareStatement.setInt(4, producto.getStock());
                prepareStatement.setBoolean(5, producto.isVigente());
                prepareStatement.setInt(6, producto.getMarca().getId());
                prepareStatement.setInt(7, producto.getCategoria().getId());
                prepareStatement.setInt(8, this.id);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE producto SET vigencia = FALSE WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Producto> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var productos = new ArrayList<Producto>();
            var query = "SELECT * FROM producto "
                    + "INNER JOIN marca ON producto.marca_id = marca.id "
                    + "INNER JOIN categoria ON producto.categoria_id = categoria.id "
                    + "ORDER BY producto.id;";
            
            var resultSet = connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                var producto = new Producto();
                    producto.setId(resultSet.getInt(1));
                    producto.setNombre(resultSet.getString(2));
                    producto.setDescripcion(resultSet.getString(3));
                    producto.setPrecio(resultSet.getFloat(4));
                    producto.setStock(resultSet.getInt(5));
                    producto.setVigente(resultSet.getBoolean(6));
                    
                var marca = new Marca();
                    marca.setId(resultSet.getInt(9));
                    marca.setNombre(resultSet.getString(10));
                    marca.setVigente(resultSet.getBoolean(11));
                    producto.setMarca(marca);
                    
                var categoria = new Categoria();
                    categoria.setId(resultSet.getInt(12));
                    categoria.setNombre(resultSet.getString(13));
                    categoria.setDescripcion(resultSet.getString(14));
                    categoria.setVigente(resultSet.getBoolean(15));
                    producto.setCategoria(categoria);
                    
                productos.add(producto);
            }
            return productos;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
