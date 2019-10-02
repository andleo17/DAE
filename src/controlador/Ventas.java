
package controlador;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Cliente;
import modelo.Producto;
import vista.JDVentas;

public class Ventas extends JDVentas {
    
    private Cliente cliente;
    private ArrayList<Producto> productos;
    
    public Ventas(Frame parent, boolean modal) {
        super(parent, modal);
        iniciar();
    }
    
    private void iniciar() {
        productos = new ArrayList();
        pnlInformacionCliente.setVisible(false);
        
        btnBuscarCliente.addActionListener(evt -> buscarCliente());
        
        rdbBoleta.addActionListener(evt -> mostrarTipoDocumento("DNI"));
        rdbFactura.addActionListener(evt -> mostrarTipoDocumento("RUC"));
        
        txtNumeroDocumento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                limitarCaracteres(evt, 11);
            }

            @Override
            public void keyTyped(KeyEvent evt) {
                permitirSoloNumeros(evt);
                hacerClick(evt, btnBuscarCliente);
                limitarCaracteres(evt, 11);
            }
        });
        
    }
    
    private void buscarCliente() {
        try {
            if (txtNumeroDocumento.getText().length() == 8 || txtNumeroDocumento.getText().length() == 11) {
                cliente = Cliente.buscar(txtNumeroDocumento.getText());
                lblNombres.setText(cliente.getNombres());
                lblDireccion.setText(cliente.getDireccion());
                lblTipoCliente.setText(cliente.getTipoCliente().toString());
                pnlInformacionCliente.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido");
            }
        } catch (Exception e) {
            int respuesta = JOptionPane.showConfirmDialog(this, e.getMessage() + "\n¿Desea agregarlo?", "No se encontró al cliente", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                var mantenimientoCliente = new MantenimientoCliente(null, true);
                    mantenimientoCliente.setLocationRelativeTo(this);
                    mantenimientoCliente.setVisible(true);
            }
        }
    }
    
    private void mostrarTipoDocumento(String tipoDocumento) {
        lblNumeroDocumento.setText(tipoDocumento);
    }
    
    private void limitarCaracteres(KeyEvent evt, int caracteres) {
        var txt = (JTextField) evt.getComponent();
        if (txt.getText().length() >= caracteres) evt.consume();
    }
    
    private void permitirSoloNumeros(KeyEvent evt) {
        if ('0' > evt.getKeyChar() || evt.getKeyChar() > '9') evt.consume();
    }
    
    private void hacerClick(KeyEvent evt, JButton boton) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) boton.doClick();
    }
    
}
