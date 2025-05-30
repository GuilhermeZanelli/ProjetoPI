package view;



public class TelaMenuDoAluno extends javax.swing.JFrame {


    public TelaMenuDoAluno() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        retornarButton = new javax.swing.JButton();
        opcoesButton = new javax.swing.JButton();
        historicoDePerguntasButton = new javax.swing.JButton();
        telaMenuDoAlunoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retornarButton.setContentAreaFilled(false);
        retornarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retornarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 910, 380, 120));

        opcoesButton.setContentAreaFilled(false);
        opcoesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opcoesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 450, 380, 120));

        historicoDePerguntasButton.setContentAreaFilled(false);
        getContentPane().add(historicoDePerguntasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 520, 120));

        telaMenuDoAlunoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuDoAluno.png"))); // NOI18N
        getContentPane().add(telaMenuDoAlunoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcoesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcoesButtonActionPerformed
        var telaOpcoes = new TelaMenuOpcoes();
        telaOpcoes.setVisible(true);
    }//GEN-LAST:event_opcoesButtonActionPerformed

    private void retornarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornarButtonActionPerformed
        var telaMenu = new TelaMenuInicial();
        telaMenu.setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaMenuDoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuDoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton historicoDePerguntasButton;
    private javax.swing.JButton opcoesButton;
    private javax.swing.JButton retornarButton;
    private javax.swing.JLabel telaMenuDoAlunoLabel;
    // End of variables declaration//GEN-END:variables
}
