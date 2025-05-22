
package controller;

import dao.AlunoDAO;
import dao.ProfessorDAO;
import dao.CoordenadorDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import model.Aluno;
import model.Professor;
import model.Coordenador;
import model.TipoUsuario;
import util.SessaoUsuario;

public class CadastroController {

    private UsuarioDAO usuarioDAO;
    private AlunoDAO alunoDAO;
    private ProfessorDAO professorDAO;
    private CoordenadorDAO coordenadorDAO;

    public CadastroController() {
        usuarioDAO = new UsuarioDAO();
        alunoDAO = new AlunoDAO(usuarioDAO);
        professorDAO = new ProfessorDAO();
        coordenadorDAO = new CoordenadorDAO();
    }

    public boolean podeCadastrarAluno() {
        return SessaoUsuario.getUsuario().getTipo() == TipoUsuario.COORDENADOR;
    }

    public boolean podeCadastrarProfessor() {
        return SessaoUsuario.getUsuario().getTipo() == TipoUsuario.PROFESSOR;
    }

    public boolean podeCadastrarCoordenador() {
        return SessaoUsuario.getUsuario().getTipo() == TipoUsuario.COORDENADOR;
    }

    public boolean cadastrarAluno(Aluno aluno) throws SQLException {
        if (podeCadastrarAluno()) {
            usuarioDAO.cadastrar(aluno);
            alunoDAO.cadastrar(aluno);
            return true;
        } else {
            System.out.println("Apenas professores podem cadastrar alunos.");
            return false;
        }
    }

    public boolean cadastrarProfessor(Professor professor) throws SQLException {
        if (podeCadastrarProfessor()) {
            usuarioDAO.cadastrar(professor);
            professorDAO.cadastrar(professor, SessaoUsuario.getUsuario().getId());
            return true;
        } else {
            System.out.println("Apenas coordenadores podem cadastrar professores.");
            return false;
        }
    }

    public boolean cadastrarCoordenador(Coordenador coordenador) throws SQLException {
        if (podeCadastrarCoordenador()) {
            usuarioDAO.cadastrar(coordenador);
            coordenadorDAO.cadastrar(coordenador, SessaoUsuario.getUsuario().getId());
            return true;
        } else {
            System.out.println("Apenas coordenadores podem cadastrar outros coordenadores.");
            return false;
        }
    }
}
