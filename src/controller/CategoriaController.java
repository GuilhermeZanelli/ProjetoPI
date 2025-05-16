package controller;
import dao.CategoriaDAO;
import model.Categoria;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CategoriaController {
    private final CategoriaDAO dao;
    public CategoriaController(CategoriaDAO dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    public boolean adicionar(String nome) throws SQLException {
        return dao.inserir(new Categoria(0, nome));
    }

    public List<Categoria> listar() throws SQLException {
        return dao.listarTodas();
    }

    public Categoria buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public boolean atualizar(int id, String novoNome) throws SQLException {
        return dao.atualizar(new Categoria(id, novoNome));
    }

    public boolean deletar(int id) throws SQLException {
        return dao.deletar(id);
    }
}