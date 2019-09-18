
package capaNegocio;

import capaDatos.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class Producto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;
    private boolean vigente;
    private Marca marca;
    private Categoria categoria;
    
    private static DBConnection connection = new DBConnection();
    
    public static int generarCodigo() throws Exception {
        try {
            String query = "SELECT coalesce(MAX(id), 0) + 1 FROM producto;";
            ResultSet rs = connection.consultarBD(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try {
            String query = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            connection.conectarBD();
            PreparedStatement ps = connection.connection.prepareStatement(query);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.descripcion);
            ps.setFloat(4, this.precio);
            ps.setInt(5, this.stock);
            ps.setBoolean(6, this.vigente);
            ps.setInt(7, this.marca.getId());
            ps.setInt(8, this.categoria.getId());
            ps.executeUpdate();
            connection.desconectarBD();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Producto buscar(int codigo) throws Exception {
        try {
            String query = "SELECT * FROM producto WHERE id = " + codigo;
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(codigo));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setVigente(rs.getBoolean("vigencia"));
                producto.setMarca(Marca.buscar(rs.getInt("marca_id")));
                producto.setCategoria(Categoria.buscar(rs.getInt("categoria_id")));
                return producto;
            } else {
                throw new Exception("No se encontró la marca");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try {
            String query = "DELETE FROM producto WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Producto producto) throws Exception {
        try {
            String query = "UPDATE producto " +
                "SET nombre = ?, descripcion = ?, precio = ?, stock = ?, vigencia = ?, " +
                "marca_id = ?, categoria_id = ? " +
                "WHERE id = ?;";
            connection.conectarBD();
            PreparedStatement ps = connection.connection.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isVigente());
            ps.setInt(6, producto.getMarca().getId());
            ps.setInt(7, producto.getCategoria().getId());
            ps.setInt(8, this.id);
            ps.executeUpdate();
            connection.desconectarBD();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try {
            String query = "UPDATE producto SET vigencia = FALSE WHERE id = " + codigo;
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Producto> listarTodo() throws Exception {
        ArrayList<Producto> productos = new ArrayList();
        String query = "SELECT * FROM producto "
                + "INNER JOIN marca ON producto.marca_id = marca.id "
                + "INNER JOIN categoria ON producto.categoria_id = categoria.id "
                + "ORDER BY producto.id;";
        ResultSet rs = connection.consultarBD(query);
        while(rs.next()) {
            Producto producto = new Producto();
            Marca marca = new Marca();
            Categoria categoria = new Categoria();
            producto.setId(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setDescripcion(rs.getString(3));
            producto.setPrecio(rs.getFloat(4));
            producto.setStock(rs.getInt(5));
            producto.setVigente(rs.getBoolean(6));
            
            marca.setId(9);
            marca.setNombre(rs.getString(10));
            marca.setVigente(rs.getBoolean(11));
            producto.setMarca(marca);
            
            categoria.setId(rs.getInt(12));
            categoria.setNombre(rs.getString(13));
            categoria.setDescripcion(rs.getString(14));
            categoria.setVigente(rs.getBoolean(15));
            producto.setCategoria(categoria);
            
            productos.add(producto);
        }
        return productos;
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
