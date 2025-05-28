package controller;
import dao.RespostaDAO;
import model.Resposta;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class RespostaController {
    private final RespostaDAO respostaDAO;
    public RespostaController(RespostaDAO respostaDAO) {
        this.respostaDAO = Objects.requireNonNull(respostaDAO);
    }

    public boolean cadastrarResposta(int idPergunta, String texto, boolean correta) throws SQLException {
        Resposta resposta = new Resposta(0, idPergunta, texto, correta);
        return respostaDAO.cadastrar(resposta);
    }

    public List<Resposta> listarRespostasDaPergunta(int idPergunta) throws SQLException {
        return respostaDAO.listarPorPergunta(idPergunta);
    }

    public boolean atualizarResposta(Resposta resposta) throws SQLException {
        return respostaDAO.atualizar(resposta);
    }

    public boolean deletarResposta(int idResposta) throws SQLException {
        return respostaDAO.deletar(idResposta);
    }
}