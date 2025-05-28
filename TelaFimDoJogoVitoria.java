package view;


public class TelaFimDoJogoVitoria extends javax.swing.JFrame {

    public TelaFimDoJogoVitoria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        premioLabel = new javax.swing.JLabel();
        reiniciarButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        telaFimDoJogoVitoriaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        premioLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        premioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(premioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 630, 90));

        reiniciarButton.setContentAreaFilled(false);
        getContentPane().add(reiniciarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 750, 390, 130));

        sairButton.setContentAreaFilled(false);
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sairButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 750, 390, 130));

        telaFimDoJogoVitoriaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FimDoJogoVitoria.png"))); // NOI18N
        getContentPane().add(telaFimDoJogoVitoriaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFimDoJogoVitoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFimDoJogoVitoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFimDoJogoVitoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFimDoJogoVitoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFimDoJogoVitoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel premioLabel;
    private javax.swing.JButton reiniciarButton;
    private javax.swing.JButton sairButton;
    private javax.swing.JLabel telaFimDoJogoVitoriaLabel;
    // End of variables declaration//GEN-END:variables
}
