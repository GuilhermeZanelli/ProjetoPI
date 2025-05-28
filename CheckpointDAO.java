package dao;
import model.Checkpoint;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckpointDAO {
    public boolean inserir(Checkpoint checkpoint) throws SQLException {
        String sql = "INSERT INTO Checkpoint (titulo, descricao, id_autor) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, checkpoint.getTitulo());
            stmt.setString(2, checkpoint.getDescricao());
            stmt.setInt(3, checkpoint.getIdAutor());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Checkpoint> listarPorAutor(int idAutor) throws SQLException {
        List<Checkpoint> checkpoints = new ArrayList<>();
        String sql = "SELECT * FROM Checkpoint WHERE id_autor = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    checkpoints.add(new Checkpoint(
                            rs.getInt("id_checkpoint"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getTimestamp("criado_em").toLocalDateTime(),
                            rs.getInt("id_autor")
                    ));
                }
            }
        }

        return checkpoints;
    }

    public boolean atualizar(Checkpoint checkpoint) throws SQLException {
        String sql = "UPDATE Checkpoint SET titulo = ?, descricao = ? WHERE id_checkpoint = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, checkpoint.getTitulo());
            stmt.setString(2, checkpoint.getDescricao());
            stmt.setInt(3, checkpoint.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idCheckpoint) throws SQLException {
        String sql = "DELETE FROM Checkpoint WHERE id_checkpoint = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCheckpoint);
            return stmt.executeUpdate() > 0;
        }
    }

    public Checkpoint buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Checkpoint WHERE id_checkpoint = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Checkpoint(
                            rs.getInt("id_checkpoint"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getTimestamp("criado_em").toLocalDateTime(),
                            rs.getInt("id_autor")
                    );
                }
            }
        }

        return null;
    }
}
