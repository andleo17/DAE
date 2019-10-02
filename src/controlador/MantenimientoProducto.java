
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Marca;
import modelo.Producto;
import vista.JDMantenimientoProducto;

public class MantenimientoProducto extends JDMantenimientoProducto {
    
    public MantenimientoProducto(Frame parent, boolean modal) {
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
        
        btnAgregarMarca.addActionListener(evt -> abrirVentana(new MantenimientoMarca(null, true)));
        btnAgregarCategoria.addActionListener(evt -> abrirVentana(new MantenimientoCategoria(null, true)));
        
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
        
        txtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                permitirSoloNumeros(evt);
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                listar();
                listarCategorias();
                listarMarcas();
            }
        });
    
    }
    
    private void agregar(){
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                txtCodigo.setText(String.valueOf(Producto.generarCodigo()));
                txtCodigo.setEditable(false);
                txtNombre.requestFocus();
                btnNuevo.setText("Guardar");
            } else {
                var producto = new Producto();
                    producto.setId(Integer.valueOf(txtCodigo.getText()));
                    producto.setNombre(txtNombre.getText());
                    producto.setDescripcion(txtDescripcion.getText());
                    producto.setPrecio(Float.valueOf(txtPrecio.getText()));
                    producto.setStock((int) spnStock.getValue());
                    producto.setVigente(chkVigencia.isSelected());
                    producto.setMarca((Marca) cboMarca.getSelectedItem());
                    producto.setCategoria((Categoria) cboCategoria.getSelectedItem());
                    
                producto.registrar();
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void buscar(){
        if (!txtCodigo.getText().isEmpty()) {
            try {
                var producto = Producto.buscar(Integer.valueOf(txtCodigo.getText()));
                txtCodigo.setText(String.valueOf(producto.getId()));
                txtNombre.setText(producto.getNombre());
                txtDescripcion.setText(producto.getDescripcion());
                txtPrecio.setText(String.valueOf(producto.getPrecio()));
                spnStock.setValue(producto.getStock());
                cboMarca.setSelectedItem(producto.getMarca());
                cboCategoria.setSelectedItem(producto.getCategoria());
                chkVigencia.setSelected(producto.isVigente());
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
                Producto.eliminar(Integer.valueOf(txtCodigo.getText()));
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
                var productoAnterior = Producto.buscar(Integer.valueOf(txtCodigo.getText()));
                var productoNuevo = new Producto();
                    productoNuevo.setId(productoAnterior.getId());
                    productoNuevo.setNombre(txtNombre.getText());
                    productoNuevo.setDescripcion(txtDescripcion.getText());
                    productoNuevo.setVigente(chkVigencia.isSelected());
                    productoNuevo.setPrecio(Float.valueOf(txtPrecio.getText()));
                    productoNuevo.setStock((int) spnStock.getValue());
                    productoNuevo.setVigente(chkVigencia.isSelected());
                    productoNuevo.setMarca((Marca) cboMarca.getSelectedItem());
                    productoNuevo.setCategoria((Categoria) cboCategoria.getSelectedItem());
                    
                productoAnterior.modificar(productoNuevo);
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
                Producto.darBaja(Integer.valueOf(txtCodigo.getText()));
                JOptionPane.showMessageDialog(this, "Producto dado de baja correctamente");
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
    
    private void abrirVentana(JDialog ventana) {
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }
    
    private void limpiar() {
        txtCodigo.setText(null);
        txtCodigo.setEditable(true);
        txtNombre.setText(null);
        txtDescripcion.setText(null);
        txtPrecio.setText(null);
        spnStock.setValue(0);
        cboCategoria.setSelectedIndex(-1);
        cboMarca.setSelectedIndex(-1);
        chkVigencia.setSelected(false);
        btnNuevo.setText("Nuevo");
        txtCodigo.requestFocus();
        listar();
    }
    
    private void listar() {
        try {
            var model = new DefaultTableModel(new String[] {
                "ID", "Nombre", "Descripcion", "Precio", "Stock", "Vigente", "Marca", "Categoria"
            }, 0);
            Producto.listarTodo().forEach(p -> {
                model.addRow(new Object[] {
                    p.getId(),
                    p.getNombre(),
                    p.getDescripcion(),
                    p.getPrecio(),
                    p.getStock(),
                    p.isVigente() ? "Sí" : "No",
                    p.getMarca().getNombre(),
                    p.getCategoria().getNombre()
                });
            });
            
            tblDatos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void listarCategorias() {
        try {
            var modelo = new DefaultComboBoxModel<Categoria>();
            modelo.addAll(Categoria.listarTodo());
            modelo.setSelectedItem(null);
            cboCategoria.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void listarMarcas() {
        try {
            var modelo = new DefaultComboBoxModel<Marca>();
            modelo.addAll(Marca.listarTodo());
            modelo.setSelectedItem(null);
            cboMarca.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
}
