package dao;
import model.Estatistica;
import java.sql.*;
public class EstatisticaDAO {
    public boolean criarParaUsuario(int idUsuario) throws SQLException {
        String sql = "INSERT INTO Estatistica (id_usuario, totalPerguntasRespondidas, total_corretas, total_erradas) VALUES (?, 0, 0, 0)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }

    public Estatistica buscarPorUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Estatistica WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Estatistica(
                        rs.getInt("id_usuario"),
                        rs.getInt("totalPerguntasRespondidas"),
                        rs.getInt("total_corretas"),
                        rs.getInt("total_erradas")
                    );
                }
            }
        }
        return null;
    }

    public boolean atualizar(Estatistica estatistica) throws SQLException {
        String sql = "UPDATE Estatistica SET totalPerguntasRespondidas = ?, total_corretas = ?, total_erradas = ? WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estatistica.getTotalRespondidas());
            stmt.setInt(2, estatistica.getTotalCorretas());
            stmt.setInt(3, estatistica.getTotalErradas());
            stmt.setInt(4, estatistica.getIdUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Estatistica WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        }
    }
}