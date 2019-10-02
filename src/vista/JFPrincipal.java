package vista;

public class JFPrincipal extends javax.swing.JFrame {

    public JFPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnIniciarSesion = new javax.swing.JButton();
        btnCambiarUsuario = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnConsultarProductos = new javax.swing.JButton();
        btnAdministrarVentas = new javax.swing.JButton();
        btnMantenimientoClientes = new javax.swing.JButton();
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
        mnuMantenimientoUsuarios = new javax.swing.JMenuItem();
        mnuMantenimientoMarca = new javax.swing.JMenuItem();
        mnuMantenimientoCategoria = new javax.swing.JMenuItem();
        mnuMantenimientoProductos = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuConsultarProductos = new javax.swing.JMenuItem();
        mnuMantenimientoClientes = new javax.swing.JMenuItem();
        mnuAdministrarVentas = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de comercialización");

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
        jToolBar1.add(btnCerrarSesion);
        jToolBar1.add(jSeparator3);

        btnConsultarProductos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnConsultarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/consultar.png"))); // NOI18N
        btnConsultarProductos.setText("Productos");
        btnConsultarProductos.setFocusable(false);
        btnConsultarProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarProductos.setMinimumSize(new java.awt.Dimension(70, 75));
        btnConsultarProductos.setPreferredSize(new java.awt.Dimension(70, 75));
        btnConsultarProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnConsultarProductos);

        btnAdministrarVentas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAdministrarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ventas.png"))); // NOI18N
        btnAdministrarVentas.setText("Venta");
        btnAdministrarVentas.setFocusable(false);
        btnAdministrarVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdministrarVentas.setMinimumSize(new java.awt.Dimension(70, 75));
        btnAdministrarVentas.setPreferredSize(new java.awt.Dimension(70, 75));
        btnAdministrarVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnAdministrarVentas);

        btnMantenimientoClientes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnMantenimientoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/clientes.png"))); // NOI18N
        btnMantenimientoClientes.setText("Clientes");
        btnMantenimientoClientes.setFocusable(false);
        btnMantenimientoClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMantenimientoClientes.setPreferredSize(new java.awt.Dimension(70, 75));
        btnMantenimientoClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnMantenimientoClientes);

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
        mnuLogin.add(mnuCerrarSesion);

        mnuCambiarClave.setText("Cambiar Contraseña");
        mnuLogin.add(mnuCambiarClave);

        jMenuBar1.add(mnuLogin);

        mnuMantenimiento.setText("Mantenimiento");

        mnuMantenimientoUsuarios.setText("Usuarios");
        mnuMantenimiento.add(mnuMantenimientoUsuarios);

        mnuMantenimientoMarca.setText("Marcas");
        mnuMantenimiento.add(mnuMantenimientoMarca);

        mnuMantenimientoCategoria.setText("Categorías");
        mnuMantenimiento.add(mnuMantenimientoCategoria);

        mnuMantenimientoProductos.setText("Productos");
        mnuMantenimiento.add(mnuMantenimientoProductos);

        jMenuBar1.add(mnuMantenimiento);

        mnuVentas.setText("Ventas");

        mnuConsultarProductos.setText("Productos");
        mnuVentas.add(mnuConsultarProductos);

        mnuMantenimientoClientes.setText("Clientes");
        mnuVentas.add(mnuMantenimientoClientes);

        mnuAdministrarVentas.setText("Venta");
        mnuVentas.add(mnuAdministrarVentas);

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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAdministrarVentas;
    protected javax.swing.JButton btnCambiarUsuario;
    protected javax.swing.JButton btnCerrarSesion;
    protected javax.swing.JButton btnConsultarProductos;
    protected javax.swing.JButton btnIniciarSesion;
    protected javax.swing.JButton btnMantenimientoClientes;
    protected javax.swing.JButton btnPagar;
    protected javax.swing.JPanel infoSesion;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JMenuItem jMenuItem10;
    protected javax.swing.JMenuItem jMenuItem11;
    protected javax.swing.JMenuItem jMenuItem12;
    protected javax.swing.JMenuItem jMenuItem13;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JToolBar.Separator jSeparator1;
    protected javax.swing.JSeparator jSeparator2;
    protected javax.swing.JToolBar.Separator jSeparator3;
    protected javax.swing.JToolBar jToolBar1;
    protected javax.swing.JLabel lblFecha;
    protected javax.swing.JLabel lblHora;
    protected javax.swing.JLabel lblNumeroSesiones;
    protected javax.swing.JLabel lblSesion;
    protected javax.swing.JLabel lblUsuario;
    protected javax.swing.JMenuItem mnuAdministrarVentas;
    protected javax.swing.JMenuItem mnuCambiarClave;
    protected javax.swing.JMenuItem mnuCerrarSesion;
    protected javax.swing.JMenuItem mnuConsultarProductos;
    protected javax.swing.JMenuItem mnuIniciarSesion;
    protected javax.swing.JMenu mnuLogin;
    protected javax.swing.JMenu mnuMantenimiento;
    protected javax.swing.JMenuItem mnuMantenimientoCategoria;
    protected javax.swing.JMenuItem mnuMantenimientoClientes;
    protected javax.swing.JMenuItem mnuMantenimientoMarca;
    protected javax.swing.JMenuItem mnuMantenimientoProductos;
    protected javax.swing.JMenuItem mnuMantenimientoUsuarios;
    protected javax.swing.JMenu mnuReportes;
    protected javax.swing.JMenu mnuVentas;
    protected javax.swing.JPanel usuarioContenedor;
    // End of variables declaration//GEN-END:variables
}
