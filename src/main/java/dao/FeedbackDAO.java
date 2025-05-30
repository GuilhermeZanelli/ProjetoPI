package dao;
import model.Feedback;
import java.sql.*;
public class FeedbackDAO {
    public boolean inserir(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO Feedback (id_pergunta, feedback) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, feedback.getIdPergunta());
            stmt.setString(2, feedback.getTexto());
            return stmt.executeUpdate() > 0;
        }
    }

    public Feedback buscarPorPergunta(int idPergunta) throws SQLException {
        String sql = "SELECT * FROM Feedback WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPergunta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Feedback(
                        rs.getInt("id_pergunta"),
                        rs.getString("feedback")
                    );
                }
            }
        }

        return null;
    }

    public boolean atualizar(Feedback feedback) throws SQLException {
        String sql = "UPDATE Feedback SET feedback = ? WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, feedback.getTexto());
            stmt.setInt(2, feedback.getIdPergunta());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idPergunta) throws SQLException {
        String sql = "DELETE FROM Feedback WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPergunta);
            return stmt.executeUpdate() > 0;
        }
    }
}