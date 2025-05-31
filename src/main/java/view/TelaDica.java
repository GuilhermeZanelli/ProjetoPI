package view;



public class TelaDica extends javax.swing.JFrame {


    public TelaDica() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminar3AlternativasButton = new javax.swing.JButton();
        eliminar2AlternativasButton = new javax.swing.JButton();
        pularButton = new javax.swing.JButton();
        fecharButton = new javax.swing.JButton();
        telaDicaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eliminar3AlternativasButton.setContentAreaFilled(false);
        getContentPane().add(eliminar3AlternativasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 540, 90));

        eliminar2AlternativasButton.setContentAreaFilled(false);
        getContentPane().add(eliminar2AlternativasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 550, 90));

        pularButton.setContentAreaFilled(false);
        getContentPane().add(pularButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 180, 90));

        fecharButton.setContentAreaFilled(false);
        getContentPane().add(fecharButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 350, 110));

        telaDicaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelaDica.png"))); // NOI18N
        getContentPane().add(telaDicaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar2AlternativasButton;
    private javax.swing.JButton eliminar3AlternativasButton;
    private javax.swing.JButton fecharButton;
    private javax.swing.JButton pularButton;
    private javax.swing.JLabel telaDicaLabel;
    // End of variables declaration//GEN-END:variables
}
