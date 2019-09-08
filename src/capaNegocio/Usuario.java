
package capaNegocio;

import capaDatos.DBConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    
    private DBConnection connection = new DBConnection();
    
    private int id;
    private String usuario;
    private String clave;
    private String nombre;
    private String cargo;
    private boolean estado;
    
    public boolean login(String usuario, String clave) throws Exception{
        
        try {
            String query = String.format("SELECT id, nombre, estado FROM usuario WHERE usuario.usuario = '%s' AND clave = '%s';", usuario, clave);
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                this.usuario = usuario;
                this.clave = clave;
                this.id = rs.getInt("id");
                this.nombre = rs.getString("nombre");
                this.estado = rs.getBoolean("estado");
                insertarMovimiento();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String obtenerPreguntaSecreta(String usuario) throws Exception {
        try {
            String query = "SELECT pregunta FROM usuario WHERE usuario.usuario = '" + usuario + "';";
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                return rs.getString("pregunta");
            } else {
                return "";
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar pregunta secreta");
        }
    }
    
    public boolean validarPreguntaSecreta(String usuario, String respuesta) throws Exception {
        try {
            String query = "SELECT * FROM usuario WHERE usuario.usuario = '" + usuario + "' AND respuesta = '" + respuesta + "';";
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                this.usuario = usuario;
                this.clave = clave;
                this.id = rs.getInt("id");
                this.nombre = rs.getString("nombre");
                this.estado = rs.getBoolean("estado");
                insertarMovimiento();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Error al consultar respuesta secreta");
        }
    }
    
    public void cambiarClave(String clave) throws Exception {
        try {
            String query = "UPDATE usuario SET clave = '" + clave + "' WHERE usuario.usuario = '" + this.usuario + "' AND clave = '" + this.clave + "';";
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertarMovimiento() throws Exception {
        try {
            String query = String.format("INSERT INTO movimiento VALUES(DEFAULT, %d, DEFAULT, DEFAULT, TRUE);", this.id);
            connection.ejecutarBD(query);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String obtenerUltimaSesion(String usuario) throws Exception {
        try {
            String query = "SELECT fecha, hora FROM movimiento WHERE id_usuario = (SELECT id FROM usuario WHERE usuario.usuario = '" + usuario + "') AND estado = TRUE;";
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha"));
                String hora = new SimpleDateFormat("hh:mm:ss a").format(rs.getTime("hora"));
                return "Última sesión: " + fecha + " - " + hora;
            } else {
                return "Primera vez iniciando sesión";
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String obtenerSesion() throws Exception {
        try {
            String query = String.format("SELECT fecha, hora FROM movimiento WHERE id_usuario = %d AND estado = TRUE;", this.id);
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha"));
                String hora = new SimpleDateFormat("hh:mm:ss a").format(rs.getTime("hora"));
                return "Sesión iniciada a las: " + hora + " del " + fecha;
            }
            return "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int obtenerCantidadSesiones() throws Exception {
        try {
            String query = String.format("SELECT COUNT(*) FROM movimiento WHERE id_usuario = %d;", this.id);
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
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
