
package capaNegocio;

import capaDatos.IDBConnection;
import static capaDatos.IDBConnection.conectarBD;
import java.text.SimpleDateFormat;

public class Usuario implements IDBConnection {
    
    private int id;
    private String usuario;
    private String clave;
    private String nombre;
    private String cargo;
    private boolean estado;
    
    public boolean login(String usuario, String clave) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT id, nombre, estado FROM usuario WHERE usuario.usuario = ? AND clave = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, usuario);
                prepareStatement.setString(2, clave);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                this.usuario = usuario;
                this.clave = clave;
                this.id = resultSet.getInt("id");
                this.nombre = resultSet.getString("nombre");
                this.estado = resultSet.getBoolean("estado");
                insertarMovimiento();
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static String obtenerPreguntaSecreta(String usuario) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT pregunta FROM usuario WHERE usuario.usuario = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, usuario);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getString("pregunta");
            else
                return "";
        } catch (Exception e) {
            throw new Exception("Error al consultar pregunta secreta");
        }
    }
    
    public boolean validarPreguntaSecreta(String usuario, String respuesta) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM usuario WHERE usuario.usuario = ? AND respuesta = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, usuario);
                prepareStatement.setString(2, respuesta);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                this.usuario = usuario;
                this.id = resultSet.getInt("id");
                this.nombre = resultSet.getString("nombre");
                this.estado = resultSet.getBoolean("estado");
                insertarMovimiento();
                return true;
            } else
                return false;
        } catch (Exception e) {
            throw new Exception("Error al consultar respuesta secreta");
        }
    }
    
    public void cambiarClave(String clave) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE usuario SET clave = ? WHERE usuario.usuario = ? AND clave = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, clave);
                prepareStatement.setString(2, this.usuario);
                prepareStatement.setString(3, this.clave);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertarMovimiento() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO movimiento VALUES (DEFAULT, ?, DEFAULT, DEFAULT, TRUE);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static String obtenerUltimaSesion(String usuario) throws Exception {
        try (var connection = conectarBD()) {
            var query1 = "SELECT id FROM usuario WHERE usuario.usuario = ?;";
            var prepareStatement1 = connection.prepareStatement(query1);
                prepareStatement1.setString(1, usuario);
                
            var resultSet1 = prepareStatement1.executeQuery();
            if (resultSet1.next()) {
                var query = "SELECT fecha, hora FROM movimiento INNER JOIN usuario ON usuario.id = movimiento.id_usuario WHERE usuario.usuario = ?;";
                var prepareStatement = connection.prepareStatement(query);
                    prepareStatement.setString(1, usuario);
                    
                var resultSet = prepareStatement.executeQuery();
                if (resultSet.next()) {
                    var fecha = new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("fecha"));
                    var hora = new SimpleDateFormat("hh:mm:ss a").format(resultSet.getTime("hora"));
                    return "Última sesión: " + fecha + " - " + hora;
                } else
                    return "Primera vez iniciando sesión";
            } else
                return "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String obtenerSesion() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT fecha, hora FROM movimiento WHERE id_usuario = ? AND estado = TRUE;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var fecha = new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("fecha"));
                var hora = new SimpleDateFormat("hh:mm:ss a").format(resultSet.getTime("hora"));
                return "Sesión iniciada a las: " + hora + " del " + fecha;
            }
            return "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int obtenerCantidadSesiones() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT COUNT(*) FROM movimiento WHERE id_usuario = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                
            var rs = prepareStatement.executeQuery();
            if (rs.next())
                return rs.getInt(1);
            else
                return 0;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
