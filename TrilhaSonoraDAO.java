package dao;
import model.TrilhaSonora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TrilhaSonoraDAO {
    public boolean cadastrar(TrilhaSonora trilha) throws SQLException {
        String sql = "INSERT INTO TrilhaSonora (nome, tipo) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trilha.getNome());
            stmt.setString(2, trilha.getTipo());

            stmt.executeUpdate();
            return true;
        }
    }

    public List<TrilhaSonora> listarTodas() throws SQLException {
        List<TrilhaSonora> trilhas = new ArrayList<>();
        String sql = "SELECT * FROM TrilhaSonora";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TrilhaSonora trilha = new TrilhaSonora(
                    rs.getInt("id_trilha"),
                    rs.getString("nome"),
                    rs.getString("tipo")
                );
                trilhas.add(trilha);
            }
        }

        return trilhas;
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM TrilhaSonora WHERE id_trilha = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean atualizar(TrilhaSonora trilha) throws SQLException {
        String sql = "UPDATE TrilhaSonora SET nome = ?, tipo = ? WHERE id_trilha = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trilha.getNome());
            stmt.setString(2, trilha.getTipo());
            stmt.setInt(3, trilha.getId());

            return stmt.executeUpdate() > 0;
        }
    }
}