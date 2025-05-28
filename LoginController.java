package controller;
import dao.UsuarioDAO;
import model.Usuario;
import java.sql.SQLException;
public class LoginController {
    private final UsuarioDAO usuarioDAO;
    public LoginController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario login(String nome, String email, String senha) throws SQLException {
        Usuario usuario = usuarioDAO.buscarPorEmail(email);
        if (nome != null && email != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public boolean autenticar(String email, String senha) {
        try {
            String senhaBanco = usuarioDAO.buscarSenhaPorEmail(email);
            return senhaBanco != null && senhaBanco.equals(senha);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}