package controller;

import dao.FeedbackDAO;
import dao.PerguntaDAO;
import dao.RespostaDAO;
import model.Feedback;
import model.Pergunta;
import model.Resposta;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PerguntaController {
    private final PerguntaDAO perguntaDAO;
    private final FeedbackDAO feedbackDAO;
    
    public PerguntaController(PerguntaDAO perguntaDAO, FeedbackDAO feedbackDAO) {
        this.perguntaDAO = Objects.requireNonNull(perguntaDAO);
        this.feedbackDAO = Objects.requireNonNull(feedbackDAO);
    }

    // ===== MÉTODOS NOVOS PARA O JOGO =====
    
    /**
     * Busca uma pergunta aleatória por nível de dificuldade
     * @param nivel Nível de dificuldade (1-16, baseado no Show do Milhão)
    * @return Pergunta do nível especificado ou null se não encontrar
    */
    public Pergunta buscarPerguntaPorNivel(int nivel) throws SQLException {
        // Mapear níveis do jogo para IDs de dificuldade no banco
        int idDificuldade = mapearNivelParaDificuldade(nivel);
    
        // Busca direto uma pergunta aleatória do banco
        return perguntaDAO.buscarAleatoriaPorDificuldade(idDificuldade);
    }
    
    /**
     * Mapeia os níveis do jogo (1-16) para IDs de dificuldade no banco
     */
    private int mapearNivelParaDificuldade(int nivel) {
        // Exemplo de mapeamento - ajuste conforme sua estrutura:
        // Níveis 1-5: Fácil (ID 1)
        // Níveis 6-10: Médio (ID 2)  
        // Níveis 11-15: Difícil (ID 3)
        // Nível 16: Muito Difícil (ID 4)
        
        if (nivel <= 5) return 1;      // Fácil
        else if (nivel <= 10) return 2; // Médio
        else if (nivel <= 15) return 3; // Difícil
        else return 4;                  // Muito Difícil
    }

    // ===== MÉTODOS ORIGINAIS MANTIDOS =====
    
    //Cadastrar pergunta com feedback opcional
    public boolean cadastrarPerguntaComFeedback(String enunciado, int idCategoria, int idDificuldade, String feedbackTexto) throws SQLException {
        Pergunta pergunta = new Pergunta(0, enunciado, idCategoria, idDificuldade);
        boolean sucesso = perguntaDAO.cadastrar(pergunta);
        if (sucesso && feedbackTexto != null && !feedbackTexto.isBlank()) {
            // Buscar a última pergunta com esse enunciado para obter o ID
            Pergunta ultima = perguntaDAO.buscarUltimaPorEnunciado(enunciado);
            if (ultima != null) {
                Feedback feedback = new Feedback(ultima.getId(), feedbackTexto);
                feedbackDAO.inserir(feedback);
            }
        }
        return sucesso;
    }
    public boolean cadastrarAlternativas(String enunciado, String[] alternativas) throws SQLException {
        // Buscar a pergunta pelo enunciado para obter o ID
        Pergunta pergunta = perguntaDAO.buscarUltimaPorEnunciado(enunciado);
        if (pergunta == null) {
            return false; // Pergunta não encontrada
        }
        
        boolean sucessoTotal = true;
        RespostaDAO respostaDAO = new RespostaDAO();
        
        // Cadastrar as 5 alternativas - a última (índice 4) é sempre a correta
        for (int i = 0; i < alternativas.length; i++) {
            if (alternativas[i] != null && !alternativas[i].isBlank()) {
                boolean isCorreta = (i == 4); // Última alternativa sempre correta
                Resposta resposta = new Resposta(0, pergunta.getId(), alternativas[i].trim(), isCorreta);
                boolean sucesso = respostaDAO.cadastrar(resposta);
                if (!sucesso) {
                    sucesso = false;
                    // Continue tentando cadastrar as outras, mas marque como falha
                }
            }
        }
        
        return sucessoTotal;
    }

    // ✅ Atualizar pergunta com novo feedback (ou remoção)
    public boolean atualizarPerguntaComFeedback(Pergunta pergunta, String novoFeedback) throws SQLException {
        boolean sucesso = perguntaDAO.atualizar(pergunta);
        Feedback existente = feedbackDAO.buscarPorPergunta(pergunta.getId());
        if (novoFeedback == null || novoFeedback.isBlank()) {
            // Feedback foi removido
            if (existente != null) {
                feedbackDAO.deletar(pergunta.getId());
            }
        } else if (existente == null) {
            feedbackDAO.inserir(new Feedback(pergunta.getId(), novoFeedback));
        } else {
            feedbackDAO.atualizar(new Feedback(pergunta.getId(), novoFeedback));
        }
        return sucesso;
    }

    //Buscar uma pergunta com suas respostas
    public Pergunta buscarPorId(int idPergunta) throws SQLException {
        return perguntaDAO.buscarPorId(idPergunta);
    }

    //Listar todas as perguntas com suas respostas
    public List<Pergunta> listarPerguntas() throws SQLException {
        return perguntaDAO.listarTodas();
    }

    //Deletar pergunta e feedback
    public boolean deletarPergunta(int idPergunta) throws SQLException {
        Feedback existente = feedbackDAO.buscarPorPergunta(idPergunta);
        if (existente != null) {
            feedbackDAO.deletar(idPergunta);
        }
        return perguntaDAO.deletar(idPergunta);
    }
}