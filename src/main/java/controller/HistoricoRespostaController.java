package controller;
import dao.HistoricoRespostaDAO;
import model.HistoricoResposta;
import java.sql.SQLException;
import java.util.Objects;

public class HistoricoRespostaController {
    private final HistoricoRespostaDAO dao;
    public HistoricoRespostaController(HistoricoRespostaDAO dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    public boolean salvarNovoHistorico(int idUsuario, String respostasJson) throws SQLException {
        HistoricoResposta historico = new HistoricoResposta(idUsuario, respostasJson);
        return dao.inserir(historico);
    }

    public HistoricoResposta buscarHistorico(int idUsuario) throws SQLException {
        return dao.buscarPorUsuario(idUsuario);
    }

    public boolean atualizarHistorico(int idUsuario, String novoJson) throws SQLException {
        HistoricoResposta historico = new HistoricoResposta(idUsuario, novoJson);
        return dao.atualizar(historico);
    }

    public boolean deletarHistorico(int idUsuario) throws SQLException {
        return dao.deletar(idUsuario);
    }
}
