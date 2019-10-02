
package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import modelo.Usuario;
import vista.JFPrincipal;

public class Principal extends JFPrincipal {
    
    private Usuario usuario;

    public Principal() {
        new Reloj();
        iniciar();
    }
    
    private void iniciar() {
        usuario = new Usuario();
        usuarioContenedor.setVisible(false);
        infoSesion.setVisible(false);
        
        btnCerrarSesion.addActionListener(evt -> cerrarSesion());
        mnuCerrarSesion.addActionListener(evt -> cerrarSesion());
        
        mnuCambiarClave.addActionListener(evt -> {
            var cambiarClave = new CambiarClave(this, true);
            abrirVentana(cambiarClave);
            cambiarClave.setUsuario(usuario);
        });
        
        mnuMantenimientoMarca.addActionListener(evt -> abrirVentana(new MantenimientoMarca(this, true)));
        mnuMantenimientoCategoria.addActionListener(evt -> abrirVentana(new MantenimientoCategoria(this, true)));
        mnuMantenimientoProductos.addActionListener(evt -> abrirVentana(new MantenimientoProducto(this, true)));
        mnuMantenimientoUsuarios.addActionListener(evt -> abrirVentana(new MantenimientoUsuario(this, true)));
        
        mnuMantenimientoClientes.addActionListener(evt -> abrirVentana(new MantenimientoCliente(this, true)));
        btnMantenimientoClientes.addActionListener(evt -> abrirVentana(new MantenimientoCliente(this, true)));
        
        mnuConsultarProductos.addActionListener(evt -> abrirVentana(new Consultas(this, true)));
        btnConsultarProductos.addActionListener(evt -> abrirVentana(new Consultas(this, true)));
        
        mnuAdministrarVentas.addActionListener(evt -> abrirVentana(new Ventas(this, true)));
        btnAdministrarVentas.addActionListener(evt -> abrirVentana(new Ventas(this, true)));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent evt) {
                abrirIniciarSesion();
            }
        });
    }
    
    private class Reloj implements Runnable {

        public Reloj() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            var hora = new SimpleDateFormat("hh:mm:ss a");
            var fecha = new SimpleDateFormat("dd/MM/yyyy");
            while (true) {
                try {
                    var tiempo = new Date();
                    lblFecha.setText(fecha.format(tiempo));
                    lblHora.setText(hora.format(tiempo));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    private void abrirVentana(JDialog ventana) {
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }
    
    private void cerrarSesion() {
        usuario = new Usuario();
        alternarInicioSesion();
        abrirIniciarSesion();
    }
    
    private void abrirIniciarSesion() {
        var inicioSesion = new InicioSesion(this, true);
            inicioSesion.setLocationRelativeTo(this);
            inicioSesion.setVisible(true);
            
        if (inicioSesion.getUsuario().getId() != 0) {
            try {
                usuario = inicioSesion.getUsuario();
                lblNumeroSesiones.setText(String.valueOf(usuario.obtenerCantidadSesiones()));
                lblSesion.setText(usuario.obtenerSesion());
                alternarInicioSesion();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.exit(0);
        }
    }
    
    private void alternarInicioSesion() {
        try {
            lblUsuario.setText(this.usuario.getNombre());
            infoSesion.setVisible(!infoSesion.isVisible());
            usuarioContenedor.setVisible(!usuarioContenedor.isVisible());
            btnIniciarSesion.setVisible(!btnIniciarSesion.isVisible());
            mnuIniciarSesion.setVisible(!mnuIniciarSesion.isVisible());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
