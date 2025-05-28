package view;


public class TelaMenuInicial extends javax.swing.JFrame {

    public TelaMenuInicial() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sairButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        iniciarButton = new javax.swing.JButton();
        telaMenuInicialLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sairButton.setContentAreaFilled(false);
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sairButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 790, 390, 130));

        menuButton.setContentAreaFilled(false);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 630, 380, 130));

        iniciarButton.setContentAreaFilled(false);
        iniciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 630, 380, 130));

        telaMenuInicialLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuInicial.png"))); // NOI18N
        getContentPane().add(telaMenuInicialLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed

        // Verificar se há usuário logado
        if (util.SessaoUsuario.getUsuario() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhum usuário logado no sistema.");
            return;
        }

        //obter o tipo do usuário logado
        model.TipoUsuario tipoUsuario = util.SessaoUsuario.getUsuario().getTipo();

        switch(tipoUsuario) {
            case COORDENADOR:
                TelaMenuDoCoordenador telaMenuDoCoordenador = new TelaMenuDoCoordenador();
                telaMenuDoCoordenador.setVisible(true);
                this.dispose();
                break;
            case PROFESSOR:
                TelaMenuDoProfessor telaMenuDoProfessor = new TelaMenuDoProfessor();
                telaMenuDoProfessor.setVisible(true);
                this.dispose();
                break;
            case ALUNO:
                TelaMenuDoAluno telaMenuDoAluno = new TelaMenuDoAluno();
                telaMenuDoAluno.setVisible(true);
                this.dispose();
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "Tipo de usuário desconhecido: " + tipoUsuario);
                return;
        }
        
    }//GEN-LAST:event_menuButtonActionPerformed

    private void iniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarButtonActionPerformed
        TelaJogo telaJogoPerguntas = new TelaJogo();
        telaJogoPerguntas.setVisible(true);
        this.dispose();
        

    }//GEN-LAST:event_iniciarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarButton;
    private javax.swing.JButton menuButton;
    private javax.swing.JButton sairButton;
    private javax.swing.JLabel telaMenuInicialLabel;
    // End of variables declaration//GEN-END:variables
}
