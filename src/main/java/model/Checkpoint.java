package model;
import java.time.LocalDateTime;
public class Checkpoint {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime criadoEm;
    private int idAutor;

    public Checkpoint(int id, String titulo, String descricao, LocalDateTime criadoEm, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.criadoEm = criadoEm;
        this.idAutor = idAutor;
    }

    public Checkpoint(int id, String titulo, String descricao, int idAutor) {
        this(id, titulo, descricao, null, idAutor);
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public int getIdAutor() { return idAutor; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    public String toString() {
        return "Checkpoint{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criadoEm=" + criadoEm +
                ", idAutor=" + idAutor +
                '}';
    }
}