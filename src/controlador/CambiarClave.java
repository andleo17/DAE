
package controlador;

import java.awt.Frame;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.JDCambiarClave;

public class CambiarClave extends JDCambiarClave {
    
    private Usuario usuario;
    
    public CambiarClave(Frame parent, boolean modal) {
        super(parent, modal);
        iniciar();
    }
    
    private void iniciar() {
        btnGuardar.addActionListener(evt -> guardar());
        btnGuardar.addActionListener(evt -> cerrar());
    }
    
    private void guardar() {
        try {
            if (String.valueOf(txtClave.getPassword()).equals(usuario.getClave())) {
                if (Arrays.equals(txtNuevaClave.getPassword(), txtConfirmacion.getPassword())) {
                    usuario.cambiarClave(String.valueOf(txtNuevaClave.getPassword()));
                    JOptionPane.showMessageDialog(this, "Contraseña cambiada correctamente");
                    this.dispose();
                }
                else 
                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            } else
                JOptionPane.showMessageDialog(this, "La contraseña es incorrecta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void cerrar() {
        dispose();
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
