package model;
public class Professor extends Usuario {
    private int idCadastradoPor;

    // Construtor principal (sem ID)
    public Professor(String nome, String email, String senha, TipoUsuario tipo) {
        super(nome, email, senha, tipo);
    }

    // Construtor completo (com ID)
    public Professor(int id, String nome, String email, String senha, TipoUsuario tipo) {
        super(id, nome, email, senha, tipo);
    }

    public int getIdCadastradoPor() {
        return idCadastradoPor;
    }

    public void setIdCadastradoPor(int idCadastradoPor) {
        this.idCadastradoPor = idCadastradoPor;
    }

    public String toString() {
        return super.toString() + " | Cadastrado por: " + idCadastradoPor;
    }
}