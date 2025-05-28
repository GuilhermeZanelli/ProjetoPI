package controller;
import dao.EstatisticaDAO;
import model.Estatistica;
import java.sql.SQLException;
import java.util.Objects;

public class EstatisticaController {
    private final EstatisticaDAO estatisticaDAO;
    public EstatisticaController(EstatisticaDAO estatisticaDAO) {
        this.estatisticaDAO = Objects.requireNonNull(estatisticaDAO);
    }

    public boolean criarEstatisticaParaUsuario(int idUsuario) throws SQLException {
        return estatisticaDAO.criarParaUsuario(idUsuario);
    }

    public Estatistica buscarEstatistica(int idUsuario) throws SQLException {
        return estatisticaDAO.buscarPorUsuario(idUsuario);
    }

    public boolean registrarResposta(int idUsuario, boolean acertou) throws SQLException {
        Estatistica estat = estatisticaDAO.buscarPorUsuario(idUsuario);
        if (estat == null) return false;

        estat.setTotalRespondidas(estat.getTotalRespondidas() + 1);
        if (acertou) {
            estat.setTotalCorretas(estat.getTotalCorretas() + 1);
        } else {
            estat.setTotalErradas(estat.getTotalErradas() + 1);
        }

        return estatisticaDAO.atualizar(estat);
    }

    public boolean resetarEstatistica(int idUsuario) throws SQLException {
        Estatistica estat = new Estatistica(idUsuario, 0, 0, 0);
        return estatisticaDAO.atualizar(estat);
    }
}