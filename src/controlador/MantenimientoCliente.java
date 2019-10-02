
package controlador;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.TipoCliente;
import vista.JDMantenimientoCliente;

public class MantenimientoCliente extends JDMantenimientoCliente {

    public MantenimientoCliente(Frame parent, boolean modal) {
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
        
        cboTipoCliente.addActionListener(evt -> alternarTiposCliente());
        
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
                listarTiposCliente();
            }
        });
    
    }
    
    private void agregar(){
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                txtCodigo.setText(String.valueOf(Cliente.generarCodigo()));
                txtCodigo.setEditable(false);
                txtNombres.requestFocus();
                btnNuevo.setText("Guardar");
            } else {
                var cliente = new Cliente();
                    cliente.setId(Integer.valueOf(txtCodigo.getText()));
                    cliente.setDni(txtDNI.getText());
                    cliente.setRuc(txtRUC.getText());
                    cliente.setNombres(txtNombres.getText());
                    cliente.setTelefono(txtTelefono.getText());
                    cliente.setCorreo(txtCorreo.getText());
                    cliente.setDireccion(txtDireccion.getText());
                    cliente.setVigente(chkVigencia.isSelected());
                    cliente.setTipoCliente((TipoCliente) cboTipoCliente.getSelectedItem());
                    
                cliente.registrar();
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void buscar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var cliente = Cliente.buscar(Integer.valueOf(txtCodigo.getText()));
                    txtCodigo.setText(String.valueOf(cliente.getId()));
                    txtDNI.setText(comprobarVacio(cliente.getDni()));
                    txtRUC.setText(comprobarVacio(cliente.getRuc()));
                    txtNombres.setText(cliente.getNombres());
                    txtTelefono.setText(comprobarVacio(cliente.getTelefono()));
                    txtCorreo.setText(comprobarVacio(cliente.getCorreo()));
                    txtDireccion.setText(cliente.getDireccion());
                    chkVigencia.setSelected(cliente.isVigente());
                    cboTipoCliente.setSelectedItem(cliente.getTipoCliente());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void buscarFila(){
        try {
            txtCodigo.setText(tblDatos.getValueAt(tblDatos.getSelectedRow(), 0).toString());
            buscar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void eliminar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                Cliente.eliminar(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void modificar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var clienteAnterior = Cliente.buscar(Integer.valueOf(txtCodigo.getText()));
                var clienteNuevo = new Cliente();
                    clienteNuevo.setId(Integer.valueOf(txtCodigo.getText()));
                    clienteNuevo.setDni(comprobarVacio(txtDNI.getText()));
                    clienteNuevo.setRuc(comprobarVacio(txtRUC.getText()));
                    clienteNuevo.setNombres(txtNombres.getText());
                    clienteNuevo.setTelefono(comprobarVacio(txtTelefono.getText()));
                    clienteNuevo.setCorreo(comprobarVacio(txtCorreo.getText()));
                    clienteNuevo.setDireccion(txtDireccion.getText());
                    clienteNuevo.setVigente(chkVigencia.isSelected());
                    clienteNuevo.setTipoCliente((TipoCliente) cboTipoCliente.getSelectedItem());
                    
                clienteAnterior.modificar(clienteNuevo);
                JOptionPane.showMessageDialog(this, "Registro modificado correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                limpiar();
            }
        } else
            JOptionPane.showMessageDialog(this, "Ingrese un código");
    }
    
    private void darBaja(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                Cliente.darBaja(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Cliente dado de baja correctamente");
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
    
    private void alternarTiposCliente() {
        var tipoCliente = (TipoCliente) cboTipoCliente.getSelectedItem();
        if (tipoCliente != null) {
            switch (tipoCliente.getId()) {
                case 1:
                    pnlRUC.setVisible(true);
                    pnlDNI.setVisible(false);
                    break;
                case 2:
                    pnlRUC.setVisible(false);
                    pnlDNI.setVisible(true);
                    break;
                case 3:
                    pnlRUC.setVisible(true);
                    pnlDNI.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "No sé qué estás seleccionando");
            }
        }
    }
    
    private void limpiar() {
        txtCodigo.setText(null);
        txtCodigo.setEditable(true);
        pnlRUC.setVisible(false);
        pnlDNI.setVisible(false);
        txtDNI.setText(null);
        txtRUC.setText(null);
        txtNombres.setText(null);
        txtTelefono.setText(null);
        txtCorreo.setText(null);
        txtDireccion.setText(null);
        chkVigencia.setSelected(false);
        cboTipoCliente.setSelectedItem(null);
        btnNuevo.setText("Nuevo");
        txtCodigo.requestFocus();
        listar();
    }
    
    private void listar() {
        try {
            var model = new DefaultTableModel(new String[] {
                "ID", "Nombres", "DNI", "RUC", "Teléfono", "Correo", "Dirección", "Vigente", "Tipo Cliente"
            }, 0);
            Cliente.listarTodo().forEach(c -> {
                model.addRow(new Object[] {
                    c.getId(),
                    c.getNombres(),
                    c.getDni(),
                    c.getRuc(),
                    c.getTelefono(),
                    c.getCorreo(),
                    c.getDireccion(),
                    c.isVigente() ? "Sí" : "No",
                    c.getTipoCliente().getNombre()
                });
            });
            
            tblDatos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void listarTiposCliente() {
        try {
            var modelo = new DefaultComboBoxModel();
            modelo.addAll(TipoCliente.listarTodo());
            modelo.setSelectedItem(null);
            cboTipoCliente.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private String comprobarVacio(String texto) {
        if (!texto.isBlank()) return texto;
        return null;
    }
    
}
