package capaCliente;

import capaNegocio.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JFPrincipal extends javax.swing.JFrame {

    Usuario usuario;
    
    public JFPrincipal() {
        initComponents();
        usuarioContenedor.setVisible(false);
        infoSesion.setVisible(false);
        new Reloj();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnIniciarSesion = new javax.swing.JButton();
        btnCambiarUsuario = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        usuarioContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        infoSesion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNumeroSesiones = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuLogin = new javax.swing.JMenu();
        mnuIniciarSesion = new javax.swing.JMenuItem();
        mnuCerrarSesion = new javax.swing.JMenuItem();
        mnuCambiarClave = new javax.swing.JMenuItem();
        mnuMantenimiento = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenuItem();
        mnuMantenimientoMarca = new javax.swing.JMenuItem();
        mnuMantenimientoCategoria = new javax.swing.JMenuItem();
        mnuMantenimientoProductos = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuConsultarProductos = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de comercialización");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iniciar-sesion.png"))); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnIniciarSesion);

        btnCambiarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCambiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cambiar-sesion.png"))); // NOI18N
        btnCambiarUsuario.setText("Cambiar Usuario");
        btnCambiarUsuario.setFocusable(false);
        btnCambiarUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCambiarUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCambiarUsuario);

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cerrar-sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrarSesion);
        jToolBar1.add(jSeparator3);

        btnProductos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/consultar.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setMinimumSize(new java.awt.Dimension(70, 75));
        btnProductos.setPreferredSize(new java.awt.Dimension(70, 75));
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProductos);

        btnVentas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ventas.png"))); // NOI18N
        btnVentas.setText("Venta");
        btnVentas.setFocusable(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setMinimumSize(new java.awt.Dimension(70, 75));
        btnVentas.setPreferredSize(new java.awt.Dimension(70, 75));
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVentas);

        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setFocusable(false);
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setPreferredSize(new java.awt.Dimension(70, 75));
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClientes);

        btnPagar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pagar.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setFocusable(false);
        btnPagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagar.setPreferredSize(new java.awt.Dimension(70, 75));
        btnPagar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPagar);
        jToolBar1.add(jSeparator1);

        usuarioContenedor.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sesion-peque.png"))); // NOI18N
        jLabel1.setText("Usuario:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario");

        javax.swing.GroupLayout usuarioContenedorLayout = new javax.swing.GroupLayout(usuarioContenedor);
        usuarioContenedor.setLayout(usuarioContenedorLayout);
        usuarioContenedorLayout.setHorizontalGroup(
            usuarioContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usuarioContenedorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario))
        );
        usuarioContenedorLayout.setVerticalGroup(
            usuarioContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioContenedorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(usuarioContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario))
                .addGap(0, 0, 0))
        );

        jPanel3.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/hora.png"))); // NOI18N
        jLabel3.setText("Hora:");

        lblHora.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblHora.setText("12:59:59 p.m.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHora))
                .addGap(0, 0, 0))
        );

        jPanel4.setOpaque(false);

        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFecha.setText("31/12/9999");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fecha.png"))); // NOI18N
        jLabel5.setText("Fecha:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFecha))
                .addGap(0, 0, 0))
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("N° Sesiones hasta la fecha:");

        lblNumeroSesiones.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNumeroSesiones.setText("0");

        lblSesion.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSesion.setText("Sesión");

        javax.swing.GroupLayout infoSesionLayout = new javax.swing.GroupLayout(infoSesion);
        infoSesion.setLayout(infoSesionLayout);
        infoSesionLayout.setHorizontalGroup(
            infoSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoSesionLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumeroSesiones)
                .addGap(18, 18, 18)
                .addComponent(lblSesion)
                .addGap(0, 256, Short.MAX_VALUE))
        );
        infoSesionLayout.setVerticalGroup(
            infoSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNumeroSesiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuarioContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarioContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(infoSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/fondo.png"))); // NOI18N
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        mnuLogin.setText("Login");

        mnuIniciarSesion.setText("Inicio Sesión");
        mnuLogin.add(mnuIniciarSesion);

        mnuCerrarSesion.setText("Cerrar Sesión");
        mnuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarSesionActionPerformed(evt);
            }
        });
        mnuLogin.add(mnuCerrarSesion);

        mnuCambiarClave.setText("Cambiar Contraseña");
        mnuCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambiarClaveActionPerformed(evt);
            }
        });
        mnuLogin.add(mnuCambiarClave);

        jMenuBar1.add(mnuLogin);

        mnuMantenimiento.setText("Mantenimiento");

        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuUsuarios);

        mnuMantenimientoMarca.setText("Marcas");
        mnuMantenimientoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoMarcaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantenimientoMarca);

        mnuMantenimientoCategoria.setText("Categorías");
        mnuMantenimientoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoCategoriaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantenimientoCategoria);

        mnuMantenimientoProductos.setText("Productos");
        mnuMantenimientoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoProductosActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuMantenimientoProductos);

        jMenuBar1.add(mnuMantenimiento);

        mnuVentas.setText("Ventas");

        mnuConsultarProductos.setText("Productos");
        mnuConsultarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarProductosActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuConsultarProductos);

        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuClientes);

        jMenuItem9.setText("Venta");
        mnuVentas.add(jMenuItem9);

        jMenuItem10.setText("Pago");
        mnuVentas.add(jMenuItem10);

        jMenuBar1.add(mnuVentas);

        mnuReportes.setText("Reportes");

        jMenuItem11.setText("Ventas diarias");
        mnuReportes.add(jMenuItem11);

        jMenuItem12.setText("Ingresos");
        mnuReportes.add(jMenuItem12);

        jMenuItem13.setText("Productos");
        mnuReportes.add(jMenuItem13);

        jMenuBar1.add(mnuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambiarClaveActionPerformed
        var frmCambiarClave = new JDCambiarClave(this, true, usuario);
            frmCambiarClave.setLocationRelativeTo(this);
            frmCambiarClave.setVisible(true);
    }//GEN-LAST:event_mnuCambiarClaveActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        abrirIniciarSesion();
    }//GEN-LAST:event_formWindowOpened

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void mnuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_mnuCerrarSesionActionPerformed

    private void mnuMantenimientoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoMarcaActionPerformed
        var frm = new JDMantenimientoMarca(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoMarcaActionPerformed

    private void mnuMantenimientoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoCategoriaActionPerformed
        var frm = new JDMantenimientoCategoria(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoCategoriaActionPerformed

    private void mnuMantenimientoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoProductosActionPerformed
        var frm = new JDMantenimientoProducto(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuMantenimientoProductosActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed
        var frm = new JDMantenimientoUsuario(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        var frm = new JDConsultas(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void mnuConsultarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarProductosActionPerformed
        var frm = new JDConsultas(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuConsultarProductosActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        var frm = new JDMantenimientoCliente(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        var frm = new JDMantenimientoCliente(this, true);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private class Reloj implements Runnable {

        public Reloj() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            DateFormat hora = new SimpleDateFormat("hh:mm:ss a");
            DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            while (true) {
                try {
                    Date tiempo = new Date();
                    lblFecha.setText(fecha.format(tiempo));
                    lblHora.setText(hora.format(tiempo));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    private void cerrarSesion() {
        usuario = new Usuario();
        alternarInicioSesion();
        abrirIniciarSesion();
    }
    
    private void abrirIniciarSesion() {
        var frmInicioSesion = new JDInicioSesion(this, true);
            frmInicioSesion.setLocationRelativeTo(this);
            frmInicioSesion.setVisible(true);
            
        if (frmInicioSesion.usuario.getId() != 0) {
            try {
                this.usuario = frmInicioSesion.usuario;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarUsuario;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel infoSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNumeroSesiones;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuCambiarClave;
    private javax.swing.JMenuItem mnuCerrarSesion;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuConsultarProductos;
    private javax.swing.JMenuItem mnuIniciarSesion;
    private javax.swing.JMenu mnuLogin;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenuItem mnuMantenimientoCategoria;
    private javax.swing.JMenuItem mnuMantenimientoMarca;
    private javax.swing.JMenuItem mnuMantenimientoProductos;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JPanel usuarioContenedor;
    // End of variables declaration//GEN-END:variables
}
