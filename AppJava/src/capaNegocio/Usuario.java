
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
    
    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public boolean login() throws Exception{
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
            throw new Exception("Usuario y/o contraseña incorrectos");
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
