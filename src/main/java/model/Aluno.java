package model;
public class Aluno extends Usuario {
    private String serie;
    private int idade;
    private int idCadastradoPor;
    public Aluno(int id, String nome, String email, String senha, String serie, int idade, int idCadastradoPor) {
        super(id, nome, email, senha, TipoUsuario.ALUNO);
        this.serie = serie;
        this.idade = idade;
        this.idCadastradoPor = idCadastradoPor;
    }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public int getIdCadastradoPor() { return idCadastradoPor; }
    public void setIdCadastradoPor(int idCadastradoPor) { this.idCadastradoPor = idCadastradoPor; }

    public String toString() {
        return "Aluno{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", serie='" + serie + '\'' +
                ", idade=" + idade +
                ", idCadastradoPor=" + idCadastradoPor +
                '}';
    }
}