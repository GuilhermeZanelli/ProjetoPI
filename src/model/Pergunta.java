package model;
import java.time.LocalDateTime;
import java.util.List;

public class Pergunta {
    private int id;
    private String enunciado;
    private int idCategoria;
    private int idDificuldade;
    private LocalDateTime criadaEm;
    private List<Resposta> respostas; // Respostas vinculadas

    public Pergunta(int id, String enunciado, int idCategoria, int idDificuldade, LocalDateTime criadaEm) {
        this.id = id;
        this.enunciado = enunciado;
        this.idCategoria = idCategoria;
        this.idDificuldade = idDificuldade;
        this.criadaEm = criadaEm;
    }

    //Construtor auxiliar
    public Pergunta(int id, String enunciado, int idCategoria, int idDificuldade) {
        this(id, enunciado, idCategoria, idDificuldade, null);
    }

    //Getters e Setters
    public int getId() { return id; }
    public String getEnunciado() { return enunciado; }
    public int getIdCategoria() { return idCategoria; }
    public int getIdDificuldade() { return idDificuldade; }
    public LocalDateTime getCriadaEm() { return criadaEm; }
    public List<Resposta> getRespostas() { return respostas; }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public void setId(int id) { this.id = id; }
    public void setEnunciado(String enunciado) { this.enunciado = enunciado; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    public void setIdDificuldade(int idDificuldade) { this.idDificuldade = idDificuldade; }
    public void setCriadaEm(LocalDateTime criadaEm) { this.criadaEm = criadaEm; }

    public String toString() {
        return "Pergunta{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", idCategoria=" + idCategoria +
                ", idDificuldade=" + idDificuldade +
                ", criadaEm=" + criadaEm +
                ", respostas=" + respostas +
                '}';
    }
}
