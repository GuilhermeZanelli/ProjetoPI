package dao;
import model.Ajuda;
import java.sql.*;
public class AjudaDAO {
    public boolean inserirAjudaPadrao(int idUsuario) throws SQLException {
        String sql = "INSERT INTO Ajuda (id_usuario, disponivel, quantidade) VALUES (?, TRUE, 3)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }

    public Ajuda buscarAjudaPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Ajuda WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ajuda(
                        rs.getInt("id_usuario"),
                        rs.getBoolean("disponivel"),
                        rs.getInt("quantidade")
                    );
                }
            }
        }

        return null;
    }

    public boolean atualizarAjuda(Ajuda ajuda) throws SQLException {
        String sql = "UPDATE Ajuda SET disponivel = ?, quantidade = ? WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, ajuda.isDisponivel());
            stmt.setInt(2, ajuda.getQuantidade());
            stmt.setInt(3, ajuda.getIdUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean removerAjuda(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Ajuda WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }
}