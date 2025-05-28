package dao;
import model.Dificuldade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DificuldadeDAO {
    public boolean inserir(Dificuldade dificuldade) throws SQLException {
        String sql = "INSERT INTO Dificuldade (nivel) VALUES (?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dificuldade.getNivel());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Dificuldade> listarTodas() throws SQLException {
        List<Dificuldade> dificuldades = new ArrayList<>();
        String sql = "SELECT * FROM Dificuldade";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dificuldades.add(new Dificuldade(
                        rs.getInt("id_dificuldade"),
                        rs.getString("nivel")
                ));
            }
        }

        return dificuldades;
    }

    public Dificuldade buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Dificuldade WHERE id_dificuldade = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Dificuldade(rs.getInt("id_dificuldade"), rs.getString("nivel"));
                }
            }
        }

        return null;
    }

    public boolean atualizar(Dificuldade dificuldade) throws SQLException {
        String sql = "UPDATE Dificuldade SET nivel = ? WHERE id_dificuldade = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dificuldade.getNivel());
            stmt.setInt(2, dificuldade.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM Dificuldade WHERE id_dificuldade = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
