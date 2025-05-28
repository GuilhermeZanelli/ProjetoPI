package dao;
import model.Professor;
import model.TipoUsuario;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (nome, email, senha, tipo, pontuacao, ajudaDisponivel, saldo) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipo().name());
            stmt.setInt(5, usuario.getPontuacao());
            stmt.setBoolean(6, usuario.ajudaDisponivel());
            stmt.setInt(7, usuario.getSaldo());
            int rows = stmt.executeUpdate();
            if (rows == 0) return false;

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idUsuario = generatedKeys.getInt(1);
                    usuario.setId(idUsuario); // ✅ garante que o ID seja atribuído ao objeto

                    // Inserir ajuda padrão
                    String ajudaSql = "INSERT INTO Ajuda (id_usuario, disponivel, quantidade) VALUES (?, TRUE, 3)";
                    try (PreparedStatement ajudaStmt = conn.prepareStatement(ajudaSql)) {
                        ajudaStmt.setInt(1, idUsuario);
                        ajudaStmt.executeUpdate();
                    }

                    // Inserir estatística padrão
                    String estatSql = "INSERT INTO Estatistica (id_usuario, totalPerguntasRespondidas, total_corretas, total_erradas) VALUES (?, 0, 0, 0)";
                    try (PreparedStatement estatStmt = conn.prepareStatement(estatSql)) {
                        estatStmt.setInt(1, idUsuario);
                        estatStmt.executeUpdate();
                    }

                    return true;
                }
            }
        }

        return false;
    }

    public boolean coordenadorExiste(int idCoordenador) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Usuario WHERE id_usuario = ? AND tipo = 'COORDENADOR'";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCoordenador);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    public boolean cadastrarProfessorPorCoordenador(Professor professor, int idCoordenador) throws SQLException {
        if (!coordenadorExiste(idCoordenador)) {
            throw new IllegalArgumentException("Usuário informado não é um coordenador válido.");
        }

        professor.setIdCadastradoPor(idCoordenador);

        if (!cadastrar(professor)) {
            return false;
        }

        String sql = "INSERT INTO Professor (id_usuario, id_cadastrado_por) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professor.getId()); // ✅ usa o ID já atribuído pelo método cadastrar
            stmt.setInt(2, professor.getIdCadastradoPor());
            stmt.executeUpdate();
            return true;
        }
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    TipoUsuario.valueOf(rs.getString("tipo").toUpperCase())
                );
                usuario.setPontuacao(rs.getInt("pontuacao"));
                usuario.setAjudaDisponivel(rs.getInt("ajudaDisponivel"));
                usuario.setSaldo(rs.getInt("saldo"));

                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    public Usuario buscarPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        TipoUsuario.valueOf(rs.getString("tipo").toUpperCase())
                    );
                    usuario.setPontuacao(rs.getInt("pontuacao"));
                    usuario.setAjudaDisponivel(rs.getInt("ajudaDisponivel"));
                    usuario.setSaldo(rs.getInt("saldo"));

                    return usuario;
                }
            }
        }

        return null;
    }

    public Usuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE email = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        TipoUsuario.valueOf(rs.getString("tipo").toUpperCase())
                    );
                    usuario.setPontuacao(rs.getInt("pontuacao"));
                    usuario.setAjudaDisponivel(rs.getInt("ajudaDisponivel"));
                    usuario.setSaldo(rs.getInt("saldo"));
                    return usuario;
                }
            }
        }

        return null;
    }

    public boolean atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET nome = ?, senha = ?, pontuacao = ?, ajudaDisponivel = ?, saldo = ? WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getPontuacao());
            stmt.setBoolean(4, usuario.ajudaDisponivel());
            stmt.setInt(5, usuario.getSaldo());
            stmt.setInt(6, usuario.getId());

            stmt.executeUpdate();
            return true;
        }
    }

    public boolean deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            return true;
        }
    }

    public String buscarSenhaPorEmail(String email) throws SQLException {
    String sql = "SELECT senha FROM usuario WHERE email = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("senha");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // lança exceção para ser tratada onde for chamado
    }

    return null; // Retorna null se o email não for encontrado
}
}