
package controlador;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.JDInicioSesion;

public class InicioSesion extends JDInicioSesion {
    
    private final Usuario usuario;
    private byte numeroIntentos;
    
    public InicioSesion (java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        usuario = new Usuario();
        iniciar();
    }
    
    private void iniciar() {
        pnlPregunta.setVisible(false);
        
        btnLogin.addActionListener(evt -> login());
        btnEnviar.addActionListener(evt -> enviarRespuestaSecreta());
        btnCancelar.addActionListener(evt -> cerrar());
        
        txtUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evt) {
                obtenerUltimaSesion();
            }
        });
        
        txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                hacerClick(evt, btnLogin);
            }
        });
        
        txtClave.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                hacerClick(evt, btnLogin);
            }
        });
        
        txtRespuesta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                hacerClick(evt, btnEnviar);
            }
        });
    }
    
    private void login() {
        try {
            if (usuario.login(txtUsuario.getText(), String.valueOf(txtClave.getPassword()))) {
                if (usuario.isEstado()) {
                    JOptionPane.showMessageDialog(this, "Inicio de sesión correcto");
                    this.dispose();
                } else
                    JOptionPane.showMessageDialog(this, "Usuario caducado");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
                txtClave.setText(null);
                txtClave.requestFocus();
                if (++numeroIntentos == 3) {
                    JOptionPane.showMessageDialog(this, "Superó el número de intentos permitidos, por favor conteste su pregunta secreta");
                    pnlPregunta.setVisible(true);
                    lblPregunta.setText(usuario.obtenerPreguntaSecreta(txtUsuario.getText()));
                    txtRespuesta.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void enviarRespuestaSecreta() {
        try {
            if (usuario.validarPreguntaSecreta(txtRespuesta.getText())) 
                JOptionPane.showMessageDialog(this, "Inicio de sesión correcto");
             else 
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void cerrar() {
        this.dispose();
    }
    
    private void obtenerUltimaSesion() {
        try {
            lblUltimaSesion.setText(Usuario.obtenerUltimaSesion(txtUsuario.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void hacerClick(KeyEvent evt, JButton boton) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) boton.doClick();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
}
