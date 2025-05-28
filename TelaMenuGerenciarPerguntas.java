package view;


public class TelaMenuGerenciarPerguntas extends javax.swing.JFrame {


    public TelaMenuGerenciarPerguntas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editarPerguntaButton = new javax.swing.JButton();
        adicionarPerguntaButton = new javax.swing.JButton();
        telaMenuGerenciarPerguntasLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editarPerguntaButton.setContentAreaFilled(false);
        getContentPane().add(editarPerguntaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 370, 120));

        adicionarPerguntaButton.setContentAreaFilled(false);
        getContentPane().add(adicionarPerguntaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 480, 420, 120));

        telaMenuGerenciarPerguntasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuGerenciarPerguntas.png"))); // NOI18N
        getContentPane().add(telaMenuGerenciarPerguntasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(TelaMenuGerenciarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuGerenciarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuGerenciarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuGerenciarPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuGerenciarPerguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarPerguntaButton;
    private javax.swing.JButton editarPerguntaButton;
    private javax.swing.JLabel telaMenuGerenciarPerguntasLabel;
    // End of variables declaration//GEN-END:variables
}
