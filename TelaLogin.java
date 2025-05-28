package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.LoginController;
import controller.UsuarioController;
import dao.UsuarioDAO;
import model.TipoUsuario;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        confirmacaoSenhaLabel = new javax.swing.JLabel();
        confirmacaoSenhaPasswordField = new javax.swing.JPasswordField();
        senhaPasswordField = new javax.swing.JPasswordField();
        entrarButton = new javax.swing.JButton();
        cadastrarButton = new javax.swing.JButton();
        telaLoginLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 730, 30));

        nomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        nomeLabel.setText("NOME DE EXIBIÇÃO");
        getContentPane().add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 610, 180, 30));
        getContentPane().add(nomeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 640, 650, 30));

        confirmacaoSenhaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmacaoSenhaLabel.setForeground(new java.awt.Color(255, 255, 255));
        confirmacaoSenhaLabel.setText("CONFIRME A SENHA");
        confirmacaoSenhaLabel.setToolTipText("CONFIRME A SENHA");
        getContentPane().add(confirmacaoSenhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 706, 140, 20));
        getContentPane().add(confirmacaoSenhaPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 730, 650, 30));

        senhaPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(senhaPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 730, 730, 30));

        entrarButton.setContentAreaFilled(false);
        entrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(entrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 790, 1470, 40));

        cadastrarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cadastrarButton.setText("Cadastrar-se");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 860, 1450, 60));

        telaLoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelaLogin.png"))); // NOI18N
        getContentPane().add(telaLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void senhaPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaPasswordFieldActionPerformed
        
    }//GEN-LAST:event_senhaPasswordFieldActionPerformed

    private void entrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButtonActionPerformed
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String senha = new String(senhaPasswordField.getPassword());
        String confirmacaoSenha = new String(confirmacaoSenhaPasswordField.getPassword());

        if (email.isEmpty() || senha.isEmpty() || nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        };

        // Sistema especial para coordenador
        if ("coordenador".equals(nome) && "coordenador".equals(email) && "coordenador".equals(senha)) {
            try {
                // Criar um usuário coordenador temporário para a sessão
                model.Usuario coordenador = new model.Usuario();
                coordenador.setId(999); // ID temporário para o coordenador especial
                coordenador.setNome("Coordenador 1");
                coordenador.setEmail("coordenador@poliedro.com");
                coordenador.setTipo(model.TipoUsuario.COORDENADOR);
                coordenador.setPontuacao(0);
                coordenador.setAjudaDisponivel(3);
                coordenador.setSaldo(0);

                // Definir o usuário na sessão
                util.SessaoUsuario.setUsuario(coordenador);
            
                JOptionPane.showMessageDialog(this, "Login como Coordenador realizado com sucesso!");
                new TelaMenuInicial().setVisible(true);
                this.dispose();
                return;
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao fazer login como coordenador: " + e.getMessage());
                return;
            }
        }

        LoginController login = new LoginController(new UsuarioDAO());
        if(login.autenticar(email, senha)){
            try {
                model.Usuario usuarioLogado = login.login(nome, email, senha);
    
                if (usuarioLogado != null) {
                    util.SessaoUsuario.setUsuario(usuarioLogado);
                    JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                    new TelaMenuInicial().setVisible(true);
                    this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
                }
            } 
            catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro no banco de dados: " + e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
        }
    }


//GEN-LAST:event_entrarButtonActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String senha = new String(senhaPasswordField.getPassword());
        String confirmacaoSenha = new String(confirmacaoSenhaPasswordField.getPassword());
        TipoUsuario tipo = null;

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                return;
        }

        if (email.contains("@poliedro.com")){
            tipo = model.TipoUsuario.ALUNO;
        } else if (email.contains("@p4ed.com")){
            tipo = model.TipoUsuario.PROFESSOR;
        }
        if (tipo == null) {
            JOptionPane.showMessageDialog(null, "E-mail inválido. Use um e-mail institucional com @poliedro.com ou @p4ed.com.");
            return; 
        }
        
        if (senha.equals(confirmacaoSenha)){
            try {
                UsuarioController cadastro = new UsuarioController(new UsuarioDAO());
                boolean sucesso = cadastro.cadastrarUsuario(nome, email, senha, tipo);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                
                    //faz login automático após cadastro
                    try {
                        LoginController login = new LoginController(new UsuarioDAO());
                        model.Usuario usuarioLogado = login.login(nome, email, senha);
                        
                        if (usuarioLogado != null) {
                            // Define o usuário na sessão ativa
                            util.SessaoUsuario.setUsuario(usuarioLogado);
                        
                            new TelaMenuInicial().setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário cadastrado, mas erro no login automático. Tente fazer login manualmente.");
                        }
                        
                    } catch (SQLException loginException) {
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado, mas erro no login automático: " + loginException.getMessage());
                    }
                
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
        }


    }//GEN-LAST:event_cadastrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel confirmacaoSenhaLabel;
    private javax.swing.JPasswordField confirmacaoSenhaPasswordField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton entrarButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JPasswordField senhaPasswordField;
    private javax.swing.JLabel telaLoginLabel;
    // End of variables declaration//GEN-END:variables
}
