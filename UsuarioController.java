package controller;
import dao.UsuarioDAO;
import model.*;
import static model.TipoUsuario.ALUNO;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = Objects.requireNonNull(usuarioDAO);
    }

    //Cadastro de usuário (aluno, coordenador)
    public boolean cadastrarUsuario(String nome, String email, String senha, TipoUsuario tipo) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTipo(tipo); // Tipo padrão
        return usuarioDAO.cadastrar(usuario);
    }

    //Cadastro de professor por coordenador
    public boolean cadastrarProfessor(Professor professor, int idCoordenador) throws SQLException {
        return usuarioDAO.cadastrarProfessorPorCoordenador(professor, idCoordenador);
    }

    //Buscar usuário por ID
    public Usuario buscarPorId(int idUsuario) throws SQLException {
        return usuarioDAO.buscarPorId(idUsuario);
    }

    //Buscar usuário por e-mail (útil em alguns fluxos)
    public Usuario buscarPorEmail(String email) throws SQLException {
        return usuarioDAO.buscarPorEmail(email);
    }

    //Atualizar dados do usuário
    public boolean atualizarUsuario(Usuario usuario) throws SQLException {
        return usuarioDAO.atualizar(usuario);
    }

    //Deletar usuário
    public boolean deletarUsuario(int idUsuario) throws SQLException {
        return usuarioDAO.deletar(idUsuario);
    }

    //Listar todos os usuários
    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listar();
    }
}
