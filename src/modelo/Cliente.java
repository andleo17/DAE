
package modelo;

import datos.IDBConnection;
import static datos.IDBConnection.conectarBD;
import java.util.ArrayList;

public class Cliente implements IDBConnection {
    
    private int id;
    private String dni;
    private String ruc;
    private String nombres;
    private String telefono;
    private String correo;
    private String direccion;
    private boolean vigente;
    private TipoCliente tipoCliente;

    public static int generarCodigo() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT coalesce(MAX(id), 0) + 1 FROM cliente;";
            var resultSet = connection.createStatement().executeQuery(query);
                resultSet.next();
                
            return resultSet.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                prepareStatement.setString(2, this.dni);
                prepareStatement.setString(3, this.ruc);
                prepareStatement.setString(4, this.nombres);
                prepareStatement.setString(5, this.telefono);
                prepareStatement.setString(6, this.correo);
                prepareStatement.setString(7, this.direccion);
                prepareStatement.setBoolean(8, this.vigente);
                prepareStatement.setInt(9, this.tipoCliente.getId());
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Cliente buscar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM cliente "
                    + "INNER JOIN tipo_cliente ON cliente.tipo_cliente_id = tipo_cliente.id "
                    + "WHERE cliente.id = ?;";
            
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var cliente = new Cliente();
                    cliente.setId(resultSet.getInt(1));
                    cliente.setDni(resultSet.getString(2));
                    cliente.setRuc(resultSet.getString(3));
                    cliente.setNombres(resultSet.getString(4));
                    cliente.setTelefono(resultSet.getString(5));
                    cliente.setCorreo(resultSet.getString(6));
                    cliente.setDireccion(resultSet.getString(7));
                    cliente.setVigente(resultSet.getBoolean(8));
                
                var tipoCliente = new TipoCliente();
                    tipoCliente.setId(resultSet.getInt(10));
                    tipoCliente.setNombre(resultSet.getString(11));
                    
                cliente.setTipoCliente(tipoCliente);
                return cliente;
            } else
                throw new Exception("No se encontró el cliente");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Cliente buscar(String numeroDocumento) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM cliente "
                    + "INNER JOIN tipo_cliente ON cliente.tipo_cliente_id = tipo_cliente.id "
                    + "WHERE cliente.dni = ? OR cliente.ruc = ?;";
            
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, numeroDocumento);
                prepareStatement.setString(2, numeroDocumento);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var cliente = new Cliente();
                    cliente.setId(resultSet.getInt(1));
                    cliente.setDni(resultSet.getString(2));
                    cliente.setRuc(resultSet.getString(3));
                    cliente.setNombres(resultSet.getString(4));
                    cliente.setTelefono(resultSet.getString(5));
                    cliente.setCorreo(resultSet.getString(6));
                    cliente.setDireccion(resultSet.getString(7));
                    cliente.setVigente(resultSet.getBoolean(8));
                
                var tipoCliente = new TipoCliente();
                    tipoCliente.setId(resultSet.getInt(10));
                    tipoCliente.setNombre(resultSet.getString(11));
                    
                cliente.setTipoCliente(tipoCliente);
                return cliente;
            } else
                throw new Exception("No se encontró el cliente");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "DELETE FROM cliente WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Cliente cliente) throws Exception {
        try (var connection = conectarBD()) {
            String query = "UPDATE cliente " +
                "SET dni = ?, ruc = ?, nombres = ?, telefono = ?, correo = ?, " +
                "direccion = ?, vigencia = ?, tipo_cliente_id = ? " +
                "WHERE id = ?;";
            
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, cliente.getDni());
                prepareStatement.setString(2, cliente.getRuc());
                prepareStatement.setString(3, cliente.getNombres());
                prepareStatement.setString(4, cliente.getTelefono());
                prepareStatement.setString(5, cliente.getCorreo());
                prepareStatement.setString(6, cliente.getDireccion());
                prepareStatement.setBoolean(7, cliente.isVigente());
                prepareStatement.setInt(8, cliente.getTipoCliente().getId());
                prepareStatement.setInt(9, this.id);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE cliente SET vigencia = FALSE WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Cliente> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var clientes = new ArrayList<Cliente>();
            var query = "SELECT * FROM cliente "
                    + "INNER JOIN tipo_cliente ON cliente.tipo_cliente_id = tipo_cliente.id "
                    + "ORDER BY cliente.id;";
            
            var resultSet = connection.createStatement().executeQuery(query);
            while(resultSet.next()) {
                var cliente = new Cliente();
                    cliente.setId(resultSet.getInt(1));
                    cliente.setDni(resultSet.getString(2));
                    cliente.setRuc(resultSet.getString(3));
                    cliente.setNombres(resultSet.getString(4));
                    cliente.setTelefono(resultSet.getString(5));
                    cliente.setCorreo(resultSet.getString(6));
                    cliente.setDireccion(resultSet.getString(7));
                    cliente.setVigente(resultSet.getBoolean(8));
                
                var tipoCliente = new TipoCliente();
                    tipoCliente.setId(resultSet.getInt(10));
                    tipoCliente.setNombre(resultSet.getString(11));
                    cliente.setTipoCliente(tipoCliente);
                    
                clientes.add(cliente);
            }
            return clientes;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    @Override
    public String toString() {
        return this.nombres;
    }
    
}
