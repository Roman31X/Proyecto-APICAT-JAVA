package com.roman31x.proyectothecatapi.vista;

public class Menu_Favoritos extends javax.swing.JFrame {

    public Menu_Favoritos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GatoFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VER = new javax.swing.JToggleButton();
        ELIMINAR = new javax.swing.JToggleButton();
        REGRESAR = new javax.swing.JToggleButton();
        Nombre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesCAT/LogoGitHub.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel1.setText("Proyecto The Cat API");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GatoFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GatoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesCAT/asiesXD.png"))); // NOI18N
        GatoFoto.setMaximumSize(new java.awt.Dimension(400, 350));
        GatoFoto.setMinimumSize(new java.awt.Dimension(400, 350));
        GatoFoto.setPreferredSize(new java.awt.Dimension(400, 350));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setText("Selecciones nombre de la foto:");

        VER.setBackground(new java.awt.Color(255, 204, 51));
        VER.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        VER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesCAT/huellagato.png"))); // NOI18N
        VER.setText("VER FOTO");

        ELIMINAR.setBackground(new java.awt.Color(255, 204, 51));
        ELIMINAR.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        ELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesCAT/huellagato.png"))); // NOI18N
        ELIMINAR.setText("ELIMINAR DE  FAVORITO");

        REGRESAR.setBackground(new java.awt.Color(255, 204, 51));
        REGRESAR.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        REGRESAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesCAT/huellagato.png"))); // NOI18N
        REGRESAR.setText("REGRESAR");

        Nombre.setBackground(new java.awt.Color(255, 204, 51));
        Nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEOWTH" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GatoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(VER)
                            .addGap(29, 29, 29)
                            .addComponent(ELIMINAR)
                            .addGap(27, 27, 27)
                            .addComponent(REGRESAR))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VER)
                    .addComponent(ELIMINAR)
                    .addComponent(REGRESAR))
                .addGap(18, 18, 18)
                .addComponent(GatoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton ELIMINAR;
    public javax.swing.JLabel GatoFoto;
    public javax.swing.JComboBox<String> Nombre;
    public javax.swing.JToggleButton REGRESAR;
    public javax.swing.JToggleButton VER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
