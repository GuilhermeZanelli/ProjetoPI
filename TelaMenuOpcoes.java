package view;


public class TelaMenuOpcoes extends javax.swing.JFrame {

    public TelaMenuOpcoes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        retornarButton = new javax.swing.JButton();
        volumeMusicaSlider = new javax.swing.JSlider();
        volumeEfeitosSlider = new javax.swing.JSlider();
        ativarButton = new javax.swing.JButton();
        desativarButton = new javax.swing.JButton();
        telaMenuOpcoesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retornarButton.setContentAreaFilled(false);
        retornarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retornarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 900, 380, 120));
        getContentPane().add(volumeMusicaSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 900, -1));
        getContentPane().add(volumeEfeitosSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 900, -1));

        ativarButton.setText("Ativar");
        getContentPane().add(ativarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 680, 160, 60));

        desativarButton.setText("Desativar");
        getContentPane().add(desativarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 680, 160, 60));

        telaMenuOpcoesLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuOpcoes.png"))); // NOI18N
        getContentPane().add(telaMenuOpcoesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retornarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_retornarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuOpcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ativarButton;
    private javax.swing.JButton desativarButton;
    private javax.swing.JButton retornarButton;
    private javax.swing.JLabel telaMenuOpcoesLabel;
    private javax.swing.JSlider volumeEfeitosSlider;
    private javax.swing.JSlider volumeMusicaSlider;
    // End of variables declaration//GEN-END:variables
}
