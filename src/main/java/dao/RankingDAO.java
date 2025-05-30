package dao;
import java.sql.*;
import java.util.*;

public class RankingDAO {
    public List<String> getRanking() {
        List<String> ranking = new ArrayList<>();
        String sql = "SELECT nome, pontuacao FROM Usuario WHERE tipo = 'aluno' ORDER BY pontuacao DESC";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ranking.add(rs.getString("nome") + ": " + rs.getInt("pontuacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter ranking: " + e.getMessage());
        }
        return ranking;
    }
}