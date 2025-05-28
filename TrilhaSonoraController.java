package controller;
import dao.TrilhaSonoraDAO;
import model.TrilhaSonora;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
public class TrilhaSonoraController {
    private final TrilhaSonoraDAO trilhaDAO;
    
    public TrilhaSonoraController(TrilhaSonoraDAO trilhaDAO) {
        this.trilhaDAO = Objects.requireNonNull(trilhaDAO);
    }

    public boolean cadastrarTrilha(String nome, String tipo) throws SQLException {
        TrilhaSonora trilha = new TrilhaSonora(0, nome, tipo);
        return trilhaDAO.cadastrar(trilha);
    }

    public List<TrilhaSonora> listarTrilhas() throws SQLException {
        return trilhaDAO.listarTodas();
    }

    public boolean atualizarTrilha(int id, String novoNome, String novoTipo) throws SQLException {
        TrilhaSonora trilha = new TrilhaSonora(id, novoNome, novoTipo);
        return trilhaDAO.atualizar(trilha);
    }

    public boolean deletarTrilha(int id) throws SQLException {
        return trilhaDAO.deletar(id);
    }
}