package dao;
import model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final UsuarioDAO usuarioDAO;
    public AlunoDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean cadastrar(Aluno aluno) throws SQLException {
        if (!usuarioDAO.cadastrar(aluno)) return false;

        String sql = "INSERT INTO Aluno (id_usuario, id_cadastrado_por, serie, idade) " +
                     "VALUES ((SELECT id_usuario FROM Usuario WHERE email = ?), ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getEmail());
            stmt.setInt(2, aluno.getIdCadastradoPor());
            stmt.setString(3, aluno.getSerie());
            stmt.setInt(4, aluno.getIdade());
            stmt.executeUpdate();
            return true;
        }
    }

    public List<Aluno> listar() throws SQLException {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT u.*, a.serie, a.idade, a.id_cadastrado_por FROM Usuario u JOIN Aluno a ON u.id_usuario = a.id_usuario";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Aluno(
                    rs.getInt("id_usuario"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("serie"),
                    rs.getInt("idade"),
                    rs.getInt("id_cadastrado_por")
                ));
            }
        }
        return lista;
    }

    public boolean atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE Usuario SET nome = ?, senha = ? WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSenha());
            stmt.setInt(3, aluno.getId());
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
}