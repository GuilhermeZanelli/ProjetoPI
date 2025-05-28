package view;



public class TelaMenuDoProfessor extends javax.swing.JFrame {


    public TelaMenuDoProfessor() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gerenciarCheckpointButton = new javax.swing.JButton();
        historicoDePerguntasButton = new javax.swing.JButton();
        gerenciarPerguntasButton = new javax.swing.JButton();
        visualizarRankingButton = new javax.swing.JButton();
        gerenciarAlunosButton = new javax.swing.JButton();
        opcoesButton = new javax.swing.JButton();
        retornarButton = new javax.swing.JButton();
        telaMenuDoProfessorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gerenciarCheckpointButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarCheckpointButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 490, 130));

        historicoDePerguntasButton.setContentAreaFilled(false);
        getContentPane().add(historicoDePerguntasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 510, 120));

        gerenciarPerguntasButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarPerguntasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 460, 130));

        visualizarRankingButton.setContentAreaFilled(false);
        getContentPane().add(visualizarRankingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 400, 120));

        gerenciarAlunosButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarAlunosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 480, 380, 110));

        opcoesButton.setContentAreaFilled(false);
        opcoesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opcoesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 630, 380, 120));

        retornarButton.setContentAreaFilled(false);
        retornarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retornarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 900, 380, 120));

        telaMenuDoProfessorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuDoProfessor.png"))); // NOI18N
        getContentPane().add(telaMenuDoProfessorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retornarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornarButtonActionPerformed
        var telaMenu = new TelaMenuInicial();
        telaMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retornarButtonActionPerformed

    private void opcoesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcoesButtonActionPerformed
        var telaOpcoes = new TelaMenuOpcoes();
        telaOpcoes.setVisible(true);
    }//GEN-LAST:event_opcoesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuDoProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuDoProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton gerenciarCheckpointButton;
    private javax.swing.JButton gerenciarPerguntasButton;
    private javax.swing.JButton historicoDePerguntasButton;
    private javax.swing.JButton opcoesButton;
    private javax.swing.JButton retornarButton;
    private javax.swing.JLabel telaMenuDoProfessorLabel;
    private javax.swing.JButton visualizarRankingButton;
    // End of variables declaration//GEN-END:variables
}
