package controller;
import dao.UsuarioDAO;
import model.Usuario;
//controller do cadastro de usuario
public class CadastroController {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    public boolean cadastrarUsuario(String nome, String email, String senha, String tipo) {
        if (!email.toLowerCase().endsWith("@sistemapoliedro.com.br")) {
            System.out.println("Email inválido");
            return false;
        }

        Usuario usuario = new Usuario(0, nome, email.toLowerCase(), senha, tipo);
        return usuarioDAO.cadastrar(usuario);
    }
}