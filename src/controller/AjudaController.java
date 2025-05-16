package controller;
import dao.AjudaDAO;
import model.Ajuda;
import java.sql.SQLException;
import java.util.Objects;
public class AjudaController {
    private final AjudaDAO ajudaDAO;
    public AjudaController(AjudaDAO ajudaDAO) {
        this.ajudaDAO = Objects.requireNonNull(ajudaDAO);
    }

    // Inicializa ajuda padrão para novo usuário
    public boolean criarAjudaParaUsuario(int idUsuario) throws SQLException {
        return ajudaDAO.inserirAjudaPadrao(idUsuario);
    }

    // Busca ajuda do usuário
    public Ajuda buscarAjuda(int idUsuario) throws SQLException {
        return ajudaDAO.buscarAjudaPorUsuario(idUsuario);
    }

    // Atualiza ajuda (ex: após usar)
    public boolean atualizarAjuda(Ajuda ajuda) throws SQLException {
        return ajudaDAO.atualizarAjuda(ajuda);
    }

    // Reduz uma ajuda (usando-a)
    public boolean usarAjuda(int idUsuario) throws SQLException {
        Ajuda ajuda = ajudaDAO.buscarAjudaPorUsuario(idUsuario);
        if (ajuda == null || ajuda.getQuantidade() <= 0) {
            return false;
        }
        ajuda.setQuantidade(ajuda.getQuantidade() - 1);
        if (ajuda.getQuantidade() == 0) {
            ajuda.setDisponivel(false);
        }
        return ajudaDAO.atualizarAjuda(ajuda);
    }

    // Excluir ajuda
    public boolean removerAjuda(int idUsuario) throws SQLException {
        return ajudaDAO.removerAjuda(idUsuario);
    }
}
