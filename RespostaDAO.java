package dao;
import model.Resposta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RespostaDAO {
    public boolean cadastrar(Resposta resposta) throws SQLException {
        String sql = "INSERT INTO Resposta (id_pergunta, texto_resposta, correta) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, resposta.getIdPergunta());
            stmt.setString(2, resposta.getTextoResposta());
            stmt.setBoolean(3, resposta.isCorreta());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Resposta> listarPorPergunta(int idPergunta) throws SQLException {
        List<Resposta> respostas = new ArrayList<>();
        String sql = "SELECT * FROM Resposta WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPergunta);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Resposta resposta = new Resposta(
                        rs.getInt("id_resposta"),
                        rs.getInt("id_pergunta"),
                        rs.getString("texto_resposta"),
                        rs.getBoolean("correta")
                    );
                    respostas.add(resposta);
                }
            }
        }

        return respostas;
    }

    public boolean atualizar(Resposta resposta) throws SQLException {
        String sql = "UPDATE Resposta SET texto_resposta = ?, correta = ? WHERE id_resposta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resposta.getTextoResposta());
            stmt.setBoolean(2, resposta.isCorreta());
            stmt.setInt(3, resposta.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idResposta) throws SQLException {
        String sql = "DELETE FROM Resposta WHERE id_resposta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idResposta);
            return stmt.executeUpdate() > 0;
        }
    }
}