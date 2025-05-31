package view;


public class TelaMenuDoCoordenador extends javax.swing.JFrame {


    public TelaMenuDoCoordenador() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gerenciarProfessoresButton = new javax.swing.JButton();
        gerenciarCheckpointButton = new javax.swing.JButton();
        historicoPerguntasButton = new javax.swing.JButton();
        gerenciarPerguntasButton = new javax.swing.JButton();
        visualizarRankingButton = new javax.swing.JButton();
        gerenciarAlunosButton = new javax.swing.JButton();
        opcoesButton = new javax.swing.JButton();
        retornarButton = new javax.swing.JButton();
        telaMenuDoCoordenadorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gerenciarProfessoresButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarProfessoresButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 500, 130));

        gerenciarCheckpointButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarCheckpointButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 490, 120));

        historicoPerguntasButton.setContentAreaFilled(false);
        getContentPane().add(historicoPerguntasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 520, 120));

        gerenciarPerguntasButton.setContentAreaFilled(false);
        gerenciarPerguntasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarPerguntasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(gerenciarPerguntasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 460, 120));

        visualizarRankingButton.setContentAreaFilled(false);
        getContentPane().add(visualizarRankingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 400, 120));

        gerenciarAlunosButton.setContentAreaFilled(false);
        getContentPane().add(gerenciarAlunosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 480, 390, 120));

        opcoesButton.setContentAreaFilled(false);
        opcoesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opcoesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 650, 380, 120));

        retornarButton.setContentAreaFilled(false);
        retornarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retornarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 910, 380, 120));

        telaMenuDoCoordenadorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuDoCoordenador.png"))); // NOI18N
        getContentPane().add(telaMenuDoCoordenadorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

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

    private void gerenciarPerguntasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarPerguntasButtonActionPerformed
        var telaMenuGerenciarPerguntasCoordenador = new TelaMenuGerenciarPerguntasCoordenador();
        telaMenuGerenciarPerguntasCoordenador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gerenciarPerguntasButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuDoCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuDoCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuDoCoordenador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton gerenciarCheckpointButton;
    private javax.swing.JButton gerenciarPerguntasButton;
    private javax.swing.JButton gerenciarProfessoresButton;
    private javax.swing.JButton historicoPerguntasButton;
    private javax.swing.JButton opcoesButton;
    private javax.swing.JButton retornarButton;
    private javax.swing.JLabel telaMenuDoCoordenadorLabel;
    private javax.swing.JButton visualizarRankingButton;
    // End of variables declaration//GEN-END:variables
}
