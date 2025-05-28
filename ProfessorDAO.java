package dao;

import model.Professor;
import model.TipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public boolean cadastrar(Professor professor, int idCoordenadorResponsavel) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (!coordenadorExiste(idCoordenadorResponsavel)) {
            throw new IllegalArgumentException("O usuário informado não é um coordenador válido.");
        }

        professor.setIdCadastradoPor(idCoordenadorResponsavel);

        boolean sucesso = usuarioDAO.cadastrar(professor);

        if (!sucesso) {
            return false;
        }

        String sql = "INSERT INTO Professor (id_usuario, id_cadastrado_por) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, professor.getId());
            stmt.setInt(2, professor.getIdCadastradoPor());

            stmt.executeUpdate();
            return true;
        }
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

    public List<Professor> listar() throws SQLException {
        List<Professor> professores = new ArrayList<>();

        String sql = "SELECT u.*, p.id_cadastrado_por " +
                     "FROM Usuario u " +
                     "JOIN Professor p ON u.id_usuario = p.id_usuario";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        TipoUsuario.PROFESSOR
                );
                professor.setPontuacao(rs.getInt("pontuacao"));
                professor.setAjudaDisponivel(rs.getInt("ajudaDisponivel"));
                professor.setSaldo(rs.getInt("saldo"));
                professor.setIdCadastradoPor(rs.getInt("id_cadastrado_por"));

                professores.add(professor);
            }
        }

        return professores;
    }

    public boolean deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Professor WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            return true;
        }
    }
}