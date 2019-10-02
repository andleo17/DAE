
package controlador;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import vista.JDMantenimientoUsuario;

public class MantenimientoUsuario extends JDMantenimientoUsuario {
    
    public MantenimientoUsuario(Frame parent, boolean modal) {
        super(parent, modal);
        iniciar();
    }
    
    private void iniciar() {
        limpiar();
        
        btnNuevo.addActionListener(evt -> agregar());
        btnBuscar.addActionListener(evt -> buscar());
        btnEliminar.addActionListener(evt -> eliminar());
        btnModificar.addActionListener(evt -> modificar());
        btnDarBaja.addActionListener(evt -> darBaja());
        btnLimpiar.addActionListener(evt -> limpiar());
        
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buscarFila();
            }
        });
        
        txtCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                hacerClick(evt, btnBuscar);
                permitirSoloNumeros(evt);
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                listar();
            }
        });
    
    }
    
    private void agregar() {
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                txtCodigo.setText(String.valueOf(Usuario.generarCodigo()));
                txtCodigo.setEditable(false);
                txtUsuario.requestFocus();
                btnNuevo.setText("Guardar");
            } else {
                var usuario = new Usuario();
                    usuario.setId(Integer.valueOf(txtCodigo.getText()));
                    usuario.setUsuario(txtUsuario.getText());
                    usuario.setClave(txtClave.getText());
                    usuario.setNombre(txtNombre.getText());
                    usuario.setCargo(comprobarVacio(txtCargo.getText()));
                    usuario.setEstado(chkVigencia.isSelected());
                    usuario.setPregunta(txtPregunta.getText());
                    usuario.setRespuesta(txtRespuesta.getText());
                    
                usuario.registrar();
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void buscar() {
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var usuario = Usuario.buscar(Integer.valueOf(txtCodigo.getText()));
                txtCodigo.setText(String.valueOf(usuario.getId()));
                txtUsuario.setText(usuario.getUsuario());
                txtClave.setText(usuario.getClave());
                txtNombre.setText(usuario.getNombre());
                txtCargo.setText(usuario.getCargo());
                txtPregunta.setText(usuario.getPregunta());
                txtRespuesta.setText(usuario.getRespuesta());
                chkVigencia.setSelected(usuario.isEstado());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void buscarFila() {
        try {
            txtCodigo.setText(tblDatos.getValueAt(tblDatos.getSelectedRow(), 0).toString());
            buscar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void eliminar() {
        if (!txtCodigo.getText().isEmpty()) {
            try {
                Usuario.eliminar(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void modificar() {
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var usuarioAnterior = Usuario.buscar(Integer.valueOf(txtCodigo.getText()));
                var usuarioNuevo = new Usuario();
                    usuarioNuevo.setId(Integer.valueOf(txtCodigo.getText()));
                    usuarioNuevo.setUsuario(txtUsuario.getText());
                    usuarioNuevo.setClave(txtClave.getText());
                    usuarioNuevo.setNombre(txtNombre.getText());
                    usuarioNuevo.setCargo(comprobarVacio(txtCargo.getText()));
                    usuarioNuevo.setEstado(chkVigencia.isSelected());
                    usuarioNuevo.setPregunta(txtPregunta.getText());
                    usuarioNuevo.setRespuesta(txtRespuesta.getText());
                    
                usuarioAnterior.modificar(usuarioNuevo);
                JOptionPane.showMessageDialog(this, "Registro modificado correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void darBaja() {
        if (!txtCodigo.getText().isEmpty()) {
            try {
                Usuario.darBaja(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Usuario dado de baja correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void permitirSoloNumeros(KeyEvent evt) {
        if ('0' > evt.getKeyChar() || evt.getKeyChar() > '9') evt.consume();
    }
    
    private void hacerClick(KeyEvent evt, JButton boton) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) boton.doClick();
    }
    
    private void limpiar() {
        txtCodigo.setText(null);
        txtCodigo.setEditable(true);
        txtUsuario.setText(null);
        txtClave.setText(null);
        txtNombre.setText(null);
        txtCargo.setText(null);
        txtPregunta.setText(null);
        txtRespuesta.setText(null);
        chkVigencia.setSelected(false);
        btnNuevo.setText("Nuevo");
        txtCodigo.requestFocus();
        listar();
    }
    
    private void listar() {
        try {
            var model = new DefaultTableModel(new String[] {
                "ID", "Usuario", "Clave", "Nombre", "Cargo", "Estado", "Pregunta", "Respuesta"
            }, 0);
            Usuario.listarTodo().forEach(u -> {
                model.addRow(new Object[] {
                    u.getId(),
                    u.getUsuario(),
                    u.getClave(),
                    u.getNombre(),
                    u.getCargo(),
                    u.isEstado() ? "Vigente" : "Caducado",
                    u.getPregunta(),
                    u.getRespuesta()
                });
            });
            
            tblDatos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private String comprobarVacio(String texto) {
        if (!texto.isBlank()) return texto;
        return null;
    }
    
}
