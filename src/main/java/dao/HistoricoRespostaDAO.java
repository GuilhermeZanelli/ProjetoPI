package dao;
import model.HistoricoResposta;
import java.sql.*;

public class HistoricoRespostaDAO {
    public boolean inserir(HistoricoResposta historico) throws SQLException {
        String sql = "INSERT INTO HistoricoResposta (id_usuario, respostasUsuario) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historico.getIdUsuario());
            stmt.setString(2, historico.getRespostasJson());
            return stmt.executeUpdate() > 0;
        }
    }

    public HistoricoResposta buscarPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM HistoricoResposta WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new HistoricoResposta(
                        rs.getInt("id_usuario"),
                        rs.getString("respostasUsuario")
                    );
                }
            }
        }

        return null;
    }

    public boolean atualizar(HistoricoResposta historico) throws SQLException {
        String sql = "UPDATE HistoricoResposta SET respostasUsuario = ? WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, historico.getRespostasJson());
            stmt.setInt(2, historico.getIdUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM HistoricoResposta WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }
}