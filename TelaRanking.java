package view;


public class TelaRanking extends javax.swing.JFrame {

    public TelaRanking() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voltarButton = new javax.swing.JButton();
        rankingNomeLabel = new javax.swing.JLabel();
        rankingPontuacaoLabel = new javax.swing.JLabel();
        telaRankingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton.setContentAreaFilled(false);
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 860, 370, 120));

        rankingNomeLabel.setBackground(new java.awt.Color(0, 0, 0));
        rankingNomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rankingNomeLabel.setText("\n");
        rankingNomeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rankingNomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 620, 620));

        rankingPontuacaoLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(rankingPontuacaoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 610, 620));

        telaRankingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuRanking2.png"))); // NOI18N
        getContentPane().add(telaRankingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

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
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel rankingNomeLabel;
    private javax.swing.JLabel rankingPontuacaoLabel;
    private javax.swing.JLabel telaRankingLabel;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
