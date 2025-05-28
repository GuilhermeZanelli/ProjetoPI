package controller;
import dao.FeedbackDAO;
import model.Feedback;
import java.sql.SQLException;
import java.util.Objects;

public class FeedbackController {
    private final FeedbackDAO dao;
    public FeedbackController(FeedbackDAO dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    public boolean adicionarFeedback(int idPergunta, String texto) throws SQLException {
        Feedback feedback = new Feedback(idPergunta, texto);
        return dao.inserir(feedback);
    }

    public Feedback buscarFeedback(int idPergunta) throws SQLException {
        return dao.buscarPorPergunta(idPergunta);
    }

    public boolean atualizarFeedback(int idPergunta, String novoTexto) throws SQLException {
        Feedback feedback = new Feedback(idPergunta, novoTexto);
        return dao.atualizar(feedback);
    }

    public boolean deletarFeedback(int idPergunta) throws SQLException {
        return dao.deletar(idPergunta);
    }
}