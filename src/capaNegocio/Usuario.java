
package capaNegocio;

import capaDatos.IDBConnection;
import static capaDatos.IDBConnection.conectarBD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Usuario implements IDBConnection {
    
    private int id;
    private String usuario;
    private String clave;
    private String nombre;
    private String cargo;
    private boolean estado;
    private String pregunta;
    private String respuesta;
    
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
    
    public String obtenerPreguntaSecreta(String usuario) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT pregunta FROM usuario WHERE usuario.usuario = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, usuario);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                this.usuario = usuario;
                this.respuesta = resultSet.getString("pregunta");
                return this.respuesta;
            } else
                return "";
        } catch (Exception e) {
            throw new Exception("Error al consultar pregunta secreta");
        }
    }
    
    public boolean validarPreguntaSecreta(String respuesta) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM usuario WHERE usuario.usuario = ? AND respuesta = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, this.usuario);
                prepareStatement.setString(2, respuesta);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                this.id = resultSet.getInt("id");
                this.nombre = resultSet.getString("nombre");
                this.estado = resultSet.getBoolean("estado");
                this.respuesta = resultSet.getString("respuesta");
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
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);
            else
                return 0;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static int generarCodigo() throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT coalesce(MAX(id), 0) + 1 FROM usuario;";
            var resultSet = connection.createStatement().executeQuery(query);
                resultSet.next();
                
            return resultSet.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void registrar() throws Exception {
        try (var connection = conectarBD()) {
            var query = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, this.id);
                prepareStatement.setString(2, this.usuario);
                prepareStatement.setString(3, this.clave);
                prepareStatement.setString(4, this.nombre);
                prepareStatement.setString(5, this.cargo);
                prepareStatement.setBoolean(6, this.estado);
                prepareStatement.setString(7, this.pregunta);
                prepareStatement.setString(8, this.respuesta);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Usuario buscar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "SELECT * FROM usuario WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            var resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                var usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setUsuario(resultSet.getString("usuario"));
                    usuario.setClave(resultSet.getString("clave"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setCargo(resultSet.getString("cargo"));
                    usuario.setEstado(resultSet.getBoolean("estado"));
                    usuario.setPregunta(resultSet.getString("pregunta"));
                    usuario.setRespuesta(resultSet.getString("respuesta"));
                
                return usuario;
            } else {
                throw new Exception("No se encontró el usuario");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar(Usuario usuario) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE usuario SET usuario = ?, clave = ?, nombre = ?, cargo = ?, estado = ?, pregunta = ?, respuesta = ? WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setString(1, usuario.getUsuario());
                prepareStatement.setString(2, usuario.getClave());
                prepareStatement.setString(3, usuario.getNombre());
                prepareStatement.setString(4, usuario.getCargo());
                prepareStatement.setBoolean(5, usuario.isEstado());
                prepareStatement.setString(6, usuario.getPregunta());
                prepareStatement.setString(7, usuario.getRespuesta());
                prepareStatement.setInt(8, this.id);
            
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminar(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "DELETE FROM usuario WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void darBaja(int codigo) throws Exception {
        try (var connection = conectarBD()) {
            var query = "UPDATE usuario SET estado = FALSE WHERE id = ?;";
            var prepareStatement = connection.prepareStatement(query);
                prepareStatement.setInt(1, codigo);
                
            prepareStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static ArrayList<Usuario> listarTodo() throws Exception {
        try (var connection = conectarBD()) {
            var usuarios = new ArrayList<Usuario>();
            var query = "SELECT * FROM usuario ORDER BY id;";
            var resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                var usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setUsuario(resultSet.getString("usuario"));
                    usuario.setClave(resultSet.getString("clave"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setCargo(resultSet.getString("cargo"));
                    usuario.setEstado(resultSet.getBoolean("estado"));
                    usuario.setPregunta(resultSet.getString("pregunta"));
                    usuario.setRespuesta(resultSet.getString("respuesta"));
                    
                usuarios.add(usuario);
            }
            return usuarios;
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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
}
