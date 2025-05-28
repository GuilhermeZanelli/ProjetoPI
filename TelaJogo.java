package view;

import controller.PerguntaController;
import controller.RespostaController;
import controller.AjudaController;
import dao.AjudaDAO;
import dao.FeedbackDAO;
import dao.PerguntaDAO;
import dao.RespostaDAO;
import model.Pergunta;
import model.Resposta;
import model.Ajuda;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;

public class TelaJogo extends javax.swing.JFrame {


    // Definir valores de pontuação baseados no Show do Milhão
    private String pontuacaoPrevia, pontuacaoProxima;
    private String pontuacaoFinal;
    private String pontuacaoAtual = "R$: 0";
    // Controllers
    private PerguntaController perguntaController;
    private RespostaController respostaController;
    private AjudaController ajudaController;
    
    // Dados da questão atual
    private Pergunta perguntaAtual;
    private List<Resposta> respostasAtuais;
    private Resposta respostaCorreta;
    private int nivelAtual = 1; // Começar no nível 1
    
    // Mapeamento dos botões para índices das respostas
    private int[] indiceResposta = new int[5]; // Para mapear qual resposta está em cada botão


    public TelaJogo() {
        initComponents();
        inicializarControllers();
        carregarPrimeiraQuestao();
    }

    public String getPontuacaoFinal(){
        return pontuacaoFinal;
    }
    
    private void inicializarControllers() {
        // Você precisará injetar os DAOs conforme sua implementação
        // Exemplo assumindo que você tem uma factory ou singleton para DAOs:
        try {
            PerguntaDAO perguntaDAO = new PerguntaDAO(); // ou DAOFactory.getPerguntaDAO();
            FeedbackDAO feedbackDAO = new FeedbackDAO(); // ou DAOFactory.getFeedbackDAO();
            RespostaDAO respostaDAO = new RespostaDAO(); // ou DAOFactory.getRespostaDAO();
            AjudaDAO dicaDAO = new AjudaDAO(); // ou DAOFactory.getDicaDAO();
            
            this.perguntaController = new PerguntaController(perguntaDAO, feedbackDAO);
            this.respostaController = new RespostaController(respostaDAO);
            this.ajudaController = new AjudaController(dicaDAO);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar controllers: " + e.getMessage());
            e.printStackTrace();
        }
    }

        private void carregarPrimeiraQuestao() {
        carregarQuestao(nivelAtual);
    }
        private void carregarQuestao(int nivel) {
        try {
            // Buscar pergunta do nível especificado
            perguntaAtual = perguntaController.buscarPerguntaPorNivel(nivel);
            
            if (perguntaAtual == null) {
                JOptionPane.showMessageDialog(this, "Não há mais perguntas disponíveis!");
                return;
            }
            
            // Buscar respostas da pergunta
            respostasAtuais = respostaController.listarRespostasDaPergunta(perguntaAtual.getId());
            
            if (respostasAtuais.size() != 5) {
                JOptionPane.showMessageDialog(this, "Erro: A pergunta deve ter exatamente 5 alternativas!");
                return;
            }
            
            // Identificar a resposta correta
            for (Resposta resposta : respostasAtuais) {
                if (resposta.isCorreta()) {
                    respostaCorreta = resposta;
                    break;
                }
            }
            
            // Embaralhar as respostas para randomizar a posição
            Collections.shuffle(respostasAtuais);
            
            // Exibir a questão na tela
            exibirQuestao();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar questão: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
    private void exibirQuestao() {
        // Exibir o enunciado
        enunciadoLabel.setText("<html><div style='text-align: center;'>" + 
                              perguntaAtual.getEnunciado() + "</div></html>");
        
        // Exibir as alternativas
        javax.swing.JLabel[] labels = {alternativa1Label, alternativa2Label, alternativa3Label, 
                                     alternativa4Label, alternativa5Label};
        
        for (int i = 0; i < 5; i++) {
            if (i < respostasAtuais.size()) {
                Resposta resposta = respostasAtuais.get(i);
                labels[i].setText("<html>" + resposta.getTextoResposta() + "</html>");
                indiceResposta[i] = resposta.getId(); // Mapear o ID da resposta
            }
        }
        
        // Atualizar informações de nível/pontuação
        atualizarInformacoesJogo();
    }

        private void atualizarInformacoesJogo() {        

        switch (nivelAtual) {
            case 1:
                pontuacaoPrevia = "R$: 0";
                pontuacaoAtual = "R$: 0";
                pontuacaoProxima = "R$: 1.000";
                break;
            case 2:
                pontuacaoPrevia = "R$: 0";
                pontuacaoAtual = "R$: 1.000";
                pontuacaoProxima = "R$: 2.000";
                break;
            case 3:
                pontuacaoPrevia = "R$: 1.000";
                pontuacaoAtual = "R$: 2.000";
                pontuacaoProxima = "R$: 3.000";
                break;
            case 4:     //checkpoint
                pontuacaoPrevia = "R$: 2.000";
                pontuacaoAtual = "R$: 3.000";
                pontuacaoProxima = "R$: 4.000";
                break;
            case 5:   
                pontuacaoPrevia = "R$: 3.000";
                pontuacaoAtual = "R$: 4.000";
                pontuacaoProxima = "R$: 5.000";
                break;
            case 6:
                pontuacaoPrevia = "R$: 3.000";
                pontuacaoAtual = "R$: 5.000";
                pontuacaoProxima = "R$: 10.000";
                break;
            case 7:
                pontuacaoPrevia = "R$: 3.000";
                pontuacaoAtual = "R$: 10.000";
                pontuacaoProxima = "R$: 20.000";
                break;
            case 8:     //checkpoint
                pontuacaoPrevia = "R$: 3.000";
                pontuacaoAtual = "R$: 20.000";
                pontuacaoProxima = "R$: 30.000";
                break;
            case 9:    
                pontuacaoPrevia = "R$: 20.000";
                pontuacaoAtual = "R$: 30.000";
                pontuacaoProxima = "R$: 40.000";
                break;
            case 10:
                pontuacaoPrevia = "R$: 20.000";
                pontuacaoAtual = "R$: 40.000";
                pontuacaoProxima = "R$: 50.000";
                break;
            case 11:
                pontuacaoPrevia = "R$: 20.000";
                pontuacaoAtual = "R$: 50.000";
                pontuacaoProxima = "R$: 100.000";
                break;
            case 12:        //checkpoint
                pontuacaoPrevia = "R$: 20.000";
                pontuacaoAtual = "R$: 100.000";
                pontuacaoProxima = "R$: 200.000";
                break;
            case 13:
                pontuacaoPrevia = "R$: 100.000";
                pontuacaoAtual = "R$: 200.000";
                pontuacaoProxima = "R$: 300.000";
                break;
            case 14:
                pontuacaoPrevia = "R$: 100.000";
                pontuacaoAtual = "R$: 300.000";
                pontuacaoProxima = "R$: 400.000";
                break;
            case 15:
                pontuacaoPrevia = "R$: 100.000";
                pontuacaoAtual = "R$: 400.000";
                pontuacaoProxima = "R$: 500.000";
                break;
            case 16:
                pontuacaoPrevia = "R$: 0";
                pontuacaoAtual = "R$: 500.000";
                pontuacaoProxima = "R$: 1.000.000";
                break;
            default: pontuacaoAtual = "Sem prêmio";
        }
        // Atualizar labels de informação (assumindo que existem)
        atualizarLabelsDePontuacao();
        // Você pode adicionar labels para mostrar nível e pontuação atual
        this.setTitle("Show do Milhão - Nível " + nivelAtual + " - R$ " + pontuacaoAtual);
    }
    
    private void processarResposta(int botaoClicado) {
        try {
            // Buscar a resposta selecionada
            int idRespostaSelecionada = indiceResposta[botaoClicado];
            Resposta respostaSelecionada = null;
            
            for (Resposta resposta : respostasAtuais) {
                if (resposta.getId() == idRespostaSelecionada) {
                    respostaSelecionada = resposta;
                    break;
                }
            }
            
            if (respostaSelecionada == null) {
                JOptionPane.showMessageDialog(this, "Erro ao processar resposta!");
                return;
            }
            
            // Verificar se a resposta está correta
            if (respostaSelecionada.isCorreta()) {
                // Resposta correta
                JOptionPane.showMessageDialog(this, "Parabéns! Resposta correta!");
                
                // Avançar para próximo nível
                nivelAtual++;
                
                if (nivelAtual > 16) { // Assumindo 16 níveis como no Show do Milhão
                    pontuacaoFinal = pontuacaoAtual;
                    JOptionPane.showMessageDialog(this, "PARABÉNS! VOCÊ GANHOU O MILHÃO!");
                    TelaFimDoJogoVitoria telaFim = new TelaFimDoJogoVitoria("R$: 1.000.000");
                    telaFim.setVisible(true);
                    this.dispose();
                    return;
                }
                
                // Carregar próxima questão
                Thread.sleep(1000); 
                limparLabelsResultado();
                carregarQuestao(nivelAtual);
                
            } else {
                // Resposta incorreta
                pontuacaoFinal = pontuacaoPrevia;
                JOptionPane.showMessageDialog(this, "Resposta incorreta!");
                // Mostrar a resposta correta
                JOptionPane.showMessageDialog(this, "A resposta correta era: " + respostaCorreta.getTextoResposta());
                TelaFimDoJogoVitoria telaFim = new TelaFimDoJogoVitoria(pontuacaoFinal);
                telaFim.setVisible(true);
                this.dispose();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao processar resposta: " + e.getMessage());
            e.printStackTrace();
        }
    }   

    private void atualizarLabelsDePontuacao() {
        // Parar: mostra a pontuação atual (nível atual - 1)
        pararLabel.setText(pontuacaoAtual);

        // Errar: mostra o prêmio anterior (nívelAtual - 2), ou zero se for a primeira rodada
        errarLabel.setText(pontuacaoPrevia);

        // Acertar: mostra o prêmio da próxima rodada, se houver
        acertarLabel.setText(pontuacaoProxima);
    }


        
    private void limparLabelsResultado() {
        acertarLabel.setText("");
        errarLabel.setText("");
        pararLabel.setText("");
    }

    private void pararJogo() {
        JOptionPane.showMessageDialog(this, "Você decidiu parar o jogo.\n" +
                "Sua pontuação final é: R$ " + pontuacaoAtual);
        // Adicionar pontuação no banco de dados para fazer o ranking no futuro
    }

    
    private void reiniciarJogo() {
        nivelAtual = 1;
        pontuacaoAtual = "R$: 0";
        limparLabelsResultado();
        carregarQuestao(nivelAtual);
    }

        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enunciadoLabel = new javax.swing.JLabel();
        alternativa1Label = new javax.swing.JLabel();
        alternativa1Button = new javax.swing.JButton();
        alternativa2Label = new javax.swing.JLabel();
        alternativa2Button = new javax.swing.JButton();
        alternativa3Label = new javax.swing.JLabel();
        alternativa3Button = new javax.swing.JButton();
        alternativa4Label = new javax.swing.JLabel();
        alternativa4Button = new javax.swing.JButton();
        alternativa5Label = new javax.swing.JLabel();
        alternativa5Button = new javax.swing.JButton();
        dicasButton = new javax.swing.JButton();
        errarLabel = new javax.swing.JLabel();
        acertarLabel = new javax.swing.JLabel();
        pararLabel = new javax.swing.JLabel();
        pararJogoButton = new javax.swing.JButton();
        telaJogoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enunciadoLabel.setBackground(new java.awt.Color(51, 51, 51));
        enunciadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        enunciadoLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(enunciadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 1240, 80));

        alternativa1Label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        alternativa1Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 1380, 110));

        alternativa1Button.setContentAreaFilled(false);
        alternativa1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, 110));

        alternativa2Label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        alternativa2Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 1380, 100));

        alternativa2Button.setContentAreaFilled(false);
        alternativa2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, 110));

        alternativa3Label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        alternativa3Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 1390, 100));

        alternativa3Button.setContentAreaFilled(false);
        alternativa3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa3ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 110, 100));

        alternativa4Label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        alternativa4Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 1390, 110));

        alternativa4Button.setContentAreaFilled(false);
        alternativa4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 110, 110));

        alternativa5Label.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        alternativa5Label.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(alternativa5Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 1390, 100));

        alternativa5Button.setContentAreaFilled(false);
        alternativa5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alternativa5ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(alternativa5Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, 110, 100));

        dicasButton.setContentAreaFilled(false);
        getContentPane().add(dicasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 490, 210, 130));

        errarLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        errarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(errarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 940, 380, 80));

        acertarLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        acertarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(acertarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 940, 380, 80));

        pararLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        pararLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(pararLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 940, 380, 80));

        pararJogoButton.setText("Parar jogo");
        pararJogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararJogoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pararJogoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 720, 180, 80));

        telaJogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelaJogo.png"))); // NOI18N
        getContentPane().add(telaJogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alternativa1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa1ButtonActionPerformed
        processarResposta(0);
    }//GEN-LAST:event_alternativa1ButtonActionPerformed

    private void alternativa2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa2ButtonActionPerformed
        processarResposta(1);
    }//GEN-LAST:event_alternativa2ButtonActionPerformed

    private void alternativa3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa3ButtonActionPerformed
        processarResposta(2);
    }//GEN-LAST:event_alternativa3ButtonActionPerformed

    private void alternativa4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa4ButtonActionPerformed
        processarResposta(3);
    }//GEN-LAST:event_alternativa4ButtonActionPerformed

    private void alternativa5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alternativa5ButtonActionPerformed
        processarResposta(4);
    }//GEN-LAST:event_alternativa5ButtonActionPerformed

    private void pararJogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararJogoButtonActionPerformed
        pararJogo();
        TelaMenuInicial telaMenu = new TelaMenuInicial();
        telaMenu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_pararJogoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acertarLabel;
    private javax.swing.JButton alternativa1Button;
    private javax.swing.JLabel alternativa1Label;
    private javax.swing.JButton alternativa2Button;
    private javax.swing.JLabel alternativa2Label;
    private javax.swing.JButton alternativa3Button;
    private javax.swing.JLabel alternativa3Label;
    private javax.swing.JButton alternativa4Button;
    private javax.swing.JLabel alternativa4Label;
    private javax.swing.JButton alternativa5Button;
    private javax.swing.JLabel alternativa5Label;
    private javax.swing.JButton dicasButton;
    private javax.swing.JLabel enunciadoLabel;
    private javax.swing.JLabel errarLabel;
    private javax.swing.JButton pararJogoButton;
    private javax.swing.JLabel pararLabel;
    private javax.swing.JLabel telaJogoLabel;
    // End of variables declaration//GEN-END:variables
}
