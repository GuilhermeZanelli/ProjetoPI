/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.PerguntaController;
import dao.FeedbackDAO;
import dao.PerguntaDAO;
import model.Feedback;
import model.Pergunta;
import model.Resposta;

/**
 *
 * @author guilh
 */
public class TelaGerenciarPerguntasEditarCoordenador extends javax.swing.JFrame {

    private Pergunta perguntaAtualTela; // Variável para armazenar a pergunta atual
    /**
     * Creates new form TelaGerenciarPerguntasEditarCoordenador
     */
    public TelaGerenciarPerguntasEditarCoordenador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enunciadoButton = new javax.swing.JButton();
        enunciadoTextField = new javax.swing.JTextField();
        alternativa1Label = new javax.swing.JLabel();
        alternativa2Label = new javax.swing.JLabel();
        alternativa3Label = new javax.swing.JLabel();
        alternativa4Label = new javax.swing.JLabel();
        alternativa5Label = new javax.swing.JLabel();
        feedbackLabel = new javax.swing.JLabel();
        feedbackTextField = new javax.swing.JTextField();
        dificuldadeLabel = new javax.swing.JLabel();
        dificuldadeTextField = new javax.swing.JTextField();
        excluirPerguntaButton = new javax.swing.JButton();
        sairButton = new javax.swing.JButton();
        buscarPerguntaButton = new javax.swing.JButton();
        editarPerguntasLabel = new javax.swing.JLabel();
        telaGerenciarPerguntasEditarCoordenadorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enunciadoButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        enunciadoButton.setText("Clique aqui para digitar o enunciado da pergunta: ");
        enunciadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enunciadoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(enunciadoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 570, 110));

        enunciadoTextField.setBackground(new java.awt.Color(8, 54, 114));
        enunciadoTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        enunciadoTextField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(enunciadoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 1210, 110));

        alternativa1Label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        alternativa1Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 1380, 100));

        alternativa2Label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        alternativa2Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 1380, 100));

        alternativa3Label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        alternativa3Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 1380, 100));

        alternativa4Label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        alternativa4Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 1380, 100));

        alternativa5Label.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        alternativa5Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa5Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 760, 1380, 100));

        feedbackLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        feedbackLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(feedbackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 900, 660, 100));

        feedbackTextField.setBackground(new java.awt.Color(8, 54, 114));
        feedbackTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        feedbackTextField.setForeground(new java.awt.Color(255, 255, 255));
        feedbackTextField.setText("FEEDBACK:");
        getContentPane().add(feedbackTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 900, 790, 100));

        dificuldadeLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dificuldadeLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dificuldadeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 900, 520, 100));

        dificuldadeTextField.setBackground(new java.awt.Color(8, 54, 114));
        dificuldadeTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dificuldadeTextField.setForeground(new java.awt.Color(255, 255, 255));
        dificuldadeTextField.setText("DIFICULDADE: ");
        getContentPane().add(dificuldadeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 900, 690, 100));

        excluirPerguntaButton.setBackground(new java.awt.Color(18, 54, 114));
        excluirPerguntaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        excluirPerguntaButton.setForeground(new java.awt.Color(255, 255, 255));
        excluirPerguntaButton.setText("Excluir pergunta");
        excluirPerguntaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirPerguntaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(excluirPerguntaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 420, 360, 130));

        sairButton.setContentAreaFilled(false);
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sairButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 580, 340, 110));

        buscarPerguntaButton.setBackground(new java.awt.Color(18, 54, 114));
        buscarPerguntaButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buscarPerguntaButton.setForeground(new java.awt.Color(255, 255, 255));
        buscarPerguntaButton.setText("Buscar pergunta");
        buscarPerguntaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPerguntaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarPerguntaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 730, 360, 130));

        editarPerguntasLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GerenciarPerguntasAdicionar3.png"))); // NOI18N
        getContentPane().add(editarPerguntasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1080));

        telaGerenciarPerguntasEditarCoordenadorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GerenciarPerguntasAdicionar3.png"))); // NOI18N
        getContentPane().add(telaGerenciarPerguntasEditarCoordenadorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enunciadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enunciadoButtonActionPerformed
        enunciadoButton.setVisible(false);
        enunciadoTextField.setVisible(true);
        enunciadoTextField.requestFocus();
    }//GEN-LAST:event_enunciadoButtonActionPerformed

    private void excluirPerguntaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirPerguntaButtonActionPerformed

        try {
            // Verificar se há uma pergunta carregada
            if (perguntaAtualTela == null) {
                JOptionPane.showMessageDialog(this,
                    "Nenhuma pergunta foi carregada. Busque uma pergunta primeiro.",
                    "Pergunta Não Carregada",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Confirmar exclusão com o enunciado
            int opcao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir esta pergunta?\n" +
                "Enunciado: " + perguntaAtualTela.getEnunciado() + "\n" +
                "Esta ação não pode ser desfeita.",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if (opcao == JOptionPane.YES_OPTION) {
                PerguntaDAO perguntaDAO = new PerguntaDAO();
                FeedbackDAO feedbackDAO = new FeedbackDAO();
                PerguntaController controller = new PerguntaController(perguntaDAO, feedbackDAO);

                boolean sucesso = controller.deletarPergunta(perguntaAtualTela.getId());

                if (sucesso) {
                    JOptionPane.showMessageDialog(this,
                        "Pergunta excluída com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                    enunciadoTextField.setText("");
                    perguntaAtualTela = null; // Limpar a pergunta atual
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Erro ao excluir pergunta.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao excluir pergunta: " + e.getMessage(),
                "Erro de Banco de Dados",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro inesperado: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_excluirPerguntaButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        var telaMenuGerenciarPerguntasCoordenador = new TelaMenuGerenciarPerguntasCoordenador();
        telaMenuGerenciarPerguntasCoordenador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sairButtonActionPerformed

    private void buscarPerguntaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPerguntaButtonActionPerformed

        try {
            String enunciadoDigitado = enunciadoTextField.getText().trim();

            if (enunciadoDigitado.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor, digite o enunciado da pergunta.",
                    "Campo Obrigatório",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            PerguntaDAO perguntaDAO = new PerguntaDAO();
            perguntaAtualTela = perguntaDAO.buscarUltimaPorEnunciado(enunciadoDigitado);

            if (perguntaAtualTela == null) {
                JOptionPane.showMessageDialog(this,
                    "Pergunta não encontrada com esse enunciado.",
                    "Pergunta Não Encontrada",
                    JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                return;
            }

            exibirInformacoesPergunta(perguntaAtualTela);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao buscar pergunta: " + e.getMessage(),
                "Erro de Banco de Dados",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro inesperado: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_buscarPerguntaButtonActionPerformed

    public String converterDificuldadeParaString(int dificuldade) {
        switch (dificuldade) {
            case 1:
                return "Fácil";
            case 2:
                return "Médio";
            case 3:
                return "Difícil";
            case 4:
                return "Milhão";
            default:
                return "Desconhecido";
        }
    }

    private void exibirInformacoesPergunta(Pergunta pergunta) {
        try {
            // Exibir informações básicas da pergunta
            var perguntaNumero = pergunta.getIdDificuldade();
            var dificuldadePergunta = converterDificuldadeParaString(perguntaNumero);
            dificuldadeLabel.setText(dificuldadePergunta);

            alternativa1Label.setText("");
            alternativa2Label.setText("");
            alternativa3Label.setText("");
            alternativa4Label.setText("");
            alternativa5Label.setText("");
            
        if (pergunta.getRespostas() != null && !pergunta.getRespostas().isEmpty()) {
            for (int i = 0; i < pergunta.getRespostas().size() && i < 5; i++) {
                Resposta resposta = pergunta.getRespostas().get(i);
                String textoAlternativa = resposta.getTextoResposta();
                if (resposta.isCorreta()) {
                    textoAlternativa += " (CORRETA)";
                }
                
                // Definir texto no label correspondente
                switch (i) {
                    case 0:
                        alternativa1Label.setText(textoAlternativa);
                        break;
                    case 1:
                        alternativa2Label.setText(textoAlternativa);
                        break;
                    case 2:
                        alternativa3Label.setText(textoAlternativa);
                        break;
                    case 3:
                        alternativa4Label.setText(textoAlternativa);
                        break;
                    case 4:
                        alternativa5Label.setText(textoAlternativa);
                        break;
                }
            }
        }
            
            // Buscar e exibir feedback
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            Feedback feedback = feedbackDAO.buscarPorPergunta(pergunta.getId());
            if (feedback != null) {
                feedbackLabel.setText(feedback.getTexto());
            } else {
                feedbackLabel.setText("Sem feedback cadastrado.");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao carregar feedback: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            feedbackLabel.setText("Erro ao carregar feedback.");
        }
    }

    private void limparCampos() {
        dificuldadeLabel.setText("");
            
        // Limpar labels das alternativas individuais
        alternativa1Label.setText("");
        alternativa2Label.setText("");
        alternativa3Label.setText("");
        alternativa4Label.setText("");
        alternativa5Label.setText("");
            
        feedbackLabel.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasEditarCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasEditarCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasEditarCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarPerguntasEditarCoordenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarPerguntasEditarCoordenador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alternativa1Label;
    private javax.swing.JLabel alternativa2Label;
    private javax.swing.JLabel alternativa3Label;
    private javax.swing.JLabel alternativa4Label;
    private javax.swing.JLabel alternativa5Label;
    private javax.swing.JButton buscarPerguntaButton;
    private javax.swing.JLabel dificuldadeLabel;
    private javax.swing.JTextField dificuldadeTextField;
    private javax.swing.JLabel editarPerguntasLabel;
    private javax.swing.JButton enunciadoButton;
    private javax.swing.JTextField enunciadoTextField;
    private javax.swing.JButton excluirPerguntaButton;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JTextField feedbackTextField;
    private javax.swing.JButton sairButton;
    private javax.swing.JLabel telaGerenciarPerguntasEditarCoordenadorLabel;
    // End of variables declaration//GEN-END:variables
}
