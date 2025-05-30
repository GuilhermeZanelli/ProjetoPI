package controller;
import dao.DificuldadeDAO;
import model.Dificuldade;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
public class DificuldadeController {
    private final DificuldadeDAO dao;
    public DificuldadeController(DificuldadeDAO dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    public boolean adicionar(String nivel) throws SQLException {
        return dao.inserir(new Dificuldade(0, nivel));
    }

    public List<Dificuldade> listar() throws SQLException {
        return dao.listarTodas();
    }

    public Dificuldade buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public boolean atualizar(int id, String novoNivel) throws SQLException {
        return dao.atualizar(new Dificuldade(id, novoNivel));
    }

    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }
}
