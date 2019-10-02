
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
import modelo.Categoria;
import vista.JDMantenimientoCategoria;

public class MantenimientoCategoria extends JDMantenimientoCategoria {

    public MantenimientoCategoria(Frame parent, boolean modal) {
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
                txtCodigo.setText(String.valueOf(Categoria.generarCodigo()));
                txtCodigo.setEditable(false);
                txtNombre.requestFocus();
                btnNuevo.setText("Guardar");
            } else {
                var categoria = new Categoria();
                    categoria.setId(Integer.valueOf(txtCodigo.getText()));
                    categoria.setNombre(txtNombre.getText());
                    categoria.setDescripcion(txtDescripcion.getText());
                    categoria.setVigente(chkVigencia.isSelected());
                    
                categoria.registrar();
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void buscar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var categoria = Categoria.buscar(Integer.valueOf(txtCodigo.getText()));
                txtCodigo.setText(String.valueOf(categoria.getId()));
                txtNombre.setText(categoria.getNombre());
                txtDescripcion.setText(categoria.getDescripcion());
                chkVigencia.setSelected(categoria.isVigente());
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
                Categoria.eliminar(Integer.valueOf(txtCodigo.getText()));
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
                var categoriaAnterior = Categoria.buscar(Integer.valueOf(txtCodigo.getText()));
                var categoriaNueva = new Categoria();
                    categoriaNueva.setId(categoriaAnterior.getId());
                    categoriaNueva.setNombre(txtNombre.getText());
                    categoriaNueva.setDescripcion(txtDescripcion.getText());
                    categoriaNueva.setVigente(chkVigencia.isSelected());
                    
                categoriaAnterior.modificar(categoriaNueva);
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
                Categoria.darBaja(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Categoria dada de baja correctamente");
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
        txtDescripcion.setText(null);
        chkVigencia.setSelected(false);
        btnNuevo.setText("Nuevo");
        txtCodigo.requestFocus();
        listar();
    }
    
    private void listar() {
        try {
            var model = new DefaultTableModel(new String[] {"ID", "Nombre", "Descripcion", "Vigente"}, 0);
            Categoria.listarTodo().forEach(c -> {
                model.addRow(new Object[] {
                    c.getId(),
                    c.getNombre(),
                    c.getDescripcion(),
                    c.isVigente() ? "Sí" : "No"
                });
            });
            
            tblDatos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
}
