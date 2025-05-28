package dao;

import model.Coordenador;
import model.TipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO {

    public boolean cadastrar(Coordenador coordenador, int idCoordenadorResponsavel) throws SQLException {
        if (!coordenadorExiste(idCoordenadorResponsavel)) {
            throw new IllegalArgumentException("Usuário informado não é um coordenador válido.");
        }

        coordenador.setIdCadastradoPor(idCoordenadorResponsavel);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = usuarioDAO.cadastrar(coordenador);

        if (!sucesso) {
            return false;
        }

        String sql = "INSERT INTO Coordenador (id_usuario, id_cadastrado_por) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, coordenador.getId());
            stmt.setInt(2, coordenador.getIdCadastradoPor());

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

    public List<Coordenador> listar() throws SQLException {
        List<Coordenador> coordenadores = new ArrayList<>();

        String sql = """
                SELECT u.*, c.id_cadastrado_por
                FROM Usuario u
                JOIN Coordenador c ON u.id_usuario = c.id_usuario
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Coordenador coordenador = new Coordenador(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        TipoUsuario.COORDENADOR
                );
                coordenador.setPontuacao(rs.getInt("pontuacao"));
                coordenador.setAjudaDisponivel(rs.getInt("ajudaDisponivel"));
                coordenador.setSaldo(rs.getInt("saldo"));
                coordenador.setIdCadastradoPor(rs.getInt("id_cadastrado_por"));

                coordenadores.add(coordenador);
            }
        }

        return coordenadores;
    }

    public boolean deletar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Coordenador WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
            return true;
        }
    }
}