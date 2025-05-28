package view;

import java.awt.Color;


public class TelaGerenciarPerguntasAdicionar extends javax.swing.JFrame {

    public TelaGerenciarPerguntasAdicionar() {
        initComponents();
        enunciadoTextField.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        enunciadoButton = new javax.swing.JButton();
        enunciadoTextField = new javax.swing.JTextField();
        alternativa1Button = new javax.swing.JButton();
        alternativa1TextField = new javax.swing.JTextField();
        alternativa2Button = new javax.swing.JButton();
        alternativa2TextField = new javax.swing.JTextField();
        alternativa3Button = new javax.swing.JButton();
        alternativa3TextField = new javax.swing.JTextField();
        alternativa4Button = new javax.swing.JButton();
        alternativa4TextField = new javax.swing.JTextField();
        alternativa5Button = new javax.swing.JButton();
        alternativa5TextField = new javax.swing.JTextField();
        telaGerenciarPerguntasAdicionarLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salvarButton.setContentAreaFilled(false);
        getContentPane().add(salvarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 420, 340, 120));

        cancelarButton.setContentAreaFilled(false);
        getContentPane().add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 570, 340, 120));

        enunciadoButton.setText("Clique aqui para adicionar o enunciado");
        enunciadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enunciadoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(enunciadoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 240, 90));

        enunciadoTextField.setBackground(new java.awt.Color(8, 54, 114));
        enunciadoTextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(enunciadoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1240, 90));

        alternativa1Button.setText("Clique aqui para adicionar a 1° alternativa");
        alternativa1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 300, 100));

        alternativa1TextField.setBackground(new java.awt.Color(8, 54, 114));
        alternativa1TextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(alternativa1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 1370, 100));

        alternativa2Button.setText("Clique aqui para adicionar a 2° alternativa");
        alternativa2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 300, 100));

        alternativa2TextField.setBackground(new java.awt.Color(8, 54, 114));
        alternativa2TextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(alternativa2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 1370, 100));

        alternativa3Button.setText("Clique aqui para adicionar a 3° alternativa");
        alternativa3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa3ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 300, 110));

        alternativa3TextField.setBackground(new java.awt.Color(8, 54, 114));
        alternativa3TextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(alternativa3TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 1370, 110));

        alternativa4Button.setText("Clique aqui para adicionar a 4° alternativa");
        alternativa4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 300, 100));

        alternativa4TextField.setBackground(new java.awt.Color(8, 54, 114));
        alternativa4TextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(alternativa4TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 630, 1370, 100));

        alternativa5Button.setText("Clique aqui para adicionar a 5° alternativa");
        alternativa5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa5ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa5Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 760, 300, 100));

        alternativa5TextField.setBackground(new java.awt.Color(8, 54, 114));
        alternativa5TextField.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(alternativa5TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 760, 1370, 110));

        telaGerenciarPerguntasAdicionarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GerenciarPerguntasAdicionar3.png"))); // NOI18N
        getContentPane().add(telaGerenciarPerguntasAdicionarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enunciadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enunciadoButtonActionPerformed
        enunciadoButton.setVisible(false);
        enunciadoTextField.setVisible(true);
        enunciadoTextField.setForeground(Color.WHITE);
        enunciadoTextField.requestFocus();
    }//GEN-LAST:event_enunciadoButtonActionPerformed

    private void alternativa1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa1ButtonActionPerformed
        alternativa1Button.setVisible(false);
        alternativa1TextField.setVisible(true);
        alternativa1TextField.setForeground(Color.WHITE);
        alternativa1TextField.requestFocus();
    }//GEN-LAST:event_alternativa1ButtonActionPerformed

    private void alternativa2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa2ButtonActionPerformed
        alternativa2Button.setVisible(false);
        alternativa2TextField.setVisible(true);
        alternativa2TextField.setForeground(Color.WHITE);
        alternativa2TextField.requestFocus();
    }//GEN-LAST:event_alternativa2ButtonActionPerformed

    private void alternativa3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa3ButtonActionPerformed
        alternativa3Button.setVisible(false);
        alternativa3TextField.setVisible(true);
        alternativa3TextField.setForeground(Color.WHITE);
        alternativa3TextField.requestFocus();
    }//GEN-LAST:event_alternativa3ButtonActionPerformed

    private void alternativa4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa4ButtonActionPerformed
        alternativa4Button.setVisible(false);
        alternativa4TextField.setVisible(true);
        alternativa4TextField.setForeground(Color.WHITE);
        alternativa4TextField.requestFocus();
    }//GEN-LAST:event_alternativa4ButtonActionPerformed

    private void alternativa5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa5ButtonActionPerformed
        alternativa5Button.setVisible(false);
        alternativa5TextField.setVisible(true);
        alternativa5TextField.setForeground(Color.WHITE);
        alternativa5TextField.requestFocus();
    }//GEN-LAST:event_alternativa5ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasAdicionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarPerguntasAdicionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alternativa1Button;
    private javax.swing.JTextField alternativa1TextField;
    private javax.swing.JButton alternativa2Button;
    private javax.swing.JTextField alternativa2TextField;
    private javax.swing.JButton alternativa3Button;
    private javax.swing.JTextField alternativa3TextField;
    private javax.swing.JButton alternativa4Button;
    private javax.swing.JTextField alternativa4TextField;
    private javax.swing.JButton alternativa5Button;
    private javax.swing.JTextField alternativa5TextField;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton enunciadoButton;
    private javax.swing.JTextField enunciadoTextField;
    private javax.swing.JButton salvarButton;
    private javax.swing.JLabel telaGerenciarPerguntasAdicionarLabel;
    // End of variables declaration//GEN-END:variables
}
