
package capaNegocio;

import capaDatos.DBConnection;
import java.sql.*;

public class Usuario {
    
    private DBConnection connection = new DBConnection();
    
    private String usuario;
    private String clave;
    private String nombre;
    private String cargo;
    private boolean estado;
    
    public boolean login(String usuario, String clave) throws Exception{
        this.usuario = usuario;
        this.clave = clave;
        try {
            String query = String.format("SELECT nombre, estado FROM usuario WHERE usuario.usuario = '%s' AND clave = '%s';", this.usuario, this.clave);
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                this.nombre = rs.getString("nombre");
                this.estado = rs.getBoolean("estado");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String obtenerPreguntaSecreta() throws Exception {
        try {
            String query = "SELECT pregunta FROM usuario WHERE usuario.usuario = '" + this.usuario + "';";
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
    
    public String validarPreguntaSecreta(String respuesta) throws Exception {
        try {
            String query = "SELECT * FROM usuario WHERE usuario.usuario = '" + this.usuario + "' AND respuesta = '" + respuesta + "';";
            ResultSet rs = connection.consultarBD(query);
            if (rs.next()) {
                this.nombre = rs.getString("nombre");
                this.estado = rs.getBoolean("estado");
                return this.nombre;
            } else {
                return "";
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
