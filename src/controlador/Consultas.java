
package controlador;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Marca;
import modelo.Producto;
import vista.JDConsultas;

public class Consultas extends JDConsultas {
    
    public Consultas(Frame parent, boolean modal) {
        super(parent, modal);
        iniciar();
    }
    
    private void iniciar() {
        cboCategoria.addActionListener(evt -> filtrar());
        cboMarca.addActionListener(evt -> filtrar());
        btnLimpiar.addActionListener(evt -> limpiar());
        
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrar();
            }
        });
        
        try {
            listar(Producto.listarTodo());
            listarCategorias();
            listarMarcas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void listar(ArrayList<Producto> productos) {
        try {
            var model = new DefaultTableModel(new String[] {
                "ID", "Nombre", "Descripcion", "Precio", "Stock", "Vigente", "Marca", "Categoria"
            }, 0);
            productos.forEach(p -> {
                model.addRow(new Object[] {
                    p.getId(),
                    p.getNombre(),
                    p.getDescripcion(),
                    p.getPrecio(),
                    p.getStock(),
                    p.isVigente() ? "Sí" : "No",
                    p.getMarca().toString(),
                    p.getCategoria().toString()
                });
            });
            
            tblDatos.setModel(model);
            lblProductos.setText("Productos encontrados: " + productos.size());
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
    
    private void limpiar() {
        txtNombre.setText(null);
        cboCategoria.setSelectedIndex(-1);
        cboMarca.setSelectedIndex(-1);
    }
    
    private void filtrar() {
        try {
            var marca = (Marca) cboMarca.getSelectedItem();
            var categoria = (Categoria) cboCategoria.getSelectedItem();
            var productos = Producto.filtrarProductos(txtNombre.getText(), categoria, marca);
            listar(productos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
}
