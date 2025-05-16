package controller;
import dao.CheckpointDAO;
import dao.UsuarioDAO;
import model.Checkpoint;
import model.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CheckpointController {
    private final CheckpointDAO checkpointDAO;
    private final UsuarioDAO usuarioDAO;
    public CheckpointController(CheckpointDAO checkpointDAO, UsuarioDAO usuarioDAO) {
        this.checkpointDAO = Objects.requireNonNull(checkpointDAO);
        this.usuarioDAO = Objects.requireNonNull(usuarioDAO);
    }

    private boolean usuarioPodeGerenciar(int idUsuario) throws SQLException {
        Usuario usuario = usuarioDAO.buscarPorId(idUsuario);
        return usuario != null && (
                usuario.getTipo().name().equals("PROFESSOR") ||
                usuario.getTipo().name().equals("COORDENADOR")
        );
    }

    public boolean criarCheckpoint(String titulo, String descricao, int idAutor) throws SQLException {
        if (!usuarioPodeGerenciar(idAutor)) {
            throw new IllegalArgumentException("Apenas professores ou coordenadores podem criar checkpoints.");
        }
        Checkpoint checkpoint = new Checkpoint(0, titulo, descricao, idAutor);
        return checkpointDAO.inserir(checkpoint);
    }

    public List<Checkpoint> listarDoAutor(int idAutor) throws SQLException {
        return checkpointDAO.listarPorAutor(idAutor);
    }

    public boolean atualizarCheckpoint(Checkpoint checkpoint) throws SQLException {
        if (!usuarioPodeGerenciar(checkpoint.getIdAutor())) {
            throw new IllegalArgumentException("Usuário sem permissão para atualizar este checkpoint.");
        }

        return checkpointDAO.atualizar(checkpoint);
    }

    public boolean deletarCheckpoint(int idCheckpoint, int idUsuario) throws SQLException {
        Checkpoint checkpoint = checkpointDAO.buscarPorId(idCheckpoint);
        if (checkpoint == null || checkpoint.getIdAutor() != idUsuario) {
            throw new IllegalArgumentException("Você só pode deletar seus próprios checkpoints.");
        }
        return checkpointDAO.deletar(idCheckpoint);
    }

    public Checkpoint buscarPorId(int id) throws SQLException {
        return checkpointDAO.buscarPorId(id);
    }
}