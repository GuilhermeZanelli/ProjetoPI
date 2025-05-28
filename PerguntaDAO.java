package dao;
import model.Pergunta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerguntaDAO {
    private final RespostaDAO respostaDAO = new RespostaDAO(); // para integrar respostas
    public boolean cadastrar(Pergunta pergunta) throws SQLException {
        String sql = "INSERT INTO pergunta (enunciado, id_categoria, id_dificuldade) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pergunta.getEnunciado());
            stmt.setInt(2, pergunta.getIdCategoria());
            stmt.setInt(3, pergunta.getIdDificuldade());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Pergunta> listarTodas() throws SQLException {
        List<Pergunta> perguntas = new ArrayList<>();
        String sql = "SELECT * FROM pergunta";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pergunta pergunta = new Pergunta(
                        rs.getInt("id_pergunta"),
                        rs.getString("enunciado"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_dificuldade"),
                        rs.getTimestamp("criada_em").toLocalDateTime()
                );

                pergunta.setRespostas(respostaDAO.listarPorPergunta(pergunta.getId()));
                perguntas.add(pergunta);
            }
        }

        return perguntas;
    }

    public Pergunta buscarPorId(int idPergunta) throws SQLException {
        String sql = "SELECT * FROM pergunta WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPergunta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pergunta pergunta = new Pergunta(
                            rs.getInt("id_pergunta"),
                            rs.getString("enunciado"),
                            rs.getInt("id_categoria"),
                            rs.getInt("id_dificuldade"),
                            rs.getTimestamp("criada_em").toLocalDateTime()
                    );

                    pergunta.setRespostas(respostaDAO.listarPorPergunta(pergunta.getId()));
                    return pergunta;
                }
            }
        }

        return null;
    }

    public boolean atualizar(Pergunta pergunta) throws SQLException {
        String sql = "UPDATE pergunta SET enunciado = ?, id_categoria = ?, id_dificuldade = ? WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pergunta.getEnunciado());
            stmt.setInt(2, pergunta.getIdCategoria());
            stmt.setInt(3, pergunta.getIdDificuldade());
            stmt.setInt(4, pergunta.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(int idPergunta) throws SQLException {
        String sql = "DELETE FROM pergunta WHERE id_pergunta = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPergunta);
            return stmt.executeUpdate() > 0;
        }
    }

    public Pergunta buscarUltimaPorEnunciado(String enunciado) throws SQLException {
        String sql = "SELECT * FROM pergunta WHERE enunciado = ? ORDER BY id_pergunta DESC RAND() LIMIT 1";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, enunciado);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pergunta pergunta = new Pergunta(
                            rs.getInt("id_pergunta"),
                            rs.getString("enunciado"),
                            rs.getInt("id_categoria"),
                            rs.getInt("id_dificuldade"),
                            rs.getTimestamp("criada_em").toLocalDateTime()
                    );

                    pergunta.setRespostas(respostaDAO.listarPorPergunta(pergunta.getId()));
                    return pergunta;
                }
            }
        }

        return null;
    }

    public Pergunta buscarAleatoriaPorDificuldade(int idDificuldade) throws SQLException {
    String sql = "SELECT id_pergunta, enunciado, id_categoria, id_dificuldade FROM pergunta " +
                 "WHERE id_dificuldade = ? ORDER BY RAND() LIMIT 1"; 
    // Para MySQL use: "ORDER BY RAND() LIMIT 1"
    // Para PostgreSQL use: "ORDER BY RANDOM() LIMIT 1"
    // Para SQL Server use: "ORDER BY NEWID()"
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, idDificuldade);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Pergunta(
                    rs.getInt("id_pergunta"),
                    rs.getString("enunciado"),
                    rs.getInt("id_categoria"),
                    rs.getInt("id_dificuldade")
                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar pergunta aleatória por dificuldade: " + e.getMessage());
        throw e;
    }
    
    return null;
}
}
