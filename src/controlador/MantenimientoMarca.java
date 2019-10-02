
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
import modelo.Marca;
import vista.JDMantenimientoMarca;

public class MantenimientoMarca extends JDMantenimientoMarca {

    public MantenimientoMarca(Frame parent, boolean modal) {
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
    
    private void agregar(){
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                txtCodigo.setText(String.valueOf(Marca.generarCodigo()));
                txtCodigo.setEditable(false);
                txtNombre.requestFocus();
                btnNuevo.setText("Guardar");
            } else {
                var marca = new Marca();
                    marca.setId(Integer.valueOf(txtCodigo.getText()));
                    marca.setNombre(txtNombre.getText());
                    marca.setVigente(chkVigencia.isSelected());
                    
                marca.registrar();
                limpiar();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void buscar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var marca = Marca.buscar(Integer.valueOf(txtCodigo.getText()));
                txtCodigo.setText(String.valueOf(marca.getId()));
                txtNombre.setText(marca.getNombre());
                chkVigencia.setSelected(marca.isVigente());
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
                Marca.eliminar(Integer.valueOf(txtCodigo.getText()));
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
                var marcaAnterior = Marca.buscar(Integer.valueOf(txtCodigo.getText()));
                var marcaNueva = new Marca();
                    marcaNueva.setId(marcaAnterior.getId());
                    marcaNueva.setNombre(txtNombre.getText());
                    marcaNueva.setVigente(chkVigencia.isSelected());
                    marcaAnterior.modificar(marcaNueva);
                    
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
                Marca.darBaja(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Marca dada de baja correctamente");
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
        txtNombre.setText(null);
        chkVigencia.setSelected(false);
        btnNuevo.setText("Nuevo");
        txtCodigo.requestFocus();
        listar();
    }
    
    private void listar() {
        try {
            var model = new DefaultTableModel(new String[] {"ID", "Nombre", "Vigente"}, 0);
            Marca.listarTodo().forEach(m -> {
                model.addRow(new Object[] {
                    m.getId(),
                    m.getNombre(),
                    m.isVigente() ? "Sí" : "No"
                });
            });
            
            tblDatos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
}
